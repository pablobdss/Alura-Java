import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        // Declaração das variaveis
        Scanner leitor = new Scanner(System.in);
        String nome = "Diel Batista";
        String tipoDeConta = "Corrente";
        double saldoAtual = 2500;
        boolean menu = true;
        
        String dados = String.format("""
        ***************************************
        Dados iniciais do cliente:

        Nome:            %s 
        Tipo conta:      %s
        Saldo inicial:   R$ %.2f
        ***************************************

        """, nome, tipoDeConta, saldoAtual);
        
        System.out.println(dados);
        // Menu de seleção do usuario
        while (menu){

            String operation = String.format("""
            Operações Bancárias:

            1- Consultar saldos
            2- Receber valor
            3- Transferir valor
            4- Sair            

            Digite a opção desejada:
            """);
            System.out.println(operation);
            int escolha = leitor.nextInt();

            switch (escolha){
                
                case 1:

                    System.out.println(String.format("Seu saldo atual é R$ %.2f", saldoAtual)); // Mostra ao usuario o saldo atual da sua conta
                    continue; // interrompe a execução da iteração atual do loop e passa para a próxima iteração.
                case 2:

                    System.out.println("\nInforme o valor a receber: \n");
                    double receber = leitor.nextDouble();
                    saldoAtual += receber;
                    System.out.println(String.format("Saldo atualizado!\nSeu saldo atual é R$ %.2f\n", saldoAtual));
                    continue;// interrompe a execução da iteração atual do loop e passa para a próxima iteração.
                case 3:
                    System.out.println("\nInforme o valor a transferir: \n");
                    double transferir = leitor.nextDouble();
                    if (transferir < saldoAtual){ // sistema de verificação para caso o valor da trasnferencia seja maior que o saldo atual, ele informe ao usuario e nao realize a operação
                        saldoAtual -= transferir;
                        System.out.println(String.format("Saldo atualizado!\nSeu saldo atual é R$ %.2f\n", saldoAtual));
                    }
                    else{
                        System.out.println("Seu saldo é insuficiente para essa transferencia\n");
                    }
                    continue;// interrompe a execução da iteração atual do loop e passa para a próxima iteração.
                case 4:
                    System.out.println("Tenha um bom dia e até mais!");
                    menu = false; // menu se torna falso encerrando o looping
                    break;

                default:
                    System.out.println("Por gentileza insira uma entrada válida");
                    // default ira servir para caso a opção do usuario nao esteja dentro das expecatitvas de intervalo 1,4.
            }
        }





        leitor.close();
    }
}
