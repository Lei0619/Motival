import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

import model.Schedule;
import service.AppData;

/** Shows the student's scheduled tasks and events. */
public class MotivaSchedule extends JFrame {

    private static final Color BURGUNDY = new Color(0x62, 0x24, 0x2F);
    private static final Color DEEP_BURGUNDY = new Color(0x46, 0x19, 0x21);
    private static final Color BACKGROUND = new Color(0xFA, 0xF7, 0xF3);
    private static final Color TEXT = new Color(0x1F, 0x24, 0x2B);
    private static final Color SECONDARY_TEXT = new Color(0x67, 0x6E, 0x78);
    private static final Color LIGHT_BURGUNDY = new Color(0xF2, 0xE7, 0xE9);
    private static final Color BORDER = new Color(0xE4, 0xE2, 0xE0);
    private static final Color GREEN = new Color(0x3F, 0x7D, 0x5A);

    private static final DateTimeFormatter MONTH_FORMAT =
            DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US);
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.US);
    private static final DateTimeFormatter[] INPUT_DATE_FORMATS = {
            DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US),
            DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US),
            DateTimeFormatter.ofPattern("M/d/yyyy", Locale.US),
            DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US),
            DateTimeFormatter.ISO_LOCAL_DATE
    };

    private LocalDate visibleMonth = LocalDate.now().withDayOfMonth(1);
    private LocalDate selectedDate = LocalDate.now();
    private boolean showAllSchedules;
    private JLabel monthLabel;
    private JLabel selectedDateLabel;
    private JPanel calendarPanel;
    private JPanel scheduleListPanel;

    public MotivaSchedule() {
        setTitle("Motiva — Schedule");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BACKGROUND);
        root.add(createSidebar(), BorderLayout.WEST);
        root.add(createMainContent(), BorderLayout.CENTER);
        setContentPane(root);
        refreshView();
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 800));
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(24, 16, 18, 16));

        JPanel topLine = new JPanel();
        topLine.setBackground(BURGUNDY);
        topLine.setMaximumSize(new Dimension(Integer.MAX_VALUE, 6));
        sidebar.add(topLine);
        sidebar.add(Box.createVerticalStrut(20));

        JLabel logo = new JLabel("MOTIVA");
        logo.setFont(new Font("Inter", Font.BOLD, 20));
        logo.setForeground(TEXT);
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(logo);

        JLabel tagline = new JLabel("Student motivation system");
        tagline.setFont(new Font("Inter", Font.PLAIN, 10));
        tagline.setForeground(SECONDARY_TEXT);
        tagline.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(tagline);
        sidebar.add(Box.createVerticalStrut(32));

        sidebar.add(createNavButton("Dashboard", false));
        sidebar.add(Box.createVerticalStrut(8));
        sidebar.add(createNavButton("My Tasks", false));
        sidebar.add(Box.createVerticalStrut(8));
        sidebar.add(createNavButton("Schedule", true));
        sidebar.add(Box.createVerticalStrut(8));
        sidebar.add(createNavButton("Rewards", false));
        sidebar.add(Box.createVerticalStrut(8));
        sidebar.add(createNavButton("Settings", false));
        sidebar.add(Box.createVerticalGlue());

        JPanel note = new JPanel();
        note.setLayout(new BoxLayout(note, BoxLayout.Y_AXIS));
        note.setBackground(DEEP_BURGUNDY);
        note.setBorder(new EmptyBorder(14, 14, 14, 14));
        note.setAlignmentX(Component.LEFT_ALIGNMENT);
        note.setMaximumSize(new Dimension(188, 112));

        JLabel noteTitle = new JLabel("TODAY'S NOTE");
        noteTitle.setFont(new Font("Inter", Font.BOLD, 10));
        noteTitle.setForeground(new Color(0xE1, 0xC2, 0xC6));
        note.add(noteTitle);
        note.add(Box.createVerticalStrut(8));

        JLabel noteText = new JLabel(
                "<html>Small progress is still progress.<br>Finish one task, then breathe.</html>"
        );
        noteText.setFont(new Font("Inter", Font.PLAIN, 12));
        noteText.setForeground(Color.WHITE);
        note.add(noteText);
        sidebar.add(note);
        return sidebar;
    }

    private JButton createNavButton(String text, boolean active) {
        JButton button = new JButton(text);
        button.setFont(new Font("Inter", Font.BOLD, 13));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setMaximumSize(new Dimension(188, 44));
        button.setPreferredSize(new Dimension(188, 44));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setBackground(active ? LIGHT_BURGUNDY : Color.WHITE);
        button.setForeground(active ? BURGUNDY : SECONDARY_TEXT);
        button.addActionListener(event -> {
            switch (text) {
                case "Dashboard":
                case "My Tasks":
                    MotivaNavigation.goToDashboard(this);
                    break;
                case "Schedule":
                    MotivaNavigation.goToSchedule(this);
                    break;
                case "Rewards":
                    MotivaNavigation.goToRewards(this);
                    break;
                case "Settings":
                    MotivaNavigation.goToSettings(this);
                    break;
                default:
                    break;
            }
        });
        return button;
    }

    private JPanel createMainContent() {
        JPanel main = new JPanel(new BorderLayout(0, 16));
        main.setBackground(BACKGROUND);
        main.setBorder(new EmptyBorder(28, 32, 24, 32));

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);

        JLabel title = new JLabel("Schedule");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(TEXT);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        top.add(title);

        JLabel subtitle = new JLabel("Balance school, personal plans, and recovery time.");
        subtitle.setFont(new Font("Inter", Font.PLAIN, 13));
        subtitle.setForeground(SECONDARY_TEXT);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        top.add(Box.createVerticalStrut(4));
        top.add(subtitle);
        top.add(Box.createVerticalStrut(20));
        top.add(createToolbar());
        main.add(top, BorderLayout.NORTH);

        JPanel body = new JPanel(new BorderLayout(0, 14));
        body.setOpaque(false);
        body.add(createCalendar(), BorderLayout.NORTH);
        body.add(createScheduleList(), BorderLayout.CENTER);
        main.add(body, BorderLayout.CENTER);
        return main;
    }

    private JPanel createToolbar() {
        JPanel toolbar = new JPanel(new BorderLayout());
        toolbar.setBackground(Color.WHITE);
        toolbar.setBorder(new EmptyBorder(10, 12, 10, 12));

        JPanel monthControls = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        monthControls.setOpaque(false);

        JButton previous = createSmallButton("‹");
        previous.setToolTipText("Previous month");
        previous.addActionListener(event -> changeMonth(-1));
        JButton next = createSmallButton("›");
        next.setToolTipText("Next month");
        next.addActionListener(event -> changeMonth(1));

        monthLabel = new JLabel();
        monthLabel.setFont(new Font("Inter", Font.BOLD, 15));
        monthLabel.setForeground(TEXT);
        monthLabel.setPreferredSize(new Dimension(150, 30));
        monthControls.add(previous);
        monthControls.add(monthLabel);
        monthControls.add(next);
        toolbar.add(monthControls, BorderLayout.WEST);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        actions.setOpaque(false);
        JButton today = createSmallButton("Today");
        today.addActionListener(event -> {
            visibleMonth = LocalDate.now().withDayOfMonth(1);
            selectedDate = LocalDate.now();
            showAllSchedules = false;
            refreshView();
        });
        JButton showAll = createSmallButton("Show All");
        showAll.addActionListener(event -> {
            selectedDate = null;
            showAllSchedules = true;
            refreshView();
        });
        JButton add = new JButton("+ Add Schedule");
        add.setFont(new Font("Inter", Font.BOLD, 12));
        add.setForeground(Color.WHITE);
        add.setBackground(BURGUNDY);
        add.setFocusPainted(false);
        add.setBorderPainted(false);
        add.setOpaque(true);
        add.addActionListener(event -> openAddSchedule());
        actions.add(today);
        actions.add(showAll);
        actions.add(add);
        toolbar.add(actions, BorderLayout.EAST);
        return toolbar;
    }

    private JPanel createCalendar() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(Color.WHITE);
        container.setBorder(new EmptyBorder(12, 14, 12, 14));
        calendarPanel = new JPanel(new GridLayout(0, 7, 4, 4));
        calendarPanel.setOpaque(false);
        container.add(calendarPanel, BorderLayout.CENTER);
        return container;
    }

    private JPanel createScheduleList() {
        JPanel wrapper = new JPanel(new BorderLayout(0, 8));
        wrapper.setOpaque(false);

        selectedDateLabel = new JLabel();
        selectedDateLabel.setFont(new Font("Inter", Font.BOLD, 16));
        selectedDateLabel.setForeground(TEXT);
        wrapper.add(selectedDateLabel, BorderLayout.NORTH);

        scheduleListPanel = new JPanel();
        scheduleListPanel.setLayout(new BoxLayout(scheduleListPanel, BoxLayout.Y_AXIS));
        scheduleListPanel.setOpaque(false);
        JScrollPane listScroll = new JScrollPane(scheduleListPanel);
        listScroll.setBorder(null);
        listScroll.getVerticalScrollBar().setUnitIncrement(14);
        wrapper.add(listScroll, BorderLayout.CENTER);
        return wrapper;
    }

    private JButton createSmallButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Inter", Font.BOLD, 12));
        button.setForeground(TEXT);
        button.setBackground(BACKGROUND);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(BORDER));
        button.setPreferredSize(new Dimension(text.length() < 3 ? 34 : 82, 30));
        return button;
    }

    private void changeMonth(int amount) {
        visibleMonth = visibleMonth.plusMonths(amount);
        if (selectedDate != null) {
            selectedDate = visibleMonth;
            showAllSchedules = false;
        }
        refreshView();
    }

    private void refreshView() {
        refreshCalendar();
        monthLabel.setText(visibleMonth.format(MONTH_FORMAT));
        selectedDateLabel.setText(showAllSchedules
                ? "All scheduled items"
                : selectedDate.format(DATE_FORMAT));
        refreshScheduleList();
    }

    private void refreshCalendar() {
        calendarPanel.removeAll();
        String[] weekdays = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (String weekday : weekdays) {
            JLabel label = new JLabel(weekday, SwingConstants.CENTER);
            label.setFont(new Font("Inter", Font.BOLD, 10));
            label.setForeground(SECONDARY_TEXT);
            calendarPanel.add(label);
        }

        LocalDate firstOfMonth = visibleMonth.withDayOfMonth(1);
        LocalDate firstDisplayedDate = firstOfMonth.minusDays(firstOfMonth.getDayOfWeek().getValue() - 1L);
        for (int index = 0; index < 42; index++) {
            calendarPanel.add(createDateButton(firstDisplayedDate.plusDays(index)));
        }
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private JButton createDateButton(LocalDate date) {
        int count = countSchedulesOn(date);
        String label = count == 0
                ? Integer.toString(date.getDayOfMonth())
                : "<html><center>" + date.getDayOfMonth() + "<br><font size='2'>" + count + " item(s)</font></center></html>";
        JButton button = new JButton(label);
        button.setFont(new Font("Inter", Font.PLAIN, 12));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(BORDER));
        button.setBackground(date.equals(selectedDate) ? BURGUNDY : Color.WHITE);
        button.setForeground(date.equals(selectedDate)
                ? Color.WHITE
                : date.getMonth() == visibleMonth.getMonth() ? TEXT : SECONDARY_TEXT);
        button.addActionListener(event -> {
            selectedDate = date;
            visibleMonth = date.withDayOfMonth(1);
            showAllSchedules = false;
            refreshView();
        });
        return button;
    }

    private int countSchedulesOn(LocalDate date) {
        int count = 0;
        for (Schedule schedule : AppData.scheduleManager.getSchedules()) {
            if (date.equals(parseDate(schedule.getDate()))) {
                count++;
            }
        }
        return count;
    }

    private void refreshScheduleList() {
        scheduleListPanel.removeAll();
        ArrayList<Schedule> schedules = new ArrayList<>(AppData.scheduleManager.getSchedules());
        int displayed = 0;
        for (Schedule schedule : schedules) {
            LocalDate scheduleDate = parseDate(schedule.getDate());
            if (!showAllSchedules && !selectedDate.equals(scheduleDate)) {
                continue;
            }
            scheduleListPanel.add(createScheduleRow(schedule));
            scheduleListPanel.add(Box.createVerticalStrut(8));
            displayed++;
        }
        if (displayed == 0) {
            JLabel empty = new JLabel(showAllSchedules
                    ? "No schedules yet."
                    : "Nothing scheduled for this day.");
            empty.setFont(new Font("Inter", Font.PLAIN, 13));
            empty.setForeground(SECONDARY_TEXT);
            empty.setBorder(new EmptyBorder(12, 4, 12, 4));
            scheduleListPanel.add(empty);
        }
        scheduleListPanel.revalidate();
        scheduleListPanel.repaint();
    }

    private JPanel createScheduleRow(Schedule schedule) {
        JPanel row = new JPanel(new BorderLayout(12, 0));
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(10, 10, 10, 10)
        ));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 76));

        JPanel accent = new JPanel();
        accent.setBackground(schedule.isEvent() ? GREEN : BURGUNDY);
        accent.setPreferredSize(new Dimension(5, 48));
        row.add(accent, BorderLayout.WEST);

        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setOpaque(false);
        JLabel title = new JLabel(schedule.getTitle() == null
                ? "Untitled schedule"
                : schedule.getTitle());
        title.setFont(new Font("Inter", Font.BOLD, 13));
        title.setForeground(TEXT);
        JLabel meta = new JLabel(scheduleMeta(schedule));
        meta.setFont(new Font("Inter", Font.PLAIN, 11));
        meta.setForeground(SECONDARY_TEXT);
        details.add(title);
        details.add(Box.createVerticalStrut(4));
        details.add(meta);
        row.add(details, BorderLayout.CENTER);

        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Inter", Font.BOLD, 11));
        delete.setForeground(BURGUNDY);
        delete.setFocusPainted(false);
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.addActionListener(event -> deleteSchedule(schedule));
        row.add(delete, BorderLayout.EAST);
        return row;
    }

    private String scheduleMeta(Schedule schedule) {
        String category = safe(schedule.getCategory());
        String type = schedule.isEvent() ? "Event" : "Task";
        String time = safe(schedule.getTime());
        if (showAllSchedules) {
            LocalDate date = parseDate(schedule.getDate());
            String dateText = date == null
                    ? safe(schedule.getDate())
                    : date.format(DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US));
            return type + "  ·  " + category + "  ·  " + dateText + "  ·  " + time;
        }
        return type + "  ·  " + category + "  ·  " + time;
    }

    private void deleteSchedule(Schedule schedule) {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Delete \"" + schedule.getTitle() + "\" from your schedule?",
                "Delete Schedule",
                JOptionPane.YES_NO_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            AppData.scheduleManager.deleteSchedule(schedule.getId());
            refreshView();
        }
    }

    private void openAddSchedule() {
        MotivaAddSchedule window = new MotivaAddSchedule();
        window.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent event) {
                refreshView();
            }
        });
        window.setLocationRelativeTo(this);
        window.setVisible(true);
    }

    private LocalDate parseDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        String trimmed = value.trim();
        for (DateTimeFormatter formatter : INPUT_DATE_FORMATS) {
            try {
                return LocalDate.parse(trimmed, formatter);
            } catch (DateTimeParseException ignored) {
                continue;
            }
        }
        return null;
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MotivaSchedule().setVisible(true));
    }
}