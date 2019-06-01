package com.prerna.gamefinder.service;

import com.prerna.gamefinder.entity.League;
import com.prerna.gamefinder.entity.Player;
import com.prerna.gamefinder.entity.Skill;
import com.prerna.gamefinder.repository.PlayerRepository;
import com.prerna.gamefinder.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PlayerService implements IPlayerService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<Player> getAllPlayers(){
        logger.debug("Getting all players");
        List<Player> list = new ArrayList<>();
        playerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Player getPlayerById(int id){
        logger.debug("Getting player with id: "+id);
        return playerRepository.findById(id).get();
    }

    @Override
    public synchronized boolean addPlayer(Player player) {
        logger.debug("Bill is adding player: " + player);
        List<Player> list = playerRepository.findByEmail(player.getEmail());
        if (list.size() > 0) {
            return false;
        } else {
            playerRepository.save(player);
            return true;
        }
    }

    @Override
    public void deletePlayer(int playerId){
        logger.debug("Deleting player with id: " + playerId);
        playerRepository.delete(getPlayerById(playerId));
    }

    @Override
    public void updatePlayer(Player player){
        logger.debug("Updating player: " + player);
        playerRepository.save(player);
    }

    @Override
    public Player getPlayerByEmail(String email){
        List<Player> list = playerRepository.findByEmail(email);
        if (list.size() > 1) {
            logger.error("More than one player found with email" + email);
            return null; //todo: throw an exception or warning or something
        } else {
            Player player = list.get(0);
            logger.debug("Email: " + email + " ----- Got player: " + player.toString());
            return player;
        }
    }

    @Override
    public boolean addSkill(Skill skill) {
        skillRepository.save(skill);
        Player player = skill.getPlayer();
        Set<Skill> skillList = player.getSkills();
        if(skillList == null){
            skillList = new HashSet<>();
        }
        skillList.add(skill);
        player.setSkills(skillList);
        playerRepository.save(player);

        return true;
    }

    @Override
    public boolean addPlayerToLeague(Player player, League league) {
        logger.debug("Adding player " + player + "to league " + league);

        //Leagues leagues = player.getLeagues();


        return false;
    }
}