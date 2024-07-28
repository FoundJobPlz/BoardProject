package com.board.service;

import com.board.controller.CreateBoardRequestDto;
import com.board.controller.ListBoardResponseDto;
import com.board.controller.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {
        Board board = new Board(createBoardRequestDto.getTitle(), createBoardRequestDto.getContent(), createBoardRequestDto.getUserId());
        boardRepository.createBoard(board);
    }

    public List<ListBoardResponseDto> getBoards() {

        return getBoardList(boardRepository.getBoards());
    }

    public static List<ListBoardResponseDto> getBoardList(List<BoardEntity> boardEntities) {
        return boardEntities.stream().map(boardEntity ->
                        new ListBoardResponseDto(
                                boardEntity.getId(),
                                boardEntity.getTitle(),
                                boardEntity.getContent(),
                                boardEntity.getUserId()))
                .toList();
    }

    public Board getBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);

        return new Board(boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getUserId());
    }

    public void deleteBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);
        boardRepository.deleteBoard(boardEntity.getId());
    }

    public void updateBoard(Long boardId, UpdateBoardRequestDto updateBoardRequestDto) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);

        boardRepository.updateBoard(boardEntity.getId(), updateBoardRequestDto);
    }
}
