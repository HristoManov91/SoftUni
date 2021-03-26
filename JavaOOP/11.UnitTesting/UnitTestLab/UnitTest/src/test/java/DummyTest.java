import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class DummyTest {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){
        axe = new Axe(10 , 10);
        dummy = new Dummy(50 , 10);
    }

    @Test
    public void testDummyLossHealthAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(40 , dummy.getHealth());
        axe.attack(dummy);
        Assert.assertEquals(30 , dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyAfterAttackThrowException(){
        while (true){
            axe.attack(dummy);
        }
    }

    @Test
    public void testDeadDummyCanGiveXP(){
        dummy = new Dummy(0 , 10);
        int i = dummy.giveExperience();
        Assert.assertEquals(10 , i);
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXP(){
        dummy.giveExperience();
    }
}
