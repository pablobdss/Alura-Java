package CreditCard.src;

public class Compra implements Comparable<Compra>{
    private String description;
    private double value;

    public Compra (String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }
    
    public double getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Compra: descrição = " + description + "valor = " + value;
    }

    @Override
    public int compareTo(Compra anotherItem) {
        return Double.valueOf(this.value).compareTo(Double.valueOf(anotherItem.value));
    }
}
