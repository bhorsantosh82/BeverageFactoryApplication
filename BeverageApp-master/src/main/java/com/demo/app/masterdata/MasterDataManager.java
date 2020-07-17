package com.demo.app.masterdata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterDataManager {
    // String constants for shop items
    private static final String COFFEE = "coffee";
    private static final String CHAI = "chai";
    private static final String BANANA_SMOOTHIE = "banana smoothie";
    private static final String STRAWBERRY_SHAKE = "strawberry shake";
    private static final String MOJITO = "mojito";

    // String constants for ingredients
    private static final String SUGAR = "sugar";
    private static final String WATER = "water";
    private static final String MILK = "milk";
    private static final String SODA = "soda";
    private static final String MINT = "mint";


    private MasterDataManager() {
    }

    public static Map<String, List<String>> getBeveragesMap() {

        Map<String, List<String>> beveragesMap = new HashMap<>();
        beveragesMap.put(COFFEE, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(CHAI, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(BANANA_SMOOTHIE, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(STRAWBERRY_SHAKE, Arrays.asList(WATER, MILK, SUGAR));
        beveragesMap.put(MOJITO, Arrays.asList(SUGAR, WATER, SODA, MINT));
        return beveragesMap;
    }

    public static Map<String, Double> getItemRates() {

        Map<String, Double> itemRates = new HashMap<>();

        itemRates.put(COFFEE,5.0d);

        itemRates.put(CHAI,4.0d);

        itemRates.put(BANANA_SMOOTHIE,6.0d);

        itemRates.put(STRAWBERRY_SHAKE,7.0d);

        itemRates.put(MOJITO, 7.5d);


        return itemRates;
    }

    public static Map<String, Double> getIngredientRates() {

        Map<String, Double> ingredientRates = new HashMap<>();
        ingredientRates.put(MILK, 1.0d);
        ingredientRates.put(SUGAR, 0.5d);
        ingredientRates.put(SODA, 0.5d);
        ingredientRates.put(MINT, 0.5d);
        ingredientRates.put(WATER, 0.5d);

        return ingredientRates;
    }


}

