package com.demo.app;

import com.demo.app.manager.BeverageManager;

public class BeverageManagerApplication {

    public static void main(String[] args) {

        BeverageManager manager = new BeverageManager();

        String order = "Coffee,-milk,-water,Chai,Mojito";

        final double totalOrderPrice = manager.getTotalOrderPrice(order);

        System.out.println("Total order price :" + totalOrderPrice);

    }
}
