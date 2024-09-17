class Maintenance {
    private String maintenanceType;
    private String technician;
    private String maintenanceDate;

    public Maintenance(String maintenanceType, String technician, String maintenanceDate) {
        this.maintenanceType = maintenanceType;
        this.technician = technician;
        this.maintenanceDate = maintenanceDate;
    }

    public void performMaintenance() {
        System.out.println("Maintenance performed: " + maintenanceType + " by " + technician + " on " + maintenanceDate);
    }
}
