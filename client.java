public class client {

	
  String firstName;
  String lastName;
  String Email;
  String licensePlate;
   public client(String firstName, String lastName, String Email) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.Email = Email;
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
    return "Students{" + "First name: " + firstName + ", Last name" + lastName + ", Email: " + Email + "License Plate" + licensePlate + '}';
}

    }