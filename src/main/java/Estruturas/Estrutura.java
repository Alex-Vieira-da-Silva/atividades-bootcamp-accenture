package Estruturas;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class Estrutura implements InterfaceProjeto {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    public void menu() {
        System.out.println("-----------------------Selecione a atividade-------------------------");
        System.out.println("1 - Gera a tabuada de 1 até 10 desse número");
        System.out.println("2 - Calcular o IMC");
        System.out.println("3 - Calcular todos os números pares ou ímpares");
        System.out.println("4 - Calcular número que tenha resto diferente de 0 na divisão");
        System.out.println("----------------------------------------------------------------------");
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar() {

        if (opcao == 1) {
            int numero = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }

        } else if (opcao == 2) {
            double peso = scanner.nextDouble();
            double altura = scanner.nextDouble();
            scanner.nextLine();

            double imc = peso / (altura * altura);

            if (imc <= 18.5) {
                System.out.println("Abaixo do peso");
            } else if (imc <= 24.9) {
                System.out.println("Peso ideal");
            } else if (imc <= 29.9) {
                System.out.println("Levemente acima do peso");
            } else if (imc <= 34.9) {
                System.out.println("Obesidade Grau I");
            } else if (imc <= 39.9) {
                System.out.println("Obesidade Grau II (Severa)");
            } else {
                System.out.println("Obesidade III (Mórbida)");
            }

        } else if (opcao == 3) {
            int primeiro = scanner.nextInt();
            int segundo = scanner.nextInt();
            scanner.nextLine();

            String tipo = scanner.nextLine();

            if (segundo < primeiro) {
                System.out.println("O segundo número deve ser maior que o primeiro.");
                return;
            }

            for (int i = segundo; i >= primeiro; i--) {
                if (tipo.equalsIgnoreCase("par") && i % 2 == 0) {
                    System.out.println(i);
                }
                if (tipo.equalsIgnoreCase("impar") && i % 2 != 0) {
                    System.out.println(i);
                }
            }

        } else if (opcao == 4) {
            int base = scanner.nextInt();

            while (true) {
                int numero = scanner.nextInt();

                if (numero < base) {
                    continue;
                }

                if (numero % base != 0) {
                    System.out.println("Encerrando. Resto diferente de 0.");
                    break;
                }

                System.out.println("Número válido: " + numero);
            }
        }
    }
}