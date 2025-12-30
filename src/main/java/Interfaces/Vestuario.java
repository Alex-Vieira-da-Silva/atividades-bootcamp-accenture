package Interfaces;

public class Vestuario extends Produto {

    public Vestuario(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.025;
    }
}
