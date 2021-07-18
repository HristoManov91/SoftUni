package com.example.dtoex.service.impl;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.dto.GamePrintDto;
import com.example.dtoex.model.entity.Game;
import com.example.dtoex.repository.GameRepository;
import com.example.dtoex.service.GameService;
import com.example.dtoex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if (!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto , Game.class);

        gameRepository.save(game);

        System.out.println("Added game " + game.getTitle());
    }

    @Override
    public void editGame(Long gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId).orElse(null);
        if (game == null){
            System.out.println("Not valid gameId");
            return;
        }
        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
    }

    @Override
    public void deleteGameById(long gameId) {
        Game game = gameRepository.findById(gameId).orElse(null);
        if (game == null){
            System.out.println("Not valid gameId");
            return;
        }
        gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public void printAllGameTitleAndPrice() {
        gameRepository.findAll().forEach(game -> System.out.printf("%s %.2f%n" , game.getTitle() , game.getPrice()));
    }

    @Override
    public void printDetailsForGame(String gameName) {
        Game game = gameRepository.findAll()
                .stream()
                .filter(g -> g.getTitle().equals(gameName))
                .findFirst()
                .orElse(null);

        if (game == null){
            System.out.println("We don't have this game " + gameName);
            return;
        }
        System.out.printf("Title: %s%n" +
                "Price: %.2f%n" +
                "Description: %s%n" +
                "Release date: %s%n", game.getTitle() , game.getPrice() , game.getDescription() , game.getReleaseDate());
    }
}
