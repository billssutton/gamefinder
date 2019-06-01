package com.prerna.gamefinder.repository;

import com.prerna.gamefinder.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByLastName(String lastName);
    List<Player> findByFirstNameAndLastName(String firstName, String lastName);
    List<Player> findByEmail(String email);

    @Query("SELECT a FROM Player a WHERE a.firstName=:firstName and a.lastName=:lastName")
    List<Player> fetchPlayers(@Param("firstName") String title, @Param("lastName") String lastName);

}
