package com.accenture.salvo;


import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    @OneToMany (mappedBy = "player" , fetch=FetchType.EAGER)
    Set<GamePlayer> players = new HashSet<>();
    public Player(String userName){
        this.userName = userName;
    }
    public Player(){

    }
    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public Map<String,Object> mapPlayer(){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", this.id);
        map1.put("email", this.userName);
        return map1;
    }
}
