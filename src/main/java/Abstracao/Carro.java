package Abstracao;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class Carro implements InterfaceProjeto {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    private boolean ligado;
    private int velocidade;
    private int marcha; // 0 a 6

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public void menu() {
        System.out.println("-----------------------Controle do Carro------------------------");
        System.out.println("1 - Ligar carro");
        System.out.println("2 - Desligar carro");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Diminuir velocidade");
        System.out.println("5 - Virar esquerda/direita");
        System.out.println("6 - Verificar velocidade");
        System.out.println("7 - Trocar marcha");
        System.out.println("----------------------------------------------------------------");
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar() {

        if (opcao == 1) {
            ligar();

        } else if (opcao == 2) {
            desligar();

        } else if (opcao == 3) {
            acelerar();

        } else if (opcao == 4) {
            diminuirVelocidade();

        } else if (opcao == 5) {
            virar();

        } else if (opcao == 6) {
            System.out.println("Velocidade atual: " + velocidade + " km/h");

        } else if (opcao == 7) {
            trocarMarcha();
        }
    }

    // ---------------------- FUNÇÕES DO CARRO ----------------------

    private void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
            return;
        }
        ligado = true;
        System.out.println("Carro ligado.");
    }

    private void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
            return;
        }
        if (velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar. Coloque em ponto morto e velocidade 0.");
        }
    }

    private void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não é possível acelerar em ponto morto.");
            return;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade máxima atingida.");
            return;
        }

        int novaVelocidade = velocidade + 1;

        if (!velocidadePermitida(novaVelocidade, marcha)) {
            System.out.println("A velocidade não é permitida para a marcha atual.");
            return;
        }

        velocidade = novaVelocidade;
        System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
    }

    private void diminuirVelocidade() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade == 0) {
            System.out.println("O carro já está parado.");
            return;
        }

        velocidade -= 1;
        System.out.println("Reduzindo... Velocidade atual: " + velocidade + " km/h");
    }

    private void virar() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Só é possível virar entre 1 km/h e 40 km/h.");
            return;
        }

        System.out.println("Digite 'E' para esquerda ou 'D' para direita:");
        String direcao = scanner.nextLine();

        if (direcao.equalsIgnoreCase("E")) {
            System.out.println("Virando à esquerda...");
        } else if (direcao.equalsIgnoreCase("D")) {
            System.out.println("Virando à direita...");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private void trocarMarcha() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        System.out.println("Informe a nova marcha (0 a 6):");
        int novaMarcha = scanner.nextInt();
        scanner.nextLine();

        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }

        if (Math.abs(novaMarcha - marcha) != 1) {
            System.out.println("Não é permitido pular marchas.");
            return;
        }

        if (!velocidadePermitida(velocidade, novaMarcha)) {
            System.out.println("A velocidade atual não é permitida para essa marcha.");
            return;
        }

        marcha = novaMarcha;
        System.out.println("Marcha atual: " + marcha);
    }

    // ---------------------- REGRAS DE VELOCIDADE ----------------------

    private boolean velocidadePermitida(int vel, int marcha) {
        return switch (marcha) {
            case 0 -> vel == 0;
            case 1 -> vel >= 0 && vel <= 20;
            case 2 -> vel >= 21 && vel <= 40;
            case 3 -> vel >= 41 && vel <= 60;
            case 4 -> vel >= 61 && vel <= 80;
            case 5 -> vel >= 81 && vel <= 100;
            case 6 -> vel >= 101 && vel <= 120;
            default -> false;
        };
    }
}
