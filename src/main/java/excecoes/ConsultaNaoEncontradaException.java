package model.excecoes;

public class ConsultaNaoEncontradaException extends RuntimeException {
    public ConsultaNaoEncontradaException(String message) {
        super(message);
    }
}
