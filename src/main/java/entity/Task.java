package entity;


public class Task {

    private String taskDate;
    private String description;
    private int id;
    private String title;
    private int statusId;

    public Task() {
    }

    public Task(int id, String taskDate, String description, String title, int statusId) {
        this.taskDate = taskDate;
        this.description = description;
        this.id = id;
        this.title = title;
        this.statusId = statusId;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskdate) {
        this.taskDate = taskdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
