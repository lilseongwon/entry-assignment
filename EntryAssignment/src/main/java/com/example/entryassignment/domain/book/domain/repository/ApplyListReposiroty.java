package com.example.entryassignment.domain.book.domain.repository;

import com.example.entryassignment.domain.book.domain.ApplyList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyListReposiroty extends JpaRepository<ApplyList, Long> {

    Optional<ApplyList> findByIsbn(String isbn);
}
