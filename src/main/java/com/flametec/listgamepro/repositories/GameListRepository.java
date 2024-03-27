package com.flametec.listgamepro.repositories;

import com.flametec.listgamepro.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
