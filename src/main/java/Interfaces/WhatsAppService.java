package Interfaces;

public class WhatsAppService implements ServicoMensagem {

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
    }
}
