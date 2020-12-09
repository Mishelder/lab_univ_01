package bsu.rfe.java.group9.lab1.Skorohodov.varC12;

public class Cheese extends Food implements Nutritious {
    public Cheese() {
        super("Сыр");
    }

    public void consume() {
        System.out.println(this.name + " съеден" + " каллорий " + calculateCalories());
    }

    @Override
    public int calculateCalories() {
        return 50;
    }


}
