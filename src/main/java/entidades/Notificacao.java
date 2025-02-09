package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Notificacao {
    private String mensagem;
    private LocalDateTime dataNotificacao;
    private String destinatario;
    private servicos.TipoNotificacao tipo;

    public Notificacao(String mensagem, String destinatario, servicos.TipoNotificacao tipo) {
        this.mensagem = mensagem;
        this.dataNotificacao = LocalDateTime.now();
        this.destinatario = destinatario;
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(LocalDateTime dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public servicos.TipoNotificacao getTipo() {
        return tipo;
    }

    public void setTipo(servicos.TipoNotificacao tipo) {
        this.tipo = tipo;
    }

    public void enviarNotificacao(){
        System.out.println("Notificação para: " + destinatario);
        System.out.println("Tipo: " + tipo);
        System.out.println("Mensagem: "+ mensagem);
        System.out.println("Data/Hora: "+ dataNotificacao);
        System.out.println("-------------------------------------------------------");
    }
}
