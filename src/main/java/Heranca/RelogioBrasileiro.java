package Heranca;

public class RelogioBrasileiro extends Relogio {

    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    public void ajustarHorario(Relogio outroRelogio) {
        this.hora = outroRelogio.getHora();
        this.minuto = outroRelogio.getMinuto();
        this.segundo = outroRelogio.getSegundo();
    }
}
