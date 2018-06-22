package com.accenture.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner initData(PlayerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Player("eze@hotmail.com"));
			repository.save(new Player("mati@hotmail.com"));		};
	}*/

    @Bean
    public CommandLineRunner initData(GameRepository repository,GamePlayerRepository gamePlayerRepository, PlayerRepository playerRepository) {
        return (args) -> {
            // save a couple of customers

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            Date date = new Date();

            Game game1 = repository. save(new Game(formatter.format(date)));

            Date date1 = date.from(date.toInstant().plusSeconds(3600));
            Game game2 = repository.save(new Game(formatter.format(date1)));


            Date date2 = date.from(date.toInstant().plusSeconds(7200));
            Game game3 = repository.save(new Game(formatter.format(date2)));

            Player jbauer = playerRepository.save(new Player("j.bauer"));
            Player ccorban = playerRepository.save(new Player("c.corban"));
            Player talmeida = playerRepository.save(new Player("t.almeida"));


            GamePlayer gp = gamePlayerRepository.save(new GamePlayer(game1, jbauer));
            GamePlayer gp2 = gamePlayerRepository.save(new GamePlayer(game2, ccorban));
            GamePlayer gp3 = gamePlayerRepository.save(new GamePlayer(game3, talmeida));


        };
	}
}
