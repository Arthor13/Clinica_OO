package excecoes;

public class PacienteJaExisteException extends Exception {

    public PacienteJaExisteException(String message) {
        super(message);
    }
}