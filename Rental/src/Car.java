class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String model, String numberPlate, double rentalRate, int numberOfSeats) {
        super(model, numberPlate, rentalRate);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car [Model: " + getModel() + ", Number Plate: " + getNumberPlate() +
                ", Rental Rate: $" + getRentalRate() + ", Seats: " + numberOfSeats + "]";
    }
}




class Bike extends Vehicle {
    private String bikeType;

    public Bike(String model, String numberPlate, double rentalRate, String bikeType) {
        super(model, numberPlate, rentalRate);
        this.bikeType = bikeType;
    }

    public String getBikeType() {
        return bikeType;
    }

    @Override
    public String toString() {
        return "Bike [Model: " + getModel() + ", Number Plate: " + getNumberPlate() +
                ", Rental Rate: $" + getRentalRate() + ", Type: " + bikeType + "]";
    }
}




class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String model, String numberPlate, double rentalRate, double loadCapacity) {
        super(model, numberPlate, rentalRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck [Model: " + getModel() + ", Number Plate: " + getNumberPlate() +
                ", Rental Rate: $" + getRentalRate() + ", Load Capacity: " + loadCapacity + " tons]";
    }
}





