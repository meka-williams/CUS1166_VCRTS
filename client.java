public class Client {

	
  String firstName;
  String lastName;
  String Email;
  String licensePlate;
   public Client(String firstName, String lastName, String Email , String licensePlate) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.Email = Email;
          this.licensePlate = licensePlate;
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
    return Email;
  }
  public void setEmail(String email) {
    Email = email;
  }
  public String getLicensePlate() {
    return licensePlate;
  }
  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }



  public String toString() {
    return "Client Information" + "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Email: " + Email + "\n License Plate: " + licensePlate;
}

    }