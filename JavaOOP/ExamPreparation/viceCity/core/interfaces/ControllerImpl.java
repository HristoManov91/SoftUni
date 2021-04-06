package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller{

    private Player mainPlayer;
    private Map<String , Player> civilPlayers;
    private GunRepository gunRepository;

    public ControllerImpl(){
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.gunRepository = new GunRepository();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer civilPlayer = new CivilPlayer(name);
        civilPlayers.put( name , civilPlayer);
        return String.format(PLAYER_ADDED , civilPlayer.getName());
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")){
            gun = new Pistol(name);
        } else if (type.equals("Rifle")){
            gun = new Rifle(name);
        } else {
            return GUN_TYPE_INVALID;
        }

        gunRepository.add(gun);
        return String.format(GUN_ADDED , name , type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = null;
        for (Gun model : gunRepository.getModels()) {
            gun = model;
            break;
        }
        if (gunRepository.getModels().isEmpty()){
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")){
            gunRepository.remove(gun);
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName() , mainPlayer.getName());
        }

        if (!civilPlayers.containsKey(name)){
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civilPlayers.get(name).getGunRepository().add(gun);
        gunRepository.remove(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER , gun.getName() , name);
    }

    @Override
    public String fight() {
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        gangNeighbourhood.action(mainPlayer , civilPlayers.values());
        if (mainPlayer.getGunRepository().getModels().isEmpty() &&
                civilPlayers.values().stream().allMatch(c -> c.getGunRepository().getModels().isEmpty())){
            return FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
            long deadCivilPlayers = civilPlayers.values().stream().filter(c -> !c.isAlive()).count();
            sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE , deadCivilPlayers)).append(System.lineSeparator());
            long liveCivilPlayers = civilPlayers.values().stream().filter(Player::isAlive).count();
            sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE , liveCivilPlayers)).append(System.lineSeparator());
            return sb.toString().trim();
        }

    }
}
