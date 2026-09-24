package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaSchedule extends JFrame {

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
    private static final Color GOLD = Color.decode("#C7A15A");
    private static final Color GREEN = Color.decode("#3F7D5A");

    public MotivaSchedule() {

        setTitle("Motiva — Schedule");
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
        // HEADER
        // =========================

        JLabel title = new JLabel("Schedule");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(TEXT);
        title.setBounds(252, 34, 650, 38);
        root.add(title);

        JLabel subtitle = new JLabel(
                "Balance school, personal plans, and recovery time."
        );
        subtitle.setFont(new Font("Inter", Font.PLAIN, 13));
        subtitle.setForeground(SECONDARY_TEXT);
        subtitle.setBounds(252, 72, 700, 25);
        root.add(subtitle);

        // =========================
        // PROFILE
        // =========================

        createProfile(root);

        // =========================
        // WEEK SELECTOR
        // =========================

        JPanel weekBar = new JPanel(null);
        weekBar.setBackground(Color.WHITE);
        weekBar.setBounds(252, 112, 984, 76);
        weekBar.setBorder(
                BorderFactory.createLineBorder(
                        Color.WHITE,
                        1
                )
        );
        root.add(weekBar);

        createDay(weekBar, "MON 21", 12, false);
        createDay(weekBar, "TUE 22", 148, false);
        createDay(weekBar, "WED 23", 284, false);
        createDay(weekBar, "THU 24", 420, true);
        createDay(weekBar, "FRI 25", 556, false);
        createDay(weekBar, "SAT 26", 692, false);
        createDay(weekBar, "SUN 27", 828, false);

        // =========================
        // DATE TITLE
        // =========================

        JLabel dateTitle =
                new JLabel("Thursday, September 24");

        dateTitle.setFont(
                new Font("Inter", Font.BOLD, 19)
        );

        dateTitle.setForeground(TEXT);
        dateTitle.setBounds(252, 218, 360, 28);
        root.add(dateTitle);

        JLabel dateSubtitle =
                new JLabel("Your plan for today");

        dateSubtitle.setFont(
                new Font("Inter", Font.PLAIN, 11)
        );

        dateSubtitle.setForeground(SECONDARY_TEXT);
        dateSubtitle.setBounds(252, 247, 300, 24);
        root.add(dateSubtitle);

        // =========================
        // TIME GRID
        // =========================

        createTimeRow(root, "8:00 AM", 288, 305);
        createTimeRow(root, "10:00 AM", 362, 379);
        createTimeRow(root, "12:00 PM", 436, 453);
        createTimeRow(root, "2:00 PM", 510, 527);
        createTimeRow(root, "4:00 PM", 584, 601);
        createTimeRow(root, "6:00 PM", 658, 675);

        // =========================
        // SCHEDULE EVENTS
        // =========================

        createScheduleEvent(
                root,
                278,
                "BSCpE Lecture",
                "School",
                "8:00 AM",
                BURGUNDY
        );

        createScheduleEvent(
                root,
                352,
                "Finish Java Project",
                "School • High priority",
                "10:00 AM",
                DEEP_BURGUNDY
        );

        createScheduleEvent(
                root,
                426,
                "Lunch / Rest",
                "Personal",
                "12:00 PM",
                GREEN
        );

        createScheduleEvent(
                root,
                500,
                "Math Review",
                "School",
                "2:00 PM",
                GOLD
        );

        createScheduleEvent(
                root,
                574,
                "Free time",
                "Personal",
                "4:00 PM",
                GREEN
        );

        createScheduleEvent(
                root,
                648,
                "Prepare for tomorrow",
                "School",
                "6:00 PM",
                BURGUNDY
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

        // Top burgundy line
        JPanel topLine = new JPanel();
        topLine.setBackground(BURGUNDY);
        topLine.setBounds(0, 0, 220, 6);
        sidebar.add(topLine);

        // Logo
        JLabel logoM = new JLabel("M");
        logoM.setFont(
                new Font("Inter", Font.BOLD, 24)
        );
        logoM.setForeground(BURGUNDY);
        logoM.setBounds(24, 25, 34, 35);
        sidebar.add(logoM);

        JLabel logo = new JLabel("MOTIVA");
        logo.setFont(
                new Font("Inter", Font.BOLD, 17)
        );
        logo.setForeground(TEXT);
        logo.setBounds(64, 28, 130, 25);
        sidebar.add(logo);

        JLabel logoSub =
                new JLabel("Student motivation system");

        logoSub.setFont(
                new Font("Inter", Font.PLAIN, 10)
        );
        logoSub.setForeground(SECONDARY_TEXT);
        logoSub.setBounds(64, 49, 140, 25);
        sidebar.add(logoSub);

        // Navigation
        createNavButton(
                sidebar,
                "Dashboard",
                100,
                false
        );

        createNavButton(
                sidebar,
                "My Tasks",
                152,
                false
        );

        createNavButton(
                sidebar,
                "Schedule",
                204,
                true
        );

        createNavButton(
                sidebar,
                "Rewards",
                256,
                false
        );

        createNavButton(
                sidebar,
                "Settings",
                308,
                false
        );

        // =========================
        // TODAY'S NOTE
        // =========================

        JPanel note = new JPanel(null);
        note.setBackground(DEEP_BURGUNDY);
        note.setBounds(16, 640, 188, 126);
        sidebar.add(note);

        JLabel noteTitle =
                new JLabel("TODAY'S NOTE");

        noteTitle.setFont(
                new Font("Inter", Font.BOLD, 10)
        );
        noteTitle.setForeground(
                Color.decode("#E1C2C6")
        );
        noteTitle.setBounds(16, 16, 150, 20);
        note.add(noteTitle);

        JLabel noteText = new JLabel(
                "<html>" +
                "Small progress is still progress.<br>" +
                "Finish one task, then breathe." +
                "</html>"
        );

        noteText.setFont(
                new Font("Inter", Font.PLAIN, 13)
        );
        noteText.setForeground(Color.WHITE);
        noteText.setBounds(16, 39, 154, 45);
        note.add(noteText);

        JLabel motiva =
                new JLabel("— Motiva");

        motiva.setFont(
                new Font("Inter", Font.BOLD, 14)
        );
        motiva.setForeground(
                Color.decode("#EBD5D8")
        );
        motiva.setBounds(16, 91, 150, 24);
        note.add(motiva);
    }

    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private void createNavButton(
            JPanel sidebar,
            String text,
            int y,
            boolean active
    ) {

        JButton button = new JButton(text);

        button.setBounds(16, y, 188, 44);

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFont(
                new Font("Inter", Font.BOLD, 13)
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

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

        button.setIcon(
                new ColorIcon(
                        active
                                ? BURGUNDY
                                : SECONDARY_TEXT,
                        18,
                        18
                )
        );

        button.setIconTextGap(12);

        sidebar.add(button);
    }

    // =========================================================
    // PROFILE
    // =========================================================

    private void createProfile(JPanel root) {

        JPanel profile = new JPanel(null);
        profile.setBackground(BACKGROUND);
        profile.setBounds(
                1038,
                24,
                198,
                52
        );

        root.add(profile);

        JLabel avatar =
                new JLabel("L", SwingConstants.CENTER);

        avatar.setOpaque(true);
        avatar.setBackground(BURGUNDY);
        avatar.setForeground(Color.WHITE);

        avatar.setFont(
                new Font("Inter", Font.BOLD, 13)
        );

        avatar.setBounds(12, 10, 32, 32);

        profile.add(avatar);

        JLabel name =
                new JLabel("Student");

        name.setFont(
                new Font("Inter", Font.BOLD, 13)
        );

        name.setForeground(TEXT);
        name.setBounds(56, 8, 110, 24);

        profile.add(name);

        JLabel course =
                new JLabel("BSCpE • 2nd Year");

        course.setFont(
                new Font("Inter", Font.PLAIN, 10)
        );

        course.setForeground(
                SECONDARY_TEXT
        );

        course.setBounds(56, 27, 125, 24);

        profile.add(course);
    }

    // =========================================================
    // DAY BUTTON
    // =========================================================

    private void createDay(
            JPanel parent,
            String text,
            int x,
            boolean active
    ) {

        JPanel day = new JPanel(null);

        day.setBounds(
                x,
                10,
                124,
                56
        );

        day.setBackground(
                active
                        ? BURGUNDY
                        : BACKGROUND
        );

        parent.add(day);

        JLabel label =
                new JLabel(
                        text,
                        SwingConstants.CENTER
                );

        label.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(
                active
                        ? Color.WHITE
                        : SECONDARY_TEXT
        );

        label.setBounds(
                0,
                active ? 8 : 12,
                124,
                24
        );

        day.add(label);

        if (active) {

            JLabel today =
                    new JLabel(
                            "Today",
                            SwingConstants.CENTER
                    );

            today.setFont(
                    new Font(
                            "Inter",
                            Font.PLAIN,
                            9
                    )
            );

            today.setForeground(
                    Color.decode("#EBD5D8")
            );

            today.setBounds(
                    0,
                    29,
                    124,
                    20
            );

            day.add(today);
        }
    }

    // =========================================================
    // TIME ROW
    // =========================================================

    private void createTimeRow(
            JPanel root,
            String time,
            int labelY,
            int lineY
    ) {

        JLabel timeLabel =
                new JLabel(time);

        timeLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        timeLabel.setForeground(
                SECONDARY_TEXT
        );

        timeLabel.setBounds(
                252,
                labelY,
                80,
                24
        );

        root.add(timeLabel);

        JPanel line = new JPanel();

        line.setBackground(BORDER);

        line.setBounds(
                340,
                lineY,
                896,
                1
        );

        root.add(line);
    }

    // =========================================================
    // SCHEDULE EVENT
    // =========================================================

    private void createScheduleEvent(
            JPanel root,
            int y,
            String title,
            String category,
            String time,
            Color accent
    ) {

        JPanel event = new JPanel(null);

        event.setBackground(Color.WHITE);

        event.setBounds(
                360,
                y,
                420,
                54
        );

        event.setBorder(
                BorderFactory.createLineBorder(
                        Color.WHITE,
                        1
                )
        );

        root.add(event);

        // Accent bar
        JPanel accentBar = new JPanel();

        accentBar.setBackground(accent);

        accentBar.setBounds(
                0,
                0,
                6,
                54
        );

        event.add(accentBar);

        // Event title
        JLabel eventTitle =
                new JLabel(title);

        eventTitle.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        12
                )
        );

        eventTitle.setForeground(TEXT);

        eventTitle.setBounds(
                18,
                7,
                260,
                24
        );

        event.add(eventTitle);

        // Category
        JLabel categoryLabel =
                new JLabel(category);

        categoryLabel.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        10
                )
        );

        categoryLabel.setForeground(
                SECONDARY_TEXT
        );

        categoryLabel.setBounds(
                18,
                29,
                250,
                20
        );

        event.add(categoryLabel);

        // Time
        JLabel timeLabel =
                new JLabel(time);

        timeLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        10
                )
        );

        timeLabel.setForeground(
                SECONDARY_TEXT
        );

        timeLabel.setBounds(
                310,
                17,
                90,
                20
        );

        event.add(timeLabel);
    }

    // =========================================================
    // SIMPLE ICON
    // =========================================================

    private static class ColorIcon
            implements Icon {

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

            MotivaSchedule app =
                    new MotivaSchedule();

            app.setVisible(true);
        });
    }
}