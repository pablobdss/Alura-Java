package screenmatchModelos;

public class Titulo implements Comparable <Titulo>{
    private String nome;
    private int anoDelancamento;

    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeavaliacoes;
    private int duracaoEmMinutos;

    public Titulo (String nome, int anoDelancamento){
        this.nome = nome;
        this.anoDelancamento = anoDelancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Nao foi possivel converter o ano, pois possui mais de 04 caracteres");
        }
        this.anoDelancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
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
        return String.format("Nome: (%s) \nAno de lancamento: (%d) \nDuracao do filme: (%d)\n", nome, anoDelancamento, duracaoEmMinutos);

    }
}
