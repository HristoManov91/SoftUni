package com.example.dtoex.service;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.dto.GamePrintDto;

import java.math.BigDecimal;

public interface GameService {

    void addGame(GameAddDto gameAddDto);

    void editGame(Long gameId, BigDecimal price, Double size);

    void deleteGameById(long gameId);

    void printAllGameTitleAndPrice();

    void printDetailsForGame(String gameName);
}
