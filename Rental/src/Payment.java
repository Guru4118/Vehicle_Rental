class Payment {
    private double amount;
    private String paymentMethod;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        System.out.println("Payment of $" + amount + " processed using " + paymentMethod);
    }
}
