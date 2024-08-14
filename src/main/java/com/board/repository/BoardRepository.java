package com.board.repository;

import com.board.controller.dto.board.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query(value = "select b from BoardEntity b",
            countQuery = "select count(b.id) from BoardEntity b")
    Page<BoardEntity> findAllBoard(Pageable pageable);
}
