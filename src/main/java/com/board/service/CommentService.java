package com.board.service;

import com.board.controller.dto.CreateCommentRequestDto;
import com.board.controller.dto.GetCommentResponseDto;
import com.board.controller.dto.ListCommentResponseDto;
import com.board.controller.dto.UpdateCommentRequestDto;
import com.board.repository.BoardEntity;
import com.board.repository.CommentEntity;
import com.board.repository.CommentRepository;
import com.board.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final JpaBoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public CreateCommentRequestDto createComment(Long boardId, CreateCommentRequestDto createCommentRequestDto) {

        BoardEntity boardEntity = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
        CommentEntity commentEntity = new CommentEntity(createCommentRequestDto.getContent(), createCommentRequestDto.getUserId(), boardEntity);
        commentRepository.save(commentEntity);

        return new CreateCommentRequestDto(commentEntity.getContent(), commentEntity.getUserId(), boardEntity.getId());
    }

    public List<ListCommentResponseDto> getComments(Long boardId) {

        boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        return commentRepository.findByBoardEntityId(boardId).stream().map(commentEntity ->
                new ListCommentResponseDto(
                        commentEntity.getId(),
                        commentEntity.getContent(),
                        commentEntity.getUserId(),
                        commentEntity.getBoardEntity().getId()))
                .toList();
    }

    public GetCommentResponseDto getComment(Long commentId) {
        CommentEntity commentEntity = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글은 존재하지 않습니다"));
        return new GetCommentResponseDto(commentEntity.getId(), commentEntity.getContent(), commentEntity.getUserId(), commentEntity.getBoardEntity().getId());
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, String newContent) {

        CommentEntity findComment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글은 존재하지 않습니다"));
        findComment.setContent(newContent);
    }

    public void clearComment() {
        commentRepository.deleteAll();
    }
}
