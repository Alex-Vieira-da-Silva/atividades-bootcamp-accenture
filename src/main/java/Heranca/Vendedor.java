package Heranca;

public class Vendedor extends Usuario {

    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha, int quantidadeVendas) {
        super(nome, email, senha, false);
        this.quantidadeVendas = quantidadeVendas;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void realizarVenda() {
        quantidadeVendas++;
        System.out.println("Venda registrada. Total: " + quantidadeVendas);
    }

    public void consultarVendas() {
        System.out.println("Vendas realizadas: " + quantidadeVendas);
    }
}