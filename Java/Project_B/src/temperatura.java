public class temperatura {
    public static void main(String[] args) {
        double celcius = 28.5;
        double fahrenheit = (celcius * 1.8) + 32;

        String mensagem = String.format("A temperatura em celcius é de %.1f e em Fahrenheit é de %.1f", celcius, fahrenheit);
        System.out.println(mensagem);

        int fahrenheitInteira = (int) (fahrenheit);

        System.out.println(fahrenheitInteira);
    }




}
