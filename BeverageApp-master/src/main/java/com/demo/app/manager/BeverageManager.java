package com.demo.app.manager;

import com.demo.app.masterdata.MasterDataManager;
import com.demo.app.exception.InvalidOrderException;
import java.util.*;
import java.util.stream.Collectors;

public class BeverageManager {

    Map<String, List<String>> availableBeverageMap = MasterDataManager.getBeveragesMap();

    Map<String, Double> rates = MasterDataManager.getItemRates();

    Map<String, Double> ingredientRates = MasterDataManager.getIngredientRates();

    public double getTotalOrderPrice(String order) {
        double cost = 0.0;
        String orders[]=order.split("(?!,\\s*-),");
        List<String> orderElements = Arrays.stream(orders).map(String::toLowerCase).collect(Collectors.toList());
        for (String element : orderElements) {
            List<String> elementWithIngredients = Arrays.stream(element.split(",")).map(s -> s.replace("-", "")).collect(Collectors.toList());
            orderValidator(element);
            cost = cost + calculatePrice(elementWithIngredients);
        }
        return cost;
    }

    private void orderValidator(String element) {
        List<String> elementIngredients = Arrays.stream(element.split(",")).map(s -> s.replace("-", "")).collect(Collectors.toList());

        if (!availableBeverageMap.containsKey(elementIngredients.get(0)))
            throw new InvalidOrderException("Invalid item ordered : " + element);

        List<String> allIngredients = availableBeverageMap.get(elementIngredients.get(0));

        if (elementIngredients.size() == allIngredients.size() + 1)
            throw new InvalidOrderException("Invalid Order. You cannot exclude all items");

        Optional<String> duplicateIngredient = elementIngredients.stream().filter(i -> Collections.frequency(elementIngredients, i) > 1).findFirst();
        if (duplicateIngredient.isPresent())
            throw new InvalidOrderException("Duplicate ingredient not allowed : " + duplicateIngredient.get());

        List<String> ingredients = elementIngredients.subList(1, elementIngredients.size());
        boolean validIngredients = ingredients.stream().allMatch(t -> allIngredients.stream().anyMatch(t::contains));

        if (!validIngredients)
            throw new InvalidOrderException("Invalid ingredient in order");

    }

    private Double calculatePrice(List<String> elementWithIngredients) {
        Double itemValue = rates.get(elementWithIngredients.get(0));
        Double ingredientsValue = 0.0d;
        if (elementWithIngredients.size() > 1)
            for (int i = 1; i < elementWithIngredients.size(); i++) {
                ingredientsValue = ingredientsValue + ingredientRates.get(elementWithIngredients.get(i));
            }
        return itemValue - ingredientsValue;
    }

}
