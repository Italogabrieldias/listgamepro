package com.flametec.listgamepro.services;

import com.flametec.listgamepro.DTO.GameListDTO;
import com.flametec.listgamepro.entities.GameList;
import com.flametec.listgamepro.projections.GameMinProjection;
import com.flametec.listgamepro.repositories.GameListRepository;
import com.flametec.listgamepro.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();

    }
    @Transactional(readOnly = true)
    public void move(Long ListId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(ListId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i<=max;i++){
            gameListRepository.updateBelongingPosition(ListId, list.get(i).getId(),i);

        }
        }

}
