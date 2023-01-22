package modern.challenge;

public class PaymentService {
    
    class InvoiceCalculation {
        
        final PaymentService paymentService;
        
        InvoiceCalculation(PaymentService PaymentService.this) {
            paymentService = PaymentService.this;
        }
    }
}
