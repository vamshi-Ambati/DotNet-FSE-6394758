interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

class StripeGateway {
    public void makeStripePayment(double amountInDollars) {
        System.out.println("Processing payment of $" + amountInDollars + " via Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makeStripePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(150.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(250.0);
    }
}
