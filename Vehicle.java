public class Vehicle {
    private String make;
    private String model;
    private String licensePlateNumber;
    private int residency;

    public Vehicle() {
        make = "";
        model = "";
        licensePlateNumber = "";
    }

    public Vehicle(String make, String model, String licensePlateNumber, int residency) {
        this.make = make;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
        this.residency = residency;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public int getResidency() {
        return residency;
    }

    public void setResidency(int residency) {
        this.residency = residency;
    }

    @Override
    public String toString() {
        return "|Make: " + make + "|Model: " + model + "|License Plate Number: " + licensePlateNumber + "|Residency Time: " + 
        residency + " days";
    }
    
}
