package com.board.controller;

import com.board.controller.dto.CreateCommentRequestDto;
import com.board.controller.dto.GetCommentResponse;
import com.board.controller.dto.ListCommentResponse;
import com.board.controller.dto.UpdateCommentRequestDto;
import com.board.repository.CommentEntity;
import com.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(path = "/{boardId}/comment")
    public ResponseEntity<CreateCommentRequestDto> createComment(@PathVariable Long boardId, @RequestBody CreateCommentRequestDto createCommentRequestDto) {
        CreateCommentRequestDto createdComment = commentService.createComment(boardId, createCommentRequestDto);

        return ResponseEntity.created(URI.create("/boards/" + boardId + "/comment")).body(createdComment);
    }

    @GetMapping(path = "/{boardId}/comment")
    public ResponseEntity<ListCommentResponse> getComments(@PathVariable Long boardId) {

        return ResponseEntity.ok().body(new ListCommentResponse(commentService.getComments(boardId)));

    }

    @GetMapping(path = "/comment/{commentId}")
    public ResponseEntity<GetCommentResponse> getComment(@PathVariable Long commentId) {
        GetCommentResponse getCommentResponse = new GetCommentResponse(commentService.getComment(commentId));

        return ResponseEntity.ok().body(getCommentResponse);
    }

    @PatchMapping("/comment/{commentId}/edit")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequestDto updateCommentRequestDto) {
        commentService.updateComment(commentId, updateCommentRequestDto.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/comment/{commentId}")
    public ResponseEntity<CommentEntity> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
