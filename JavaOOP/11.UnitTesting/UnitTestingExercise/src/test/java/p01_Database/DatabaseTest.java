package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5 , 13 , 15 , 45 , 28};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject() {
        Assert.assertEquals(NUMBERS.length , database.getElements().length);
        Integer[] arr = database.getElements();

        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(NUMBERS[i] , arr[i]);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowLessThenOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowSupportedException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(17);

        Assert.assertEquals(NUMBERS.length + 1 , database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17) , database.getElements()[database.getElements().length - 1]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExceptionWhenDataIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void checkRemoveLastElementInArray() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(NUMBERS.length - 1 , database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i] , NUMBERS[i]);
        }
    }
}