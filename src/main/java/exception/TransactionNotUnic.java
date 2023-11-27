package exception;

public class TransactionNotUnic extends RuntimeException {
    public TransactionNotUnic(String message) {
        super(message);
    }
}
