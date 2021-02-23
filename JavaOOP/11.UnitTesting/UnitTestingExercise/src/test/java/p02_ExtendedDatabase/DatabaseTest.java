package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1 , "First") , new Person(2 , "Second") ,
            new Person(3 , "Third")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasToCreateValidObject() {
        Assert.assertEquals(PEOPLE.length , database.getElements().length);
        Person[] arr = database.getElements();

        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(PEOPLE[i] , arr[i]);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowLessThenOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowSupportedException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(new Person(4 , "Four"));

        Assert.assertEquals(PEOPLE.length + 1 , database.getElements().length);
        Assert.assertEquals( "Four", database.getElements()[database.getElements().length - 1].getUsername());
        Assert.assertEquals( 4, database.getElements()[database.getElements().length - 1].getId());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExceptionWhenDataIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void checkRemoveLastElementInArray() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(PEOPLE.length - 1 , database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i] , PEOPLE[i]);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void findByUsernameThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void findByUsernameThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null , null);
        database.findByUsername("First");
    }

    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        Assert.assertEquals(1 , resultPerson.getId());
        Assert.assertEquals("First" , resultPerson.getUsername());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void findByIDThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(-1);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void findByIDThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(new Person(1 , "First") , new Person(1 , "First"));
        database.findById(1);
    }

    @Test
    public void testFindByIDReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        Assert.assertEquals(1 , resultPerson.getId());
        Assert.assertEquals("First" , resultPerson.getUsername());
    }
}