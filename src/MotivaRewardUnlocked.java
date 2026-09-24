package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaRewardUnlocked extends JFrame {

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
            new Font("Inter", Font.BOLD, 32);

    private static final Font FONT_REWARD =
            new Font("Inter", Font.BOLD, 24);

    private static final Font FONT_SMALL =
            new Font("Inter", Font.PLAIN, 12);


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public MotivaRewardUnlocked() {

        setTitle("Motiva — Reward Unlocked");

        setSize(1280, 800);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        JPanel root =
                new JPanel(new BorderLayout());

        root.setBackground(BACKGROUND);

        // Sidebar
        root.add(
                createSidebar(),
                BorderLayout.WEST
        );

        // Main content
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
                        true
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "My Tasks",
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

        avatar.setBackground(
                Color.WHITE
        );

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
        // TOP PROFILE
        // =========================

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        header.add(
                createTopProfile(),
                BorderLayout.EAST
        );


        main.add(
                header,
                BorderLayout.NORTH
        );


        // =========================
        // CENTER
        // =========================

        JPanel center =
                new JPanel();

        center.setOpaque(false);

        center.setLayout(
                new BoxLayout(
                        center,
                        BoxLayout.Y_AXIS
                )
        );


        // Push content toward center
        center.add(
                Box.createVerticalGlue()
        );


        // =========================
        // CELEBRATION ICON
        // =========================

        JLabel celebration =
                new JLabel("★");

        celebration.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        celebration.setVerticalAlignment(
                SwingConstants.CENTER
        );

        celebration.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        42
                )
        );

        celebration.setForeground(
                GOLD
        );

        celebration.setBackground(
                new Color(
                        0xF9,
                        0xF2,
                        0xE5
                )
        );

        celebration.setOpaque(true);

        celebration.setPreferredSize(
                new Dimension(90, 90)
        );

        celebration.setMaximumSize(
                new Dimension(90, 90)
        );

        celebration.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        center.add(celebration);


        center.add(
                Box.createVerticalStrut(25)
        );


        // =========================
        // TITLE
        // =========================

        JLabel title =
                new JLabel(
                        "Reward Unlocked!"
                );

        title.setFont(
                FONT_TITLE
        );

        title.setForeground(
                BURGUNDY
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        center.add(title);


        center.add(
                Box.createVerticalStrut(8)
        );


        // =========================
        // DESCRIPTION
        // =========================

        JLabel description =
                new JLabel(
                        "Nice work! You completed your task."
                );

        description.setFont(FONT);

        description.setForeground(
                SECONDARY_TEXT
        );

        description.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        center.add(description);


        center.add(
                Box.createVerticalStrut(28)
        );


        // =========================
        // REWARD CARD
        // =========================

        JPanel rewardCard =
                new JPanel();

        rewardCard.setBackground(
                Color.WHITE
        );

        rewardCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                25,
                                55,
                                25,
                                55
                        )
                )
        );

        rewardCard.setLayout(
                new BoxLayout(
                        rewardCard,
                        BoxLayout.Y_AXIS
                )
        );

        rewardCard.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel rewardLabel =
                new JLabel(
                        "YOUR REWARD"
                );

        rewardLabel.setFont(
                FONT_SMALL
        );

        rewardLabel.setForeground(
                SECONDARY_TEXT
        );

        rewardLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        rewardCard.add(rewardLabel);


        rewardCard.add(
                Box.createVerticalStrut(10)
        );


        // Temporary static reward
        JLabel food =
                new JLabel(
                        "🍗  Chickenjoy"
                );

        food.setFont(
                FONT_REWARD
        );

        food.setForeground(
                TEXT
        );

        food.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        rewardCard.add(food);


        rewardCard.add(
                Box.createVerticalStrut(8)
        );


        JLabel rewardDescription =
                new JLabel(
                        "Enjoy your well-earned reward!"
                );

        rewardDescription.setFont(
                FONT_SMALL
        );

        rewardDescription.setForeground(
                SECONDARY_TEXT
        );

        rewardDescription.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        rewardCard.add(
                rewardDescription
        );


        center.add(rewardCard);


        center.add(
                Box.createVerticalStrut(28)
        );


        // =========================
        // BACK BUTTON
        // =========================

        JButton back =
                new JButton(
                        "Back to Dashboard"
                );

        back.setFont(FONT_BOLD);

        back.setForeground(
                Color.WHITE
        );

        back.setBackground(
                BURGUNDY
        );

        back.setFocusPainted(false);

        back.setBorderPainted(false);

        back.setOpaque(true);

        back.setBorder(
                new EmptyBorder(
                        12,
                        25,
                        12,
                        25
                )
        );

        back.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        center.add(back);


        center.add(
                Box.createVerticalGlue()
        );


        main.add(
                center,
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

        avatar.setForeground(
                Color.WHITE
        );

        avatar.setBackground(
                BURGUNDY
        );

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
    // MAIN
    // ============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            MotivaRewardUnlocked app =
                    new MotivaRewardUnlocked();

            app.setVisible(true);
        });
    }
}
