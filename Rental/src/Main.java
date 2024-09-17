import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static RentalService rentalService = new RentalService();
    private static Admin admin = new Admin("Alice");

    public static void main(String[] args) {
        // Add initial vehicles and customers
        setupInitialData();

        while (true) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Rent Vehicle");
            System.out.println("2. Return Vehicle");
            System.out.println("3. Reserve Vehicle");
            System.out.println("4. Perform Maintenance");
            System.out.println("5. Complete Maintenance");
            System.out.println("6. Show Rental History");
            System.out.println("7. Add Vehicle (Admin)");
            System.out.println("8. Remove Vehicle (Admin)");
            System.out.println("9. Add Customer");
            System.out.println("10. Show Customer Details");
            System.out.println("11. Show Available Vehicles");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    rentVehicle();
                    break;
                case 2:
                    returnVehicle();
                    break;
                case 3:
                    reserveVehicle();
                    break;
                case 4:
                    performMaintenance();
                    break;
                case 5:
                    completeMaintenance();
                    break;
                case 6:
                    showRentalHistory();
                    break;
                case 7:
                    addVehicle();
                    break;
                case 8:
                    removeVehicle();
                    break;
                case 9:
                    addCustomer();
                    break;
                case 10:
                    showCustomerDetails();
                    break;
                case 11:
                    showAvailableVehicles();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void setupInitialData() {
        Vehicle car = new Car("Toyota Corolla", "ABC123", 50, 4);
        Vehicle bike = new Bike("Yamaha FZ", "XYZ987", 30, "Sport");
        Vehicle truck = new Truck("Ford F150", "LMN456", 100, 5.0);
        admin.addVehicle(rentalService, car);
        admin.addVehicle(rentalService, bike);
        admin.addVehicle(rentalService, truck);

        Customer customer = new Customer("John Doe", "DL123456");
        rentalService.addCustomer(customer);
    }

    private static void rentVehicle() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.print("Enter rental days: ");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        rentalService.rentVehicle(customer, numberPlate, rentalDays);
    }

    private static void returnVehicle() {
        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.print("Enter rental days: ");
        int rentalDays = scanner.nextInt();

        System.out.print("Enter actual days used: ");
        int actualDaysUsed = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        rentalService.returnVehicle(numberPlate, rentalDays, actualDaysUsed);
    }

    private static void reserveVehicle() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.print("Enter reservation date (YYYY-MM-DD): ");
        String reservationDate = scanner.nextLine();

        System.out.print("Enter duration days: ");
        int durationDays = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        rentalService.reserveVehicle(numberPlate, customer, reservationDate, durationDays);
    }

    private static void performMaintenance() {
        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.print("Enter maintenance type: ");
        String maintenanceType = scanner.nextLine();

        System.out.print("Enter technician name: ");
        String technician = scanner.nextLine();

        System.out.print("Enter maintenance date (YYYY-MM-DD): ");
        String maintenanceDate = scanner.nextLine();

        rentalService.performMaintenance(numberPlate, maintenanceType, technician, maintenanceDate);
    }

    private static void completeMaintenance() {
        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();
        rentalService.completeMaintenance(numberPlate);
    }

    private static void showRentalHistory() {
        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();
        rentalService.showRentalHistory(numberPlate);
    }

    private static void addVehicle() {
        System.out.print("Enter vehicle type (Car/Bike/Truck): ");
        String type = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle number plate: ");
        String numberPlate = scanner.nextLine();

        System.out.print("Enter rental rate: ");
        double rentalRate = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        if (type.equalsIgnoreCase("Car")) {
            System.out.print("Enter number of seats: ");
            int numberOfSeats = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            Vehicle vehicle = new Car(model, numberPlate, rentalRate, numberOfSeats);
            admin.addVehicle(rentalService, vehicle);
        } else if (type.equalsIgnoreCase("Bike")) {
            System.out.print("Enter bike type: ");
            String bikeType = scanner.nextLine();
            Vehicle vehicle = new Bike(model, numberPlate, rentalRate, bikeType);
            admin.addVehicle(rentalService, vehicle);
        } else if (type.equalsIgnoreCase("Truck")) {
            System.out.print("Enter load capacity (tons): ");
            double loadCapacity = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            Vehicle vehicle = new Truck(model, numberPlate, rentalRate, loadCapacity);
            admin.addVehicle(rentalService, vehicle);
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    private static void removeVehicle() {
        System.out.print("Enter vehicle number plate to remove: ");
        String numberPlate = scanner.nextLine();
        rentalService.removeVehicle(numberPlate);
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer license number: ");
        String licenseNumber = scanner.nextLine();

        Customer customer = new Customer(name, licenseNumber);
        rentalService.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void showCustomerDetails() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        rentalService.showCustomerDetails(customerName);
    }

    private static void showAvailableVehicles() {
        rentalService.showAvailableVehicles();
    }

    private static Customer findCustomerByName(String name) {
        for (Customer customer : rentalService.customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
