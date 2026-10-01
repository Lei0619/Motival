import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Profile;
import model.Task;
import service.AppData;

/** Main dashboard for reviewing activity and opening other screens. */
public class MotivaDashboard extends JFrame {


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

    private static final Color LIGHT_BURGUNDY =
            Color.decode("#F4E7E9");

    private static final Color BORDER =
            Color.decode("#E4E2E0");

    private static final Color GOLD_BG =
            Color.decode("#FAF1DC");

    private static final Color GOLD =
            Color.decode("#B57E26");

    private static final Color GREEN_BG =
            Color.decode("#E8F3EC");

    private static final Color GREEN =
            Color.decode("#3F7D5A");


    public MotivaDashboard() {

        setTitle(
                "Motiva — Student Motivation System"
        );

        setSize(
                1280,
                800
        );

        setMinimumSize(
                new Dimension(
                        1000,
                        650
                )
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        buildDashboard();
    }


    private void buildDashboard() {

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

        revalidate();
        repaint();
    }

    public void refreshDashboard() {

        buildDashboard();
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
                Color.WHITE
        );

        sidebar.setLayout(
                new BorderLayout()
        );

        JPanel topLine =
                new JPanel();

        topLine.setBackground(
                BURGUNDY
        );

        topLine.setPreferredSize(
                new Dimension(
                        220,
                        6
                )
        );

        sidebar.add(
                topLine,
                BorderLayout.NORTH
        );

        JPanel sidebarContent =
                new JPanel(
                        new BorderLayout()
                );

        sidebarContent.setBackground(
                Color.WHITE
        );

        sidebarContent.setBorder(
                new EmptyBorder(
                        22,
                        16,
                        16,
                        16
                )
        );


        JPanel logoPanel =
                new JPanel();

        logoPanel.setOpaque(false);

        logoPanel.setLayout(
                new BoxLayout(
                        logoPanel,
                        BoxLayout.X_AXIS
                )
        );

        JLabel logoM =
                new JLabel(
                        "M"
                );

        logoM.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        24
                )
        );

        logoM.setForeground(
                BURGUNDY
        );

        JPanel logoText =
                new JPanel();

        logoText.setOpaque(false);

        logoText.setLayout(
                new BoxLayout(
                        logoText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel motiva =
                new JLabel(
                        "MOTIVA"
                );

        motiva.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        17
                )
        );

        motiva.setForeground(
                TEXT
        );

        JLabel subtitle =
                new JLabel(
                        "Student motivation system"
                );

        subtitle.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        10
                )
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );

        logoText.add(
                motiva
        );

        logoText.add(
                subtitle
        );

        logoPanel.add(
                logoM
        );

        logoPanel.add(
                Box.createHorizontalStrut(6)
        );

        logoPanel.add(
                logoText
        );


        JPanel navigation =
                new JPanel();

        navigation.setOpaque(false);

        navigation.setBorder(
                new EmptyBorder(
                        30,
                        0,
                        0,
                        0
                )
        );

        navigation.setLayout(
                new BoxLayout(
                        navigation,
                        BoxLayout.Y_AXIS
                )
        );


        navigation.add(
                createNavButton(
                        "Dashboard",
                        true,
                        () ->
                                MotivaNavigation
                                        .goToDashboard(this)
                )
        );

        navigation.add(
                Box.createVerticalStrut(8)
        );


        navigation.add(
                createNavButton(
                        "Schedule",
                        false,
                        () ->
                                MotivaNavigation
                                        .goToSchedule(this)
                )
        );

        navigation.add(
                Box.createVerticalStrut(8)
        );


        navigation.add(
                createNavButton(
                        "Rewards",
                        false,
                        () ->
                                MotivaNavigation
                                        .goToRewards(this)
                )
        );

        navigation.add(
                Box.createVerticalStrut(8)
        );


        navigation.add(
                createNavButton(
                        "Settings",
                        false,
                        () ->
                                MotivaNavigation
                                        .goToSettings(this)
                )
        );

        JPanel center =
                new JPanel(
                        new BorderLayout()
                );

        center.setOpaque(false);

        center.add(
                logoPanel,
                BorderLayout.NORTH
        );

        center.add(
                navigation,
                BorderLayout.CENTER
        );

        sidebarContent.add(
                center,
                BorderLayout.CENTER
        );

        sidebarContent.add(
                createTodaysNote(),
                BorderLayout.SOUTH
        );

        sidebar.add(
                sidebarContent,
                BorderLayout.CENTER
        );

        return sidebar;
    }


    private JButton createNavButton(
            String text,
            boolean active,
            Runnable action
    ) {

        JButton button =
                new JButton(
                        "■    " + text
                );

        button.setPreferredSize(
                new Dimension(
                        188,
                        44
                )
        );

        button.setMaximumSize(
                new Dimension(
                        188,
                        44
                )
        );

        button.setMinimumSize(
                new Dimension(
                        188,
                        44
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setBorderPainted(
                false
        );

        button.setFocusPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        13
                )
        );

        button.setBorder(
                new EmptyBorder(
                        0,
                        14,
                        0,
                        0
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
                    Color.WHITE
            );

            button.setForeground(
                    SECONDARY_TEXT
            );
        }

        button.addActionListener(
                e -> action.run()
        );

        return button;
    }


    private JPanel createTodaysNote() {

        JPanel note =
                new JPanel();

        note.setPreferredSize(
                new Dimension(
                        188,
                        126
                )
        );

        note.setBackground(
                DEEP_BURGUNDY
        );

        note.setBorder(
                new EmptyBorder(
                        14,
                        16,
                        12,
                        16
                )
        );

        note.setLayout(
                new BoxLayout(
                        note,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "TODAY'S NOTE"
                );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        title.setForeground(
                Color.decode("#E1C2C6")
        );

        JLabel line1 =
                new JLabel(
                        "Small progress is still progress."
                );

        line1.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
        );

        line1.setForeground(
                Color.WHITE
        );

        JLabel line2 =
                new JLabel(
                        "Finish one task, then breathe."
                );

        line2.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
        );

        line2.setForeground(
                Color.WHITE
        );

        JLabel author =
                new JLabel(
                        "— Motiva"
                );

        author.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        12
                )
        );

        author.setForeground(
                Color.decode("#EBD5D8")
        );

        note.add(
                title
        );

        note.add(
                Box.createVerticalStrut(8)
        );

        note.add(line1);

        note.add(line2);

        note.add(
                Box.createVerticalStrut(10)
        );

        note.add(author);

        return note;
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
                        28,
                        32,
                        28,
                        44
                )
        );


        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        header.setPreferredSize(
                new Dimension(
                        0,
                        70
                )
        );

        JPanel greeting =
                new JPanel();

        greeting.setOpaque(false);

        greeting.setLayout(
                new BoxLayout(
                        greeting,
                        BoxLayout.Y_AXIS
                )
        );


        Profile profile =
                AppData.profileManager
                        .getProfile();

        String userName =
                getProfileName(
                        profile
                );

        JLabel title =
                new JLabel(
                        "Good morning, "
                                + userName
                );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        26
                )
        );

        title.setForeground(
                TEXT
        );

        JLabel description =
                new JLabel(
                        "Here's a simple view of what needs your attention today."
                );

        description.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        13
                )
        );

        description.setForeground(
                SECONDARY_TEXT
        );

        greeting.add(
                title
        );

        greeting.add(
                Box.createVerticalStrut(4)
        );

        greeting.add(
                description
        );

        header.add(
                greeting,
                BorderLayout.WEST
        );

        header.add(
                createProfile(),
                BorderLayout.EAST
        );


        JPanel content =
                new JPanel();

        content.setOpaque(false);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );


        JPanel summaryRow =
                new JPanel(
                        new BorderLayout(
                                24,
                                0
                        )
                );

        summaryRow.setOpaque(false);

        summaryRow.setPreferredSize(
                new Dimension(
                        0,
                        156
                )
        );

        summaryRow.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        156
                )
        );

        summaryRow.add(
                createProgressCard(),
                BorderLayout.CENTER
        );

        summaryRow.add(
                createDeadlineCard(),
                BorderLayout.EAST
        );


        JPanel tasksHeader =
                new JPanel(
                        new BorderLayout()
                );

        tasksHeader.setOpaque(false);

        tasksHeader.setBorder(
                new EmptyBorder(
                        28,
                        0,
                        14,
                        0
                )
        );

        JPanel taskTitle =
                new JPanel();

        taskTitle.setOpaque(false);

        taskTitle.setLayout(
                new BoxLayout(
                        taskTitle,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel tasks =
                new JLabel(
                        "Today's tasks"
                );

        tasks.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        20
                )
        );

        tasks.setForeground(
                TEXT
        );

        JLabel taskDescription =
                new JLabel(
                        "Stay focused on what matters first."
                );

        taskDescription.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
        );

        taskDescription.setForeground(
                SECONDARY_TEXT
        );

        taskTitle.add(
                tasks
        );

        taskTitle.add(
                Box.createVerticalStrut(2)
        );

        taskTitle.add(
                taskDescription
        );

        JButton addTask =
                new JButton(
                        "+ Add Task"
                );

        addTask.setPreferredSize(
                new Dimension(
                        156,
                        42
                )
        );

        addTask.setBackground(
                BURGUNDY
        );

        addTask.setForeground(
                Color.WHITE
        );

        addTask.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        13
                )
        );

        addTask.setBorderPainted(
                false
        );

        addTask.setFocusPainted(
                false
        );

        addTask.addActionListener(
                e -> openAddTask()
        );

        tasksHeader.add(
                taskTitle,
                BorderLayout.WEST
        );

        tasksHeader.add(
                addTask,
                BorderLayout.EAST
        );

        content.add(
                summaryRow
        );

        content.add(
                tasksHeader
        );

        content.add(
                createTaskList()
        );

        content.add(
                Box.createVerticalStrut(24)
        );

        content.add(
                createMotivationCard()
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        content
                );

        scrollPane.setBorder(
                null
        );

        scrollPane.setBackground(
                BACKGROUND
        );

        scrollPane.getViewport()
                .setBackground(
                        BACKGROUND
                );

        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants
                        .HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(
                        16
                );

        main.add(
                header,
                BorderLayout.NORTH
        );

        main.add(
                scrollPane,
                BorderLayout.CENTER
        );

        return main;
    }


    private JPanel createTaskList() {

        JPanel taskList =
                new JPanel();

        taskList.setOpaque(false);

        taskList.setLayout(
                new BoxLayout(
                        taskList,
                        BoxLayout.Y_AXIS
                )
        );

        if (
                AppData.taskManager
                        .getTasks()
                        .isEmpty()
        ) {

            taskList.add(
                    createEmptyTaskCard()
            );

            return taskList;
        }

        for (
                Task task
                : AppData.taskManager.getTasks()
        ) {

            taskList.add(
                    createTaskCard(
                            task
                    )
            );

            taskList.add(
                    Box.createVerticalStrut(
                            12
                    )
            );
        }

        return taskList;
    }


    private JPanel createEmptyTaskCard() {

        JPanel card =
                createWhiteCard();

        card.setPreferredSize(
                new Dimension(
                        984,
                        100
                )
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        100
                )
        );

        card.setLayout(
                new GridBagLayout()
        );

        JLabel message =
                new JLabel(
                        "No tasks yet. Click + Add Task to get started."
                );

        message.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        13
                )
        );

        message.setForeground(
                SECONDARY_TEXT
        );

        card.add(
                message
        );

        return card;
    }


    private JPanel createTaskCard(
            Task task
    ) {

        JPanel card =
                createWhiteCard();

        card.setPreferredSize(
                new Dimension(
                        984,
                        72
                )
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        72
                )
        );

        card.setBorder(
                new EmptyBorder(
                        10,
                        15,
                        10,
                        15
                )
        );

        card.setLayout(
                new BorderLayout(
                        15,
                        0
                )
        );

        JLabel checkbox =
                new JLabel();

        checkbox.setPreferredSize(
                new Dimension(
                        20,
                        20
                )
        );

        checkbox.setOpaque(true);

        if (
                task.isCompleted()
        ) {

            checkbox.setBackground(
                    GREEN
            );

            checkbox.setText(
                    "✓"
            );

            checkbox.setForeground(
                    Color.WHITE
            );

            checkbox.setHorizontalAlignment(
                    SwingConstants.CENTER
            );

        } else {

            checkbox.setBackground(
                    BURGUNDY
            );
        }

        JPanel information =
                new JPanel();

        information.setOpaque(false);

        information.setLayout(
                new BoxLayout(
                        information,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel name =
                new JLabel(
                        task.getTitle()
                );

        name.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        name.setForeground(
                task.isCompleted()
                        ? SECONDARY_TEXT
                        : TEXT
        );

        JLabel details =
                new JLabel(
                        safeText(
                                task.getCategory()
                        )
                                + " • Due "
                                + safeText(
                                        task.getDueDate()
                                )
                );

        details.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
        );

        details.setForeground(
                SECONDARY_TEXT
        );

        information.add(
                name
        );

        information.add(
                Box.createVerticalStrut(
                        3
                )
        );

        information.add(
                details
        );

        JPanel right =
                new JPanel();

        right.setOpaque(false);

        right.setPreferredSize(
                new Dimension(
                        130,
                        50
                )
        );

        right.setLayout(
                new BoxLayout(
                        right,
                        BoxLayout.Y_AXIS
                )
        );

        String priority =
                safeText(
                        task.getPriority()
                );

        Color priorityBackground;

        Color priorityText;

        if (
                priority.equalsIgnoreCase(
                        "HIGH"
                )
        ) {

            priorityBackground =
                    LIGHT_BURGUNDY;

            priorityText =
                    BURGUNDY;

        } else if (
                priority.equalsIgnoreCase(
                        "MEDIUM"
                )
        ) {

            priorityBackground =
                    GOLD_BG;

            priorityText =
                    GOLD;

        } else {

            priorityBackground =
                    GREEN_BG;

            priorityText =
                    GREEN;
        }

        JLabel priorityLabel =
                new JLabel(
                        priority,
                        SwingConstants.CENTER
                );

        priorityLabel.setPreferredSize(
                new Dimension(
                        82,
                        28
                )
        );

        priorityLabel.setMaximumSize(
                new Dimension(
                        82,
                        28
                )
        );

        priorityLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        priorityLabel.setForeground(
                priorityText
        );

        priorityLabel.setBackground(
                priorityBackground
        );

        priorityLabel.setOpaque(
                true
        );

        JLabel statusLabel =
                new JLabel(
                        task.isCompleted()
                                ? "Completed"
                                : "Not completed"
                );

        statusLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        statusLabel.setForeground(
                task.isCompleted()
                        ? GREEN
                        : SECONDARY_TEXT
        );

        right.add(
                priorityLabel
        );

        right.add(
                Box.createVerticalStrut(
                        3
                )
        );

        right.add(
                statusLabel
        );

        card.add(
                checkbox,
                BorderLayout.WEST
        );

        card.add(
                information,
                BorderLayout.CENTER
        );

        card.add(
                right,
                BorderLayout.EAST
        );


        makeTaskCardClickable(
                card,
                task
        );

        return card;
    }


    private void makeTaskCardClickable(
            JPanel card,
            Task task
    ) {

        card.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        card.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        openChildWindow(
                                new MotivaTaskDetail(
                                        task
                                )
                        );
                    }
                }
        );
    }


    private JPanel createProfile() {

        JPanel profilePanel =
                new JPanel(
                        new BorderLayout(
                                10,
                                0
                        )
                );

        profilePanel.setPreferredSize(
                new Dimension(
                        198,
                        52
                )
        );

        profilePanel.setBackground(
                BACKGROUND
        );

        profilePanel.setBorder(
                new EmptyBorder(
                        8,
                        12,
                        8,
                        12
                )
        );


        Profile profile =
                AppData.profileManager
                        .getProfile();

        String name =
                getProfileName(
                        profile
                );

        String program =
                getProfileProgram(
                        profile
                );

        String yearLevel =
                getProfileYearLevel(
                        profile
                );


        JLabel avatar =
                new JLabel(
                        getInitial(
                                name
                        ),
                        SwingConstants.CENTER
                );

        avatar.setPreferredSize(
                new Dimension(
                        32,
                        32
                )
        );

        avatar.setOpaque(
                true
        );

        avatar.setBackground(
                BURGUNDY
        );

        avatar.setForeground(
                Color.WHITE
        );

        avatar.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        13
                )
        );


        JPanel information =
                new JPanel();

        information.setOpaque(
                false
        );

        information.setLayout(
                new BoxLayout(
                        information,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel student =
                new JLabel(
                        name
                );

        student.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        13
                )
        );

        student.setForeground(
                TEXT
        );

        JLabel programLabel =
                new JLabel(
                        program
                                + " • "
                                + yearLevel
                );

        programLabel.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        10
                )
        );

        programLabel.setForeground(
                SECONDARY_TEXT
        );

        information.add(
                student
        );

        information.add(
                programLabel
        );

        profilePanel.add(
                avatar,
                BorderLayout.WEST
        );

        profilePanel.add(
                information,
                BorderLayout.CENTER
        );

        return profilePanel;
    }


    private String getProfileName(
            Profile profile
    ) {

        if (
                profile == null
                || profile.getName() == null
                || profile.getName().trim().isEmpty()
        ) {

            return "Student";
        }

        return profile.getName().trim();
    }

    private String getProfileProgram(
            Profile profile
    ) {

        if (
                profile == null
                || profile.getProgram() == null
                || profile.getProgram().trim().isEmpty()
        ) {

            return "Program";
        }

        return profile.getProgram().trim();
    }

    private String getProfileYearLevel(
            Profile profile
    ) {

        if (
                profile == null
                || profile.getYearLevel() == null
                || profile.getYearLevel().trim().isEmpty()
        ) {

            return "Year Level";
        }

        return profile.getYearLevel().trim();
    }

    private String getInitial(
            String name
    ) {

        if (
                name == null
                || name.trim().isEmpty()
        ) {

            return "?";
        }

        return name
                .trim()
                .substring(
                        0,
                        1
                )
                .toUpperCase();
    }


    private JPanel createProgressCard() {

        JPanel card =
                createWhiteCard();

        card.setPreferredSize(
                new Dimension(
                        624,
                        156
                )
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        24,
                        18,
                        24
                )
        );

        card.setLayout(
                new BorderLayout()
        );

        int total =
                AppData.taskManager
                        .getTasks()
                        .size();

        int completed = 0;

        for (
                Task task
                : AppData.taskManager.getTasks()
        ) {

            if (
                    task.isCompleted()
            ) {

                completed++;
            }
        }

        int percentage =
                total == 0
                        ? 0
                        : (completed * 100) / total;

        int remaining =
                total - completed;

        JPanel left =
                new JPanel();

        left.setOpaque(false);

        left.setPreferredSize(
                new Dimension(
                        180,
                        110
                )
        );

        left.setLayout(
                new BoxLayout(
                        left,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel label =
                new JLabel(
                        "Today's progress"
                );

        label.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                SECONDARY_TEXT
        );

        JLabel percentageLabel =
                new JLabel(
                        percentage + "%"
                );

        percentageLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        34
                )
        );

        percentageLabel.setForeground(
                BURGUNDY
        );

        JLabel completedLabel =
                new JLabel(
                        completed
                                + " of "
                                + total
                                + " tasks completed"
                );

        completedLabel.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        11
                )
        );

        completedLabel.setForeground(
                SECONDARY_TEXT
        );

        left.add(
                label
        );

        left.add(
                Box.createVerticalStrut(
                        4
                )
        );

        left.add(
                percentageLabel
        );

        left.add(
                completedLabel
        );

        JPanel progressArea =
                new JPanel();

        progressArea.setOpaque(false);

        progressArea.setLayout(
                new BoxLayout(
                        progressArea,
                        BoxLayout.Y_AXIS
                )
        );

        JProgressBar progressBar =
                new JProgressBar();

        progressBar.setValue(
                percentage
        );

        progressBar.setPreferredSize(
                new Dimension(
                        360,
                        12
                )
        );

        progressBar.setMaximumSize(
                new Dimension(
                        360,
                        12
                )
        );

        progressBar.setForeground(
                BURGUNDY
        );

        progressBar.setBackground(
                BORDER
        );

        progressBar.setBorderPainted(
                false
        );

        JLabel message =
                new JLabel(
                        remaining == 0
                                ? "Everything is done. Nice work."
                                : "Keep going — you're getting there."
                );

        message.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        12
                )
        );

        message.setForeground(
                TEXT
        );

        JLabel tasksLeft =
                new JLabel(
                        remaining
                                + " tasks left"
                );

        tasksLeft.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        tasksLeft.setForeground(
                BURGUNDY
        );

        tasksLeft.setOpaque(
                true
        );

        tasksLeft.setBackground(
                LIGHT_BURGUNDY
        );

        tasksLeft.setBorder(
                new EmptyBorder(
                        7,
                        12,
                        7,
                        12
                )
        );

        progressArea.add(
                Box.createVerticalStrut(
                        30
                )
        );

        progressArea.add(
                progressBar
        );

        progressArea.add(
                Box.createVerticalStrut(
                        10
                )
        );

        progressArea.add(
                message
        );

        progressArea.add(
                Box.createVerticalStrut(
                        8
                )
        );

        progressArea.add(
                tasksLeft
        );

        card.add(
                left,
                BorderLayout.WEST
        );

        card.add(
                progressArea,
                BorderLayout.CENTER
        );

        return card;
    }


    private JPanel createDeadlineCard() {

        JPanel card =
                new JPanel();

        card.setPreferredSize(
                new Dimension(
                        336,
                        156
                )
        );

        card.setBackground(
                DEEP_BURGUNDY
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        22,
                        18,
                        22
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "NEXT DEADLINE"
                );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        title.setForeground(
                Color.decode(
                        "#DEBEC2"
                )
        );

        Task nextTask =
                getNextIncompleteTask();

        card.add(
                title
        );

        card.add(
                Box.createVerticalStrut(
                        10
                )
        );

        if (
                nextTask == null
        ) {

            JLabel project =
                    new JLabel(
                            "All caught up!"
                    );

            project.setFont(
                    new Font(
                            "Inter",
                            Font.BOLD,
                            21
                    )
            );

            project.setForeground(
                    Color.WHITE
            );

            JLabel deadline =
                    new JLabel(
                            "No unfinished tasks"
                    );

            deadline.setFont(
                    new Font(
                            "Inter",
                            Font.PLAIN,
                            12
                    )
            );

            deadline.setForeground(
                    Color.decode(
                            "#EBD5D8"
                    )
            );

            card.add(
                    project
            );

            card.add(
                    Box.createVerticalStrut(
                            3
                    )
            );

            card.add(
                    deadline
            );

        } else {

            JLabel project =
                    new JLabel(
                            nextTask.getTitle()
                    );

            project.setFont(
                    new Font(
                            "Inter",
                            Font.BOLD,
                            21
                    )
            );

            project.setForeground(
                    Color.WHITE
            );

            JLabel deadline =
                    new JLabel(
                            "Due "
                                    + nextTask.getDueDate()
                    );

            deadline.setFont(
                    new Font(
                            "Inter",
                            Font.PLAIN,
                            12
                    )
            );

            deadline.setForeground(
                    Color.decode(
                            "#EBD5D8"
                    )
            );

            JLabel priority =
                    new JLabel(
                            nextTask.getPriority()
                                    + " priority"
                    );

            priority.setFont(
                    new Font(
                            "Inter",
                            Font.BOLD,
                            10
                    )
            );

            priority.setForeground(
                    BURGUNDY
            );

            priority.setOpaque(
                    true
            );

            priority.setBackground(
                    LIGHT_BURGUNDY
            );

            priority.setBorder(
                    new EmptyBorder(
                            7,
                            12,
                            7,
                            12
                    )
            );

            card.add(
                    project
            );

            card.add(
                    Box.createVerticalStrut(
                            3
                    )
            );

            card.add(
                    deadline
            );

            card.add(
                    Box.createVerticalStrut(
                            15
                    )
            );

            card.add(
                    priority
            );
        }

        return card;
    }


    private Task getNextIncompleteTask() {

        for (
                Task task
                : AppData.taskManager.getTasks()
        ) {

            if (
                    !task.isCompleted()
            ) {

                return task;
            }
        }

        return null;
    }


    private JPanel createMotivationCard() {

        JPanel card =
                createWhiteCard();

        card.setPreferredSize(
                new Dimension(
                        984,
                        108
                )
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        108
                )
        );

        card.setBorder(
                new EmptyBorder(
                        20,
                        24,
                        20,
                        24
                )
        );

        card.setLayout(
                new BorderLayout()
        );

        JPanel textPanel =
                new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "A calmer day starts with a clear plan."
                );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        17
                )
        );

        title.setForeground(
                BURGUNDY
        );

        JLabel description =
                new JLabel(
                        "Use your schedule to protect study time, personal time, and rest."
                );

        description.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        12
                )
        );

        description.setForeground(
                SECONDARY_TEXT
        );

        textPanel.add(
                title
        );

        textPanel.add(
                Box.createVerticalStrut(
                        8
                )
        );

        textPanel.add(
                description
        );

        JButton schedule =
                new JButton(
                        "View schedule →"
                );

        schedule.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        schedule.setForeground(
                BURGUNDY
        );

        schedule.setBackground(
                LIGHT_BURGUNDY
        );

        schedule.setBorderPainted(
                false
        );

        schedule.setFocusPainted(
                false
        );

        schedule.setBorder(
                new EmptyBorder(
                        7,
                        12,
                        7,
                        12
                )
        );

        schedule.addActionListener(
                e ->
                        MotivaNavigation
                                .goToSchedule(this)
        );

        card.add(
                textPanel,
                BorderLayout.CENTER
        );

        card.add(
                schedule,
                BorderLayout.EAST
        );

        return card;
    }


    private JPanel createWhiteCard() {

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
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        return card;
    }


    private void openAddTask() {

        MotivaAddTask addTask =
                new MotivaAddTask();

        openChildWindow(
                addTask
        );
    }


    private void openChildWindow(
            JFrame childWindow
    ) {

        if (
                childWindow == null
        ) {

            return;
        }

        setVisible(
                false
        );

        childWindow.setLocationRelativeTo(
                this
        );

        childWindow.addWindowListener(
                new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosed(
                            java.awt.event.WindowEvent e
                    ) {

                        refreshDashboard();

                        setLocationRelativeTo(
                                null
                        );

                        setVisible(
                                true
                        );

                        toFront();
                    }
                }
        );

        childWindow.setVisible(
                true
        );

        childWindow.toFront();

        childWindow.requestFocus();
    }


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


    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    try {

                        UIManager.setLookAndFeel(
                                UIManager
                                        .getSystemLookAndFeelClassName()
                        );

                    } catch (
                            Exception ignored
                    ) {
                    }

                    new MotivaDashboard()
                            .setVisible(
                                    true
                            );
                }
        );
    }
}