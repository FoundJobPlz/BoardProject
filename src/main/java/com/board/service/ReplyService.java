package com.board.service;

import com.board.controller.dto.CreateReplyRequestDto;
import com.board.controller.dto.ReplyDto;
import com.board.repository.CommentEntity;
import com.board.repository.CommentRepository;
import com.board.repository.ReplyEntity;
import com.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public void createReply(Long commentId, CreateReplyRequestDto createReplyRequestDto) {

        CommentEntity commentEntity = CommentFindByIdOrThrow(commentId);

        ReplyEntity replyEntity = ReplyEntity.builder()
                .content(createReplyRequestDto.getContent())
                .userId(createReplyRequestDto.getUserId())
                .commentEntity(commentEntity).build();

        replyRepository.save(replyEntity);
    }

    public List<ReplyDto> getReplyList(Long commentId) {

        if(!commentRepository.existsById(commentId)) throw new IllegalArgumentException("댓글이 존재하지 않습니다");

        return replyRepository.findAllByCommentEntityId(commentId).stream()
                .map(ReplyEntity ->
                        ReplyDto.builder().id(ReplyEntity.getId())
                                .content(ReplyEntity.getContent())
                                .userId(ReplyEntity.getUserId())
                                .commentId(ReplyEntity.getCommentEntity().getId())
                                .build())
                .toList();
    }

    public ReplyDto getReply(Long replyId) {
        ReplyEntity replyEntity = replyFindByIdOrThrow(replyId);

        return ReplyDto.builder()
                .id(replyEntity.getId())
                .content(replyEntity.getContent())
                .userId(replyEntity.getUserId())
                .commentId(replyEntity.getCommentEntity().getId())
                .build();
    }

    @Transactional
    public void deleteReply(Long replyId) {
        if(replyRepository.existsById(replyId)) {
            replyRepository.deleteById(replyId);
            return;
        }
        throw new IllegalArgumentException("존재하지 않는 답글입니다.");
    }

    @Transactional
    public void updateReply(Long replyId, String newContent) {
        ReplyEntity replyEntity = replyFindByIdOrThrow(replyId);

        replyEntity.updateReply(newContent);
    }

    private CommentEntity CommentFindByIdOrThrow(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글은 존재하지 않습니다"));
    }

    private ReplyEntity replyFindByIdOrThrow(Long replyId) {
        return replyRepository.findById(replyId).orElseThrow(() -> new IllegalArgumentException("해당 답글이 존재하지 않습니다."));
    }
}
