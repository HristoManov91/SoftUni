package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {
        Integer[] array = {5 , 13 , 15 , 45 , 28};
        Database database = new Database(array);

        Assert.assertEquals(5 , database.getElements().length);
        Integer[] arr = database.getElements();

        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(array[i] , arr[i]);
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
        Integer[] numbers= {2 , 3 , 4 , 5};
        Database database = new Database(numbers);
        database.add(null);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        Integer[] numbers= {2 , 3 , 4 , 5};
        Database database = new Database(numbers);
        database.add(17);

        Assert.assertEquals(5 , database.getElements().length);
        Assert.assertEquals(Integer.valueOf(17) , database.getElements()[4]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void checkArraySizeExactlySixteenElement() throws OperationNotSupportedException {
        Database database = new Database();

        int size = database.getElements().length;

        Assert.assertEquals(16 , size);
    }

    @Test (expected =  OperationNotSupportedException.class)
    public void checkRemoveLastElementInArray() throws OperationNotSupportedException {
        Database database = new Database();
    }


}