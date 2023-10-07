package screenmatchPrincipal;
import screenmatchModelos.Episodio;
import screenmatchModelos.Filme;
import screenmatchModelos.Serie;

import java.util.ArrayList;

import screenmatchCalculos.CalculadoraDeTempo;
import screenmatchCalculos.FiltroRecomedacao;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Diel", 1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeavaliacoes());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);

        System.out.println("Duração para maratonar Lost: "  + lost.getDuracaoEmMinutos()); 

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);

        System.out.println(calculadora.getTempoTotal());

        FiltroRecomedacao filtro = new FiltroRecomedacao();

        filtro.filtra(meuFilme);
        
        Episodio episodio = new Episodio("Piloto", lost.getAnoDeLancamento());
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);

        filtro.filtra(episodio);

        var filmeTester = new Filme("Dogville", 2003);
        filmeTester.setDuracaoEmMinutos(200);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(filmeTester);
        System.out.println(listaDeFilmes.size());
        System.out.println("Primeiro filme "+ listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println(listaDeFilmes.get(0).toString());
    }   
}
