package com.prerna.gamefinder.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private Set<Skill> skills;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Player(){
    }

    public Player(String email, Skill... skills){
        setEmail(email);
        this.skills = Stream.of(skills).collect(Collectors.toSet());
        this.skills.forEach(x -> x.setPlayer(this));
    }
}
