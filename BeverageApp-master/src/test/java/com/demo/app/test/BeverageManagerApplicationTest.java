package com.demo.app.test;

import com.demo.app.manager.BeverageManager;
import com.demo.app.exception.InvalidOrderException;
import org.junit.Assert;
import org.junit.Test;


public class BeverageManagerApplicationTest {

    BeverageManager manager = new BeverageManager();

    @Test(expected = InvalidOrderException.class)
    public void testForEmptyOrder() {
        String order = "";
        Assert.assertEquals(0.0d, manager.getTotalOrderPrice(order), 0.0d);
    }

    @Test
    public void testSuccessFulOrder() {
        Assert.assertEquals(2.5d, manager.getTotalOrderPrice("Chai,-milk,-water"), 0.0d);
    }

    @Test
    public void testForOrderCompleteOrder() {
        String order = "Chai,Coffee";
        Assert.assertEquals(9.0d, manager.getTotalOrderPrice(order), 0.0d);
    }

    @Test(expected = InvalidOrderException.class)
    public void testForOrderWithAllExclusions() {
        String order = "Coffee,-milk,-sugar,-water";
        Assert.assertEquals(0.0d, manager.getTotalOrderPrice(order), 0.0d);
    }

    @Test(expected = InvalidOrderException.class)
    public void testOrderWithDuplicateIngredients() {
        String order = "Chai,-water,-water,Coffee,Mojito";
        Assert.assertEquals(0.0d, manager.getTotalOrderPrice(order), 0.0d);

    }

}