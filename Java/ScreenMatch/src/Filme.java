public class Filme {
    String nome;
    int anoDelancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeavaliacoes;
    int duracaoEmMinutos;

    void exibeFichaTecnica(){
        System.out.println("Nome do filme " + nome);
        System.out.println("Ano de Lançamento " + anoDelancamento);
    }

    void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeavaliacoes++;
    }
}   

