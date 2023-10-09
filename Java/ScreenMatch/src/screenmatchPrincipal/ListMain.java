package screenmatchPrincipal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import screenmatchModelos.Filme;
import screenmatchModelos.Serie;
import screenmatchModelos.Titulo;

public class ListMain {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Diel", 1970);
        Filme outroFilme = new Filme("Avatar", 2023);
        var filmeTester = new Filme("Dogville", 2003);
        Serie lost = new Serie("Lost", 2000);

        meuFilme.avalia(9);
        outroFilme.avalia(8);
        filmeTester.avalia(2);

        List<Titulo> lista = new LinkedList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeTester);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());

            }
        }

        ArrayList<String> buscaPorArtistas = new ArrayList<>();
        buscaPorArtistas.add("Adam Sandler");
        buscaPorArtistas.add("Paulo");
        buscaPorArtistas.add("Jacqueline");
        System.out.println(buscaPorArtistas);

        Collections.sort(buscaPorArtistas);
        System.out.println("modification"+ buscaPorArtistas);

        Collections.sort(lista);
        System.out.println("Modification \n"+ lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano\n" + lista);

    }
}
