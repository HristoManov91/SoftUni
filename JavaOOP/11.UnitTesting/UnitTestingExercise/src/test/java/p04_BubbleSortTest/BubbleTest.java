package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void testSort(){
        int[] array = {100 , 13 , 25 , -4 , 6 , 57};
        Bubble.sort(array);
        int[] arrayAfterSort = {-4 , 6 , 13 , 25 , 57 , 100};

        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(arrayAfterSort[i] , array[i]);
        }
    }
}