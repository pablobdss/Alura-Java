package cepMain;

import requestModel.Endereco;
import requestModel.GeradorDeArquivo;
import java.io.IOException;
import java.util.Scanner;

import requestModel.CepConsult;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        CepConsult consultaCep = new CepConsult();

        System.out.println("Digite um número de CEP para consulta:");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}