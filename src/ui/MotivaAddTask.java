import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import model.Profile;
import model.Schedule;
import model.Task;
import service.AppData;

/**
 * Provides the task editor used to create a new item or update an existing one.
 * It captures the task details, stores the updated information, and keeps the
 * student's workload organized across the app.
 */
public class MotivaAddTask extends JFrame {


    private static final Color BURGUNDY =
            new Color(0x62, 0x24, 0x2F);

    private static final Color DEEP_BURGUNDY =
            new Color(0x46, 0x19, 0x21);

    private static final Color BACKGROUND =
            new Color(0xFA, 0xF7, 0xF3);

    private static final Color TEXT =
            new Color(0x1F, 0x24, 0x2B);

    private static final Color SECONDARY_TEXT =
            new Color(0x67, 0x6E, 0x78);

    private static final Color BORDER =
            new Color(0xE4, 0xE2, 0xE0);


    private static final Font FONT =
            new Font("Inter", Font.PLAIN, 14);

    private static final Font FONT_BOLD =
            new Font("Inter", Font.BOLD, 14);

    private static final Font FONT_TITLE =
            new Font("Inter", Font.BOLD, 28);

    private static final Font FONT_SMALL =
            new Font("Inter", Font.PLAIN, 12);


    private Task taskToEdit;


    public MotivaAddTask() {
        this(null);
    }

    public MotivaAddTask(Task taskToEdit) {

        this.taskToEdit = taskToEdit;

        if (taskToEdit == null) {
            setTitle("Motiva — Add Task");
        } else {
            setTitle("Motiva — Edit Task");
        }

        setSize(
                1280,
                800
        );

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

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

        root.add(
                createMainContent(),
                BorderLayout.CENTER
        );

        setContentPane(root);
    }


    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        240,
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
                        28,
                        20,
                        25,
                        20
                )
        );

        JLabel logo =
                new JLabel(
                        "Motiva"
                );

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        25
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        logo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel subtitle =
                new JLabel(
                        "Student Motivation System"
                );

        subtitle.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
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

        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(3)
        );

        sidebar.add(subtitle);

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
                        "My Tasks",
                        true
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


        JPanel note =
                new JPanel();

        note.setLayout(
                new BoxLayout(
                        note,
                        BoxLayout.Y_AXIS
                )
        );

        note.setBackground(
                DEEP_BURGUNDY
        );

        note.setBorder(
                new EmptyBorder(
                        16,
                        15,
                        16,
                        15
                )
        );

        note.setMaximumSize(
                new Dimension(
                        200,
                        115
                )
        );

        note.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel noteTitle =
                new JLabel(
                        "Today's Note"
                );

        noteTitle.setFont(
                FONT_BOLD
        );

        noteTitle.setForeground(
                Color.WHITE
        );

        JLabel noteText =
                new JLabel(
                        "<html>Small progress is still<br>"
                                + "progress. Keep going.</html>"
                );

        noteText.setFont(
                FONT_SMALL
        );

        noteText.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        note.add(noteTitle);

        note.add(
                Box.createVerticalStrut(8)
        );

        note.add(noteText);

        sidebar.add(note);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        sidebar.add(
                createSidebarProfile()
        );

        return sidebar;
    }


    private JPanel createSidebarProfile() {

        JPanel profile =
                new JPanel(
                        new BorderLayout(
                                10,
                                0
                        )
                );

        profile.setOpaque(false);

        profile.setMaximumSize(
                new Dimension(
                        200,
                        45
                )
        );

        profile.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        Profile currentProfile =
                AppData.profileManager.getProfile();

        String studentName =
                currentProfile != null
                        ? currentProfile.getName()
                        : "Student";

        String initial =
                studentName.isEmpty()
                        ? "S"
                        : studentName
                                .substring(0, 1)
                                .toUpperCase();

        JLabel avatar =
                new JLabel(initial);

        avatar.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        avatar.setVerticalAlignment(
                SwingConstants.CENTER
        );

        avatar.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        avatar.setForeground(
                BURGUNDY
        );

        avatar.setBackground(
                Color.WHITE
        );

        avatar.setOpaque(true);

        avatar.setPreferredSize(
                new Dimension(
                        38,
                        38
                )
        );

        JPanel profileText =
                new JPanel();

        profileText.setOpaque(false);

        profileText.setLayout(
                new BoxLayout(
                        profileText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel name =
                new JLabel(
                        studentName
                );

        name.setFont(FONT_BOLD);

        name.setForeground(
                Color.WHITE
        );

        JLabel program =
                new JLabel(
                        "BSCpE Student"
                );

        program.setFont(FONT_SMALL);

        program.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        profileText.add(name);

        profileText.add(program);

        profile.add(
                avatar,
                BorderLayout.WEST
        );

        profile.add(
                profileText,
                BorderLayout.CENTER
        );

        return profile;
    }


    private JButton createNavButton(
            String text,
            boolean active
    ) {

        JButton button =
                new JButton(text);

        button.setFont(FONT_BOLD);

        button.setForeground(
                Color.WHITE
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setBackground(
                active
                        ? DEEP_BURGUNDY
                        : BURGUNDY
        );

        button.setBorder(
                new EmptyBorder(
                        12,
                        15,
                        12,
                        15
                )
        );

        button.setFocusPainted(false);

        button.setOpaque(true);

        button.setBorderPainted(false);

        button.setMaximumSize(
                new Dimension(
                        200,
                        45
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addActionListener(
                event -> {

                    switch (text) {

                        case "Dashboard":

                            MotivaNavigation
                                    .goToDashboard(this);

                            break;

                        case "My Tasks":

                            MotivaNavigation
                                    .goToDashboard(this);

                            break;

                        case "Schedule":

                            MotivaNavigation
                                    .goToSchedule(this);

                            break;

                        case "Rewards":

                            MotivaNavigation
                                    .goToRewards(this);

                            break;

                        case "Settings":

                            MotivaNavigation
                                    .goToSettings(this);

                            break;

                        default:

                            break;
                    }
                }
        );

        return button;
    }


    private JPanel createMainContent() {

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
                        40,
                        35,
                        40
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
                        taskToEdit == null
                                ? "Add Task"
                                : "Edit Task"
                );

        title.setFont(
                FONT_TITLE
        );

        title.setForeground(
                TEXT
        );

        JLabel description =
                new JLabel(
                        taskToEdit == null
                                ? "Add something you want to accomplish."
                                : "Update the details of your task."
                );

        description.setFont(FONT);

        description.setForeground(
                SECONDARY_TEXT
        );

        titlePanel.add(title);

        titlePanel.add(
                Box.createVerticalStrut(6)
        );

        titlePanel.add(description);

        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        header.add(
                createTopProfile(),
                BorderLayout.EAST
        );

        main.add(
                header,
                BorderLayout.NORTH
        );


        JPanel formWrapper =
                new JPanel(
                        new BorderLayout()
                );

        formWrapper.setOpaque(false);

        formWrapper.setBorder(
                new EmptyBorder(
                        30,
                        80,
                        0,
                        80
                )
        );


        JPanel formCard =
                new JPanel();

        formCard.setBackground(
                Color.WHITE
        );

        formCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                28,
                                32,
                                28,
                                32
                        )
                )
        );

        formCard.setLayout(
                new BoxLayout(
                        formCard,
                        BoxLayout.Y_AXIS
                )
        );


        formCard.add(
                createLabel(
                        "Task name"
                )
        );

        JTextField taskName =
                new JTextField();

        if (taskToEdit != null) {

            taskName.setText(
                    taskToEdit.getTitle()
            );
        }

        styleTextField(taskName);

        formCard.add(taskName);

        formCard.add(
                Box.createVerticalStrut(18)
        );


        formCard.add(
                createLabel(
                        "Description"
                )
        );

        JTextArea descriptionArea =
                new JTextArea(
                        4,
                        20
                );

        if (taskToEdit != null) {

            descriptionArea.setText(
                    taskToEdit.getDescription()
            );
        }

        descriptionArea.setLineWrap(true);

        descriptionArea.setWrapStyleWord(true);

        descriptionArea.setFont(FONT);

        descriptionArea.setForeground(TEXT);

        descriptionArea.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10,
                                12,
                                10,
                                12
                        )
                )
        );

        JScrollPane descriptionScroll =
                new JScrollPane(
                        descriptionArea
                );

        descriptionScroll.setBorder(null);

        formCard.add(
                descriptionScroll
        );

        formCard.add(
                Box.createVerticalStrut(18)
        );


        JPanel row1 =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                18,
                                0
                        )
                );

        row1.setOpaque(false);

        JPanel categoryPanel =
                createFormFieldPanel(
                        "Category"
                );

        JComboBox<String> category =
                new JComboBox<>(
                        new String[]{
                                "School",
                                "Personal"
                        }
                );

        styleComboBox(category);

        if (taskToEdit != null) {

            category.setSelectedItem(
                    taskToEdit.getCategory()
            );
        }

        categoryPanel.add(category);

        JPanel priorityPanel =
                createFormFieldPanel(
                        "Priority"
                );

        JComboBox<String> priority =
                new JComboBox<>(
                        new String[]{
                                "Low",
                                "Medium",
                                "High"
                        }
                );

        styleComboBox(priority);

        if (taskToEdit != null) {

            priority.setSelectedItem(
                    taskToEdit.getPriority()
            );
        }

        priorityPanel.add(priority);

        row1.add(categoryPanel);

        row1.add(priorityPanel);

        formCard.add(row1);

        formCard.add(
                Box.createVerticalStrut(18)
        );


        JPanel row2 =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                18,
                                0
                        )
                );

        row2.setOpaque(false);

        JPanel datePanel =
                createFormFieldPanel(
                        "Due date"
                );

        JTextField dueDate =
                new JTextField();

        if (taskToEdit != null) {

            dueDate.setText(
                    taskToEdit.getDueDate()
            );

        } else {

            dueDate.setText(
                    "September 30, 2026"
            );
        }

        styleTextField(dueDate);

        datePanel.add(dueDate);

        JPanel timePanel =
                createFormFieldPanel(
                        "Time"
                );

        JTextField time =
                new JTextField(
                        "10:00 AM"
                );

        styleTextField(time);

        timePanel.add(time);

        row2.add(datePanel);

        row2.add(timePanel);

        formCard.add(row2);

        formCard.add(
                Box.createVerticalStrut(18)
        );


        JPanel scheduleRow =
                new JPanel(
                        new BorderLayout()
                );

        scheduleRow.setOpaque(false);

        JPanel scheduleText =
                new JPanel();

        scheduleText.setOpaque(false);

        scheduleText.setLayout(
                new BoxLayout(
                        scheduleText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel scheduleTitle =
                new JLabel(
                        "Add to schedule"
                );

        scheduleTitle.setFont(
                FONT_BOLD
        );

        scheduleTitle.setForeground(
                TEXT
        );

        JLabel scheduleDescription =
                new JLabel(
                        "Include this task in your daily schedule."
                );

        scheduleDescription.setFont(
                FONT_SMALL
        );

        scheduleDescription.setForeground(
                SECONDARY_TEXT
        );

        scheduleText.add(
                scheduleTitle
        );

        scheduleText.add(
                Box.createVerticalStrut(4)
        );

        scheduleText.add(
                scheduleDescription
        );

        JCheckBox scheduleToggle =
                new JCheckBox();

        scheduleToggle.setSelected(true);

        scheduleToggle.setOpaque(false);

        scheduleRow.add(
                scheduleText,
                BorderLayout.WEST
        );

        scheduleRow.add(
                scheduleToggle,
                BorderLayout.EAST
        );

        formCard.add(scheduleRow);

        formCard.add(
                Box.createVerticalGlue()
        );


        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttons.setOpaque(false);

        JButton cancel =
                new JButton(
                        "Cancel"
                );

        styleSecondaryButton(cancel);

        cancel.addActionListener(
                e -> dispose()
        );

        JButton save =
                new JButton(
                        taskToEdit == null
                                ? "Save Task"
                                : "Save Changes"
                );

        stylePrimaryButton(save);


        save.addActionListener(
                e -> {

                    String taskTitle =
                            taskName
                                    .getText()
                                    .trim();

                    String descriptionText =
                            descriptionArea
                                    .getText()
                                    .trim();

                    String selectedCategory =
                            (String)
                                    category
                                            .getSelectedItem();

                    String selectedPriority =
                            (String)
                                    priority
                                            .getSelectedItem();

                    String selectedDueDate =
                            dueDate
                                    .getText()
                                    .trim();

                    String selectedTime =
                            time
                                    .getText()
                                    .trim();

                    boolean addToSchedule =
                            scheduleToggle
                                    .isSelected();


                    if (taskTitle.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please enter a task name.",
                                "Missing Task Name",
                                JOptionPane.WARNING_MESSAGE
                        );

                        taskName.requestFocus();

                        return;
                    }

                    if (selectedDueDate.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please enter a due date.",
                                "Missing Due Date",
                                JOptionPane.WARNING_MESSAGE
                        );

                        dueDate.requestFocus();

                        return;
                    }

                    if (selectedTime.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please enter a time.",
                                "Missing Time",
                                JOptionPane.WARNING_MESSAGE
                        );

                        time.requestFocus();

                        return;
                    }


                    if (taskToEdit == null) {

                        int taskId =
                                getNextTaskId();

                        Task task =
                                new Task(
                                        taskId,
                                        taskTitle,
                                        descriptionText,
                                        selectedDueDate,
                                        selectedPriority,
                                        selectedCategory
                                );

                        AppData.taskManager
                                .addTask(task);


                        if (addToSchedule) {

                            addTaskToSchedule(
                                    task.getId(),
                                    taskTitle,
                                    selectedCategory,
                                    selectedDueDate,
                                    selectedTime,
                                    selectedPriority
                            );
                        }

                        JOptionPane.showMessageDialog(
                                this,
                                addToSchedule
                                        ? "Task saved and added to your schedule!"
                                        : "Task saved successfully!",
                                "Task Saved",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }


                    else {

                        taskToEdit.setTitle(
                                taskTitle
                        );

                        taskToEdit.setDescription(
                                descriptionText
                        );

                        taskToEdit.setDueDate(
                                selectedDueDate
                        );

                        taskToEdit.setPriority(
                                selectedPriority
                        );

                        taskToEdit.setCategory(
                                selectedCategory
                        );

                        AppData.taskManager
                                .updateTask(
                                        taskToEdit
                                );

                        JOptionPane.showMessageDialog(
                                this,
                                "Task updated successfully!",
                                "Task Updated",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }

                    dispose();
                }
        );

        buttons.add(cancel);

        buttons.add(save);

        formCard.add(buttons);

        formWrapper.add(
                formCard,
                BorderLayout.CENTER
        );

        main.add(
                formWrapper,
                BorderLayout.CENTER
        );

        return main;
    }


        /** Adds the saved task to the schedule using its new task ID. */
    private void addTaskToSchedule(
            int taskId,
            String title,
            String category,
            String date,
            String time,
            String priority
    ) {

        int scheduleId =
                AppData.scheduleManager
                        .getNextScheduleId();

        Schedule schedule =
                new Schedule(
                        scheduleId,
                        title,
                        category,
                        date,
                        time,
                        priority,
                        "TASK",
                        "TASK",
                        taskId,
                        ""
                );

        AppData.scheduleManager
                .addSchedule(
                        schedule
                );

        System.out.println(
                "Task added to schedule:"
        );

        System.out.println(
                "Schedule ID: "
                        + scheduleId
        );

        System.out.println(
                "Title: "
                        + title
        );

        System.out.println(
                "Date: "
                        + date
        );

        System.out.println(
                "Time: "
                        + time
        );
    }


    private int getNextTaskId() {

        int maxId = 0;

        for (
                Task task :
                AppData.taskManager.getTasks()
        ) {

            if (
                    task.getId() > maxId
            ) {

                maxId =
                        task.getId();
            }
        }

        return maxId + 1;
    }


    private JPanel createTopProfile() {

        JPanel profile =
                new JPanel();

        profile.setOpaque(false);

        profile.setLayout(
                new BoxLayout(
                        profile,
                        BoxLayout.X_AXIS
                )
        );

        Profile currentProfile =
                AppData.profileManager.getProfile();

        String studentName =
                currentProfile != null
                        ? currentProfile.getName()
                        : "Student";

        String initial =
                studentName.isEmpty()
                        ? "S"
                        : studentName
                                .substring(0, 1)
                                .toUpperCase();

        JLabel avatar =
                new JLabel(initial);

        avatar.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        avatar.setVerticalAlignment(
                SwingConstants.CENTER
        );

        avatar.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        avatar.setForeground(
                Color.WHITE
        );

        avatar.setBackground(
                BURGUNDY
        );

        avatar.setOpaque(true);

        avatar.setPreferredSize(
                new Dimension(
                        38,
                        38
                )
        );

        JLabel name =
                new JLabel(
                        studentName
                );

        name.setFont(FONT_BOLD);

        name.setForeground(TEXT);

        profile.add(avatar);

        profile.add(
                Box.createHorizontalStrut(10)
        );

        profile.add(name);

        return profile;
    }


    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                FONT_BOLD
        );

        label.setForeground(TEXT);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        label.setBorder(
                new EmptyBorder(
                        0,
                        0,
                        7,
                        0
                )
        );

        return label;
    }


    private JPanel createFormFieldPanel(
            String labelText
    ) {

        JPanel panel =
                new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.add(
                createLabel(
                        labelText
                )
        );

        return panel;
    }


    private void styleTextField(
            JTextField field
    ) {

        field.setFont(FONT);

        field.setForeground(TEXT);

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10,
                                12,
                                10,
                                12
                        )
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        44
                )
        );
    }


    private void styleComboBox(
            JComboBox<String> comboBox
    ) {

        comboBox.setFont(FONT);

        comboBox.setForeground(TEXT);

        comboBox.setBackground(
                Color.WHITE
        );

        comboBox.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        comboBox.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        44
                )
        );
    }


    private void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(FONT_BOLD);

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                BURGUNDY
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setOpaque(true);

        button.setBorder(
                new EmptyBorder(
                        11,
                        22,
                        11,
                        22
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    private void styleSecondaryButton(
            JButton button
    ) {

        button.setFont(FONT_BOLD);

        button.setForeground(TEXT);

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setOpaque(true);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10,
                                21,
                                10,
                                21
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    MotivaAddTask app =
                            new MotivaAddTask();

                    app.setVisible(true);
                }
        );
    }
}