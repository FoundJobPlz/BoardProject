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

    @PostMapping(path = "/board")
    public ResponseEntity<Board> createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.createBoard(
                createBoardRequestDto.getTitle(),
                createBoardRequestDto.getContent(),
                createBoardRequestDto.getUserId()
        );

        return ResponseEntity.created(URI.create("http://loaclhost:8080")).build();
    }

    @GetMapping(path = "/board")
    public ResponseEntity<List<Board>> getBoards() {
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

    @DeleteMapping(path = "/board/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/board/{boardId}")
    public ResponseEntity<UpdateBoardRequestDto> updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        boardService.updateBoard(boardId, updateBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
