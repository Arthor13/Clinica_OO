package model.excecoes;

public class PacienteNaoExisteException extends RuntimeException {
    public PacienteNaoExisteException(String message) {
        super(message);
    }
}
