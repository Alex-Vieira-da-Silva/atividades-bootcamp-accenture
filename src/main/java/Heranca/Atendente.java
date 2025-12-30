package Heranca;

public class Atendente extends Usuario {

    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha, double valorEmCaixa) {
        super(nome, email, senha, false);
        this.valorEmCaixa = valorEmCaixa;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void receberPagamento(double valor) {
        valorEmCaixa += valor;
        System.out.println("Pagamento recebido. Caixa atual: R$" + valorEmCaixa);
    }

    public void fecharCaixa() {
        System.out.println("Fechando caixa. Total: R$" + valorEmCaixa);
        valorEmCaixa = 0;
    }
}