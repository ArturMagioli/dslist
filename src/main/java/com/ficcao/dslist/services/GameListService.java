package com.ficcao.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficcao.dslist.dto.GameListDTO;
import com.ficcao.dslist.entities.GameList;
import com.ficcao.dslist.projections.GameMinProjection;
import com.ficcao.dslist.repositories.GameListRepository;
import com.ficcao.dslist.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);
        
        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex, obj);

        int min = Integer.min(sourceIndex, destinationIndex);
        int max = Integer.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
