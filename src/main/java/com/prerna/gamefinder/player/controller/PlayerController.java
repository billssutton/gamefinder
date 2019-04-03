package com.prerna.gamefinder.player.controller;

import com.prerna.gamefinder.player.model.PlayerModel;
import com.prerna.gamefinder.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    PlayerRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new PlayerModel("Jack", "Smith"));
        repository.save(new PlayerModel("Adam", "Johnson"));
        repository.save(new PlayerModel("Kim", "Smith"));
        repository.save(new PlayerModel("David", "Williams"));
        repository.save(new PlayerModel("Peter", "Davis"));
        return "Done";
    }
}