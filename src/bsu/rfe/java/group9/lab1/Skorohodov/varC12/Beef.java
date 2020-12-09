package bsu.rfe.java.group9.lab1.Skorohodov.varC12;

public class Beef extends Food implements Nutritious {

    private final String size;
    private final String preparedness;

    public Beef(String size, String preparedness) {
        super("Beef");
        this.size = size;
        this.preparedness = preparedness;
    }


    @Override
    public void consume() {
        System.out.println(this + " съедено" + " каллорий " + calculateCalories());
    }

    public String getSize() {
        return size;
    }

    public String getPreparedness() {
        return preparedness;
    }

    @Override
    public String toString() {
        return super.toString() + " размера " + size.toUpperCase() + " готовность " + preparedness;
    }

    @Override
    public int calculateCalories() {
        if (this.size == null) {
            return 0;
        }
        switch (this.size.toLowerCase()) {
            case "малый":
                return 100;
            case "средний":
                return 200;
            case "большой":
                return 300;
            default:
                return 0;
        }
    }

    @Override
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Beef)) return false;
            return (size.equals(((Beef) arg0).size)&&preparedness.equals(((Beef) arg0).preparedness));
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return (size.length() + preparedness.length())+41;
    }
}
