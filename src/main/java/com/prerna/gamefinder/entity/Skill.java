package com.prerna.gamefinder.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "player")
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sport")
    private String sport;

    @Column(name = "selfassessed_value")
    private Double selfassessed_value;

    @ManyToOne
    @JoinColumn
    private Player player;

    public Skill(){
    }

    public Skill(String sport, Double selfassessed_value, Player player){
        setSport(sport);
        setSelfassessed_value(selfassessed_value);
        setPlayer(player);
    }

}
