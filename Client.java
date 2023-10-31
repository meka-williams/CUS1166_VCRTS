import java.util.ArrayList;

public class Client extends User {
  private String clientID;
  private ArrayList<Job> requestedJobs;

  public Client(String username, String password, String clientID) {
    super(username, password);
    this.clientID = clientID;
    requestedJobs = new ArrayList<Job>();
  }

  public Client(String firstName, String lastName, String email, String licensePlate, String username, String password, String clientID) {
    super(username, password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.licensePlate = licensePlate;
    this.clientID = clientID;
    requestedJobs = new ArrayList<Job>();
  }

  public void submitJob(Job j, Controller c) {
    requestedJobs.add(j);
    c.processJob(j); // You can add logic here to process the job using the provided controller.
  }

  public String requestCheckpoint(Job j, Controller c) {
    // You can add logic here to request a checkpoint for the specified job using the provided controller.
    // Return a message or status string.
    return "Checkpoint requested for job: " + j.getJobID();
  }

  public String getQueuedJobs() {
    StringBuilder allJobs = new StringBuilder();
    for (Job job : requestedJobs) {
      allJobs.append(job.toString());
    }
    return allJobs.toString();
  }

  @Override
  public String toString() {
    return "Client ID: " + clientID + "\nQueued Jobs:\n" + getQueuedJobs();
  }
}
