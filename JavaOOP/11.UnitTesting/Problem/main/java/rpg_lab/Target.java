package rpg_lab;

import java.util.Random;

public interface Target {
    boolean isDead();
    int giveExperience();
    void takeAttack(int attackPoints);
    Weapon dropWeapon(Random random);
}
