import java.util.ArrayList;

public class Owner extends User {
    private String ownerID;
    private String firstName;
    private String lastName;
    private String email;
    private double phoneNumber;
    private String vehicleInfo;
    private String licensePlate;
    private int residencyTime;
    private ArrayList<Vehicle> rentals;

    public Owner(String ownerID, String firstName, String lastName, String email, double phoneNumber,
                 String vehicleInfo, String licensePlate, int residencyTime, String username, String password) {
        super(username, password);
        this.ownerID = ownerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vehicleInfo = vehicleInfo;
        this.licensePlate = licensePlate;
        this.residencyTime = residencyTime;
        rentals = new ArrayList<Vehicle>();
    }

    public Owner(String username, String password) {
        super(username, password);
        rentals = new ArrayList<Vehicle>();
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getResidencyTime() {
        return residencyTime;
    }

    public void setResidencyTime(int residencyTime) {
        this.residencyTime = residencyTime;
    }

    public void addRental(Vehicle aCar) {
        rentals.add(aCar);
    }

    public void removeRental(Vehicle aCar) {
        rentals.remove(aCar);
    }

    public ArrayList<Vehicle> getRentals() {
        return rentals;
    }

    public void rentVehicle(Vehicle v, Controller c) {
        if (c.rentVehicle(this, v)) {
            addRental(v);
        }
    }

    public void removeVehicle(Vehicle v, Controller c) {
        if (c.removeVehicle(v)) {
            removeRental(v);
        }
    }

    @Override
    public String toString() {
        return "Owner ID: " + ownerID + " " + super.toString();
    }
}

