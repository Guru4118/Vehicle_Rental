class Customer {
    private String name;
    private String licenseNumber;
    private int loyaltyPoints;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void redeemPoints(int points) {
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
            System.out.println("Points redeemed: " + points);
        } else {
            System.out.println("Not enough points to redeem.");
        }
    }

    public void showDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }
}
