package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaMyTasks extends JFrame {

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

    private static final Font INTER_BOLD =
            new Font("Inter", Font.BOLD, 14);

    private static final Font INTER_SEMIBOLD =
            new Font("Inter", Font.BOLD, 13);

    private static final Font INTER_REGULAR =
            new Font("Inter", Font.PLAIN, 13);

    public MotivaMyTasks() {

        setTitle("Motiva — My Tasks");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(null);
        root.setBackground(BACKGROUND);
        setContentPane(root);

        // =========================
        // SIDEBAR
        // =========================
        createSidebar(root);

        // =========================
        // PAGE TITLE
        // =========================
        JLabel title = new JLabel("My Tasks");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(TEXT);
        title.setBounds(252, 30, 650, 40);
        root.add(title);

        JLabel subtitle = new JLabel(
                "Organize school responsibilities and personal activities in one place."
        );
        subtitle.setFont(new Font("Inter", Font.PLAIN, 13));
        subtitle.setForeground(SECONDARY_TEXT);
        subtitle.setBounds(252, 68, 700, 25);
        root.add(subtitle);

        // =========================
        // PROFILE
        // =========================
        createProfile(root);

        // =========================
        // FILTER BUTTONS
        // =========================
        createFilter(root, "All", 252, true);
        createFilter(root, "School", 360, false);
        createFilter(root, "Personal", 468, false);
        createFilter(root, "Completed", 576, false);

        // =========================
        // ADD TASK
        // =========================
        JButton addTask = new JButton("+ Add Task");
        styleButton(addTask, BURGUNDY, Color.WHITE);
        addTask.setBounds(1080, 104, 156, 42);
        root.add(addTask);

        // =========================
        // TASK COUNT
        // =========================
        JLabel count = new JLabel("8 total tasks");
        count.setFont(new Font("Inter", Font.BOLD, 12));
        count.setForeground(SECONDARY_TEXT);
        count.setBounds(252, 160, 200, 25);
        root.add(count);

        // =========================
        // TASK CARDS
        // =========================

        createTaskCard(
                root,
                190,
                "Finish Java Project",
                "School • Due today",
                "HIGH",
                "In progress",
                BURGUNDY,
                LIGHT_BURGUNDY,
                BURGUNDY,
                false
        );

        createTaskCard(
                root,
                274,
                "Review Mathematics",
                "School • Due tomorrow",
                "MEDIUM",
                "Not started",
                BURGUNDY,
                GOLD_BG,
                GOLD,
                false
        );

        createTaskCard(
                root,
                358,
                "Research for BSCpE project",
                "School • Sep 28",
                "HIGH",
                "Not started",
                BURGUNDY,
                LIGHT_BURGUNDY,
                BURGUNDY,
                false
        );

        createTaskCard(
                root,
                442,
                "Clean study desk",
                "Personal • Today",
                "LOW",
                "Not started",
                BURGUNDY,
                GREEN_BG,
                GREEN,
                false
        );

        createTaskCard(
                root,
                526,
                "Watch lecture recording",
                "School • Sep 29",
                "MEDIUM",
                "Completed",
                GREEN,
                GOLD_BG,
                GOLD,
                true
        );

        createTaskCard(
                root,
                610,
                "Buy school supplies",
                "Personal • Sep 30",
                "LOW",
                "Completed",
                GREEN,
                GREEN_BG,
                GREEN,
                true
        );
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private void createSidebar(JPanel root) {

        JPanel sidebar = new JPanel(null);
        sidebar.setBackground(Color.WHITE);
        sidebar.setBounds(0, 0, 220, 800);
        root.add(sidebar);

        // Burgundy top line
        JPanel topLine = new JPanel();
        topLine.setBackground(BURGUNDY);
        topLine.setBounds(0, 0, 220, 6);
        sidebar.add(topLine);

        // Logo
        JLabel logoM = new JLabel("M");
        logoM.setFont(new Font("Inter", Font.BOLD, 24));
        logoM.setForeground(BURGUNDY);
        logoM.setBounds(24, 25, 34, 35);
        sidebar.add(logoM);

        JLabel logo = new JLabel("MOTIVA");
        logo.setFont(new Font("Inter", Font.BOLD, 17));
        logo.setForeground(TEXT);
        logo.setBounds(64, 28, 130, 25);
        sidebar.add(logo);

        JLabel logoSub = new JLabel("Student motivation system");
        logoSub.setFont(new Font("Inter", Font.PLAIN, 10));
        logoSub.setForeground(SECONDARY_TEXT);
        logoSub.setBounds(64, 49, 140, 25);
        sidebar.add(logoSub);

        // Navigation
        createNavButton(sidebar, "Dashboard", 100, false);
        createNavButton(sidebar, "My Tasks", 152, true);
        createNavButton(sidebar, "Schedule", 204, false);
        createNavButton(sidebar, "Rewards", 256, false);
        createNavButton(sidebar, "Settings", 308, false);

        // Today's Note
        JPanel note = new JPanel(null);
        note.setBackground(DEEP_BURGUNDY);
        note.setBounds(16, 640, 188, 126);
        note.setBorder(new EmptyBorder(10, 10, 10, 10));
        sidebar.add(note);

        JLabel noteTitle = new JLabel("TODAY'S NOTE");
        noteTitle.setFont(new Font("Inter", Font.BOLD, 10));
        noteTitle.setForeground(Color.decode("#E1C2C6"));
        noteTitle.setBounds(16, 13, 150, 20);
        note.add(noteTitle);

        JLabel noteText = new JLabel(
                "<html>Small progress is still progress.<br>" +
                "Finish one task, then breathe.</html>"
        );
        noteText.setFont(new Font("Inter", Font.PLAIN, 13));
        noteText.setForeground(Color.WHITE);
        noteText.setBounds(16, 37, 155, 45);
        note.add(noteText);

        JLabel motiva = new JLabel("— Motiva");
        motiva.setFont(new Font("Inter", Font.BOLD, 14));
        motiva.setForeground(Color.decode("#EBD5D8"));
        motiva.setBounds(16, 90, 150, 25);
        note.add(motiva);
    }

    private void createNavButton(
            JPanel sidebar,
            String text,
            int y,
            boolean active
    ) {

        JButton button = new JButton(text);
        button.setBounds(16, y, 188, 44);
        button.setFont(new Font("Inter", Font.BOLD, 13));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);

        if (active) {
            button.setBackground(LIGHT_BURGUNDY);
            button.setForeground(BURGUNDY);
        } else {
            button.setBackground(Color.WHITE);
            button.setForeground(SECONDARY_TEXT);
        }

        // Small icon placeholder
        button.setIcon(new ColorIcon(
                active ? BURGUNDY : SECONDARY_TEXT,
                18,
                18
        ));

        button.setIconTextGap(12);

        sidebar.add(button);
    }

    // =========================================================
    // PROFILE
    // =========================================================

    private void createProfile(JPanel root) {

        JPanel profile = new JPanel(null);
        profile.setBackground(BACKGROUND);
        profile.setBounds(1038, 24, 198, 52);
        root.add(profile);

        JLabel avatar = new JLabel("L", SwingConstants.CENTER);
        avatar.setOpaque(true);
        avatar.setBackground(BURGUNDY);
        avatar.setForeground(Color.WHITE);
        avatar.setFont(new Font("Inter", Font.BOLD, 13));
        avatar.setBounds(12, 10, 32, 32);
        profile.add(avatar);

        JLabel name = new JLabel("Student");
        name.setFont(new Font("Inter", Font.BOLD, 13));
        name.setForeground(TEXT);
        name.setBounds(56, 5, 110, 24);
        profile.add(name);

        JLabel course = new JLabel("BSCpE • 2nd Year");
        course.setFont(new Font("Inter", Font.PLAIN, 10));
        course.setForeground(SECONDARY_TEXT);
        course.setBounds(56, 25, 125, 24);
        profile.add(course);
    }

    // =========================================================
    // FILTER
    // =========================================================

    private void createFilter(
            JPanel root,
            String text,
            int x,
            boolean active
    ) {

        JButton filter = new JButton(text);
        filter.setBounds(x, 112, 92, 28);

        filter.setFont(new Font("Inter", Font.BOLD, 10));
        filter.setFocusPainted(false);
        filter.setBorderPainted(false);
        filter.setOpaque(true);

        if (active) {
            filter.setBackground(BURGUNDY);
            filter.setForeground(Color.WHITE);
        } else {
            filter.setBackground(BACKGROUND);
            filter.setForeground(SECONDARY_TEXT);
        }

        root.add(filter);
    }

    // =========================================================
    // TASK CARD
    // =========================================================

    private void createTaskCard(
            JPanel root,
            int y,
            String taskName,
            String details,
            String priority,
            String status,
            Color checkColor,
            Color priorityBackground,
            Color priorityText,
            boolean completed
    ) {

        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(
                BorderFactory.createLineBorder(BORDER, 1)
        );
        card.setBounds(252, y, 984, 72);
        root.add(card);

        // Checkbox
        JLabel checkbox = new JLabel(
                completed ? "✓" : "",
                SwingConstants.CENTER
        );

        checkbox.setOpaque(true);
        checkbox.setBackground(checkColor);
        checkbox.setForeground(Color.WHITE);

        checkbox.setFont(new Font("Inter", Font.BOLD, 12));

        checkbox.setBounds(15, 24, 20, 20);

        card.add(checkbox);

        // Task name
        JLabel name = new JLabel(taskName);
        name.setFont(new Font("Inter", Font.BOLD, 14));
        name.setForeground(TEXT);
        name.setBounds(51, 8, 794, 24);
        card.add(name);

        // Details
        JLabel detail = new JLabel(details);
        detail.setFont(new Font("Inter", Font.PLAIN, 11));
        detail.setForeground(SECONDARY_TEXT);
        detail.setBounds(51, 34, 794, 24);
        card.add(detail);

        // Priority
        JLabel priorityLabel = new JLabel(
                priority,
                SwingConstants.CENTER
        );

        priorityLabel.setOpaque(true);
        priorityLabel.setBackground(priorityBackground);
        priorityLabel.setForeground(priorityText);

        priorityLabel.setFont(
                new Font("Inter", Font.BOLD, 10)
        );

        priorityLabel.setBounds(871, 9, 82, 28);

        card.add(priorityLabel);

        // Status
        JLabel statusLabel = new JLabel(
                status,
                SwingConstants.RIGHT
        );

        statusLabel.setFont(
                new Font("Inter", Font.BOLD, 10)
        );

        statusLabel.setForeground(
                completed ? GREEN : SECONDARY_TEXT
        );

        statusLabel.setBounds(800, 37, 159, 20);

        card.add(statusLabel);
    }

    // =========================================================
    // BUTTON STYLE
    // =========================================================

    private void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {

        button.setBackground(background);
        button.setForeground(foreground);

        button.setFont(
                new Font("Inter", Font.BOLD, 13)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }

    // =========================================================
    // SIMPLE ICON
    // =========================================================

    private static class ColorIcon implements Icon {

        private final Color color;
        private final int width;
        private final int height;

        public ColorIcon(
                Color color,
                int width,
                int height
        ) {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        @Override
        public void paintIcon(
                Component c,
                Graphics g,
                int x,
                int y
        ) {

            g.setColor(color);

            g.fillRoundRect(
                    x,
                    y,
                    width,
                    height,
                    5,
                    5
            );
        }

        @Override
        public int getIconWidth() {
            return width;
        }

        @Override
        public int getIconHeight() {
            return height;
        }
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MotivaMyTasks app = new MotivaMyTasks();

            app.setVisible(true);
        });
    }
}