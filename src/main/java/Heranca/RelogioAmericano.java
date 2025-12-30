package Heranca;

public class RelogioAmericano extends Relogio {

    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(converterPara12h(hora), minuto, segundo);
    }

    private static int converterPara12h(int hora) {
        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora inválida.");
        }
        if (hora == 0) return 12;     // meia-noite → 12
        if (hora > 12) return hora - 12;
        return hora;
    }

    @Override
    public void ajustarHorario(Relogio outroRelogio) {
        this.hora = converterPara12h(outroRelogio.getHora());
        this.minuto = outroRelogio.getMinuto();
        this.segundo = outroRelogio.getSegundo();
    }
}
