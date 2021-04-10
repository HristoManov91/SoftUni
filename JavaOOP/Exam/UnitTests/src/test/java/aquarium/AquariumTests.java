package aquarium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    Aquarium aquarium;

    @Before
    public void setUp(){
        aquarium = new Aquarium("Akvarium" , 10);
    }

    @Test (expected = NullPointerException.class)
    public void testCtorWithNullNameAndThrowException(){
        aquarium = new Aquarium(null , 5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCtorWithNegativeCapacityAndThrowException(){
        aquarium = new Aquarium("asd" , -5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddElementInFullCapacityAndThrowException(){
        aquarium = new Aquarium("asd" , 1);
        aquarium.add(new Fish("Pesho"));
        aquarium.add(new Fish("Ivan"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFishNotExisting(){
        aquarium = new Aquarium("aasd" , 2);
        aquarium.add(new Fish("Pesho"));
        aquarium.remove("Ivan");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAquariumSellNotExistingFish(){
        aquarium = new Aquarium("aasd" , 2);
        aquarium.add(new Fish("Pesho"));
        aquarium.sellFish("Ivan");
    }

    @Test
    public void testAquariumReport() {
        aquarium = new Aquarium("asd", 3);
        aquarium.add(new Fish("Ivan"));
        aquarium.add(new Fish("Pesho"));
        String report = aquarium.report();
        assertEquals("Fish available at asd: Ivan, Pesho", report);
    }

    @Test
    public void testAquariumGetCount(){
        aquarium.add(new Fish("ivan"));
        aquarium.add(new Fish("pesho"));
        aquarium.add(new Fish("hristo"));
        assertEquals(3 , aquarium.getCount());
    }

    @Test
    public void testSellFishAvailable(){
        aquarium.add(new Fish("Ivan"));
        aquarium.add(new Fish("Pesho"));
        Fish ivan = aquarium.sellFish("Ivan");
        assertFalse(ivan.isAvailable());
    }
}

