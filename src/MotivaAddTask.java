package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaAddTask extends JFrame {

    // =========================
    // MOTIVA COLORS
    // =========================
    private static final Color BURGUNDY = new Color(0x62, 0x24, 0x2F);
    private static final Color DEEP_BURGUNDY = new Color(0x46, 0x19, 0x21);
    private static final Color BACKGROUND = new Color(0xFA, 0xF7, 0xF3);
    private static final Color TEXT = new Color(0x1F, 0x24, 0x2B);
    private static final Color SECONDARY_TEXT = new Color(0x67, 0x6E, 0x78);
    private static final Color LIGHT_BURGUNDY = new Color(0xF4, 0xE7, 0xE9);
    private static final Color BORDER = new Color(0xE4, 0xE2, 0xE0);
    private static final Color GOLD = new Color(0xC7, 0xA1, 0x5A);
    private static final Color GREEN = new Color(0x3F, 0x7D, 0x5A);

    private static final Font FONT =
            new Font("Inter", Font.PLAIN, 14);

    private static final Font FONT_BOLD =
            new Font("Inter", Font.BOLD, 14);

    private static final Font FONT_TITLE =
            new Font("Inter", Font.BOLD, 28);

    private static final Font FONT_SMALL =
            new Font("Inter", Font.PLAIN, 12);

    public MotivaAddTask() {

        setTitle("Motiva — Add Task");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BACKGROUND);

        // Sidebar
        root.add(createSidebar(), BorderLayout.WEST);

        // Main content
        root.add(createMainContent(), BorderLayout.CENTER);

        setContentPane(root);
    }

    // ============================================================
    // SIDEBAR
    // ============================================================

    private JPanel createSidebar() {

        JPanel sidebar = new JPanel();

        sidebar.setPreferredSize(
                new Dimension(240, 800)
        );

        sidebar.setBackground(BURGUNDY);

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(28, 20, 25, 20)
        );

        // Logo
        JLabel logo = new JLabel("Motiva");

        logo.setFont(
                new Font("Inter", Font.BOLD, 25)
        );

        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle =
                new JLabel("Student Motivation System");

        subtitle.setFont(
                new Font("Inter", Font.PLAIN, 11)
        );

        subtitle.setForeground(
                new Color(235, 220, 222)
        );

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(3));
        sidebar.add(subtitle);

        sidebar.add(
                Box.createVerticalStrut(40)
        );

        // Navigation
        sidebar.add(
                createNavButton("Dashboard", false)
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        // My Tasks is active because Add Task belongs to tasks
        sidebar.add(
                createNavButton("My Tasks", true)
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton("Schedule", false)
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton("Rewards", false)
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton("Settings", false)
        );

        sidebar.add(Box.createVerticalGlue());

        // Today's Note
        JPanel note = new JPanel();

        note.setLayout(
                new BoxLayout(
                        note,
                        BoxLayout.Y_AXIS
                )
        );

        note.setBackground(DEEP_BURGUNDY);

        note.setBorder(
                new EmptyBorder(
                        16, 15, 16, 15
                )
        );

        note.setMaximumSize(
                new Dimension(200, 115)
        );

        note.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel noteTitle =
                new JLabel("Today's Note");

        noteTitle.setFont(FONT_BOLD);
        noteTitle.setForeground(Color.WHITE);

        JLabel noteText = new JLabel(
                "<html>Small progress is still<br>" +
                "progress. Keep going.</html>"
        );

        noteText.setFont(FONT_SMALL);

        noteText.setForeground(
                new Color(235, 220, 222)
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

        // Profile
        JPanel profile =
                new JPanel(
                        new BorderLayout(10, 0)
                );

        profile.setOpaque(false);

        profile.setMaximumSize(
                new Dimension(200, 45)
        );

        profile.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel avatar = new JLabel("L");

        avatar.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        avatar.setVerticalAlignment(
                SwingConstants.CENTER
        );

        avatar.setFont(
                new Font("Inter", Font.BOLD, 14)
        );

        avatar.setForeground(BURGUNDY);
        avatar.setBackground(Color.WHITE);
        avatar.setOpaque(true);

        avatar.setPreferredSize(
                new Dimension(38, 38)
        );

        JPanel profileText = new JPanel();

        profileText.setOpaque(false);

        profileText.setLayout(
                new BoxLayout(
                        profileText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel name = new JLabel("Lei");

        name.setFont(FONT_BOLD);
        name.setForeground(Color.WHITE);

        JLabel program =
                new JLabel("BSCpE Student");

        program.setFont(FONT_SMALL);

        program.setForeground(
                new Color(235, 220, 222)
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

        sidebar.add(profile);

        return sidebar;
    }

    // ============================================================
    // NAV BUTTON
    // ============================================================

    private JButton createNavButton(
            String text,
            boolean active
    ) {

        JButton button =
                new JButton(text);

        button.setFont(FONT_BOLD);

        button.setForeground(Color.WHITE);

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
                        12, 15, 12, 15
                )
        );

        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);

        button.setMaximumSize(
                new Dimension(200, 45)
        );

        return button;
    }

    // ============================================================
    // MAIN CONTENT
    // ============================================================

    private JPanel createMainContent() {

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(BACKGROUND);

        main.setBorder(
                new EmptyBorder(
                        35, 40, 35, 40
                )
        );

        // =========================
        // HEADER
        // =========================

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
                new JLabel("Add Task");

        title.setFont(FONT_TITLE);
        title.setForeground(TEXT);

        JLabel description =
                new JLabel(
                        "Add something you want to accomplish."
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

        // Profile
        header.add(
                createTopProfile(),
                BorderLayout.EAST
        );

        main.add(
                header,
                BorderLayout.NORTH
        );

        // =========================
        // FORM
        // =========================

        JPanel formWrapper =
                new JPanel();

        formWrapper.setOpaque(false);

        formWrapper.setLayout(
                new BorderLayout()
        );

        formWrapper.setBorder(
                new EmptyBorder(
                        30, 80, 0, 80
                )
        );

        JPanel formCard =
                new JPanel();

        formCard.setBackground(Color.WHITE);

        formCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                28, 32, 28, 32
                        )
                )
        );

        formCard.setLayout(
                new BoxLayout(
                        formCard,
                        BoxLayout.Y_AXIS
                )
        );

        // Task name
        formCard.add(
                createLabel("Task name")
        );

        JTextField taskName =
                new JTextField();

        styleTextField(taskName);

        formCard.add(taskName);

        formCard.add(
                Box.createVerticalStrut(18)
        );

        // Description
        formCard.add(
                createLabel("Description")
        );

        JTextArea description1 =
                new JTextArea(4, 20);

        description1.setLineWrap(true);
        description1.setWrapStyleWord(true);

        description1.setFont(FONT);
        description1.setForeground(TEXT);

        description1.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10, 12, 10, 12
                        )
                )
        );

        JScrollPane descriptionScroll =
                new JScrollPane(description1);

        descriptionScroll.setBorder(null);

        formCard.add(
                descriptionScroll
        );

        formCard.add(
                Box.createVerticalStrut(18)
        );

        // Category + Priority
        JPanel row1 =
                new JPanel(
                        new GridLayout(
                                1, 2, 18, 0
                        )
                );

        row1.setOpaque(false);

        // Category
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

        categoryPanel.add(category);

        // Priority
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

        priorityPanel.add(priority);

        row1.add(categoryPanel);
        row1.add(priorityPanel);

        formCard.add(row1);

        formCard.add(
                Box.createVerticalStrut(18)
        );

        // Due date + Time
        JPanel row2 =
                new JPanel(
                        new GridLayout(
                                1, 2, 18, 0
                        )
                );

        row2.setOpaque(false);

        JPanel datePanel =
                createFormFieldPanel(
                        "Due date"
                );

        JTextField dueDate =
                new JTextField(
                        "September 24, 2026"
                );

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

        // Schedule toggle
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

        scheduleTitle.setFont(FONT_BOLD);
        scheduleTitle.setForeground(TEXT);

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

        scheduleText.add(scheduleTitle);

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

        // Buttons
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
                new JButton("Cancel");

        styleSecondaryButton(cancel);

        JButton save =
                new JButton("Save Task");

        stylePrimaryButton(save);

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

    // ============================================================
    // TOP PROFILE
    // ============================================================

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

        JLabel avatar =
                new JLabel("L");

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

        avatar.setForeground(Color.WHITE);
        avatar.setBackground(BURGUNDY);
        avatar.setOpaque(true);

        avatar.setPreferredSize(
                new Dimension(38, 38)
        );

        JLabel name =
                new JLabel("Lei");

        name.setFont(FONT_BOLD);
        name.setForeground(TEXT);

        profile.add(avatar);

        profile.add(
                Box.createHorizontalStrut(10)
        );

        profile.add(name);

        return profile;
    }

    // ============================================================
    // FORM LABEL
    // ============================================================

    private JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(FONT_BOLD);
        label.setForeground(TEXT);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        label.setBorder(
                new EmptyBorder(
                        0, 0, 7, 0
                )
        );

        return label;
    }

    // ============================================================
    // FORM FIELD PANEL
    // ============================================================

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

        JLabel label =
                createLabel(labelText);

        panel.add(label);

        return panel;
    }

    // ============================================================
    // TEXT FIELD STYLE
    // ============================================================

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
                                10, 12, 10, 12
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

    // ============================================================
    // COMBO BOX STYLE
    // ============================================================

    private void styleComboBox(
            JComboBox<String> comboBox
    ) {

        comboBox.setFont(FONT);
        comboBox.setForeground(TEXT);
        comboBox.setBackground(Color.WHITE);

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

    // ============================================================
    // PRIMARY BUTTON
    // ============================================================

    private void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(FONT_BOLD);
        button.setForeground(Color.WHITE);
        button.setBackground(BURGUNDY);

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        button.setBorder(
                new EmptyBorder(
                        11, 22, 11, 22
                )
        );
    }

    // ============================================================
    // SECONDARY BUTTON
    // ============================================================

    private void styleSecondaryButton(
            JButton button
    ) {

        button.setFont(FONT_BOLD);
        button.setForeground(TEXT);
        button.setBackground(Color.WHITE);

        button.setFocusPainted(false);
        button.setOpaque(true);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10, 21, 10, 21
                        )
                )
        );
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MotivaAddTask app =
                    new MotivaAddTask();

            app.setVisible(true);
        });
    }
}