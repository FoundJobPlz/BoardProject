package com.board.repository;

import com.board.controller.UpdateBoardRequestDto;
import com.board.service.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class BoardRepository {

    private final Map<Long, BoardEntity> boardStore = new HashMap<>();

    /**
     * Repository <-> DB
     * @return
     */

    public void createBoard(Board board) {
        BoardEntity boardEntity = new BoardEntity(board.getTitle(), board.getContent(), board.getUserId());

        boardStore.put(boardEntity.getId(), boardEntity);
    }

    public List<BoardEntity> getBoards() {
        return new ArrayList<>(boardStore.values());
    }

    public BoardEntity getBoard(Long boardId) {

        BoardEntity boardEntity = boardStore.get(boardId);

        if (boardEntity == null) {
            throw new IllegalStateException("boardId에 해당되는 게시글이 존재하지 않습니다");
        }

        return boardEntity;
    }

    public void deleteBoard(Long boardId) {
        boardStore.remove(boardId);
    }

    public void updateBoard(Long boarId, UpdateBoardRequestDto updateBoard) {
        BoardEntity findBoard = boardStore.get(boarId);
        findBoard.setTitle(updateBoard.getTitle());
        findBoard.setContent(updateBoard.getContent());
    }

    public void clearBoard() {
        boardStore.clear();
    }
}
