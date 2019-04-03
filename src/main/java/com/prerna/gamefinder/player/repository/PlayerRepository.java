package com.prerna.gamefinder.player.repository;

import com.prerna.gamefinder.player.model.PlayerModel;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerModel, Long> {

}
