package com.ficcao.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ficcao.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
