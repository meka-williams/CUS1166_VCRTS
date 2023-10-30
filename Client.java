import java.util.ArrayList;

public class Client extends User {
  private ArrayList<Job> requestedJobs;

  public Client(String username, String password) {
    super(username, password);
    requestedJobs = new ArrayList<Job>();
  }
  
  public Client(String username, String password, String name, String email , String phoneNumber) {
    super(username, password, name, email, phoneNumber);
    requestedJobs = new ArrayList<Job>();
  }

  public void submitJob(Job j) {
    requestedJobs.add(j);
  }

  public String requestCheckpoint(Job j, Controller c) {
    return "";
  }

  public String getQueuedJobs() {
    String allJobs = "";
    for(int i = 0; i < requestedJobs.size(); i++) {
      allJobs = allJobs.concat(String.valueOf(requestedJobs.get(i)));
    }
    return allJobs;
  }
  
  @Override
  public String toString() {
    //return "Client Information" + "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Email: " + email + "\n License Plate: " + licensePlate + "\n Username: " + this.getUsername();

    return "Client ID: " + this.getUsername() + getQueuedJobs();
  }
  
}
