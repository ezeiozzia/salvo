package com.accenture.salvo;

import com.accenture.salvo.Game;
import com.accenture.salvo.Player;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    public GamePlayer(){

    }

    public GamePlayer(Game game, Player player){
        this.player = player;
        this.game = game;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<String,Object> map(){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", this.id);
        map1.put("player", player.mapPlayer());
        return map1;
    }
}

