package Fundamentos;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class Fundamento implements InterfaceProjeto {
    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    public void menu(){
        System.out.println("-----------------------Selecione a atividade------------------------");
        System.out.println("1 - Calcular a idade.");
        System.out.println("2 - Calcular a área do quadrado.");
        System.out.println("3 - Calcular a área do retângulo.");
        System.out.println("4 - Calcular a diferença de idade entre duas pessoas.");
        System.out.println("---------------------------------------------------------------------");
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar(){
        if (opcao == 1) {
            String nome = scanner.nextLine();
            int anoNascimento = scanner.nextInt();
            scanner.nextLine();
            int idade = 2025 - anoNascimento;
            System.out.printf("Olá %s você tem %s anos", nome, idade);

        } else if (opcao == 2) {
            double lado = scanner.nextDouble();
            scanner.nextLine();
            double area = lado * lado;
            System.out.println("A área do quadrado é: " + area);

        } else if (opcao == 3) {
            double base = scanner.nextDouble();
            double altura = scanner.nextDouble();
            scanner.nextLine();
            double area = base * altura;
            System.out.println("A área do retângulo é: " + area);

        } else if (opcao == 4) {
            String nome1 = scanner.nextLine();
            int idade1 = scanner.nextInt();
            scanner.nextLine();
            String nome2 = scanner.nextLine();
            int idade2 = scanner.nextInt();
            int diferenca = Math.abs(idade1 - idade2);
            System.out.println("A diferença de idade entre " + nome1 + " e " + nome2 + " é " + diferenca + " anos");
        }
    }
}
