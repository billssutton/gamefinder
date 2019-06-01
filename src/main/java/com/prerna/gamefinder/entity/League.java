package com.prerna.gamefinder.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "league")
public class League implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long league_id;

    @Column(name = "name")
    private String name;

    @Column(name = "sport")
    private String sport;

    @Column(name = "default_location")
    private String default_location;

    @Column(name = "default_time")
    private String default_time;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "cadence")
    private Date cadence;

}
