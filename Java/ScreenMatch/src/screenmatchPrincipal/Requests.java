package screenmatchPrincipal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import screenmatchModelos.ErroDeConversaoDeAnoException;
import screenmatchModelos.Titulo;
import screenmatchModelos.TituloOmdb;

public class Requests {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
       
        while (!busca.equalsIgnoreCase("sair")){
            System.out.println("Digite um filme para busca \nSe deseja sair, digite SAIR \n");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            String endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=a1254cb2", busca.replace(" ", "+"));
            
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco)).build();
    
                HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
    
                String json = response.body();
                System.out.println(json);
    
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println("\nResultado" + meuTituloOmdb);
    
                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("\nConversão\n" + meuTitulo);
    
                titulos.add(meuTitulo);
    
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Endereco com erro");
            } catch (ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }    
        }
        System.out.println(titulos);
        
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Finalizou dboas");


    }
}
