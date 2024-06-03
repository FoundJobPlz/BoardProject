package com.board.repository;

import com.board.service.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private Map<Long, BoardEntity> boardStore = new HashMap<>();
    private Long id = 1L;

    /**
     * Repository <-> DB
     * @return
     */
    public List<BoardEntity> getBoards() {
        return boardStore.values().stream().toList();
    }

    public void createBoard(Board board) {

        BoardEntity boardEntity = new BoardEntity(id++, board.getTitle(), board.getContent(), board.getUserId());

        boardStore.put(boardEntity.getId(), boardEntity);
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

    public void updateBoard(Board board) {
        BoardEntity boardEntity = new BoardEntity(board.getId(), board.getTitle(), board.getContent(), board.getUserId());


        boardStore.put(boardEntity.getId(), boardEntity);
    }
}
