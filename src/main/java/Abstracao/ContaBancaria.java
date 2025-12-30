package Abstracao;

import Interfaces.InterfaceProjeto;

import java.util.Scanner;

public class ContaBancaria implements InterfaceProjeto {

    private final Scanner scanner = new Scanner(System.in);
    private int opcao;

    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialDisponivel;
    private double valorUsadoChequeEspecial;

    public void menu() {
        System.out.println("-----------------------Conta Bancária------------------------");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Consultar cheque especial");
        System.out.println("3 - Depositar dinheiro");
        System.out.println("4 - Sacar dinheiro");
        System.out.println("5 - Pagar boleto");
        System.out.println("6 - Verificar uso do cheque especial");
        System.out.println("----------------------------------------------------------------");
    }

    public ContaBancaria(double depositoInicial) {

        this.saldo = depositoInicial;

        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecialDisponivel = limiteChequeEspecial;
        this.valorUsadoChequeEspecial = 0;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void executar() {

        if (opcao == 1) {
            /* Consultar saldo */
            System.out.println("Saldo atual: R$" + saldo);

        } else if (opcao == 2) {
            /* Consultar cheque especial */
            System.out.println("Cheque especial disponível: R$" + chequeEspecialDisponivel);

        } else if (opcao == 3) {
            /* Depositar dinheiro */
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (valor <= 0) {
                System.out.println("Valor inválido.");
                return;
            }

            if (valorUsadoChequeEspecial > 0) {
                double taxa = valorUsadoChequeEspecial * 0.20;
                double totalParaQuitar = valorUsadoChequeEspecial + taxa;

                if (valor >= totalParaQuitar) {
                    valor -= totalParaQuitar;
                    valorUsadoChequeEspecial = 0;
                    chequeEspecialDisponivel = limiteChequeEspecial;
                    System.out.println("Cheque especial quitado com taxa de 20%.");
                } else {
                    valorUsadoChequeEspecial -= valor;
                    chequeEspecialDisponivel = limiteChequeEspecial - valorUsadoChequeEspecial;
                    System.out.println("Depósito usado para reduzir o cheque especial.");
                    return;
                }
            }

            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");

        } else if (opcao == 4) {
            /* Sacar dinheiro */
            double valor = scanner.nextDouble();
            scanner.nextLine();

            if (valor <= 0) {
                System.out.println("Valor inválido.");
                return;
            }

            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque realizado com sucesso.");
            } else {
                double restante = valor - saldo;

                if (restante <= chequeEspecialDisponivel) {
                    saldo = 0;
                    chequeEspecialDisponivel -= restante;
                    valorUsadoChequeEspecial += restante;
                    System.out.println("Saque realizado usando cheque especial.");
                } else {
                    System.out.println("Saldo insuficiente, mesmo com cheque especial.");
                }
            }

        } else if (opcao == 5) {
            /* Pagar boleto */
            double valor = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Tentando pagar boleto de R$" + valor);

            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Boleto pago com sucesso.");
            } else {
                double restante = valor - saldo;

                if (restante <= chequeEspecialDisponivel) {
                    saldo = 0;
                    chequeEspecialDisponivel -= restante;
                    valorUsadoChequeEspecial += restante;
                    System.out.println("Boleto pago usando cheque especial.");
                } else {
                    System.out.println("Saldo insuficiente para pagar o boleto.");
                }
            }

        } else if (opcao == 6) {
            /* Verificar uso do cheque especial */
            if (valorUsadoChequeEspecial > 0) {
                System.out.println("A conta está usando cheque especial.");
            } else {
                System.out.println("A conta NÃO está usando cheque especial.");
            }
        }
    }
}