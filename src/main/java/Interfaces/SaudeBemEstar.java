package Interfaces;

public class SaudeBemEstar extends Produto {

    public SaudeBemEstar(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return valor * 0.015;
    }
}
