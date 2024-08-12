package com.board.controller;

import com.board.controller.dto.CreateReplyRequestDto;
import com.board.controller.dto.ListReplyResponseDto;
import com.board.controller.dto.ReplyDto;
import com.board.controller.dto.UpdateReplyRequestDto;
import com.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping(path = "/{commentId}/reply")
    public ResponseEntity createReply(@PathVariable(name = "commentId") Long commentId, @RequestBody CreateReplyRequestDto createReplyRequestDto) {
        replyService.createReply(commentId, createReplyRequestDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{commentId}/reply")
    public ResponseEntity<ListReplyResponseDto> getReplyList(@PathVariable(name = "commentId") Long commentId) {
        List<ReplyDto> replies = replyService.getReplyList(commentId);

        ListReplyResponseDto responseDto = ListReplyResponseDto.builder()
                .replyList(replies)
                .build();
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping(path = "/reply/{replyId}")
    public ResponseEntity<ReplyDto> getReply(@PathVariable(name = "replyId") Long replyId) {
        ReplyDto responseDto = replyService.getReply(replyId);

        return ResponseEntity.ok().body(responseDto);
    }

    @PatchMapping(path = "/reply/{replyId}")
    public ResponseEntity updateReply(@PathVariable(name = "replyId") Long replyId, @RequestBody UpdateReplyRequestDto updateReplyRequestDto) {
        replyService.updateReply(replyId, updateReplyRequestDto.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/reply/{replyId}")
    public ResponseEntity deleteReply(@PathVariable(name = "replyId") Long replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.ok().build();
    }
}
