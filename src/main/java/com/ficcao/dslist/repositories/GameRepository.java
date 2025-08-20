package com.ficcao.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ficcao.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
        
}
