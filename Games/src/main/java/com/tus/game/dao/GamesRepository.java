package com.tus.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tus.game.entity.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long>{}