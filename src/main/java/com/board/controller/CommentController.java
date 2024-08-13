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

    @GetMapping(path = "/comment/{commentId}")
    public ResponseEntity<GetCommentReplyResponseDto> getComment(@PathVariable(name = "commentId") Long commentId) {
        GetCommentReplyResponseDto responseDto = commentService.getComment(commentId);

        return ResponseEntity.ok().body(responseDto);
    }

    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable(name = "commentId") Long commentId, @RequestBody UpdateCommentRequestDto updateCommentRequestDto) {
        commentService.updateComment(commentId, updateCommentRequestDto.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
