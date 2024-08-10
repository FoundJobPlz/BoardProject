package com.board.service;

import com.board.controller.dto.CreateBoardRequestDto;
import com.board.controller.dto.BoardDto;
import com.board.controller.dto.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final JpaBoardRepository jpaBoardRepository;

    @Transactional
    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        BoardEntity boardEntity = BoardEntity.builder().title(createBoardRequestDto.getTitle()).content(createBoardRequestDto.getContent()).build();

        jpaBoardRepository.save(boardEntity);
    }

    @Transactional(readOnly = true)
    public List<BoardDto> getBoards() {
        return jpaBoardRepository.findAll().stream().map(boardEntity ->
                        new BoardDto(
                                boardEntity.getId(),
                                boardEntity.getTitle(),
                                boardEntity.getContent(),
                                boardEntity.getUserId()))
                .toList();
    }

    @Transactional(readOnly = true)
    public BoardDto getBoard(Long boardId) {
        BoardEntity boardEntity = findByIdOrThrow(boardId);

        return new BoardDto(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getUserId());
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        if (jpaBoardRepository.existsById(boardId)){
            jpaBoardRepository.deleteById(boardId);
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
        return jpaBoardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("boardId에 해당되는 게시글이 존재하지 않습니다."));
    }
}
