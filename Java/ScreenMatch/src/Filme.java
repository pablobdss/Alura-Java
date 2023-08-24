public class Filme {
    String nome;
    int anoDelancamento;
    boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeavaliacoes;
    int duracaoEmMinutos;

    public int getTotalDeavaliacoes() {
        return totalDeavaliacoes;
    }

    void exibeFichaTecnica(){
        System.out.println("Nome do filme " + nome);
        System.out.println("Ano de Lançamento " + anoDelancamento);
    }

    void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeavaliacoes++;
    }

    double pegaMedia(){
        return somaDasAvaliacoes / totalDeavaliacoes;
    }
}   

