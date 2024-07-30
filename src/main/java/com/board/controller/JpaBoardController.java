package com.board.controller;

import com.board.controller.dto.CreateBoardRequestDto;
import com.board.controller.dto.GetBoardResponseDto;
import com.board.controller.dto.ListBoardResponse;
import com.board.controller.dto.UpdateBoardRequestDto;
import com.board.repository.BoardEntity;
import com.board.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class JpaBoardController {

    private final JpaBoardService boardService;

    @PostMapping
    public ResponseEntity<BoardEntity> createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        CreateBoardRequestDto createBoard = boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.created(URI.create("http://loaclhost:8080")).build();
    }

    @GetMapping
    public ResponseEntity<ListBoardResponse> getBoards() {

        return ResponseEntity.ok().body(new ListBoardResponse(boardService.getBoards()));
    }

    @GetMapping(path = "/{boardId}")
    public ResponseEntity<GetBoardResponseDto> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @DeleteMapping(path = "/{boardId}")
    public ResponseEntity<BoardEntity> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<UpdateBoardRequestDto> updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {
        boardService.updateBoard(boardId, updateBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
