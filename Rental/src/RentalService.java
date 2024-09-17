import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RentalService {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<Customer> customers = new ArrayList<>();
    private Map<String, List<String>> rentalHistory = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentVehicle(Customer customer, String numberPlate, int rentalDays) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate) && !vehicle.isRented() && !vehicle.isUnderMaintenance()) {
                vehicle.rentVehicle();
                customer.addLoyaltyPoints(rentalDays * 10);
                addRentalHistory(numberPlate, customer.getName());
                System.out.println("Vehicle rented. Points earned: " + (rentalDays * 10));
                return;
            }
        }
        System.out.println("Vehicle not available.");
    }

    public void returnVehicle(String numberPlate, int rentalDays, int actualDaysUsed) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate) && vehicle.isRented()) {
                if (actualDaysUsed > rentalDays) {
                    int extraDays = actualDaysUsed - rentalDays;
                    double lateFee = calculateLateFee(extraDays, vehicle.getRentalRate());
                    System.out.println("Late fee for " + extraDays + " extra days: $" + lateFee);
                }
                vehicle.returnVehicle();
                System.out.println("Vehicle returned successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public double calculateLateFee(int extraDays, double rentalRate) {
        return extraDays * rentalRate * 1.2;
    }

    public void reserveVehicle(String numberPlate, Customer customer, String reservationDate, int durationDays) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate) && !vehicle.isRented() && !vehicle.isUnderMaintenance()) {
                Reservation reservation = new Reservation(vehicle, customer, reservationDate, durationDays);
                reservation.confirmReservation();
                return;
            }
        }
        System.out.println("Vehicle is not available for reservation.");
    }

    public void performMaintenance(String numberPlate, String maintenanceType, String technician, String maintenanceDate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                vehicle.performMaintenance();
                Maintenance maintenance = new Maintenance(maintenanceType, technician, maintenanceDate);
                maintenance.performMaintenance();
                System.out.println("Vehicle sent for maintenance.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void completeMaintenance(String numberPlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                vehicle.completeMaintenance();
                System.out.println("Maintenance completed for vehicle: " + numberPlate);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void addRentalHistory(String vehicleNumberPlate, String customerName) {
        rentalHistory.computeIfAbsent(vehicleNumberPlate, k -> new ArrayList<>()).add(customerName);
    }

    public void showRentalHistory(String numberPlate) {
        if (rentalHistory.containsKey(numberPlate)) {
            System.out.println("Rental history for vehicle " + numberPlate + ": " + rentalHistory.get(numberPlate));
        } else {
            System.out.println("No rental history for this vehicle.");
        }
    }

    public void removeVehicle(String numberPlate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getNumberPlate().equals(numberPlate)) {
                vehicles.remove(i);
                System.out.println("Vehicle removed: " + numberPlate);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void showCustomerDetails(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                customer.showDetails();
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void showAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isRented() && !vehicle.isUnderMaintenance()) {
                System.out.println(vehicle);
            }
        }
    }
}
