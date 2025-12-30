package Interfaces;

public class Cultura extends Produto {

    public Cultura(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.04;
    }
}
