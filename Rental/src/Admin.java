class Admin {
    private String adminName;

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    public void addVehicle(RentalService rentalService, Vehicle vehicle) {
        rentalService.addVehicle(vehicle);
        System.out.println("Vehicle added to the system by " + adminName);
    }

    public void removeVehicle(RentalService rentalService, String numberPlate) {
        rentalService.removeVehicle(numberPlate);
        System.out.println("Vehicle removed from the system by " + adminName);
    }
}
