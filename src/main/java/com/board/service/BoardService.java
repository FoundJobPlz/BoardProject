package com.board.service;

import com.board.controller.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @GetMapping("/board")
    public List<Board> getBoards() {
        List<BoardEntity> boardEntities = boardRepository.getBoards();

        List<Board> boardList = boardEntities.stream().map(
                boardEntity -> new Board(boardEntity.getId(), boardEntity.getTitle(),
                        boardEntity.getContent(), boardEntity.getUserId())).toList();

        return boardList;
    }

    public void newBoard(String title, String content, String userId) {
        Board board = new Board(null, title, content, userId);
        boardRepository.createBoard(board);
    }


    public Board getBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);

        return new Board(
                boardEntity.getId(),
                boardEntity.getTitle(),
                boardEntity.getContent(),
                boardEntity.getUserId()
        );
    }

    public void deleteBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.getBoard(boardId);
        boardRepository.deleteBoard(boardEntity.getId(),boardEntity.getContent(), boardEntity.getTitle(), boardEntity.getUserId());
    }

    public void updateBoard(Long boarId, String updateTitle, String updateContent, String userId) {

        Board board = new Board(boarId, updateTitle, updateContent, userId);
        boardRepository.updateBoard(board);
    }
}
