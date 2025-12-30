package Collections;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class FormatadorTelefone {

    private final Scanner scanner = new Scanner(System.in);

    public void executar() {
        System.out.println("Digite um número de telefone:");
        String entrada = scanner.nextLine();

        String resultado = formatarTelefone(entrada);
        System.out.println(resultado);
    }

    public String formatarTelefone(String entrada) {

        String numeros = entrada.replaceAll("\\D", "");

        if (entrada.matches("\\(\\d{2}\\)\\d{4}-\\d{4}")) {
            return entrada + " → Telefone fixo com DDD";
        }
        if (entrada.matches("\\(\\d{2}\\)\\d{5}-\\d{4}")) {
            return entrada + " → Celular com DDD";
        }
        if (entrada.matches("\\d{4}-\\d{4}")) {
            return entrada + " → Telefone fixo sem DDD";
        }
        if (entrada.matches("\\d{5}-\\d{4}")) {
            return entrada + " → Celular sem DDD";
        }

        int qtd = numeros.length();

        switch (qtd) {

            case 8: // FIXO sem DDD
                return formatarFixoSemDDD(numeros) + " → Telefone fixo sem DDD";

            case 9: // CELULAR sem DDD
                return formatarCelularSemDDD(numeros) + " → Celular sem DDD";

            case 10: // FIXO com DDD
                return formatarFixoComDDD(numeros) + " → Telefone fixo com DDD";

            case 11: // CELULAR com DDD
                return formatarCelularComDDD(numeros) + " → Celular com DDD";

            default:
                return "Número inválido. Quantidade de dígitos incompatível.";
        }
    }


    private String formatarFixoSemDDD(String n) {
        return n.substring(0, 4) + "-" + n.substring(4);
    }

    private String formatarCelularSemDDD(String n) {
        return n.substring(0, 5) + "-" + n.substring(5);
    }

    private String formatarFixoComDDD(String n) {
        return "(" + n.substring(0, 2) + ")" + n.substring(2, 6) + "-" + n.substring(6);
    }

    private String formatarCelularComDDD(String n) {
        return "(" + n.substring(0, 2) + ")" + n.substring(2, 7) + "-" + n.substring(7);
    }
}
