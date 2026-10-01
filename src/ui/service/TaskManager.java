package service;

import model.Task;

import java.io.*;
import java.util.ArrayList;

/** Loads and saves tasks, including their completion state. */
public class TaskManager {

    private ArrayList<Task> tasks;

    private static final String FILE_PATH =
            "data/tasks.dat";


    public TaskManager() {

        tasks = loadTasks();

        System.out.println(
                "TaskManager loaded: "
                        + tasks.size()
                        + " tasks"
        );
    }


    public void addTask(Task task) {

        if (task == null) {
            return;
        }

        tasks.add(task);

        saveTasks();
    }


    public ArrayList<Task> getTasks() {

        return tasks;
    }


    public Task getTaskById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {

                return task;
            }
        }

        return null;
    }


    public void updateTask(Task updatedTask) {

        if (updatedTask == null) {
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {

            if (
                    tasks.get(i).getId()
                            == updatedTask.getId()
            ) {

                tasks.set(i, updatedTask);

                saveTasks();

                return;
            }
        }
    }


    public void deleteTask(int id) {

        for (int i = 0; i < tasks.size(); i++) {

            if (
                    tasks.get(i).getId()
                            == id
            ) {

                tasks.remove(i);

                saveTasks();

                System.out.println(
                        "Task ID "
                                + id
                                + " deleted."
                );

                return;
            }
        }

        System.out.println(
                "Delete failed: Task ID "
                        + id
                        + " not found."
        );
    }


    /**
     * Marks an incomplete task as complete and saves it. If the write fails,
     * the in-memory completion change is reverted.
     *
     * @return true only when the task was found and the completed state saved
    */
    public boolean completeTask(int id) {

        System.out.println(
                "Attempting to complete Task ID: "
                        + id
        );

        Task task =
                getTaskById(id);


        if (task == null) {

            System.out.println(
                    "Task ID "
                            + id
                            + " was not found."
            );

            return false;
        }


        if (task.isCompleted()) {

            System.out.println(
                    "Task ID "
                            + id
                            + " is already completed."
            );

            return false;
        }


        task.complete();

        System.out.println(
                "Task ID "
                        + id
                        + " marked completed in memory."
        );


        boolean saved =
                saveTasks();

        if (!saved) {

            // Keep memory consistent with disk when persistence fails.
            task.uncomplete();

            System.out.println(
                    "Task completion was rolled back "
                            + "because saving failed."
            );

            return false;
        }

        System.out.println(
                "Task ID "
                        + id
                        + " completed and saved successfully."
        );

        return true;
    }


    public int getNextTaskId() {

        int highestId = 0;

        for (Task task : tasks) {

            if (
                    task.getId()
                            > highestId
            ) {

                highestId =
                        task.getId();
            }
        }

        return highestId + 1;
    }


    private boolean saveTasks() {

        File file =
                new File(FILE_PATH);

        File parent =
                file.getParentFile();

        try {


            if (
                    parent != null
                            && !parent.exists()
            ) {

                boolean created =
                        parent.mkdirs();

                if (!created
                        && !parent.exists()) {

                    System.out.println(
                            "Could not create data folder."
                    );

                    return false;
                }
            }


            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(file)
                    );

            output.writeObject(tasks);

            output.close();

            System.out.println(
                    "Tasks saved successfully."
            );

            System.out.println(
                    "Task count: "
                            + tasks.size()
            );

            System.out.println(
                    "Save location: "
                            + file.getAbsolutePath()
            );

            return true;

        } catch (IOException e) {

            System.out.println(
                    "ERROR SAVING TASKS"
            );

            e.printStackTrace();

            return false;
        }
    }


    @SuppressWarnings("unchecked")
    private ArrayList<Task> loadTasks() {

        File file =
                new File(FILE_PATH);

        System.out.println(
                "Looking for tasks at:"
        );

        System.out.println(
                file.getAbsolutePath()
        );


        if (!file.exists()) {

            System.out.println(
                    "No tasks.dat found."
            );

            System.out.println(
                    "Starting with an empty task list."
            );

            return new ArrayList<>();
        }


        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(file)
                    );

            ArrayList<Task> loadedTasks =
                    (ArrayList<Task>)
                            input.readObject();

            input.close();

            System.out.println(
                    "Loaded "
                            + loadedTasks.size()
                            + " tasks."
            );

            return loadedTasks;

        } catch (
                IOException
                | ClassNotFoundException e
        ) {

            System.out.println(
                    "ERROR LOADING TASKS"
            );

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}