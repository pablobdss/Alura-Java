package CreditCard.src;

import java.util.ArrayList;
import java.util.List;


public class Card {
    private double limit;
    private double balance;
    private List <Compra> itens;

    public Card(double limit){
        this.limit = limit;
        this.balance = limit;
        this.itens = new ArrayList<>();
    }

    public boolean lancaCompra (Compra item){
        if(this.balance > item.getValue()){
            this.balance -= item.getValue();
            this.itens.add(item);
            return true;
        }

        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Compra> getItens() {
        return itens;
    }
}

