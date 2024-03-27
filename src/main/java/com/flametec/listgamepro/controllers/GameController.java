package com.flametec.listgamepro.controllers;

import com.flametec.listgamepro.DTO.GameMinDTO;
import com.flametec.listgamepro.entities.Game;
import com.flametec.listgamepro.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// interface do backend, controla a aplicação.
@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
