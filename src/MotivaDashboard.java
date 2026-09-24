package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaDashboard extends JFrame {

    // =========================
    // MOTIVA COLORS
    // =========================
    private static final Color BURGUNDY = Color.decode("#62242F");
    private static final Color DEEP_BURGUNDY = Color.decode("#461921");
    private static final Color BACKGROUND = Color.decode("#FAF7F3");
    private static final Color TEXT = Color.decode("#1F242B");
    private static final Color SECONDARY_TEXT = Color.decode("#676E78");
    private static final Color LIGHT_BURGUNDY = Color.decode("#F4E7E9");
    private static final Color BORDER = Color.decode("#E4E2E0");
    private static final Color GOLD_BG = Color.decode("#FAF1DC");
    private static final Color GOLD = Color.decode("#B57E26");
    private static final Color GREEN_BG = Color.decode("#E8F3EC");
    private static final Color GREEN = Color.decode("#3F7D5A");

    private final Font regular = new Font("Inter", Font.PLAIN, 13);
    private final Font semiBold = new Font("Inter", Font.BOLD, 13);
    private final Font bold = new Font("Inter", Font.BOLD, 20);

    public MotivaDashboard() {
        setTitle("Motiva — Student Motivation System");
        setSize(1280, 800);
        setMinimumSize(new Dimension(1000, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BACKGROUND);

        root.add(createSidebar(), BorderLayout.WEST);
        root.add(createMainContent(), BorderLayout.CENTER);

        setContentPane(root);
    }

    // ============================================================
    // SIDEBAR
    // ============================================================

    private JPanel createSidebar() {

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 800));
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new BorderLayout());

        // Burgundy top line
        JPanel topLine = new JPanel();
        topLine.setBackground(BURGUNDY);
        topLine.setPreferredSize(new Dimension(220, 6));

        sidebar.add(topLine, BorderLayout.NORTH);

        JPanel sidebarContent = new JPanel();
        sidebarContent.setBackground(Color.WHITE);
        sidebarContent.setBorder(new EmptyBorder(22, 16, 16, 16));
        sidebarContent.setLayout(new BorderLayout());

        // -------------------------
        // Logo
        // -------------------------

        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.X_AXIS));

        JLabel logoM = new JLabel("M");
        logoM.setFont(new Font("Inter", Font.BOLD, 24));
        logoM.setForeground(BURGUNDY);

        JPanel logoText = new JPanel();
        logoText.setOpaque(false);
        logoText.setLayout(new BoxLayout(logoText, BoxLayout.Y_AXIS));

        JLabel motiva = new JLabel("MOTIVA");
        motiva.setFont(new Font("Inter", Font.BOLD, 17));
        motiva.setForeground(TEXT);

        JLabel subtitle = new JLabel("Student motivation system");
        subtitle.setFont(new Font("Inter", Font.PLAIN, 10));
        subtitle.setForeground(SECONDARY_TEXT);

        logoText.add(motiva);
        logoText.add(subtitle);

        logoPanel.add(logoM);
        logoPanel.add(Box.createHorizontalStrut(6));
        logoPanel.add(logoText);

        // -------------------------
        // Navigation
        // -------------------------

        JPanel navigation = new JPanel();
        navigation.setOpaque(false);
        navigation.setBorder(new EmptyBorder(30, 0, 0, 0));

        navigation.setLayout(new BoxLayout(navigation, BoxLayout.Y_AXIS));

        navigation.add(createNavButton("Dashboard", true));
        navigation.add(Box.createVerticalStrut(8));

        navigation.add(createNavButton("My Tasks", false));
        navigation.add(Box.createVerticalStrut(8));

        navigation.add(createNavButton("Schedule", false));
        navigation.add(Box.createVerticalStrut(8));

        navigation.add(createNavButton("Rewards", false));
        navigation.add(Box.createVerticalStrut(8));

        navigation.add(createNavButton("Settings", false));

        // -------------------------
        // Today's Note
        // -------------------------

        JPanel note = createTodaysNote();

        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);

        center.add(logoPanel, BorderLayout.NORTH);
        center.add(navigation, BorderLayout.CENTER);

        sidebarContent.add(center, BorderLayout.CENTER);
        sidebarContent.add(note, BorderLayout.SOUTH);

        sidebar.add(sidebarContent, BorderLayout.CENTER);

        return sidebar;
    }

    private JButton createNavButton(String text, boolean active) {

        JButton button = new JButton();

        button.setPreferredSize(new Dimension(188, 44));
        button.setMaximumSize(new Dimension(188, 44));
        button.setMinimumSize(new Dimension(188, 44));

        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.setFont(new Font("Inter", Font.BOLD, 13));

        if (active) {
            button.setBackground(LIGHT_BURGUNDY);
            button.setForeground(BURGUNDY);
        } else {
            button.setBackground(Color.WHITE);
            button.setForeground(SECONDARY_TEXT);
        }

        // Simple square icon matching the Figma design
        button.setText("■    " + text);

        button.setBorder(new EmptyBorder(0, 14, 0, 0));

        return button;
    }

    private JPanel createTodaysNote() {

        JPanel note = new JPanel();
        note.setPreferredSize(new Dimension(188, 126));
        note.setBackground(DEEP_BURGUNDY);
        note.setBorder(new EmptyBorder(14, 16, 12, 16));
        note.setLayout(new BoxLayout(note, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("TODAY'S NOTE");
        title.setFont(new Font("Inter", Font.BOLD, 10));
        title.setForeground(Color.decode("#E1C2C6"));

        JLabel line1 = new JLabel("Small progress is still progress.");
        line1.setFont(new Font("Inter", Font.PLAIN, 11));
        line1.setForeground(Color.WHITE);

        JLabel line2 = new JLabel("Finish one task, then breathe.");
        line2.setFont(new Font("Inter", Font.PLAIN, 11));
        line2.setForeground(Color.WHITE);

        JLabel author = new JLabel("— Motiva");
        author.setFont(new Font("Inter", Font.BOLD, 12));
        author.setForeground(Color.decode("#EBD5D8"));

        note.add(title);
        note.add(Box.createVerticalStrut(8));
        note.add(line1);
        note.add(line2);
        note.add(Box.createVerticalStrut(10));
        note.add(author);

        return note;
    }

    // ============================================================
    // MAIN CONTENT
    // ============================================================

    private JPanel createMainContent() {

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BACKGROUND);
        main.setBorder(new EmptyBorder(28, 32, 28, 44));

        // -------------------------
        // HEADER
        // -------------------------

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setPreferredSize(new Dimension(0, 70));

        JPanel greeting = new JPanel();
        greeting.setOpaque(false);
        greeting.setLayout(new BoxLayout(greeting, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Good morning, Lei");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(TEXT);

        JLabel description = new JLabel(
                "Here’s a simple view of what needs your attention today."
        );
        description.setFont(new Font("Inter", Font.PLAIN, 13));
        description.setForeground(SECONDARY_TEXT);

        greeting.add(title);
        greeting.add(Box.createVerticalStrut(4));
        greeting.add(description);

        JPanel profile = createProfile();

        header.add(greeting, BorderLayout.WEST);
        header.add(profile, BorderLayout.EAST);

        // -------------------------
        // CONTENT
        // -------------------------

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Progress + Deadline
        JPanel summaryRow = new JPanel(new BorderLayout(24, 0));
        summaryRow.setOpaque(false);
        summaryRow.setPreferredSize(new Dimension(0, 156));
        summaryRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 156));

        summaryRow.add(createProgressCard(), BorderLayout.CENTER);
        summaryRow.add(createDeadlineCard(), BorderLayout.EAST);

        // Today's tasks heading
        JPanel tasksHeader = new JPanel(new BorderLayout());
        tasksHeader.setOpaque(false);
        tasksHeader.setBorder(new EmptyBorder(28, 0, 14, 0));

        JPanel taskTitle = new JPanel();
        taskTitle.setOpaque(false);
        taskTitle.setLayout(new BoxLayout(taskTitle, BoxLayout.Y_AXIS));

        JLabel tasks = new JLabel("Today's tasks");
        tasks.setFont(new Font("Inter", Font.BOLD, 20));
        tasks.setForeground(TEXT);

        JLabel taskDescription = new JLabel(
                "Stay focused on what matters first."
        );
        taskDescription.setFont(new Font("Inter", Font.PLAIN, 11));
        taskDescription.setForeground(SECONDARY_TEXT);

        taskTitle.add(tasks);
        taskTitle.add(Box.createVerticalStrut(2));
        taskTitle.add(taskDescription);

        JButton addTask = new JButton("+ Add Task");
        addTask.setPreferredSize(new Dimension(156, 42));
        addTask.setBackground(BURGUNDY);
        addTask.setForeground(Color.WHITE);
        addTask.setFont(new Font("Inter", Font.BOLD, 13));
        addTask.setBorderPainted(false);
        addTask.setFocusPainted(false);

        tasksHeader.add(taskTitle, BorderLayout.WEST);
        tasksHeader.add(addTask, BorderLayout.EAST);

        // Task cards
        JPanel taskList = new JPanel();
        taskList.setOpaque(false);
        taskList.setLayout(new BoxLayout(taskList, BoxLayout.Y_AXIS));

        taskList.add(createTaskCard(
                "Finish Java Project",
                "School • Due today",
                "HIGH",
                "In progress",
                LIGHT_BURGUNDY,
                BURGUNDY
        ));

        taskList.add(Box.createVerticalStrut(12));

        taskList.add(createTaskCard(
                "Review Mathematics",
                "School • Due tomorrow",
                "MEDIUM",
                "Not started",
                GOLD_BG,
                GOLD
        ));

        taskList.add(Box.createVerticalStrut(12));

        taskList.add(createTaskCard(
                "Clean study desk",
                "Personal • 6:00 PM",
                "LOW",
                "Not started",
                GREEN_BG,
                GREEN
        ));

        // Bottom motivational card
        JPanel motivation = createMotivationCard();

        content.add(summaryRow);
        content.add(tasksHeader);
        content.add(taskList);
        content.add(Box.createVerticalStrut(24));
        content.add(motivation);

        main.add(header, BorderLayout.NORTH);
        main.add(content, BorderLayout.CENTER);

        return main;
    }

    // ============================================================
    // PROFILE
    // ============================================================

    private JPanel createProfile() {

        JPanel profile = new JPanel(new BorderLayout(10, 0));
        profile.setPreferredSize(new Dimension(198, 52));
        profile.setBackground(BACKGROUND);
        profile.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel avatar = new JLabel("L", SwingConstants.CENTER);
        avatar.setPreferredSize(new Dimension(32, 32));
        avatar.setOpaque(true);
        avatar.setBackground(BURGUNDY);
        avatar.setForeground(Color.WHITE);
        avatar.setFont(new Font("Inter", Font.BOLD, 13));

        JPanel information = new JPanel();
        information.setOpaque(false);
        information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));

        JLabel student = new JLabel("Student");
        student.setFont(new Font("Inter", Font.BOLD, 13));
        student.setForeground(TEXT);

        JLabel program = new JLabel("BSCpE • 2nd Year");
        program.setFont(new Font("Inter", Font.PLAIN, 10));
        program.setForeground(SECONDARY_TEXT);

        information.add(student);
        information.add(program);

        profile.add(avatar, BorderLayout.WEST);
        profile.add(information, BorderLayout.CENTER);

        return profile;
    }

    // ============================================================
    // PROGRESS CARD
    // ============================================================

    private JPanel createProgressCard() {

        JPanel card = createWhiteCard();

        card.setPreferredSize(new Dimension(624, 156));
        card.setBorder(new EmptyBorder(18, 24, 18, 24));

        card.setLayout(new BorderLayout());

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setPreferredSize(new Dimension(180, 110));
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Today's progress");
        label.setFont(new Font("Inter", Font.BOLD, 14));
        label.setForeground(SECONDARY_TEXT);

        JLabel percentage = new JLabel("63%");
        percentage.setFont(new Font("Inter", Font.BOLD, 34));
        percentage.setForeground(BURGUNDY);

        JLabel completed = new JLabel("5 of 8 tasks completed");
        completed.setFont(new Font("Inter", Font.PLAIN, 11));
        completed.setForeground(SECONDARY_TEXT);

        left.add(label);
        left.add(Box.createVerticalStrut(4));
        left.add(percentage);
        left.add(completed);

        // Progress area
        JPanel progressArea = new JPanel();
        progressArea.setOpaque(false);
        progressArea.setLayout(new BoxLayout(progressArea, BoxLayout.Y_AXIS));

        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(63);
        progressBar.setPreferredSize(new Dimension(360, 12));
        progressBar.setMaximumSize(new Dimension(360, 12));
        progressBar.setForeground(BURGUNDY);
        progressBar.setBackground(Color.decode("#E4E2E0"));
        progressBar.setBorderPainted(false);

        JLabel message = new JLabel(
                "Keep going — you’re halfway there."
        );
        message.setFont(new Font("Inter", Font.BOLD, 12));
        message.setForeground(TEXT);

        JLabel tasksLeft = new JLabel("3 tasks left");
        tasksLeft.setFont(new Font("Inter", Font.BOLD, 10));
        tasksLeft.setForeground(BURGUNDY);
        tasksLeft.setOpaque(true);
        tasksLeft.setBackground(LIGHT_BURGUNDY);
        tasksLeft.setBorder(new EmptyBorder(7, 12, 7, 12));

        progressArea.add(Box.createVerticalStrut(30));
        progressArea.add(progressBar);
        progressArea.add(Box.createVerticalStrut(10));
        progressArea.add(message);
        progressArea.add(Box.createVerticalStrut(8));
        progressArea.add(tasksLeft);

        card.add(left, BorderLayout.WEST);
        card.add(progressArea, BorderLayout.CENTER);

        return card;
    }

    // ============================================================
    // DEADLINE CARD
    // ============================================================

    private JPanel createDeadlineCard() {

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(336, 156));
        card.setBackground(DEEP_BURGUNDY);
        card.setBorder(new EmptyBorder(18, 22, 18, 22));

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("NEXT DEADLINE");
        title.setFont(new Font("Inter", Font.BOLD, 10));
        title.setForeground(Color.decode("#DEBEC2"));

        JLabel project = new JLabel("Java Project");
        project.setFont(new Font("Inter", Font.BOLD, 21));
        project.setForeground(Color.WHITE);

        JLabel deadline = new JLabel("Today • 11:59 PM");
        deadline.setFont(new Font("Inter", Font.PLAIN, 12));
        deadline.setForeground(Color.decode("#EBD5D8"));

        JLabel priority = new JLabel("High priority");
        priority.setFont(new Font("Inter", Font.BOLD, 10));
        priority.setForeground(BURGUNDY);
        priority.setOpaque(true);
        priority.setBackground(LIGHT_BURGUNDY);
        priority.setBorder(new EmptyBorder(7, 12, 7, 12));

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(project);
        card.add(Box.createVerticalStrut(3));
        card.add(deadline);
        card.add(Box.createVerticalStrut(15));
        card.add(priority);

        return card;
    }

    // ============================================================
    // TASK CARD
    // ============================================================

    private JPanel createTaskCard(
            String taskName,
            String taskInfo,
            String priority,
            String status,
            Color priorityBackground,
            Color priorityText
    ) {

        JPanel card = createWhiteCard();

        card.setPreferredSize(new Dimension(984, 72));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 72));
        card.setBorder(new EmptyBorder(10, 15, 10, 15));

        card.setLayout(new BorderLayout(15, 0));

        // Checkbox-like square
        JLabel checkbox = new JLabel();
        checkbox.setPreferredSize(new Dimension(20, 20));
        checkbox.setOpaque(true);
        checkbox.setBackground(BURGUNDY);

        // Task information
        JPanel information = new JPanel();
        information.setOpaque(false);
        information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));

        JLabel name = new JLabel(taskName);
        name.setFont(new Font("Inter", Font.BOLD, 14));
        name.setForeground(TEXT);

        JLabel details = new JLabel(taskInfo);
        details.setFont(new Font("Inter", Font.PLAIN, 11));
        details.setForeground(SECONDARY_TEXT);

        information.add(name);
        information.add(Box.createVerticalStrut(3));
        information.add(details);

        // Right side
        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setPreferredSize(new Dimension(130, 50));
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JLabel priorityLabel = new JLabel(priority, SwingConstants.CENTER);
        priorityLabel.setPreferredSize(new Dimension(82, 28));
        priorityLabel.setMaximumSize(new Dimension(82, 28));
        priorityLabel.setFont(new Font("Inter", Font.BOLD, 10));
        priorityLabel.setForeground(priorityText);
        priorityLabel.setBackground(priorityBackground);
        priorityLabel.setOpaque(true);

        JLabel statusLabel = new JLabel(status);
        statusLabel.setFont(new Font("Inter", Font.BOLD, 10));
        statusLabel.setForeground(SECONDARY_TEXT);

        right.add(priorityLabel);
        right.add(Box.createVerticalStrut(3));
        right.add(statusLabel);

        card.add(checkbox, BorderLayout.WEST);
        card.add(information, BorderLayout.CENTER);
        card.add(right, BorderLayout.EAST);

        return card;
    }

    // ============================================================
    // MOTIVATIONAL CARD
    // ============================================================

    private JPanel createMotivationCard() {

        JPanel card = createWhiteCard();

        card.setPreferredSize(new Dimension(984, 108));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 108));
        card.setBorder(new EmptyBorder(20, 24, 20, 24));

        card.setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(
                "A calmer day starts with a clear plan."
        );
        title.setFont(new Font("Inter", Font.BOLD, 17));
        title.setForeground(BURGUNDY);

        JLabel description = new JLabel(
                "Use your schedule to protect study time, personal time, and rest."
        );
        description.setFont(new Font("Inter", Font.PLAIN, 12));
        description.setForeground(SECONDARY_TEXT);

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(8));
        textPanel.add(description);

        JLabel schedule = new JLabel(
                "View schedule →",
                SwingConstants.CENTER
        );

        schedule.setFont(new Font("Inter", Font.BOLD, 10));
        schedule.setForeground(BURGUNDY);
        schedule.setBackground(LIGHT_BURGUNDY);
        schedule.setOpaque(true);
        schedule.setBorder(new EmptyBorder(7, 12, 7, 12));

        card.add(textPanel, BorderLayout.CENTER);
        card.add(schedule, BorderLayout.EAST);

        return card;
    }

    // ============================================================
    // CARD HELPER
    // ============================================================

    private JPanel createWhiteCard() {

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(10, 10, 10, 10)
                )
        );

        return card;
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception ignored) {
            }

            MotivaDashboard dashboard = new MotivaDashboard();
            dashboard.setVisible(true);
        });
    }
}
