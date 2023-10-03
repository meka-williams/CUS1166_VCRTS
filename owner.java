public class owner {
    private String firstName;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String vehicleInfo;
    private String licensePlate;
    private String residencyTime; 

     public void Owner(String firstName, String lastName, String email, String phoneNumber, String vehicleInfo,
                 String licensePlate, String residencyTime) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vehicleInfo = vehicleInfo;
        this.licensePlate = licensePlate;
        this.residencyTime = residencyTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public String getResidencyTime() {
        return residencyTime;
    }

    public void setResidencyTime(String residencyTime) {
        this.residencyTime = residencyTime;
    }

    @Override
    public String toString() {
        return "Owner Information{" +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastname +
                "\n Email: " + email +
                "\n Phone Number: " + phoneNumber +
                "\n Vehicle Info: " + vehicleInfo +
                "\n License Plate: " + licensePlate +
                "\n Residency Time: " + residencyTime + " hours" +
                "\n}";
    }
}


