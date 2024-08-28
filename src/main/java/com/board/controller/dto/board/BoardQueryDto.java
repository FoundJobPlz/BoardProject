package com.board.controller.dto.board;

import com.board.repository.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardQueryDto {

    private Long id;
    private String title;
    private String content;
    private String userId;
    private List<GetBoardCommentResponseDto> comments;

    private String createdBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public BoardQueryDto(Long id, String title, String content, String userId, String createdBy, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;

    }

    public void putComments(List<GetBoardCommentResponseDto> comments) {
        this.comments = comments;
    }
}
