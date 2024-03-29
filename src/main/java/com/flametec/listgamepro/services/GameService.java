package com.flametec.listgamepro.services;

import com.flametec.listgamepro.DTO.GameDTO;
import com.flametec.listgamepro.DTO.GameMinDTO;
import com.flametec.listgamepro.entities.Game;
import com.flametec.listgamepro.projections.GameMinProjection;
import com.flametec.listgamepro.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Injetando componentes no sistema com Service.
@Service
public class GameService {
    // service devolve DTO.
    @Autowired
    private GameRepository gamerepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gamerepository.findById(id).get();
        return new GameDTO(result);
        }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll () {
        List<Game> result = gamerepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return  dto;

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList (Long ListId) {
        List<GameMinProjection> result = gamerepository.searchByList(ListId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return  dto;

    }


}
