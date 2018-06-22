package com.accenture.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
public class SalvoController {
    @Autowired
    private GameRepository gr;
        @RequestMapping("/api/games")
    public List<Object> getGameId (){
            List<Game> games = gr.findAll();
            return games.stream().map(game -> game.map()).collect(toList());
        }
}
