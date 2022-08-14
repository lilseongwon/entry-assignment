package com.example.entryassignment.domain.apply.domain.repository;

import com.example.entryassignment.domain.apply.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplyReposiroty extends JpaRepository<Apply, Long> {

    Optional<Apply> findByIsbn(String isbn);

    Apply findApplyListByIsbn(String isbn);

    List<Apply> findAllByOrderById();

}