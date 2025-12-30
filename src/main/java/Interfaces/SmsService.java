package Interfaces;

public class SmsService implements ServicoMensagem {

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}