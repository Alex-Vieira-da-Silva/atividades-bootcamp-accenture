package Interfaces;

public class RedeSocialService implements ServicoMensagem {

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Publicando nas Redes Sociais: " + mensagem);
    }
}
