import java.util.ArrayList;

public class Client extends User {

	private String firstName;
  private String lastName;
  private String email;
  private String licensePlate;
  private ArrayList<Job> jobs;

  public Client(String username, String password) {
    super(username, password);
    firstName = "";
    lastName = "";
    email = "";
    licensePlate = "";
    jobs = new ArrayList<Job>();
  }
  
  public Client(String firstName, String lastName, String email , String licensePlate, String username, String password) {
    super(username, password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.licensePlate = licensePlate;
    jobs = new ArrayList<Job>();
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

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public void addJobToQueue(Job j) {
    jobs.add(j);
  }
  
  @Override
  public String toString() {
    return "Client Information" + "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Email: " + email + "\n License Plate: " + licensePlate + "\n Username: " + this.getUsername();
  }
  
}
