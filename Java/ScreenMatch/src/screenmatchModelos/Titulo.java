package screenmatchModelos;

import com.google.gson.annotations.SerializedName;
public class Titulo implements Comparable <Titulo>{
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDelancamento;

    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeavaliacoes;
    private int duracaoEmMinutos;

    public Titulo (String nome, int anoDelancamento){
        this.nome = nome;
        this.anoDelancamento = anoDelancamento;
    }

    
    public String getNome(){
        return nome;
    }

    public int getAnoDeLancamento (){
        return anoDelancamento;
    }

    public boolean isIncluidoNoPlano(){
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }

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

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString(){
        return String.format("Nome: %s \nAno de lancamento: %d", nome, anoDelancamento);

    }
}
