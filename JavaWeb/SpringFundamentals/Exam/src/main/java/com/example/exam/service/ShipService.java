package com.example.exam.service;

import com.example.exam.model.service.ShipBattleServiceModel;
import com.example.exam.model.service.ShipServiceModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipBattleServiceModel> findAllShipFromLoggetUser();

    List<ShipBattleServiceModel> findAllShipWithoutLoginUser();

    List<ShipBattleServiceModel> findAllShipsOrderByIdAndStatus();

    void attack(String attacker , String defender);
}
