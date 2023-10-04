public class Car {
    private String make;
    private String model;
    private String licensePlateNumber;

    public Car() {
        make = "";
        model = "";
        licensePlateNumber = "";
    }

    public Car(String make, String model, String licensePlateNumber) {
        this.make = make;
        this.model = model;
        this.licensePlateNumber = licensePlateNumber;
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
}
