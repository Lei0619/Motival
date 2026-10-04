package service;

import model.Schedule;

import java.io.*;
import java.util.ArrayList;

/**
 * Manages the schedule entries stored in the app, including tasks and events,
 * so the calendar can load and persist user activity reliably.
 */
public class ScheduleManager {

    private ArrayList<Schedule> schedules;

    private static final String FILE_PATH =
            "data/schedules.dat";



    public ScheduleManager() {

        schedules = loadSchedules();

        System.out.println(
                "ScheduleManager loaded: "
                        + schedules.size()
                        + " schedules"
        );
    }



        /** Adds an entry and saves the updated list. Ignores null. */
    public void addSchedule(
            Schedule schedule
    ) {

        if (schedule == null) {
            return;
        }

        schedules.add(schedule);

        saveSchedules();
    }



        /** Returns the current schedule entries. */
    public ArrayList<Schedule> getSchedules() {

        return schedules;
    }


    public Schedule getScheduleById(
            int id
    ) {

        for (
                Schedule schedule :
                schedules
        ) {

            if (
                    schedule.getId()
                            == id
            ) {

                return schedule;
            }
        }

        return null;
    }



    public void updateSchedule(
            Schedule updatedSchedule
    ) {

        if (updatedSchedule == null) {
            return;
        }

        for (
                int i = 0;
                i < schedules.size();
                i++
        ) {

            if (
                    schedules
                            .get(i)
                            .getId()
                            == updatedSchedule.getId()
            ) {

                schedules.set(
                        i,
                        updatedSchedule
                );

                saveSchedules();

                return;
            }
        }
    }



    public void deleteSchedule(
            int id
    ) {

        for (
                int i = 0;
                i < schedules.size();
                i++
        ) {

            if (
                    schedules
                            .get(i)
                            .getId()
                            == id
            ) {

                schedules.remove(i);

                saveSchedules();

                return;
            }
        }
    }



    public int getNextScheduleId() {

        int highestId = 0;

        for (
                Schedule schedule :
                schedules
        ) {

            if (
                    schedule.getId()
                            > highestId
            ) {

                highestId =
                        schedule.getId();
            }
        }

        return highestId + 1;
    }



    private boolean saveSchedules() {

        try {

            File file =
                    new File(
                            FILE_PATH
                    );

            File parent =
                    file.getParentFile();

            if (
                    parent != null
                            && !parent.exists()
            ) {

                parent.mkdirs();
            }

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    file
                            )
                    );

            output.writeObject(
                    schedules
            );

            output.close();

            System.out.println(
                    "Schedules saved: "
                            + schedules.size()
            );

            return true;

        } catch (IOException e) {

            System.out.println(
                    "ERROR saving schedules:"
            );

            e.printStackTrace();

            return false;
        }
    }



    @SuppressWarnings("unchecked")
    /**
        * Reads saved entries and fills in fields that older schedule files lack.
    */
    private ArrayList<Schedule> loadSchedules() {

        File file =
                new File(
                        FILE_PATH
                );

        if (!file.exists()) {

            System.out.println(
                    "No schedules.dat found. "
                            + "Starting empty."
            );

            return new ArrayList<>();
        }

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(
                                    file
                            )
                    );

            ArrayList<Schedule> loadedSchedules =
                    (ArrayList<Schedule>)
                            input.readObject();

            input.close();

            if (
                    loadedSchedules == null
            ) {

                return new ArrayList<>();
            }

            // Java serialization leaves newly added fields null in older files.

            for (
                    Schedule schedule :
                    loadedSchedules
            ) {

                if (
                        schedule.getType() == null
                        || schedule.getType()
                                .trim()
                                .isEmpty()
                ) {

                    schedule.setType(
                            "TASK"
                    );
                }

                if (
                        schedule.getNotes()
                                == null
                ) {

                    schedule.setNotes(
                            ""
                    );
                }
            }

            return loadedSchedules;

        } catch (
                IOException
                | ClassNotFoundException e
        ) {

            System.out.println(
                    "ERROR loading schedules."
            );

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}