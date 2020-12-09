package bsu.rfe.java.group9.lab1.Skorohodov.varC12;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Food> foodList;

    public ShoppingCart(int size) {
        this.foodList = new ArrayList<>(size);
    }

    public ShoppingCart(List<Food> foodList){
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
