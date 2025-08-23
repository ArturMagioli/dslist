package com.ficcao.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficcao.dslist.dto.GameListDTO;
import com.ficcao.dslist.dto.GameMinDTO;
import com.ficcao.dslist.services.GameListService;
import com.ficcao.dslist.services.GameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;
    @Autowired GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
    
    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
