package exceptions;

public class EstoqueNegativoException extends RuntimeException {

    public EstoqueNegativoException(String message) {
        super(message);
    }
}
