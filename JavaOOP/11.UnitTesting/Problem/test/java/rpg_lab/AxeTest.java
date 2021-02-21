package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;

    private Axe axe;
    private Dummy dummy;


    @Test
    public void testAxeLoosesDurabilityAfterAttack(){
        axe = new Axe(AXE_ATTACK , AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH , DUMMY_XP);
        axe.attack(dummy);

        assertEquals(0 , axe.getDurabilityPoints());
    }

    @Test
    public void testAxeCanLoosesAllDurabilityAfterAttack(){
        axe = new Axe(AXE_ATTACK , AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH , DUMMY_XP);
        axe.attack(dummy);

        assertEquals(0 , axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)//когато очакваме да хвърли някаква грешка
    public void testAttackWithBrokenAxe(){
        Axe axe = new Axe(10 , 0);
        Dummy dummy = new Dummy(1000 , 10);
        axe.attack(dummy);
    }

}