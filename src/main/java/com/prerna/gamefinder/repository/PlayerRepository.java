package com.prerna.gamefinder.player.repository;

import com.prerna.gamefinder.player.model.PlayerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<PlayerModel, Long> {
    List<PlayerModel> findByLastName(String lastName);

    List<PlayerModel> findByFirstNameandAndLastName(String firstName, String lastName);

    @Query("SELECT a FROM Player a WHERE a.firstName=:firstName and a.lastName=:lastName")
    List<PlayerModel> fetchPlayers(@Param("firstName") String title, @Param("lastName") String lastName);

}
