package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaSettings extends JFrame {

    // =========================
    // COLORS
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

    // =========================
    // FONT
    // =========================
    private Font font(float size, int style) {
        return new Font("Inter", style, (int) size);
    }

    public MotivaSettings() {

        setTitle("Motiva - Settings");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(240, 800));
        sidebar.setBackground(BURGUNDY);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(28, 20, 24, 20));

        JLabel logo = new JLabel("Motiva");
        logo.setForeground(Color.WHITE);
        logo.setFont(font(26, Font.BOLD));
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel tagline = new JLabel("Student Motivation System");
        tagline.setForeground(new Color(235, 215, 218));
        tagline.setFont(font(11, Font.PLAIN));
        tagline.setAlignmentX(Component.LEFT_ALIGNMENT);

        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(4));
        sidebar.add(tagline);

        sidebar.add(Box.createVerticalStrut(38));

        sidebar.add(createNavButton("⌂   Dashboard", false));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("✓   My Tasks", false));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("▣   Schedule", false));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("★   Rewards", false));
        sidebar.add(Box.createVerticalStrut(8));

        // Settings ACTIVE
        sidebar.add(createNavButton("⚙   Settings", true));

        sidebar.add(Box.createVerticalGlue());

        // Today's Note
        JPanel note = new JPanel();
        note.setLayout(new BoxLayout(note, BoxLayout.Y_AXIS));
        note.setBackground(DEEP_BURGUNDY);
        note.setBorder(new EmptyBorder(14, 14, 14, 14));
        note.setMaximumSize(new Dimension(200, 100));
        note.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel noteTitle = new JLabel("TODAY'S NOTE");
        noteTitle.setForeground(GOLD);
        noteTitle.setFont(font(10, Font.BOLD));

        JLabel noteText = new JLabel(
                "<html>Small progress is still<br>progress.</html>"
        );
        noteText.setForeground(Color.WHITE);
        noteText.setFont(font(12, Font.PLAIN));

        note.add(noteTitle);
        note.add(Box.createVerticalStrut(7));
        note.add(noteText);

        sidebar.add(note);
        sidebar.add(Box.createVerticalStrut(20));

        JLabel student = new JLabel("Lei • BSCpE");
        student.setForeground(Color.WHITE);
        student.setFont(font(12, Font.BOLD));
        student.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel year = new JLabel("2nd Year Student");
        year.setForeground(new Color(220, 200, 204));
        year.setFont(font(11, Font.PLAIN));
        year.setAlignmentX(Component.LEFT_ALIGNMENT);

        sidebar.add(student);
        sidebar.add(Box.createVerticalStrut(3));
        sidebar.add(year);

        add(sidebar, BorderLayout.WEST);

        // =====================================================
        // MAIN AREA
        // =====================================================

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BACKGROUND);
        main.setBorder(new EmptyBorder(38, 45, 38, 45));

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(
                new BoxLayout(titlePanel, BoxLayout.Y_AXIS)
        );

        JLabel title = new JLabel("Settings");
        title.setFont(font(28, Font.BOLD));
        title.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Manage your profile and Motiva preferences."
        );
        subtitle.setFont(font(14, Font.PLAIN));
        subtitle.setForeground(SECONDARY_TEXT);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(7));
        titlePanel.add(subtitle);

        header.add(titlePanel, BorderLayout.WEST);

        // Profile
        JPanel profile = new JPanel(
                new FlowLayout(FlowLayout.RIGHT, 10, 0)
        );
        profile.setOpaque(false);

        JPanel avatar = new JPanel(new GridBagLayout());
        avatar.setPreferredSize(new Dimension(42, 42));
        avatar.setBackground(LIGHT_BURGUNDY);

        JLabel avatarText = new JLabel("L");
        avatarText.setFont(font(16, Font.BOLD));
        avatarText.setForeground(BURGUNDY);

        avatar.add(avatarText);

        JPanel profileText = new JPanel();
        profileText.setOpaque(false);
        profileText.setLayout(
                new BoxLayout(profileText, BoxLayout.Y_AXIS)
        );

        JLabel name = new JLabel("Lei");
        name.setFont(font(13, Font.BOLD));
        name.setForeground(TEXT);

        JLabel program = new JLabel("BSCpE • 2nd Year");
        program.setFont(font(11, Font.PLAIN));
        program.setForeground(SECONDARY_TEXT);

        profileText.add(name);
        profileText.add(program);

        profile.add(avatar);
        profile.add(profileText);

        header.add(profile, BorderLayout.EAST);

        main.add(header, BorderLayout.NORTH);

        // =====================================================
        // SETTINGS CONTENT
        // =====================================================

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(new EmptyBorder(28, 0, 0, 0));

        // -----------------------------------------------------
        // PROFILE CARD
        // -----------------------------------------------------

        JPanel profileCard = createWhiteCard();

        JLabel profileTitle = new JLabel("Profile");
        profileTitle.setFont(font(18, Font.BOLD));
        profileTitle.setForeground(TEXT);

        JLabel profileDescription = new JLabel(
                "Your student information."
        );
        profileDescription.setFont(font(12, Font.PLAIN));
        profileDescription.setForeground(SECONDARY_TEXT);

        profileCard.add(profileTitle);
        profileCard.add(Box.createVerticalStrut(5));
        profileCard.add(profileDescription);
        profileCard.add(Box.createVerticalStrut(18));

        JPanel profileRow = new JPanel(new BorderLayout());
        profileRow.setOpaque(false);

        JPanel userInfo = new JPanel();
        userInfo.setOpaque(false);
        userInfo.setLayout(
                new BoxLayout(userInfo, BoxLayout.Y_AXIS)
        );

        JLabel userName = new JLabel("Lei");
        userName.setFont(font(14, Font.BOLD));
        userName.setForeground(TEXT);

        JLabel userDetails = new JLabel(
                "BSCpE • 2nd Year"
        );
        userDetails.setFont(font(12, Font.PLAIN));
        userDetails.setForeground(SECONDARY_TEXT);

        userInfo.add(userName);
        userInfo.add(Box.createVerticalStrut(4));
        userInfo.add(userDetails);

        JButton editProfile = new JButton("Edit Profile");
        editProfile.setFont(font(12, Font.BOLD));
        editProfile.setForeground(BURGUNDY);
        editProfile.setBackground(Color.WHITE);
        editProfile.setFocusPainted(false);
        editProfile.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BURGUNDY),
                        new EmptyBorder(8, 16, 8, 16)
                )
        );

        profileRow.add(userInfo, BorderLayout.WEST);
        profileRow.add(editProfile, BorderLayout.EAST);

        profileCard.add(profileRow);

        content.add(profileCard);
        content.add(Box.createVerticalStrut(18));

        // -----------------------------------------------------
        // PREFERENCES CARD
        // -----------------------------------------------------

        JPanel preferencesCard = createWhiteCard();

        JLabel preferencesTitle = new JLabel("Preferences");
        preferencesTitle.setFont(font(18, Font.BOLD));
        preferencesTitle.setForeground(TEXT);

        JLabel preferencesDescription = new JLabel(
                "Customize how Motiva behaves for you."
        );
        preferencesDescription.setFont(font(12, Font.PLAIN));
        preferencesDescription.setForeground(SECONDARY_TEXT);

        preferencesCard.add(preferencesTitle);
        preferencesCard.add(Box.createVerticalStrut(5));
        preferencesCard.add(preferencesDescription);
        preferencesCard.add(Box.createVerticalStrut(20));

        // Reminder
        preferencesCard.add(
                createSettingRow(
                        "Task reminders",
                        "Get reminders for upcoming tasks.",
                        true
                )
        );

        preferencesCard.add(Box.createVerticalStrut(12));

        // Rewards
        preferencesCard.add(
                createSettingRow(
                        "Reward system",
                        "Show a reward after completing a task.",
                        true
                )
        );

        preferencesCard.add(Box.createVerticalStrut(12));

        // Personal tasks
        preferencesCard.add(
                createSettingRow(
                        "Personal tasks",
                        "Include chores, hobbies, and personal plans.",
                        true
                )
        );

        preferencesCard.add(Box.createVerticalStrut(12));

        // Quiet mode
        preferencesCard.add(
                createSettingRow(
                        "Quiet mode",
                        "Reduce reminders when you need uninterrupted time.",
                        false
                )
        );

        content.add(preferencesCard);

        // Put content inside scroll pane
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        main.add(scrollPane, BorderLayout.CENTER);

        add(main, BorderLayout.CENTER);
    }

    // =====================================================
    // SETTING ROW
    // =====================================================

    private JPanel createSettingRow(
            String title,
            String description,
            boolean selected
    ) {

        JPanel row = new JPanel(new BorderLayout());
        row.setOpaque(false);
        row.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 55)
        );

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(
                new BoxLayout(textPanel, BoxLayout.Y_AXIS)
        );

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(font(13, Font.BOLD));
        titleLabel.setForeground(TEXT);

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(font(11, Font.PLAIN));
        descriptionLabel.setForeground(SECONDARY_TEXT);

        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(descriptionLabel);

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(selected);
        checkBox.setOpaque(false);
        checkBox.setFocusPainted(false);

        row.add(textPanel, BorderLayout.WEST);
        row.add(checkBox, BorderLayout.EAST);

        return row;
    }

    // =====================================================
    // WHITE CARD
    // =====================================================

    private JPanel createWhiteCard() {

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(22, 24, 22, 24)
                )
        );
        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        return card;
    }

    // =====================================================
    // NAV BUTTON
    // =====================================================

    private JButton createNavButton(
            String text,
            boolean active
    ) {

        JButton button = new JButton(text);

        button.setFont(font(13, Font.BOLD));
        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setMaximumSize(
                new Dimension(200, 42)
        );

        if (active) {

            button.setBackground(
                    new Color(0x7A, 0x32, 0x40)
            );

            button.setForeground(Color.WHITE);

        } else {

            button.setBackground(BURGUNDY);

            button.setForeground(
                    new Color(235, 215, 218)
            );
        }

        button.setBorder(
                new EmptyBorder(
                        10, 12, 10, 12
                )
        );

        return button;
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MotivaSettings window =
                    new MotivaSettings();

            window.setVisible(true);
        });
    }
}
