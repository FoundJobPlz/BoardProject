package com.board.service;

import com.board.controller.dto.board.*;
import com.board.repository.BoardEntity;
import com.board.repository.BoardQueryRepository;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;

    @Transactional
    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(createBoardRequestDto.getTitle())
                .content(createBoardRequestDto.getContent())
                .userId(createBoardRequestDto.getUserId())
                .build();

        boardRepository.save(boardEntity);
    }

    @Transactional(readOnly = true)
    public Page<BoardDto> getBoards(Pageable pageable) {
        Page<BoardEntity> allBoardEntity = boardRepository.findBoardAllCountBy(pageable);
        return allBoardEntity.map(
                boardEntity -> BoardDto.builder()
                        .id(boardEntity.getId())
                        .title(boardEntity.getTitle())
                        .content(boardEntity.getContent())
                        .userId(boardEntity.getUserId())
                        .build());
    }

    @Transactional(readOnly = true)
    public BoardQueryDto getBoard(Long boardId) {
        return boardQueryRepository.findBoardComments(boardId);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        if (boardRepository.existsById(boardId)){
            boardRepository.deleteById(boardId);
            return;
        }

        throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
    }

    @Transactional
    public void updateBoard(Long boardId, UpdateBoardRequestDto updateBoardRequestDto) {
        BoardEntity findBoard = findByIdOrThrow(boardId);

        findBoard.updateTitle(updateBoardRequestDto.getTitle());
        findBoard.updateContent(updateBoardRequestDto.getContent());
    }

    private BoardEntity findByIdOrThrow(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("boardId에 해당되는 게시글이 존재하지 않습니다."));
    }
}
