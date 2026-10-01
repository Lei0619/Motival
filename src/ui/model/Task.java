package model;
import java.io.Serializable;

/** A task's details and whether it has been completed. */
public class Task implements Serializable {

    private int id;
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String category;
    private boolean completed;



    /** Creates a task in the incomplete state. */
    public Task(int id, String title, String description,
                String dueDate, String priority, String category) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;

        this.completed = false;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return completed;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public void complete() {
        this.completed = true;
    }

    public void uncomplete() {
        this.completed = false;
    }
}