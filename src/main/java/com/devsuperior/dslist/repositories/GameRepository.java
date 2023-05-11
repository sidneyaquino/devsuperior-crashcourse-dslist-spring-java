package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
}