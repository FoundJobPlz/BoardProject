package com.board.service;

import com.board.controller.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(String title, String content, String userId) {
        Board board = new Board(null, title, content, userId);
        boardRepository.createBoard(board);
    }

    public List<Board> getBoards() {
        List<BoardEntity> boardEntities = boardRepository.getBoards();

        List<Board> boardList = boardEntities.stream().map(
                boardEntity -> new Board(boardEntity.getId(), boardEntity.getTitle(),
                        boardEntity.getContent(), boardEntity.getUserId())).toList();

        return boardList;
    }

    public Board getBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);

        return new Board(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getUserId());
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
