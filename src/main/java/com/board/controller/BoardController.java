package com.board.controller;

import com.board.controller.dto.board.*;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ListBoardResponseDto> getBoards(Pageable pageable) {
        ListBoardResponseDto response = ListBoardResponseDto.builder().list(boardService.getBoards(pageable)).build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{boardId}")
    public ResponseEntity<BoardQueryDto> getBoard(@PathVariable(name = "boardId") Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @DeleteMapping(path = "/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable(name = "boardId") Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<?> updateBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        boardService.updateBoard(boardId, updateBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
