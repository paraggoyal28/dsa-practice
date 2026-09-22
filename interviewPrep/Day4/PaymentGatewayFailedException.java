package Day4;

public class PaymentGatewayFailedException extends Exception {
    PaymentGatewayFailedException(String message) {
        super(message);
    }
}
