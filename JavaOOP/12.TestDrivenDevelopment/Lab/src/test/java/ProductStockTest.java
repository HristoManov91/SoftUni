import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductStockTest {
    private Instock instock;

    @Before
    public void setUp(){
        instock = new Instock();
    }

    @Test
    public void testGetCountShouldReturnTwoWhenTwoProductsAdded(){
        instock.add(new Product("test_label_1" , 100.0 , 1));
        instock.add(new Product("test_label_2" , 200.0 , 1));

        assertEquals(Integer.valueOf(2) , instock.getCount());
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty(){
        assertEquals(Integer.valueOf(0) , instock.getCount());
    }

    @Test
    public void testAddProductCorrect(){
        Product product = new Product("test_label_1" , 100.0 , 1);
        instock.add(product);
        Product fakeProduct = new Product("gosho" , 123,1);

        assertFalse(instock.contains(fakeProduct));
        assertTrue(instock.contains(product));
    }

    @Test
    public void testFindByIndexIsBounds(){
        addElements();
        Product product = instock.find(6);
        assertEquals("test_label_5" , product.getLabel());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testFindByIndexOutOfBoundsAndThrowException(){
        addElements();
        Product product = instock.find(20);
    }

    @Test
    public void testChangeQuantityOfValidProductAndReturned(){
        addElements();
        instock.changeQuantity("test_label_1" , 13);
        assertEquals(13 , instock.findByLabel("test_label_1").getQuantity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeQuantityOfWrongProductAndThrowException(){
        addElements();
        instock.changeQuantity("ivan" , 20);
    }

    @Test
    public void testFindByValidLabelAndReturned(){
        addElements();
        Product product = instock.findByLabel("test_label_2");

        assertEquals("test_label_2" , product.getLabel());
        assertEquals(125.0 , product.getPrice() , 0.5);
        assertEquals(21 , product.getQuantity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindByInvalidLabelAndThrowException(){
        addElements();
        instock.findByLabel("ico");
    }

    @Test
    public void testFindByAlphabeticalOrderShouldReturnedEmptyCollectionIfCountIsOutOfRange(){
        addElements();
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(instock.getCount() + 1);
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        for (Product product : iterable) {
            products.add(product);
        }
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindByAlphabeticalOrderShouldReturnedCollections(){
        addElements();
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(3);
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        assertEquals(3 , products.size());
    }

    private void addElements(){
        instock.add(new Product("test_label_0" , 100.0 , 1));
        instock.add(new Product("test_label_1" , 1000.0 , 11));
        instock.add(new Product("test_label_2" , 125.0 , 21));
        instock.add(new Product("test_label_3" , 105.5 , 35));
        instock.add(new Product("test_label_4" , 55.55 , 45));
        instock.add(new Product("test_label_5" , 77.77 , 54));
        instock.add(new Product("test_label_6" , 33.44 , 77));
        instock.add(new Product("test_label_7" , 99.98 , 64));
        instock.add(new Product("test_label_8" , 69.99 , 13));
        instock.add(new Product("test_label_9" , 89.99 , 26));
    }

}