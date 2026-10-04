package service;

/**
 * Provides a shared entry point to the app's data managers, making it easy for
 * the UI to read and write profile, task, reward, and schedule information.
 */
public class AppData {

    public static final TaskManager taskManager =
            new TaskManager();

    public static final RewardManager rewardManager =
            new RewardManager();

    public static final ScheduleManager scheduleManager =
            new ScheduleManager();

    public static final ProfileManager profileManager =
            new ProfileManager();
}