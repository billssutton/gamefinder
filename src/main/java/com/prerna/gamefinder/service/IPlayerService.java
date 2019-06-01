package com.prerna.gamefinder.service;

import com.prerna.gamefinder.entity.League;
import com.prerna.gamefinder.entity.Player;
import com.prerna.gamefinder.entity.Skill;

import java.util.List;

public interface IPlayerService {

    List<Player> getAllPlayers();
    Player getPlayerById(int id);
    boolean addPlayer(Player player);
    void updatePlayer(Player player);
    void deletePlayer(int id);

    Player getPlayerByEmail(String email);

    boolean addPlayerToLeague(Player player, League league);
    boolean addSkill(Skill skill);

}
