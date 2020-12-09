package bsu.rfe.java.group9.lab1.Skorohodov.varC12;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        ShoppingCart shoppingCart = new ShoppingCart(20);
        for (String arg : args) {
            if(selectOption(arg, shoppingCart.getFoodList())) continue;
            checkProducts(arg, shoppingCart.getFoodList());
        }

        for(Food food : shoppingCart.getFoodList().stream().distinct().collect(Collectors.toList()))
        System.out.println(equals(shoppingCart.getFoodList(),food));

        output(shoppingCart.getFoodList());
    }

    private static String equals(List<Food> foodList,Food food){
        int count = 0;
        if(food == null)
            return null;
        for(Food f : foodList){
            if(f.equals(food)){
                count++;
            }
        }
        return "В корзине "+ food + " " +count;
    }

    private static void output(List<Food> foodList) {
        for (Food item : foodList)
            item.consume();
        System.out.println("Всего хорошего!");
    }

    private static boolean selectOption(String arg, List<Food> foodList) {
        if(arg.equals("-calories")||arg.equals("-c")) {
            if (foodList.isEmpty()) {
                System.out.println("Нет продуктов в корзине(Каллорийность 0)");
            } else {
                int calories = foodList.stream().map(Nutritious::calculateCalories).
                        mapToInt(Integer::intValue).sum();
                System.out.println("Колличество каллорий: " + calories);
            }
            return true;
        }else if(arg.equals("-sort")||arg.equals("-s")){
                foodList.sort((o1, o2) -> o2.calculateCalories() - o1.calculateCalories());
                return true;
        }
        return false;
    }

    private static void checkProducts(String arg,List<Food> foodList) {
        String[] parts = arg.split("/");
        try {
            Class<?> c = Class.forName("bsu.rfe.java.group9.lab1.Skorohodov.varC12."+parts[0]);
            if(c==Beef.class){
                foodList.add((Beef)c.getConstructor(String.class, String.class).newInstance(parts[1], parts[2]));
            }else if(c==Apple.class){
                foodList.add((Apple)c.getConstructor(String.class).newInstance(parts[1]));
            }else {
                foodList.add((Cheese)c.newInstance());
            }
        } catch (Exception e) {
            System.err.println("Такого продукта нет");
        }
    }

}
