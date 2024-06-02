package com.board.controller;

import com.board.service.Board;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(path = "/board")
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boards = boardService.getBoards();

        return ResponseEntity.ok().body(boards);
    }

    @GetMapping(path = "/board/{boardId}")
    public ResponseEntity<GetBoardResponseDto> getBoard(@PathVariable Long boardId) {
        Board board = boardService.getBoard(boardId);

        GetBoardResponseDto responseDto = new GetBoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getUserId()
        );

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping(path = "/board")
    public ResponseEntity<Board> newBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.newBoard(
                createBoardRequestDto.getTitle(),
                createBoardRequestDto.getContent(),
                createBoardRequestDto.getUserId()
        );

        return ResponseEntity.created(URI.create("http://loaclhost:8080")).build();
    }

    @DeleteMapping(path = "/board/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/board/{boardId}")
    public ResponseEntity<Board> updateBoard(@RequestBody UpdateBoardRequestDto boardId) {
        boardService.updateBoard(
                boardId.getId(),
                boardId.getTitle(),
                boardId.getContent(),
                boardId.getUserId());

        return ResponseEntity.ok().build();
    }
}
