package Interfaces;

public class EmailService implements ServicoMensagem {

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando E-mail: " + mensagem);
    }
}