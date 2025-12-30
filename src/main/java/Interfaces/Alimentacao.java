package Interfaces;

public class Alimentacao extends Produto {

    public Alimentacao(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.01;
    }
}
