package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroGainsXpByKillingTarget(){
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Test Hero", weapon);

        Target target = Mockito.mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(10);
        hero.attack(target);

        assertEquals(10 , hero.getExperience());
    }

    @Test
    public void testItemDropShouldDropCorrectly(){
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Test Hero", weapon);
        Target target = Mockito.mock(Target.class);

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(2);

        

        when(target.dropWeapon(random)).thenReturn()
    }
}