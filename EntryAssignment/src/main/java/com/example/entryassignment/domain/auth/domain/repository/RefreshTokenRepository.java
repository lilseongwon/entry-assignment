package com.example.entryassignment.domain.auth.domain.repository;

import com.example.entryassignment.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

    Optional<RefreshToken> findByToken(String RefreshToken);
}