package br.com.ayran.conversor.leitor;

import java.util.Scanner;

public class LeitorTeclado {
    private static final Scanner scanner = new Scanner(System.in);

    public static String ler(String mensagem) {
        exibirMoedasSuportadas();
        System.out.print(mensagem);
        return scanner.nextLine().trim().toUpperCase();
    }

    private static void exibirMoedasSuportadas() {
        System.out.println("\n💱 Moedas disponíveis para conversão:");
        System.out.println("USD - Dólar Americano");
        System.out.println("BRL - Real Brasileiro");
        System.out.println("EUR - Euro");
        System.out.println("GBP - Libra Esterlina");
        System.out.println("JPY - Iene Japonês");
        System.out.println("ARS - Peso Argentino\n");
    }
}
