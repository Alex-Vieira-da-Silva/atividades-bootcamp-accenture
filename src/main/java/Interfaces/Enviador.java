package Interfaces;

public class Enviador {

    public void enviar(ServicoMensagem servico, String mensagem) {
        servico.enviarMensagem(mensagem);
    }
}