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

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Component
public class PlayerSevice implements IPlayerService{
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
    public Player getPlayerById(long id){
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
    public boolean addSkillToPlayer(Skill skill, Player player) {
        logger.debug("Adding skill " + skill + "to league " + player);

        List<Skill> skills = player.getSkillList();

        if(skills == null) {
            skills = new Vector<Skill>();
        }

        for (Skill s : skills) {
            logger.debug("player already has skill : " + s);
        }

        skills.add(skill);
        player.setSkillList(skills);
        skillRepository.save(skill);
        playerRepository.save(player);

        return false;
    }

    @Override
    public boolean addPlayerToLeague(Player player, League league) {
        logger.debug("Adding player " + player + "to league " + league);

        //Leagues leagues = player.getLeagues();


        return false;
    }
}