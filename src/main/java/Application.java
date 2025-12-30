import Abstracao.Carro;
import Abstracao.ContaBancaria;
import Abstracao.PetshopBanho;
import Collections.Calculadora;
import Collections.ConversorEstruturas;
import Collections.FormatadorTelefone;
import Estruturas.Estrutura;
import Fundamentos.Fundamento;
import Heranca.Atendente;
import Heranca.Gerente;
import Heranca.Ingresso;
import Heranca.IngressoFamilia;
import Heranca.MeiaEntrada;
import Heranca.RelogioAmericano;
import Heranca.RelogioBrasileiro;
import Heranca.Vendedor;
import Interfaces.Alimentacao;
import Interfaces.Circulo;
import Interfaces.Cultura;
import Interfaces.EmailService;
import Interfaces.Enviador;
import Interfaces.FiguraGeometrica;
import Interfaces.Produto;
import Interfaces.Quadrado;
import Interfaces.RedeSocialService;
import Interfaces.Retangulo;
import Interfaces.SaudeBemEstar;
import Interfaces.ServicoMensagem;
import Interfaces.SmsService;
import Interfaces.Vestuario;
import Interfaces.WhatsAppService;

import java.util.Scanner;

public class Application {

    public static final Scanner scanner = new Scanner(System.in);

    public void start() {

        System.out.println("-----Selecione a atividade do bootcamp da accenture Java e Cloud------");
        System.out.println("1 - Fundamentos da linguagem");
        System.out.println("2 - Estruturas de Controle");
        System.out.println("3 - Abstração com Classes e Encapsulamento");
        System.out.println("4 - Cinema");
        System.out.println("5 - Usuários do sistema");
        System.out.println("6 - Relógio Mundial");
        System.out.println("7 - Enviar Mensagens de Marketing");
        System.out.println("8 - Calcular o Valor de Tributos de Produtos");
        System.out.println("9 - Calcular a Área de uma Figura Geométrica");
        System.out.println("10 - Calculadora");
        System.out.println("11 - Formatar Número de Telefones");
        System.out.println("12 - Conversor de Estrutura");
        System.out.println("-----------------------------------------------------------------------");

        int opcaoAtividade = scanner.nextInt();
        scanner.nextLine(); // limpa buffer

        if (opcaoAtividade == 1) {
            Fundamento fundamentosLinguagem = new Fundamento();
            fundamentosLinguagem.menu();

            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            fundamentosLinguagem.setOpcao(opcaoMenu);
            fundamentosLinguagem.executar();

        } else if (opcaoAtividade == 2) {
            Estrutura estruturasControle = new Estrutura();
            estruturasControle.menu();

            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            estruturasControle.setOpcao(opcaoMenu);
            estruturasControle.executar();
        } else if (opcaoAtividade == 3) {

            System.out.println("Escolhar a atividade desse modulo.");
            System.out.println("1 - Conta  Bancaria");
            System.out.println("2 - Carro");
            System.out.println("3 - PetshopBanho");

            int modulo = scanner.nextInt();

            if(modulo == 1) {
                System.out.println("Informe o depósito inicial da conta:");
                double depositoInicial = scanner.nextDouble();
                scanner.nextLine();

                ContaBancaria conta = new ContaBancaria(depositoInicial);

                conta.menu();

                int opcaoMenu = scanner.nextInt();
                scanner.nextLine();

                conta.setOpcao(opcaoMenu);
                conta.executar();

            } else if (modulo == 2) {
                Carro carro = new Carro();

                while (true) {

                    carro.menu();

                    System.out.println("Escolha uma opção:");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    carro.setOpcao(opcao);
                    carro.executar();

                    System.out.println();
                    System.out.println("Deseja continuar controlando o carro? (s/n)");
                    String continuar = scanner.nextLine();

                    if (continuar.equalsIgnoreCase("n")) {
                        System.out.println("Encerrando sistema...");
                        break;
                    }
                }
            } else if (modulo == 3) {
                PetshopBanho maquina = new PetshopBanho();

                while (true) {

                    maquina.menu();

                    System.out.println("Escolha uma opção:");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    maquina.setOpcao(opcao);
                    maquina.executar();

                    System.out.println();
                    System.out.println("Deseja continuar usando a máquina? (s/n)");
                    String continuar = scanner.nextLine();

                    if (continuar.equalsIgnoreCase("n")) {
                        System.out.println("Encerrando sistema...");
                        break;
                    }
                }
            }
        } else if (opcaoAtividade == 4) {
            Ingresso ingressoNormal = new Ingresso(30, "Matrix", true);
            MeiaEntrada meia = new MeiaEntrada(30, "Matrix", false);
            IngressoFamilia familia = new IngressoFamilia(30, "Matrix", true, 5);

            System.out.println("Ingresso normal: R$" + ingressoNormal.getValorReal());
            System.out.println("Meia entrada: R$" + meia.getValorReal());
            System.out.println("Ingresso família (5 pessoas): R$" + familia.getValorReal());

        } else if (opcaoAtividade == 5) {
            Gerente g = new Gerente("Carlos", "carlos@empresa.com", "123");
            Vendedor v = new Vendedor("Ana", "ana@empresa.com", "abc", 10);
            Atendente a = new Atendente("João", "joao@empresa.com", "xyz", 500);

            g.realizarLogin();
            g.gerarRelatorioFinanceiro();
            g.consultarVendas();
            g.realizarLogoff();

            v.realizarLogin();
            v.realizarVenda();
            v.consultarVendas();
            v.realizarLogoff();

            a.realizarLogin();
            a.receberPagamento(200);
            a.fecharCaixa();
            a.realizarLogoff();

        } else if (opcaoAtividade == 6) {
            RelogioBrasileiro br = new RelogioBrasileiro(18, 30, 45);
            RelogioAmericano us = new RelogioAmericano(18, 30, 45);

            System.out.println("Brasil: " + br.getHoraFormatada());
            System.out.println("EUA: " + us.getHoraFormatada());

            // Ajustando o relógio americano com base no brasileiro
            us.ajustarHorario(br);

            System.out.println("EUA ajustado: " + us.getHoraFormatada());

        } else if (opcaoAtividade == 7) {
            Enviador enviador = new Enviador();

            ServicoMensagem sms = new SmsService();
            ServicoMensagem email = new EmailService();
            ServicoMensagem redeSocial = new RedeSocialService();
            ServicoMensagem whatsapp = new WhatsAppService();

            String mensagem = "Promoção imperdível! 50% de desconto hoje!";

            enviador.enviar(sms, mensagem);
            enviador.enviar(email, mensagem);
            enviador.enviar(redeSocial, mensagem);
            enviador.enviar(whatsapp, mensagem);

        } else if (opcaoAtividade == 8) {
            Produto p1 = new Alimentacao("Arroz", 20);
            Produto p2 = new SaudeBemEstar("Shampoo", 30);
            Produto p3 = new Vestuario("Camiseta", 50);
            Produto p4 = new Cultura("Livro", 40);

            System.out.println("Imposto Alimentação: R$" + p1.calcularImposto());
            System.out.println("Imposto Saúde e Bem-estar: R$" + p2.calcularImposto());
            System.out.println("Imposto Vestuário: R$" + p3.calcularImposto());
            System.out.println("Imposto Cultura: R$" + p4.calcularImposto());

        } else if (opcaoAtividade == 9) {
            FiguraGeometrica q = new Quadrado(5);
            FiguraGeometrica r = new Retangulo(4, 6);
            FiguraGeometrica c = new Circulo(3);

            System.out.println("Área do quadrado: " + q.calcularArea());
            System.out.println("Área do retângulo: " + r.calcularArea());
            System.out.println("Área do círculo: " + c.calcularArea());

        } else if (opcaoAtividade == 10) {
            Calculadora calculadora = new Calculadora();

            calculadora.menu();

            System.out.println("Escolha uma opção:");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            calculadora.setOpcao(opcao);
            calculadora.executar();

        } else if (opcaoAtividade == 11) {
            FormatadorTelefone formatador = new FormatadorTelefone();

            System.out.println("---- FORMATADOR DE TELEFONE ----");

            formatador.executar();

        } else if (opcaoAtividade == 12) {
            ConversorEstruturas conversor = new ConversorEstruturas();

            System.out.println("---- CONVERSOR DE ESTRUTURAS ----");

            conversor.executar();
        }
    }
}
