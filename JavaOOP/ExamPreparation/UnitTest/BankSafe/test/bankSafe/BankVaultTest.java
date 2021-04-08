package bankSafe;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BankVaultTest {

    BankVault bankVault;

    @Before
    public void setUp(){
        bankVault = new BankVault();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemWithCellExistingAndThrowException() throws OperationNotSupportedException {
        Item item = new Item("Hristo" , "asd");
        bankVault.addItem("Z1" , item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemOffBusyCellAndThrowException() throws OperationNotSupportedException {
        Item item = new Item("Hristo" , "123");
        Item item2 = new Item("Ivan" , "asd");
        bankVault.addItem("A1" , item);
        bankVault.addItem("A1" , item2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddItemThatContainsInCollectionAndThrowException() throws OperationNotSupportedException {
        Item item = new Item("Hristo" , "123");
        bankVault.addItem("A1" , item);
        bankVault.addItem("A2" , item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveItemFromNotExistingCellAndThrowException(){
        Item item = new Item("Hristo" , "123");
        bankVault.removeItem("Z1" , item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveItemFromCellIsEmpty(){
        Item item = new Item("Hristo" , "123");
        bankVault.removeItem("A1" , item);
    }

    @Test
    public void testAfterRemoveItemCellEqualsNullAndReturnMessage() throws OperationNotSupportedException {
        Item item = new Item("Hristo" , "123");
        bankVault.addItem("A1" , item);
        String removeMessage = bankVault.removeItem("A1", item);
        assertEquals(String.format("Remove item:%s successfully!", item.getItemId()) , removeMessage);
        assertNull(bankVault.getVaultCells().get("A1"));
    }

    //TODO: Write your tests here

}