package model.excecoes;

public class ConsultaJaExisteException extends RuntimeException {
    public ConsultaJaExisteException(String message) {
        super(message);
    }
}
