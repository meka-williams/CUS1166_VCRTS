public class Job {
    private String title;
    private String description;
    private int durationTime;
    private String deadline;

    public Job() {
        this.title = "";
        this.description = "";
        this.durationTime = -1;
        this.deadline = "";
    }

    public Job(String title, String description, int durationTime, String deadline) {
        this.title = title;
        this.description = description;
        this.durationTime = durationTime;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "|Title: " + title + "|Description: " + description + "|Duration Time: " + 
            durationTime + " minutes |Deadline: " + deadline;
    }
}
