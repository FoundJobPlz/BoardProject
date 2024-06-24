package com.board.service;

import com.board.controller.CreateBoardRequestDto;
import com.board.controller.GetBoardResponseDto;
import com.board.controller.ListBoardResponseDto;
import com.board.controller.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaBoardService {

    private final JpaBoardRepository jpaBoardRepository;

    public CreateBoardRequestDto createBoard(CreateBoardRequestDto createBoardRequestDto) {
        BoardEntity boardEntity = new BoardEntity(createBoardRequestDto.getTitle(), createBoardRequestDto.getContent(), createBoardRequestDto.getUserId());
        BoardEntity saveBoard = jpaBoardRepository.save(boardEntity);
        return new CreateBoardRequestDto(saveBoard.getTitle(), saveBoard.getContent(), saveBoard.getUserId());
    }

    public List<ListBoardResponseDto> getBoards() {
        return jpaBoardRepository.findAll().stream().map(boardEntity ->
                        new ListBoardResponseDto(
                                boardEntity.getId(),
                                boardEntity.getTitle(),
                                boardEntity.getContent(),
                                boardEntity.getUserId()))
                .toList();
    }

    public GetBoardResponseDto getBoard(Long boardId) {
        BoardEntity boardEntity = jpaBoardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("boardId에 해당되는 게시글이 존재하지 않습니다."));
        return new GetBoardResponseDto(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getUserId());
    }

    public void deleteBoard(Long boardId) {
        jpaBoardRepository.deleteById(boardId);
    }

    public UpdateBoardRequestDto updateBoard(Long boardId, UpdateBoardRequestDto updateBoardRequestDto) {
        BoardEntity findBoard = jpaBoardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("boardId에 해당되는 게시글이 존재하지 않습니다."));

        findBoard.setTitle(updateBoardRequestDto.getTitle());
        findBoard.setContent(updateBoardRequestDto.getContent());

        BoardEntity updateBoard = jpaBoardRepository.save(findBoard);

        return new UpdateBoardRequestDto(updateBoard.getTitle(), updateBoard.getContent());
    }

    public void clearBoard() {
        jpaBoardRepository.deleteAll();
    }
}
