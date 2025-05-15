package br.com.ayran.conversor.servico;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiCotacao {
    private final String API_KEY = "0d137e9a494ca3c842c0f114";

    public void mostrarCotacoesParaReal() {
        List<String> moedas = List.of("USD", "EUR", "GBP", "JPY", "ARS");
        System.out.println("\n💱 Cotação atual (1 unidade de cada moeda para BRL):\n");

        for (String moeda : moedas) {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moeda;

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

                    double valor = taxas.get("BRL").getAsDouble();
                    System.out.printf("1 %s = %.4f BRL%n", moeda, valor);
                } else {
                    System.out.println("Erro na API para " + moeda + ": " + response.statusCode());
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao buscar cotação para " + moeda + ": " + e.getMessage());
            }
        }
    }
}
