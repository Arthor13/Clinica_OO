package excecoes;

public class MedicoJaExisteException extends Exception {

    public MedicoJaExisteException(String message) {
        super(message);
    }
}