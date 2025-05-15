package br.com.ayran.conversor.servico;

import br.com.ayran.conversor.modelo.Conversao;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConversor {
    private final String API_KEY = "0d137e9a494ca3c842c0f114";

    public Conversao buscarTaxa(String moedaOrigem, String moedaDestino) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaOrigem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject taxas = json.getAsJsonObject("conversion_rates");

                if (taxas.has(moedaDestino)) {
                    double taxa = taxas.get(moedaDestino).getAsDouble();

                    // Retorna a conversão com taxa preenchida
                    return new Conversao(moedaOrigem, moedaDestino, taxa);
                } else {
                    System.out.println("Moeda de destino não encontrada.");
                }
            } else {
                System.out.println("Erro: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }

        return null; // Retorna null em caso de erro
    }
}
