package Collections;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class Calculadora implements InterfaceProjeto {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    public void menu() {
        System.out.println("-----------------------Calculadora------------------------");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("-----------------------------------------------------------");
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar() {

        System.out.println("Digite os números separados por vírgula:");
        String entrada = scanner.nextLine();

        String[] partes = entrada.split(",");
        double[] numeros = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Double.parseDouble(partes[i].trim());
        }

        double resultado = 0;

        if (opcao == 1) {
            // SOMA
            for (double n : numeros) {
                resultado += n;
            }
            System.out.println("Resultado da soma: " + resultado);

        } else if (opcao == 2) {
            // SUBTRAÇÃO
            resultado = numeros[0];
            for (int i = 1; i < numeros.length; i++) {
                resultado -= numeros[i];
            }
            System.out.println("Resultado da subtração: " + resultado);

        } else {
            System.out.println("Opção inválida.");
        }
    }
}
