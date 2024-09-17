class Reservation {
    private Vehicle vehicle;
    private Customer customer;
    private String reservationDate;
    private int durationDays;

    public Reservation(Vehicle vehicle, Customer customer, String reservationDate, int durationDays) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.reservationDate = reservationDate;
        this.durationDays = durationDays;
    }

    public void confirmReservation() {
        System.out.println("Reservation confirmed for " + customer.getName() + " on " + reservationDate + " for " + durationDays + " days.");
    }
}
