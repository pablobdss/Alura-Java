import screenmatchModelos.Filme;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme= new Filme();
        meuFilme.setNome("Diel e as cachorras");
        meuFilme.anoDelancamento = 2023;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeavaliacoes());

        //System.out.println(meuFilme.somaDasAvaliacoes);
       //System.out.println(meuFilme.totalDeavaliacoes);
        
        System.out.println(meuFilme.pegaMedia());

    }   
}
