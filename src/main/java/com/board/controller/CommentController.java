package com.board.controller;

import com.board.controller.dto.comment.*;
import com.board.repository.CommentEntity;
import com.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class CommentController {

    private final CommentService commentService;

    @PostMapping(path = "/{boardId}/comment")
    public ResponseEntity<?> createComment(@PathVariable(name = "boardId") Long boardId, @RequestBody CreateCommentRequestDto createCommentRequestDto) {
        commentService.createComment(boardId, createCommentRequestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{boardId}/comment")
    public ResponseEntity<ListCommentResponseDto> getComments(@PathVariable(name = "boardId") Long boardId) {
        List<CommentDto> comments = commentService.getComments(boardId);

        ListCommentResponseDto responseDto = ListCommentResponseDto.builder().comments(comments).build();

        return ResponseEntity.ok().body(responseDto);

    }

    @GetMapping(path = "/{boardId}/comment/{commentId}")
    public ResponseEntity<CommentQueryDto> getComment(@PathVariable(name = "boardId") Long boardId, @PathVariable(name = "commentId") Long commentId) {
        CommentQueryDto responseDto = commentService.getComment(boardId,commentId);

        return ResponseEntity.ok().body(responseDto);
    }

    @PatchMapping("/{boardId}/comment/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable(name = "boardId") Long boardId, @PathVariable(name = "commentId") Long commentId, @RequestBody UpdateCommentRequestDto updateCommentRequestDto) {
        commentService.updateComment(boardId,commentId, updateCommentRequestDto.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{boardId}/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "boardId") Long boardId, @PathVariable(name = "commentId") Long commentId) {
        commentService.deleteComment(boardId, commentId);
        return ResponseEntity.ok().build();
    }
}
