package com.board.controller;

import com.board.controller.dto.BoardDto;
import com.board.controller.dto.CreateBoardRequestDto;
import com.board.controller.dto.ListBoardResponseDto;
import com.board.controller.dto.UpdateBoardRequestDto;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ListBoardResponseDto> getBoards() {
        ListBoardResponseDto response = ListBoardResponseDto.builder().list(boardService.getBoards()).build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{boardId}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable(name = "boardId") Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @DeleteMapping(path = "/{boardId}")
    public ResponseEntity deleteBoard(@PathVariable(name = "boardId") Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<UpdateBoardRequestDto> updateBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        boardService.updateBoard(boardId, updateBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
