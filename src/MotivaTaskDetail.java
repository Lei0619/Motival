package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaTaskDetail extends JFrame {

    // =========================
    // MOTIVA COLORS
    // =========================

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

    private static final Color LIGHT_BURGUNDY =
            new Color(0xF4, 0xE7, 0xE9);

    private static final Color BORDER =
            new Color(0xE4, 0xE2, 0xE0);

    private static final Color GOLD =
            new Color(0xC7, 0xA1, 0x5A);

    private static final Color GREEN =
            new Color(0x3F, 0x7D, 0x5A);


    // =========================
    // FONTS
    // =========================

    private static final Font FONT =
            new Font("Inter", Font.PLAIN, 14);

    private static final Font FONT_BOLD =
            new Font("Inter", Font.BOLD, 14);

    private static final Font FONT_TITLE =
            new Font("Inter", Font.BOLD, 30);

    private static final Font FONT_SMALL =
            new Font("Inter", Font.PLAIN, 12);


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public MotivaTaskDetail() {

        setTitle("Motiva — Task Detail");

        setSize(1280, 800);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        JPanel root =
                new JPanel(new BorderLayout());

        root.setBackground(BACKGROUND);

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


    // ============================================================
    // SIDEBAR
    // ============================================================

    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel();

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
                new EmptyBorder(
                        28, 20, 25, 20
                )
        );


        // =========================
        // LOGO
        // =========================

        JLabel logo =
                new JLabel("Motiva");

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        25
                )
        );

        logo.setForeground(Color.WHITE);

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
                new Color(235, 220, 222)
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


        // =========================
        // NAVIGATION
        // =========================

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


        // =========================
        // TODAY'S NOTE
        // =========================

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
                new JLabel(
                        "Today's Note"
                );

        noteTitle.setFont(FONT_BOLD);

        noteTitle.setForeground(
                Color.WHITE
        );


        JLabel noteText =
                new JLabel(
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


        // =========================
        // PROFILE
        // =========================

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

        avatar.setForeground(BURGUNDY);

        avatar.setBackground(Color.WHITE);

        avatar.setOpaque(true);

        avatar.setPreferredSize(
                new Dimension(38, 38)
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
                new JLabel("Lei");

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

        main.setBackground(
                BACKGROUND
        );

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
                new JLabel(
                        "Task Detail"
                );

        title.setFont(FONT_TITLE);

        title.setForeground(TEXT);


        JLabel description =
                new JLabel(
                        "Review the details of your task."
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


        // =========================
        // CONTENT
        // =========================

        JPanel contentWrapper =
                new JPanel(
                        new GridBagLayout()
                );

        contentWrapper.setOpaque(false);

        contentWrapper.setBorder(
                new EmptyBorder(
                        30, 70, 0, 70
                )
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
                                30,
                                35,
                                30,
                                35
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );


        // =========================
        // CATEGORY + PRIORITY
        // =========================

        JPanel badges =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0
                        )
                );

        badges.setOpaque(false);


        JLabel category =
                new JLabel(
                        "SCHOOL"
                );

        category.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        11
                )
        );

        category.setForeground(
                BURGUNDY
        );

        category.setBackground(
                LIGHT_BURGUNDY
        );

        category.setOpaque(true);

        category.setBorder(
                new EmptyBorder(
                        6, 10, 6, 10
                )
        );


        JLabel priority =
                new JLabel(
                        "HIGH PRIORITY"
                );

        priority.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        11
                )
        );

        priority.setForeground(
                Color.WHITE
        );

        priority.setBackground(
                BURGUNDY
        );

        priority.setOpaque(true);

        priority.setBorder(
                new EmptyBorder(
                        6, 10, 6, 10
                )
        );


        badges.add(category);

        badges.add(
                Box.createHorizontalStrut(8)
        );

        badges.add(priority);


        card.add(badges);


        card.add(
                Box.createVerticalStrut(18)
        );


        // =========================
        // TASK TITLE
        // =========================

        JLabel taskTitle =
                new JLabel(
                        "Finish Java Project"
                );

        taskTitle.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        26
                )
        );

        taskTitle.setForeground(TEXT);


        card.add(taskTitle);


        card.add(
                Box.createVerticalStrut(12)
        );


        // =========================
        // DUE DATE
        // =========================

        JLabel dueDate =
                new JLabel(
                        "Due today • September 24, 2026 • 10:00 AM"
                );

        dueDate.setFont(FONT);

        dueDate.setForeground(
                SECONDARY_TEXT
        );


        card.add(dueDate);


        card.add(
                Box.createVerticalStrut(25)
        );


        // =========================
        // DIVIDER
        // =========================

        JSeparator separator =
                new JSeparator();

        separator.setForeground(
                BORDER
        );

        separator.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        1
                )
        );


        card.add(separator);


        card.add(
                Box.createVerticalStrut(25)
        );


        // =========================
        // DESCRIPTION LABEL
        // =========================

        JLabel descriptionLabel =
                new JLabel(
                        "Description"
                );

        descriptionLabel.setFont(
                FONT_BOLD
        );

        descriptionLabel.setForeground(TEXT);


        card.add(descriptionLabel);


        card.add(
                Box.createVerticalStrut(8)
        );


        JLabel taskDescription =
                new JLabel(
                        "<html>" +
                        "Complete the remaining features of the Java project, " +
                        "review the code, and make sure the application is ready " +
                        "for submission." +
                        "</html>"
                );

        taskDescription.setFont(FONT);

        taskDescription.setForeground(
                SECONDARY_TEXT
        );


        card.add(taskDescription);


        card.add(
                Box.createVerticalStrut(25)
        );


        // =========================
        // STATUS
        // =========================

        JLabel statusLabel =
                new JLabel(
                        "Status"
                );

        statusLabel.setFont(FONT_BOLD);

        statusLabel.setForeground(TEXT);


        card.add(statusLabel);


        card.add(
                Box.createVerticalStrut(8)
        );


        JLabel status =
                new JLabel(
                        "●  In progress"
                );

        status.setFont(FONT_BOLD);

        status.setForeground(
                GOLD
        );


        card.add(status);


        card.add(
                Box.createVerticalStrut(28)
        );


        // =========================
        // BUTTONS
        // =========================

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttons.setOpaque(false);


        JButton edit =
                new JButton(
                        "Edit Task"
                );

        styleSecondaryButton(edit);


        JButton complete =
                new JButton(
                        "Mark as Complete"
                );

        stylePrimaryButton(complete);


        buttons.add(edit);

        buttons.add(complete);


        card.add(buttons);


        contentWrapper.add(card);


        main.add(
                contentWrapper,
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
    // PRIMARY BUTTON
    // ============================================================

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
                        20,
                        11,
                        20
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
                                19,
                                10,
                                19
                        )
                )
        );
    }


    // ============================================================
    // MAIN
    // ============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            MotivaTaskDetail app =
                    new MotivaTaskDetail();

            app.setVisible(true);
        });
    }
}
