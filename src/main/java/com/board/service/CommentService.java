package com.board.service;

import com.board.controller.dto.comment.CreateCommentRequestDto;
import com.board.controller.dto.comment.CommentDto;
import com.board.controller.dto.comment.GetCommentReplyResponseDto;
import com.board.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentQueryRepository commentQueryRepository;

    @Transactional
    public void createComment(Long boardId, CreateCommentRequestDto createCommentRequestDto) {
        BoardEntity boardEntity = boardFindByIdOrThrow(boardId);

        CommentEntity commentEntity = CommentEntity.builder()
                .content(createCommentRequestDto.getContent())
                .userId(createCommentRequestDto.getUserId())
                .boardEntity(boardEntity)
                .build();

        commentRepository.save(commentEntity);
    }

    @Transactional(readOnly = true)
    public List<CommentDto> getComments(Long boardId) {

        if (!boardRepository.existsById(boardId)) throw new IllegalArgumentException("존재하지 않는 게시판입니다.");

        return commentRepository.findAllByBoardEntityId(boardId)
                .stream()
                .map(commentEntity ->
                        CommentDto.builder().id(commentEntity.getId())
                                .content(commentEntity.getContent())
                                .boardId(commentEntity.getBoardEntity().getId())
                                .userId(commentEntity.getUserId())
                                .build()
                )
                .toList();
    }

    @Transactional(readOnly = true)
    public GetCommentReplyResponseDto getComment(Long commentId) {
        return commentQueryRepository.findCommentReply(commentId);
//        CommentEntity commentEntity = commentFindByIdOrThrow(commentId);
//
//        return CommentDto.builder()
//                .id(commentEntity.getId())
//                .content(commentEntity.getContent())
//                .boardId(commentEntity.getBoardEntity().getId())
//                .userId(commentEntity.getUserId())
//                .build();
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
            return;
        }

        throw new IllegalArgumentException("존재하지 않는 댓글입니다.");
    }

    @Transactional
    public void updateComment(Long commentId, String newContent) {
        CommentEntity findComment = commentFindByIdOrThrow(commentId);

        findComment.updateContent(newContent);
    }

    private BoardEntity boardFindByIdOrThrow(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
    }

    private CommentEntity commentFindByIdOrThrow(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글은 존재하지 않습니다"));
    }
}
