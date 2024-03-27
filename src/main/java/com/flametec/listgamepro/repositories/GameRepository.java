package com.flametec.listgamepro.repositories;

import com.flametec.listgamepro.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
