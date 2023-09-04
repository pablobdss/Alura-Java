package screenmatchModelos;

public class Filme {
    private String nome;
    private int anoDelancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeavaliacoes;
    private int duracaoEmMinutos;

    public int getTotalDeavaliacoes() {
        return totalDeavaliacoes;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDelancamento){
        this.anoDelancamento = anoDelancamento;
    } 

    public void setIncluidoNoPlano(boolean incluidoNoPlano){
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos){
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme " + nome);
        System.out.println("Ano de Lançamento " + anoDelancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeavaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeavaliacoes;
    }
}   


