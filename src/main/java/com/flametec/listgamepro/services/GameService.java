package com.flametec.listgamepro.services;

import com.flametec.listgamepro.DTO.GameMinDTO;
import com.flametec.listgamepro.entities.Game;
import com.flametec.listgamepro.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Injetando componentes no sistema com Service.
@Service
public class GameService {
    // service devolve DTO.
    @Autowired
    private GameRepository gamerepository;
    public List<GameMinDTO> findAll () {
        List<Game> result = gamerepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return  dto;

    }


}
