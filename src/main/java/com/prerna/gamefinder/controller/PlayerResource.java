package com.prerna.gamefinder.player.web;

import com.prerna.gamefinder.service.PlayerSevice;
import com.prerna.gamefinder.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerResource {
    @Autowired
    PlayerSevice playerSevice;

    @RequestMapping("/saveTest")
    public String process() {
        playerSevice.saveTest();
        return "Done";
    }

    @RequestMapping("/findAll")
    public String findAll() {
        String result = "";

        for(Player play : playerSevice.findAll()){
            result += play.toString() + "</br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = playerSevice.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "";

        for(Player play: playerSevice.findByLastName(lastName)){
            result += play.toString() + "</br>";
        }

        return result;
    }
}