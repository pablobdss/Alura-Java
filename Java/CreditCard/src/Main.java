package CreditCard.src;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o limite do cartão: ");
        double limit = scanner.nextDouble();
        Card cartao = new Card(limit); 

        int sair = 1;

        while(sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String description = scanner.next();

            System.out.println("Digite o valor da compra:");
            double value = scanner.nextDouble();

            Compra compra = new Compra(description, value);
            boolean itemBought = cartao.lancaCompra(compra);

            if (itemBought) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = scanner.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(cartao.getItens());

        for (Compra c : cartao.getItens()) {
            System.out.println(c.getDescription() + " - " + c.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " + cartao.getBalance());
    }


}