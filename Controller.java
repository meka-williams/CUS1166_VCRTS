import java.util.ArrayList;

public class Controller {
  private ArrayList<Vehicle> vehicles; // List of vehicles
  private ArrayList<Job> jobs; // List of jobs
  private Server server; // Reference to the server
  private int redundancyLevel; // Redundancy level for fault tolerance

  public Controller(ArrayList<Vehicle> vehicles, ArrayList<Job> jobs, Server server, int redundancyLevel) {
    this.vehicles = vehicles;
    this.jobs = jobs;
    this.server = server;
    this.redundancyLevel = redundancyLevel;
  }

  // Assign a job to the controller
  public void assignJob(Job j) {
    jobs.add(j);
  }

  // Trigger a checkpoint for a vehicle
  public void triggerCheckpoint(Vehicle v) {
    // Implement the logic for triggering a checkpoint for a vehicle
  }

  // Recruit a new vehicle to replace an old one
  public void recruitNewVehicle(Vehicle oldV, Vehicle newV, Job j) {
    // Implement the logic for recruiting a new vehicle to replace an old one
  }

  // Mark a job as completed
  public void setJobCompleted(Job j) {
    // Implement the logic for marking a job as completed
  }

  // Calculate and display completion times for jobs
  public void calculateJobCompletionTime() {
    int currentTime = 0;
    for (Job job : jobs) {
      job.setDurationTime(currentTime);
      currentTime += job.getDurationTime();
      // job.setDeadline(currentTime);
    }
    for (Job job : jobs) {
      System.out.println("Job ID: " + job.getDescription() + " - Completion Time: " + job.getDeadline());
    }
  }
}

