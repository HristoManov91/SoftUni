package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    Player player;
    List<Gun> guns;

    @Before
    public void setUp() {
        player = new Player("Hunter", 100);
        guns = new ArrayList<>();
    }

    @Test
    public void testValidGetUsername() {
        assertEquals("Hunter", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testNullUsername() {
        player = new Player(null, 100);
    }

    @Test (expected = NullPointerException.class)
    public void testEmptyUsername(){
        player = new Player("   " , 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHealthWithNegativeNumberAndThrowException(){
        player = new Player("Hristo" , -5);
    }

    @Test
    public void testGetHealth(){
        assertEquals(100 , player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunWithNullThrowException() {
        player.addGun(null);
    }

    @Test
    public void testAddGunCorrect() {
        addGuns();
        Gun gun = player.getGun("Makarov");
        assertEquals("Makarov", gun.getName());
        assertEquals(12, gun.getBullets());
    }

    @Test (expected = IllegalStateException.class)
    public void testTakeDamageWithDeadPlayerAndThrowException(){
        player = new Player("Hristo" , 0);
        player.takeDamage(10);
    }

    @Test
    public void testTakeDamageWithLessDamageThanBlood(){
        player.takeDamage(10);
        assertEquals(90 , player.getHealth());
    }

    @Test
    public void testTakeDamageWithMoreDamageThanHealthAndHealthEqualZero(){
        player.takeDamage(110);
        assertEquals(0 , player.getHealth());
    }

    @Test
    public void testGetGunWrongGun(){
        addGuns();
        Gun gun = player.getGun("pesho");
        assertNull(gun);
    }

    @Test
    public void testRemoveExistingWeapon(){
        addGuns();
        Gun gun = player.getGun("Makarov");
        assertTrue(player.removeGun(gun));
        assertEquals(2 , player.getGuns().size());
    }

//    @Test
//    public void testGetGunsReturnUnmodifiableList(){
//        addGuns();
//        List<Gun> guns = player.getGuns();
//        int size = guns.size();
//        assertFalse(guns.add(new Gun("asd" , 10)));
//        assertEquals(size , guns.size());
//    }


    private void addGuns() {
        player.addGun(new Gun("Makarov", 12));
        player.addGun(new Gun("Remington", 50));
        player.addGun(new Gun("Glock", 20));
    }
}
