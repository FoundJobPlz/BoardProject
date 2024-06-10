package com.board.repository;

import com.board.controller.UpdateBoardRequestDto;
import com.board.service.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BoardRepositoryTest {

    BoardRepository boardRepository = new BoardRepository();

    @AfterEach
    void afterEach() {
        boardRepository.clearBoard();
    }

    @Test
    public void save() throws Exception{
        //given
        Board board = new Board("test", "test1", "userA");

        //when
        boardRepository.createBoard(board);
        BoardEntity findBoard = boardRepository.getBoard(board.getId());

        //then
        System.out.println("board = " + board.getId());
        System.out.println("findBoard.getId() = " + findBoard.getId());
        assertThat(board.getId()).isEqualTo(findBoard.getId());
    }

    @Test
    public void findAll() throws Exception{
        //given
        Board board1 = new Board("testA", "test1", "userA");
        Board board2 = new Board("testB", "test2", "userB");

        boardRepository.createBoard(board1);
        boardRepository.createBoard(board2);

        //when
        List<BoardEntity> boards = boardRepository.getBoards();

        //then
        assertThat(boards.size()).isEqualTo(2);
    }

    @Test
    public void update() throws Exception{
        //given
        Board board1 = new Board("testA", "test1", "userA");

        boardRepository.createBoard(board1);
        Long boardId = board1.getId();

        //when
        UpdateBoardRequestDto updateData = new UpdateBoardRequestDto("updateA", "updateB");
        boardRepository.updateBoard(boardId, updateData);

        BoardEntity findBoard = boardRepository.getBoard(boardId);
        //then
        System.out.println("updateData = " + updateData.getContent());
        System.out.println("updateData = " + updateData.getTitle());
        System.out.println("findBoard = " + findBoard.getContent());
        System.out.println("findBoard = " + findBoard.getTitle());
        assertThat(findBoard.getTitle()).isEqualTo(updateData.getTitle());
        assertThat(findBoard.getContent()).isEqualTo(updateData.getContent());

    }

}