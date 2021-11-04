package com.example.exam.model.binding;

import javax.validation.constraints.NotNull;

public class ShipBattleBindingModel {

    @NotNull(message = "You must select the ship.")
    private Long attackerShipId;
    @NotNull(message = "You must select the ship.")
    private Long defenderShipId;

    public ShipBattleBindingModel() {
    }

    public Long getAttackerShipId() {
        return attackerShipId;
    }

    public ShipBattleBindingModel setAttackerShipId(Long attackerShipId) {
        this.attackerShipId = attackerShipId;
        return this;
    }

    public Long getDefenderShipId() {
        return defenderShipId;
    }

    public ShipBattleBindingModel setDefenderShipId(Long defenderShipId) {
        this.defenderShipId = defenderShipId;
        return this;
    }
}
