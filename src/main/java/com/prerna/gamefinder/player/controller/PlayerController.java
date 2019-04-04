package com.prerna.gamefinder.player.controller;

import com.prerna.gamefinder.player.model.PlayerModel;
import com.prerna.gamefinder.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlayerController {
    @Autowired
    PlayerRepository repository;

    public void saveTest(){
        repository.save(new PlayerModel("Jack", "Smith"));
        repository.save(new PlayerModel("Adam", "Johnson"));
        repository.save(new PlayerModel("Kim", "Smith"));
        repository.save(new PlayerModel("David", "Williams"));
        repository.save(new PlayerModel("Peter", "Davis"));
    }


    public Iterable<PlayerModel> findAll(){
        Iterable<PlayerModel> result = repository.findAll();

        return result;
    }

    public PlayerModel findById(long id){
        Optional<PlayerModel> result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public Iterable<PlayerModel> findByLastName(String lastName){
        Iterable<PlayerModel> result =  repository.findByLastName(lastName);
        return result;
    }
}