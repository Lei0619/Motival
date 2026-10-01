import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import model.Task;
import model.Schedule;
import model.FoodReward;
import service.AppData;

/**
 * Shows a selected task and sends changes through the app's managers.
 * Since tasks have no time field, this screen reads the time from a matching
 * schedule entry, preferring a title-and-date match before falling back to title.
 */
public class MotivaTaskDetail extends JFrame {

    private static final Color BURGUNDY =
            Color.decode("#62242F");

    private static final Color DEEP_BURGUNDY =
            Color.decode("#461921");

    private static final Color BACKGROUND =
            Color.decode("#FAF7F3");

    private static final Color TEXT =
            Color.decode("#1F242B");

    private static final Color SECONDARY_TEXT =
            Color.decode("#676E78");

    private static final Color BORDER =
            Color.decode("#E4E2E0");

    private static final Color LIGHT_BURGUNDY =
            Color.decode("#F4E7E9");

    private static final Color GREEN =
            Color.decode("#3F7D5A");

    private static final Color LIGHT_GREEN =
            Color.decode("#E8F3EC");



    private static final Font TITLE_FONT =
            new Font(
                    "Inter",
                    Font.BOLD,
                    28
            );

    private static final Font HEADER_FONT =
            new Font(
                    "Inter",
                    Font.BOLD,
                    18
            );

    private static final Font NORMAL_FONT =
            new Font(
                    "Inter",
                    Font.PLAIN,
                    14
            );

    private static final Font BOLD_FONT =
            new Font(
                    "Inter",
                    Font.BOLD,
                    14
            );

    private static final Font SMALL_FONT =
            new Font(
                    "Inter",
                    Font.PLAIN,
                    12
            );


        /** The task on screen; refreshed from TaskManager after completion. */
    private Task task;


    private JLabel statusLabel;

    private JButton completeButton;



    public MotivaTaskDetail(
            Task task
    ) {

        this.task = task;

        setTitle(
                "Motiva — Task Details"
        );

        setSize(
                1280,
                800
        );

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        // Keep the card layout stable at its designed desktop size.
        setResizable(false);

        createUI();
    }



    private void createUI() {

        JPanel root =
                new JPanel(
                        new BorderLayout()
                );

        root.setBackground(
                BACKGROUND
        );



        root.add(
                createSidebar(),
                BorderLayout.WEST
        );



        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                BACKGROUND
        );

        main.setBorder(
                new EmptyBorder(
                        35,
                        45,
                        35,
                        45
                )
        );



        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);


        JPanel titlePanel =
                new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel title =
                new JLabel(
                        "Task Details"
                );

        title.setFont(
                TITLE_FONT
        );

        title.setForeground(
                TEXT
        );


        JLabel subtitle =
                new JLabel(
                        "View and manage this task."
                );

        subtitle.setFont(
                NORMAL_FONT
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );


        titlePanel.add(
                title
        );

        titlePanel.add(
                Box.createVerticalStrut(5)
        );

        titlePanel.add(
                subtitle
        );


        header.add(
                titlePanel,
                BorderLayout.WEST
        );


        main.add(
                header,
                BorderLayout.NORTH
        );



        JPanel card =
                new JPanel();

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                35,
                                40,
                                25,
                                40
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );



        JLabel taskTitle =
                new JLabel(
                        task == null
                                ? "Unknown Task"
                                : safeText(
                                        task.getTitle()
                                )
                );

        taskTitle.setFont(
                HEADER_FONT
        );

        taskTitle.setForeground(
                TEXT
        );

        taskTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        card.add(
                taskTitle
        );


        card.add(
                Box.createVerticalStrut(15)
        );



        statusLabel =
                new JLabel();

        statusLabel.setFont(
                BOLD_FONT
        );

        statusLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        updateStatusLabel();

        card.add(
                statusLabel
        );


        card.add(
                Box.createVerticalStrut(25)
        );



        card.add(
                createSectionTitle(
                        "Description"
                )
        );

        card.add(
                Box.createVerticalStrut(8)
        );


        JTextArea description =
                new JTextArea(
                        task == null
                                ? ""
                                : safeText(
                                        task.getDescription()
                                )
                );

        description.setFont(
                NORMAL_FONT
        );

        description.setForeground(
                TEXT
        );

        description.setBackground(
                LIGHT_BURGUNDY
        );

        description.setLineWrap(
                true
        );

        description.setWrapStyleWord(
                true
        );

        // Keep edits in the dedicated task form rather than this read-only view.
        description.setEditable(
                false
        );

        description.setFocusable(
                false
        );

        description.setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        description.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        description.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        100
                )
        );

        card.add(
                description
        );


        card.add(
                Box.createVerticalStrut(25)
        );



        card.add(
                createSectionTitle(
                        "Task Information"
                )
        );

        card.add(
                Box.createVerticalStrut(15)
        );


        card.add(
                createInfoRow(
                        "Category",
                        task == null
                                ? "-"
                                : safeText(
                                        task.getCategory()
                                )
                )
        );


        card.add(
                Box.createVerticalStrut(10)
        );


        card.add(
                createInfoRow(
                        "Priority",
                        task == null
                                ? "-"
                                : safeText(
                                        task.getPriority()
                                )
                )
        );


        card.add(
                Box.createVerticalStrut(10)
        );


        card.add(
                createInfoRow(
                        "Due Date",
                        task == null
                                ? "-"
                                : safeText(
                                        task.getDueDate()
                                )
                )
        );


        card.add(
                Box.createVerticalStrut(10)
        );


        // Task has no time field, so show the time from its schedule entry.
        card.add(
                createInfoRow(
                        "Time",
                        getTaskScheduleTime()
                )
        );


        card.add(
                Box.createVerticalStrut(25)
        );



        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttons.setOpaque(
                false
        );

        buttons.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        buttons.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );



        JButton cancel =
                new JButton(
                        "Cancel"
                );

        styleSecondaryButton(
                cancel
        );

        cancel.addActionListener(
                e -> dispose()
        );



        JButton delete =
                new JButton(
                        "Delete"
                );

        styleDeleteButton(
                delete
        );

        delete.addActionListener(
                e -> deleteTask()
        );



        JButton edit =
                new JButton(
                        "Edit"
                );

        styleSecondaryButton(
                edit
        );

        edit.addActionListener(
                e -> editTask()
        );



        completeButton =
                new JButton();

        styleCompleteButton(
                completeButton
        );

        completeButton.addActionListener(
                e -> completeTask()
        );


        buttons.add(
                cancel
        );

        buttons.add(
                delete
        );

        buttons.add(
                edit
        );

        buttons.add(
                completeButton
        );


        card.add(
                buttons
        );



        JPanel wrapper =
                new JPanel(
                        new BorderLayout()
                );

        wrapper.setOpaque(
                false
        );

        wrapper.setBorder(
                new EmptyBorder(
                        30,
                        70,
                        0,
                        70
                )
        );

        wrapper.add(
                card,
                BorderLayout.CENTER
        );


        main.add(
                wrapper,
                BorderLayout.CENTER
        );



        root.add(
                main,
                BorderLayout.CENTER
        );

        setContentPane(
                root
        );

        revalidate();

        repaint();
    }


        /** Finds the task's scheduled time, or a dash when no matching entry exists. */
        private String getTaskScheduleTime() {

        if (task == null) {
            return "—";
        }


        String taskTitle =
                task.getTitle();

        String taskDate =
                task.getDueDate();


        if (
                taskTitle == null
                || taskTitle.trim().isEmpty()
        ) {

            return "—";
        }


        Schedule fallbackSchedule =
                null;


        for (
                Schedule schedule
                : AppData.scheduleManager.getSchedules()
        ) {

            if (schedule == null) {
                continue;
            }


            String scheduleTitle =
                    schedule.getTitle();

            String scheduleDate =
                    schedule.getDate();


            if (
                    scheduleTitle == null
                    || !scheduleTitle.equals(taskTitle)
            ) {

                continue;
            }


            if (
                    taskDate != null
                    && scheduleDate != null
                    && scheduleDate.equals(taskDate)
            ) {

                return safeText(
                        schedule.getTime()
                );
            }


            if (fallbackSchedule == null) {

                fallbackSchedule =
                        schedule;
            }
        }


        if (fallbackSchedule != null) {

            return safeText(
                    fallbackSchedule.getTime()
            );
        }


        return "—";
    }



    private void completeTask() {

        if (task == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No task was selected.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        if (task.isCompleted()) {

            JOptionPane.showMessageDialog(
                    this,
                    "This task is already completed.",
                    "Motiva",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }


        // TaskManager owns the state change and disk write.
        boolean success =
                AppData.taskManager
                        .completeTask(
                                task.getId()
                        );


        if (!success) {

            JOptionPane.showMessageDialog(
                    this,
                    "The task could not be completed.",
                    "Motiva",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        // Reload the saved object so the status reflects the manager's state.
        Task updatedTask =
                AppData.taskManager
                        .getTaskById(
                                task.getId()
                        );


        if (updatedTask == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Task was completed, but the updated task could not be loaded.",
                    "Motiva",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        task =
                updatedTask;


        updateStatusLabel();


        FoodReward reward =
                AppData.rewardManager
                        .getRandomFoodReward();


        if (reward != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Task completed! 🎉\n\n"
                            + reward.getRewardMessage(),
                    "Reward Unlocked!",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Task completed successfully! 🎉",
                    "Motiva",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }



    private void updateStatusLabel() {

        if (statusLabel == null) {
            return;
        }


        if (
                task != null
                && task.isCompleted()
        ) {

            statusLabel.setText(
                    "✓ COMPLETED"
            );

            statusLabel.setForeground(
                    GREEN
            );

            statusLabel.setBackground(
                    LIGHT_GREEN
            );

        } else {

            statusLabel.setText(
                    "● IN PROGRESS"
            );

            statusLabel.setForeground(
                    BURGUNDY
            );

            statusLabel.setBackground(
                    LIGHT_BURGUNDY
            );
        }


        statusLabel.setOpaque(
                true
        );

        statusLabel.setBorder(
                new EmptyBorder(
                        8,
                        12,
                        8,
                        12
                )
        );

        statusLabel.revalidate();

        statusLabel.repaint();



        if (completeButton != null) {

            if (
                    task != null
                    && task.isCompleted()
            ) {

                completeButton.setText(
                        "Completed"
                );

                completeButton.setEnabled(
                        false
                );

                completeButton.setForeground(
                        GREEN
                );

                completeButton.setBackground(
                        LIGHT_GREEN
                );

            } else {

                completeButton.setText(
                        "Complete"
                );

                completeButton.setEnabled(
                        true
                );

                completeButton.setForeground(
                        Color.WHITE
                );

                completeButton.setBackground(
                        BURGUNDY
                );
            }

            completeButton.revalidate();

            completeButton.repaint();
        }
    }


        /** Opens the task form with this task loaded for editing. */
    private void editTask() {

        if (task == null) {
            return;
        }


        MotivaAddTask editScreen =
                new MotivaAddTask(
                        task
                );


        editScreen.setLocationRelativeTo(
                this
        );

        editScreen.setVisible(
                true
        );


        dispose();
    }



    private void deleteTask() {

        if (task == null) {
            return;
        }


        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this task?",
                        "Delete Task",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );


        if (
                result != JOptionPane.YES_OPTION
        ) {

            return;
        }


        // Keep task removal and persistence in TaskManager.
        AppData.taskManager.deleteTask(
                task.getId()
        );


        JOptionPane.showMessageDialog(
                this,
                "Task deleted successfully.",
                "Motiva",
                JOptionPane.INFORMATION_MESSAGE
        );


        dispose();
    }



    private JLabel createSectionTitle(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );

        label.setFont(
                BOLD_FONT
        );

        label.setForeground(
                TEXT
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }


        /** Creates a task detail row with its label on the left and value on the right. */
    private JPanel createInfoRow(
            String labelText,
            String valueText
    ) {

        JPanel row =
                new JPanel(
                        new BorderLayout()
                );

        row.setOpaque(
                false
        );

        row.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        25
                )
        );


        JLabel label =
                new JLabel(
                        labelText
                );

        label.setFont(
                BOLD_FONT
        );

        label.setForeground(
                SECONDARY_TEXT
        );


        JLabel value =
                new JLabel(
                        valueText
                );

        value.setFont(
                NORMAL_FONT
        );

        value.setForeground(
                TEXT
        );


        row.add(
                label,
                BorderLayout.WEST
        );

        row.add(
                value,
                BorderLayout.EAST
        );


        return row;
    }



    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        220,
                        800
                )
        );

        sidebar.setBackground(
                BURGUNDY
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        30,
                        18,
                        25,
                        18
                )
        );



        JLabel logo =
                new JLabel(
                        "MOTIVA"
                );

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        22
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        logo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(
                logo
        );


        JLabel subtitle =
                new JLabel(
                        "Student Motivation System"
                );

        subtitle.setFont(
                SMALL_FONT
        );

        subtitle.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(
                subtitle
        );


        sidebar.add(
                Box.createVerticalStrut(40)
        );



        sidebar.add(
                createNavButton(
                        "Dashboard",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "Schedule",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "Rewards",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "Settings",
                        false
                )
        );


        sidebar.add(
                Box.createVerticalGlue()
        );



        JLabel noteTitle =
                new JLabel(
                        "TODAY'S NOTE"
                );

        noteTitle.setFont(
                BOLD_FONT
        );

        noteTitle.setForeground(
                Color.WHITE
        );

        noteTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(
                noteTitle
        );


        sidebar.add(
                Box.createVerticalStrut(8)
        );


        JLabel note =
                new JLabel(
                        "<html>Small progress is still<br>"
                                + "progress. Keep going.</html>"
                );

        note.setFont(
                SMALL_FONT
        );

        note.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        note.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(
                note
        );


        return sidebar;
    }


        /** Builds a sidebar button that routes through the shared navigator. */
    private JButton createNavButton(
            String text,
            boolean active
    ) {

        JButton button =
                new JButton(
                        text
                );

        button.setFont(
                BOLD_FONT
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFocusPainted(
                false
        );

        button.setBorderPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setMaximumSize(
                new Dimension(
                        190,
                        44
                )
        );


        if (active) {

            button.setBackground(
                    LIGHT_BURGUNDY
            );

            button.setForeground(
                    BURGUNDY
            );

        } else {

            button.setBackground(
                    BURGUNDY
            );

            button.setForeground(
                    Color.WHITE
            );
        }


        button.addActionListener(
                event -> {

                    switch (text) {

                        case "Dashboard":

                            MotivaNavigation
                                    .goToDashboard(
                                            this
                                    );

                            break;


                        case "Schedule":

                            MotivaNavigation
                                    .goToSchedule(
                                            this
                                    );

                            break;


                        case "Rewards":

                            MotivaNavigation
                                    .goToRewards(
                                            this
                                    );

                            break;


                        case "Settings":

                            MotivaNavigation
                                    .goToSettings(
                                            this
                                    );

                            break;


                        default:

                            break;
                    }
                }
        );


        return button;
    }



    private void styleSecondaryButton(
            JButton button
    ) {

        button.setFont(
                BOLD_FONT
        );

        button.setForeground(
                TEXT
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setPreferredSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setMinimumSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setMaximumSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                8,
                                12,
                                8,
                                12
                        )
                )
        );
    }



    private void styleDeleteButton(
            JButton button
    ) {

        button.setFont(
                BOLD_FONT
        );

        button.setForeground(
                BURGUNDY
        );

        button.setBackground(
                LIGHT_BURGUNDY
        );

        button.setFocusPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setPreferredSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setMinimumSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setMaximumSize(
                new Dimension(
                        90,
                        42
                )
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                LIGHT_BURGUNDY
                        ),
                        new EmptyBorder(
                                8,
                                12,
                                8,
                                12
                        )
                )
        );
    }


        /** Sets a fixed size so FlowLayout does not collapse the completion button. */
    private void styleCompleteButton(
            JButton button
    ) {

        button.setText(
                "Complete"
        );

        button.setFont(
                BOLD_FONT
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                BURGUNDY
        );

        button.setFocusPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setContentAreaFilled(
                true
        );

        button.setPreferredSize(
                new Dimension(
                        105,
                        42
                )
        );

        button.setMinimumSize(
                new Dimension(
                        105,
                        42
                )
        );

        button.setMaximumSize(
                new Dimension(
                        105,
                        42
                )
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BURGUNDY
                        ),
                        new EmptyBorder(
                                8,
                                14,
                                8,
                                14
                        )
                )
        );
    }


        /** Uses a dash for missing text so Swing labels never receive null. */
    private String safeText(
            String text
    ) {

        if (
                text == null
                || text.trim().isEmpty()
        ) {

            return "—";
        }

        return text;
    }


        /** Opens the first saved task for local UI testing. */
    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    if (
                            AppData.taskManager
                                    .getTasks()
                                    .isEmpty()
                    ) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No tasks available.",
                                "Motiva",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        return;
                    }


                    Task task =
                            null;


                    for (
                            Task candidate
                            : AppData.taskManager
                                    .getTasks()
                    ) {

                        if (
                                !candidate.isCompleted()
                        ) {

                            task =
                                    candidate;

                            break;
                        }
                    }


                    if (task == null) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No incomplete tasks available.",
                                "Motiva",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        return;
                    }


                    MotivaTaskDetail screen =
                            new MotivaTaskDetail(
                                    task
                            );

                    screen.setVisible(
                            true
                    );
                }
        );
    }
}