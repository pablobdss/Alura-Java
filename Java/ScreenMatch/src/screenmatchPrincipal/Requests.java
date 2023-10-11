package screenmatchPrincipal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;

import screenmatchModelos.Titulo;

public class Requests {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca");
        var busca = scanner.nextLine();

        String endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=a1254cb2", busca);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Titulo meTitulo = gson.fromJson(json, Titulo.class);

        System.out.println(meTitulo);
    }
}
