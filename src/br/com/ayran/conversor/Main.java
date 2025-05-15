package br.com.ayran.conversor;

import br.com.ayran.conversor.modelo.Conversao;
import br.com.ayran.conversor.servico.ApiConversor;
import br.com.ayran.conversor.servico.ApiCotacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ApiConversor api = new ApiConversor();
        ApiCotacao cotacao = new ApiCotacao();

        System.out.println("""
                Bem-vindo ao Conversor de Moedas!
                Moedas disponíveis:
                
                USD - Dólar Americano
                BRL - Real Brasileiro
                EUR - Euro
                GBP - Libra Esterlina
                JPY - Iene Japonês
                ARS - Peso Argentino
                """);

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Menu:");
            System.out.println("1 - Converter moeda");
            System.out.println("2 - Verificar cotação");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar o buffer do scanner

                if (opcao == 1) {
                    System.out.print("Digite a moeda de origem (ex: USD): ");
                    String origem = scanner.nextLine().toUpperCase();

                    System.out.print("Digite a moeda de destino (ex: BRL): ");
                    String destino = scanner.nextLine().toUpperCase();

                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // limpar o buffer

                    Conversao conversao = api.buscarTaxa(origem, destino);

                    if (conversao != null) {
                        double convertido = conversao.converterValor(valor);
                        System.out.printf("Resultado: %.2f %s = %.2f %s%n",
                                valor, origem, convertido, destino);
                    } else {
                        System.out.println("Não foi possível realizar a conversão.");
                    }

                } else if (opcao == 2) {
                    cotacao.mostrarCotacoesParaReal();

                } else if (opcao == 3) {
                    System.out.println("Encerrando o programa. Até logo!");

                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } else {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); // limpar entrada inválida
            }
        }

        scanner.close();
    }
}
