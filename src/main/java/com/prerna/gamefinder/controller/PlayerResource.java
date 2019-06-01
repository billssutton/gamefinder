package com.prerna.gamefinder.controller;

import com.prerna.gamefinder.entity.Skill;
import com.prerna.gamefinder.service.IPlayerService;
import com.prerna.gamefinder.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IPlayerService playerService;

    @RequestMapping("/savetest")
    public String process() {
        logger.info("adding players");
        playerService.addPlayer(new Player("Jack.Smith@fake.com"));
        playerService.addPlayer(new Player("Adam.Johnson@fake.com"));
        playerService.addPlayer(new Player("Kim.Smith@fake.com"));
        playerService.addPlayer(new Player("David.Williams@fake.com"));
        playerService.addPlayer(new Player("Peter.Davis@fake.com"));

        logger.info("adding skills");
        playerService.addSkill(new Skill("Basketball", 2.0, playerService.getPlayerById(1)));
        playerService.addSkill(new Skill("Soccer", 8.0, playerService.getPlayerById(1)));
        playerService.addSkill(new Skill("Tennis", 1.0, playerService.getPlayerById(1)));
        playerService.addSkill(new Skill("Tennis", 9.0, playerService.getPlayerById(3)));
        playerService.addSkill(new Skill("Tennis", 9.0, playerService.getPlayerById(2)));
        playerService.addSkill(new Skill("Tennis", 9.0, playerService.getPlayerById(4)));
        playerService.addSkill(new Skill("Tennis", 9.0, playerService.getPlayerById(5)));

//        logger.info("getting skills");
//        playerService

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";

        for(Player play : playerService.getAllPlayers()){
            result += play.toString() + "</br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") int id){
        String result = playerService.getPlayerById(id).toString();
        return result;
    }

    @RequestMapping("/findbyemail")
    public String fetchDataByLastName(@RequestParam("email") String email){
        String result = "";

        Player play = playerService.getPlayerByEmail(email);
            result = play.toString() + "</br>";

        return result;
    }
}