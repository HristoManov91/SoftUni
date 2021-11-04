package com.example.exam.service.impl;

import com.example.exam.model.entity.ShipEntity;
import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.service.ShipBattleServiceModel;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.service.UserServiceModel;
import com.example.exam.repository.ShipRepository;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public ShipServiceImpl(ShipRepository shipRepository, CategoryService categoryService, UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.shipRepository = shipRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");

        ShipEntity ship = modelMapper.map(shipServiceModel, ShipEntity.class);
        UserEntity user = userService.findByUsername(userServiceModel.getUsername());
        ship.setUserEntity(user);
        ship.setCategory(categoryService.findByName(shipServiceModel.getCategory()));


        shipRepository.save(ship);
    }

    @Override
    public List<ShipBattleServiceModel> findAllShipFromLoggetUser() {
        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        UserEntity user = userService.findByUsername(userServiceModel.getUsername());

        return shipRepository
                .findAllByUserEntity_Username(user.getUsername())
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipBattleServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipBattleServiceModel> findAllShipWithoutLoginUser() {
        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        UserEntity user = userService.findByUsername(userServiceModel.getUsername());

        return shipRepository
                .findAllByUserEntity_UsernameNotEquals(user.getUsername())
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipBattleServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipBattleServiceModel> findAllShipsOrderByIdAndStatus() {
        return shipRepository
                .findAll()
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipBattleServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void attack(Long attackerId, Long defenderId) {
        Optional<ShipEntity> attackerEntity = shipRepository.findById(attackerId);
        Optional<ShipEntity> defenderEntity = shipRepository.findById(defenderId);

        if (attackerEntity.isEmpty() || defenderEntity.isEmpty()){
            return;
        }

        ShipEntity defender = defenderEntity.get();
        ShipEntity attacker = attackerEntity.get();
        if (defender.getHealth() > attacker.getPower()){
            defender.setHealth(defender.getHealth() - (attacker.getPower().floatValue()));
            shipRepository.save(defender);
        } else {
            shipRepository.delete(defender);
        }
    }
}
