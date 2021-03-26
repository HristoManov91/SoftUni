import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTest {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){
        axe = new Axe(10 , 10);
        dummy = new Dummy(50 , 10);
    }

    @Test
    public void testWeaponLoseDurabilityAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(9 , axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testAttackingWithBrokenWeapon(){
        axe = new Axe(10 , 1);
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
