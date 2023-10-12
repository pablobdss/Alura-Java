package requestModel;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CepApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cepUser;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o seu CEP: ");
        cepUser = scanner.nextLine();

        // Crie uma instância da classe CepMethods com o CEP fornecido pelo usuário
        CepMethods cep = new CepMethods(cepUser);

        // Crie uma instância do GSON para formatar o JSON
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

        // Construa a URL da API ViaCEP com o CEP fornecido
        String endereco = String.format("https://viacep.com.br/ws/%s/json/", cep.getCep());

        // Crie um cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Crie uma solicitação HTTP para a URL da API ViaCEP
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        // Faça a solicitação e obtenha a resposta como uma string JSON
        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());

        // Obtenha a resposta JSON da API ViaCEP
        String json = response.body();

        // Desserialize o JSON em um objeto CepRecord
        CepRecord meuCepRecord = gson.fromJson(json, CepRecord.class);

        // Crie uma nova instância da classe CepMethods com base no objeto CepRecord
        CepMethods meuNovoCep = new CepMethods(meuCepRecord);
        System.out.println(meuNovoCep);

        // Escreva os dados do objeto meuNovoCep em um arquivo JSON chamado "bairros.json"
        FileWriter escrita = new FileWriter("bairros.json");
        escrita.write(gson.toJson(meuNovoCep));
        escrita.close();
    }
}
