import java.util.ArrayList;

public class Owner extends User {
    private ArrayList<Vehicle> rentals;

    public Owner(String username, String password, String name, String email, String phoneNumber) {
        super(username, password, name, email, phoneNumber);
        rentals = new ArrayList<Vehicle>();
    }

    public Owner(String username, String password) {
        super(username, password);
        rentals = new ArrayList<Vehicle>();
    }

    public void rentVehicle(Vehicle v) {
        rentals.add(v);
    }

    public void removeVehicle(Vehicle v) {
        rentals.remove(v);
    }

    public String getRentals() {
        String carRentals = "";
        
        for(Vehicle c: rentals) {
            carRentals = carRentals.concat(String.valueOf(c));
        }

        return carRentals;
    }

    @Override
    public String toString() {
        // return "Owner Information{" +
        //         "\n First Name: " + firstName +
        //         "\n Last Name: " + lastname +
        //         "\n Email: " + email +
        //         "\n Phone Number: " + phoneNumber +
        //         "\n Vehicle Info: " + vehicleInfo +
        //         "\n License Plate: " + licensePlate +
        //         "\n Residency Time: " + residencyTime + " hours" +
        //         "\n}";

        return "Owner ID: " + this.getUsername() + getRentals();
    }
}
