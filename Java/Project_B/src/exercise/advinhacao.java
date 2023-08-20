import java.util.Scanner;
import java.util.Random;

public class advinhacao {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        // Gera um número secreto aleatório entre 0 e 99
        int numeroSecreto = new Random().nextInt(100);
        int tentativas = 0;
        boolean escolha = true;
        int dificuldade = 0;

        /* Sistema de looping para o usuário escolher uma dificuldade do jogo, caso ele escolha um valor fora do intervalo 1 e 3, ele irá repetir o código e pedir um numer valido */
        while (escolha){
            String select = """ 
                *******************************
                *    Escolha a Dificuldade    *
                *******************************
                (1) Fácil (2) Médio 3 (Difícil)
            """;

            System.out.println(select);
            dificuldade = leitor.nextInt();

            switch (dificuldade){
                case 1:
                    dificuldade = 20;
                    escolha = false; // Sai do loop de escolha
                    break;
                case 2: 
                    dificuldade = 10; 
                    escolha = false; // Sai do loop de escolha
                    break;
                case 3:
                    dificuldade = 5;
                    escolha = false; // Sai do loop de escolha
                    break;
                default:
                    System.out.println("Por gentileza insira uma dificuldade valida");
            }
        }   

        int tentativasRestante = dificuldade;
        
        while (tentativas < dificuldade) {

            System.out.println("Digite o seu chute: ");
            int chute = leitor.nextInt();

            if (chute == numeroSecreto) {
                System.out.println("Parabéns, você acertou! :D");
                break;
            } else if (chute > numeroSecreto) {
                System.out.println("Chute maior do que o número-secreto");
            } else {
                System.out.println("Chute menor do que o número-secreto");
            }
            
            tentativas++;
            tentativasRestante--;
            // Verifica se as tentativas restantes acabaram para informar que o jogador perdeu.
            if (tentativasRestante == 0){
                System.out.println("Acabou as tentativas, você perdeu XD!");
                System.out.println("Game Over :(");
                System.out.println("O numero secreto era " + numeroSecreto);

                break; // Encerra o looping
            }
            System.out.println("Restam "+ tentativasRestante +" tentativas");

     
        }
        leitor.close();
    }
}
