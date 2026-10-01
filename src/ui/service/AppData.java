package service;

/** Shared access to the managers that load and save application data. */
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