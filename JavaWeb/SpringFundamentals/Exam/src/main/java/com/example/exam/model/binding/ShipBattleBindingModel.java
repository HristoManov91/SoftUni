package com.example.exam.model.binding;

public class ShipBattleBindingModel {

    private String attackerName;
    private String defenderName;

    public ShipBattleBindingModel() {
    }

    public String getAttackerName() {
        return attackerName;
    }

    public ShipBattleBindingModel setAttackerName(String attackerName) {
        this.attackerName = attackerName;
        return this;
    }

    public String getDefenderName() {
        return defenderName;
    }

    public ShipBattleBindingModel setDefenderName(String defenderName) {
        this.defenderName = defenderName;
        return this;
    }
}
