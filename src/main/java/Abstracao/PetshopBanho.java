package Abstracao;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class PetshopBanho implements InterfaceProjeto {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    private int agua = 0;          // capacidade máxima 30L
    private int shampoo = 0;       // capacidade máxima 10L
    private boolean temPet = false;
    private boolean petLimpo = false;
    private boolean precisaLimpeza = false;

    public void menu() {
        System.out.println("-----------------------Máquina de Banho------------------------");
        System.out.println("1 - Colocar pet na máquina");
        System.out.println("2 - Retirar pet da máquina");
        System.out.println("3 - Dar banho no pet");
        System.out.println("4 - Abastecer com água (+2L)");
        System.out.println("5 - Abastecer com shampoo (+2L)");
        System.out.println("6 - Verificar nível de água");
        System.out.println("7 - Verificar nível de shampoo");
        System.out.println("8 - Verificar se tem pet na máquina");
        System.out.println("9 - Limpar máquina");
        System.out.println("----------------------------------------------------------------");
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar() {

        if (opcao == 1) {
            colocarPet();

        } else if (opcao == 2) {
            retirarPet();

        } else if (opcao == 3) {
            darBanho();

        } else if (opcao == 4) {
            abastecerAgua();

        } else if (opcao == 5) {
            abastecerShampoo();

        } else if (opcao == 6) {
            System.out.println("Nível de água: " + agua + "L");

        } else if (opcao == 7) {
            System.out.println("Nível de shampoo: " + shampoo + "L");

        } else if (opcao == 8) {
            System.out.println(temPet ? "Tem pet na máquina." : "Não tem pet na máquina.");

        } else if (opcao == 9) {
            limparMaquina();
        }
    }

    private void colocarPet() {
        if (temPet) {
            System.out.println("Já existe um pet na máquina.");
            return;
        }
        if (precisaLimpeza) {
            System.out.println("A máquina está suja. Limpe antes de colocar outro pet.");
            return;
        }

        temPet = true;
        petLimpo = false;
        System.out.println("Pet colocado na máquina.");
    }

    private void retirarPet() {
        if (!temPet) {
            System.out.println("Não há pet na máquina.");
            return;
        }

        temPet = false;

        if (!petLimpo) {
            precisaLimpeza = true;
            System.out.println("Pet retirado, mas estava sujo. A máquina agora precisa ser limpa.");
        } else {
            System.out.println("Pet retirado limpo.");
        }
    }

    private void darBanho() {
        if (!temPet) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        if (agua < 10 || shampoo < 2) {
            System.out.println("Não há recursos suficientes para dar banho.");
            return;
        }

        agua -= 10;
        shampoo -= 2;
        petLimpo = true;

        System.out.println("Banho realizado com sucesso! Pet está limpo.");
    }

    private void abastecerAgua() {
        if (agua >= 30) {
            System.out.println("Tanque de água já está cheio.");
            return;
        }

        agua += 2;
        if (agua > 30) agua = 30;

        System.out.println("Água abastecida. Nível atual: " + agua + "L");
    }

    private void abastecerShampoo() {
        if (shampoo >= 10) {
            System.out.println("Tanque de shampoo já está cheio.");
            return;
        }

        shampoo += 2;
        if (shampoo > 10) shampoo = 10;

        System.out.println("Shampoo abastecido. Nível atual: " + shampoo + "L");
    }

    private void limparMaquina() {
        if (!precisaLimpeza) {
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (agua < 3 || shampoo < 1) {
            System.out.println("Não há recursos suficientes para limpar a máquina.");
            return;
        }

        agua -= 3;
        shampoo -= 1;
        precisaLimpeza = false;

        System.out.println("Máquina limpa com sucesso.");
    }
}
