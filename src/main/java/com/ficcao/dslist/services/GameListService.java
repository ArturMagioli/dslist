package com.ficcao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficcao.dslist.dto.GameListDTO;
import com.ficcao.dslist.entities.GameList;
import com.ficcao.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
