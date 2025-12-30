package Heranca;

public class Ingresso {

    protected double valor;
    protected String nomeFilme;
    protected boolean dublado; // true = dublado, false = legendado

    public Ingresso(double valor, String nomeFilme, boolean dublado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    public double getValorReal() {
        return valor;
    }

    public String getTipoAudio() {
        return dublado ? "Dublado" : "Legendado";
    }

    public void exibirInfo() {
        System.out.println("Filme: " + nomeFilme);
        System.out.println("Tipo: " + getTipoAudio());
        System.out.println("Valor base: R$" + valor);
    }
}