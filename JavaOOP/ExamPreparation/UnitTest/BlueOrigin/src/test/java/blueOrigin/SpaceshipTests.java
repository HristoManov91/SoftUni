package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;

    @Before
    public void setUp(){
        spaceship = new Spaceship("Cosmos" , 5);
    }

    @Test
    public void testConstructorCorrectly(){
        addAstronautInSpaceship();
        assertEquals("Cosmos" , spaceship.getName());
        assertEquals(5 , spaceship.getCapacity());
        assertEquals(3 , spaceship.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCapacityWithNegativeNumberAndThrowException(){
        Spaceship spaceship = new Spaceship("Brr" , -2);
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidNameWithNullAndThrowException(){
        Spaceship spaceship = new Spaceship(null , 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddSameAstronautAndExpectedThrowException(){
        addAstronautInSpaceship();
        spaceship.add(new Astronaut("Hristo" , 29.9));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addOneMoreAstronautFromCapacityAndThrowException(){
        addAstronautInSpaceship();
        spaceship.add(new Astronaut("Gosho" , 39.9));
        spaceship.add(new Astronaut("Plamen" , 30.1));
        spaceship.add(new Astronaut("Ico" , 34.3));
    }

    @Test
    public void testRemoveWithExistingAstronautAndReturnTrue(){
        addAstronautInSpaceship();
        boolean isRemove = spaceship.remove("Hristo");
        assertTrue(isRemove);
    }

    @Test
    public void testRemoveWithNotExistingAstronautAndReturnFalse(){
        addAstronautInSpaceship();
        boolean isRemove = spaceship.remove("Gosho");
        assertFalse(isRemove);
    }

    private void addAstronautInSpaceship(){
        spaceship.add(new Astronaut("Hristo" , 29.9));
        spaceship.add(new Astronaut("Pesho" , 20.1));
        spaceship.add(new Astronaut("Ivan" , 24.3));
    }
}
