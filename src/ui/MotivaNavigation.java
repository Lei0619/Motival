import javax.swing.*;

/**
 * Centralizes the app's screen navigation logic, helping one window transition
 * smoothly to another while closing the previous view to keep the interface tidy.
 */
public class MotivaNavigation {

    private MotivaNavigation() {
    }

    public static void goTo(
            JFrame currentWindow,
            JFrame nextWindow
    ) {

        if (nextWindow == null) {
            return;
        }

        nextWindow.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        if (currentWindow != null) {
            currentWindow.dispose();
        }

        nextWindow.setLocationRelativeTo(null);
        nextWindow.setVisible(true);
        nextWindow.toFront();
        nextWindow.requestFocus();
    }

    public static void goToDashboard(
            JFrame currentWindow
    ) {

        goTo(
                currentWindow,
                new MotivaDashboard()
        );
    }

    public static void goToSchedule(
            JFrame currentWindow
    ) {

        goTo(
                currentWindow,
                new MotivaSchedule()
        );
    }

    public static void goToRewards(
            JFrame currentWindow
    ) {

        goTo(
                currentWindow,
                new MotivaRewards()
        );
    }

    public static void goToSettings(
            JFrame currentWindow
    ) {

        goTo(
                currentWindow,
                new MotivaSettings()
        );
    }
}