package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        List<Player> players = new ArrayList<>(civilPlayers);
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        for (Gun gun : guns) {
            while (gun.canFire() && players.stream().anyMatch(Player::isAlive)){
                Player player = players.get(0);
                player.takeLifePoints(gun.fire());
                if (!player.isAlive()){
                    players.remove(0);
                }
            }
        }

        if (players.stream().anyMatch(Player::isAlive)) {
            for (Player player : players) {
                Collection<Gun> models = player.getGunRepository().getModels();
                for (Gun model : models) {
                    while (model.canFire() || mainPlayer.isAlive()){
                        mainPlayer.takeLifePoints(model.fire());
                    }
                    if (!mainPlayer.isAlive()){
                        return;
                    }
                }
            }
        }


    }
}
