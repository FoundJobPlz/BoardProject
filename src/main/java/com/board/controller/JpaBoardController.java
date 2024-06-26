package com.board.controller;

import com.board.service.Board;
import com.board.service.BoardService;
import com.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class JpaBoardController {

    private final JpaBoardService boardService;

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.created(URI.create("http://loaclhost:8080")).build();
    }

    @GetMapping
    public ResponseEntity<ListBoardResponse> getBoards() {
        List<ListBoardResponseDto> boards = boardService.getBoards();
        ListBoardResponse listBoardResponse = new ListBoardResponse(boards);

        return ResponseEntity.ok().body(listBoardResponse);
    }

    @GetMapping(path = "/{boardId}")
    public ResponseEntity<GetBoardResponseDto> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @DeleteMapping(path = "/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<UpdateBoardRequestDto> updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        boardService.updateBoard(boardId, updateBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
