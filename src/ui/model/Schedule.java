package model;

import java.io.Serializable;

/** A task or standalone event on the student's schedule. */
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;


    private int id;

    private String title;
    private String category;
    private String date;
    private String time;
    private String priority;
    private String colorType;

    /** Identifies this entry as a task or an event. */
    private String type;

    /** Linked task ID, or null when this is a standalone event. */
    private Integer taskId;

    /** Optional notes for an event. */
    private String notes;



    /**
    * Keeps older callers working. Entries made this way are treated as tasks
    * and start without a task link or notes.
    */
    public Schedule(
            int id,
            String title,
            String category,
            String date,
            String time,
            String priority,
            String colorType
    ) {

        this(
                id,
                title,
                category,
                date,
                time,
                priority,
                colorType,
                "TASK",
                null,
                ""
        );
    }



    public Schedule(
            int id,
            String title,
            String category,
            String date,
            String time,
            String priority,
            String colorType,
            String type,
            Integer taskId,
            String notes
    ) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.colorType = colorType;

        this.type =
                type == null
                        ? "EVENT"
                        : type;

        this.taskId = taskId;

        this.notes =
                notes == null
                        ? ""
                        : notes;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPriority() {
        return priority;
    }

    public String getColorType() {
        return colorType;
    }

    public String getType() {
        return type;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getNotes() {
        return notes;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public boolean isTask() {

        return "TASK".equalsIgnoreCase(type);
    }

    public boolean isEvent() {

        return "EVENT".equalsIgnoreCase(type);
    }
}