public abstract class Vehicle {
    private String model;
    private String numberPlate;
    private double rentalRate;
    private boolean rented = false;
    private boolean underMaintenance = false;

    public Vehicle(String model, String numberPlate, double rentalRate) {
        this.model = model;
        this.numberPlate = numberPlate;
        this.rentalRate = rentalRate;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public boolean isRented() {
        return rented;
    }

    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    public void rentVehicle() {
        this.rented = true;
    }

    public void returnVehicle() {
        this.rented = false;
    }

    public void performMaintenance() {
        this.underMaintenance = true;
    }

    public void completeMaintenance() {
        this.underMaintenance = false;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Number Plate: " + numberPlate + ", Rental Rate: $" + rentalRate;
    }
}
