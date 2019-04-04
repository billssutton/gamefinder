package com.prerna.gamefinder.player.web;

import com.prerna.gamefinder.player.controller.PlayerController;
import com.prerna.gamefinder.player.model.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerResource {
    @Autowired
    PlayerController playerController;

    @RequestMapping("/saveTest")
    public String process() {
        playerController.saveTest();
        return "Done";
    }

    @RequestMapping("/findAll")
    public String findAll() {
        String result = "";

        for(PlayerModel play : playerController.findAll()){
            result += play.toString() + "</br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = playerController.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "";

        for(PlayerModel play: playerController.findByLastName(lastName)){
            result += play.toString() + "</br>";
        }

        return result;
    }
}