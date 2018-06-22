package com.accenture.salvo;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String GameDate;
    @OneToMany (mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();
    public Game(){}

    public Game (String date) {this.GameDate=date;}

    public String getGameDate() {
        return GameDate;
    }

    public void setGameDate(String gameDate) {
        this.GameDate = gameDate;
    }


    public Map<String,Object> map() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", this.id);
        map1.put("created", this.GameDate);
        map1.put("gamePlayers",gamePlayers.stream().map(gp ->gp.map()).collect(toList()));
        return map1;
    }


        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

