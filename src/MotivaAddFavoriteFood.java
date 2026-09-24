package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaAddFavoriteFood extends JFrame {

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

    // =========================
    // FONT
    // =========================
    private Font font(float size, int style) {
        return new Font("Inter", style, (int) size);
    }

    public MotivaAddFavoriteFood() {

        setTitle("Motiva - Add Favorite Food");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // =========================
        // SIDEBAR
        // =========================
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

        // Rewards ACTIVE
        sidebar.add(createNavButton("★   Rewards", true));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("⚙   Settings", false));

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

        // =========================
        // MAIN AREA
        // =========================
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BACKGROUND);
        main.setBorder(new EmptyBorder(38, 45, 38, 45));

        // =========================
        // HEADER
        // =========================
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Add Favorite Food");
        title.setFont(font(28, Font.BOLD));
        title.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Add something you would love to receive as a reward."
        );
        subtitle.setFont(font(14, Font.PLAIN));
        subtitle.setForeground(SECONDARY_TEXT);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(7));
        titlePanel.add(subtitle);

        header.add(titlePanel, BorderLayout.WEST);

        // Profile
        JPanel profile = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
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
        profileText.setLayout(new BoxLayout(profileText, BoxLayout.Y_AXIS));

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

        // =========================
        // FORM AREA
        // =========================
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);

        JPanel formCard = new JPanel();
        formCard.setPreferredSize(new Dimension(700, 470));
        formCard.setBackground(Color.WHITE);
        formCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(32, 38, 32, 38)
                )
        );
        formCard.setLayout(new BoxLayout(formCard, BoxLayout.Y_AXIS));

        JLabel formTitle = new JLabel("Favorite Food");
        formTitle.setFont(font(21, Font.BOLD));
        formTitle.setForeground(TEXT);
        formTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel formDescription = new JLabel(
                "This food can randomly appear when you complete a task."
        );
        formDescription.setFont(font(13, Font.PLAIN));
        formDescription.setForeground(SECONDARY_TEXT);
        formDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        formCard.add(formTitle);
        formCard.add(Box.createVerticalStrut(6));
        formCard.add(formDescription);
        formCard.add(Box.createVerticalStrut(28));

        // =========================
        // FOOD NAME
        // =========================
        JLabel foodLabel = new JLabel("Food name");
        foodLabel.setFont(font(13, Font.BOLD));
        foodLabel.setForeground(TEXT);
        foodLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField foodField = new JTextField();
        foodField.setFont(font(13, Font.PLAIN));
        foodField.setForeground(TEXT);
        foodField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(10, 12, 10, 12)
                )
        );
        foodField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        formCard.add(foodLabel);
        formCard.add(Box.createVerticalStrut(8));
        formCard.add(foodField);

        formCard.add(Box.createVerticalStrut(20));

        // =========================
        // NOTE
        // =========================
        JLabel noteLabel = new JLabel("Note");
        noteLabel.setFont(font(13, Font.BOLD));
        noteLabel.setForeground(TEXT);
        noteLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField noteField = new JTextField();
        noteField.setFont(font(13, Font.PLAIN));
        noteField.setForeground(TEXT);
        noteField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(10, 12, 10, 12)
                )
        );
        noteField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        formCard.add(noteLabel);
        formCard.add(Box.createVerticalStrut(8));
        formCard.add(noteField);

        formCard.add(Box.createVerticalStrut(20));

        // =========================
        // CATEGORY
        // =========================
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(font(13, Font.BOLD));
        categoryLabel.setForeground(TEXT);
        categoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{
                        "Comfort Food",
                        "Snack",
                        "Drink",
                        "Dessert",
                        "Meal"
                }
        );

        categoryBox.setFont(font(13, Font.PLAIN));
        categoryBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        formCard.add(categoryLabel);
        formCard.add(Box.createVerticalStrut(8));
        formCard.add(categoryBox);

        formCard.add(Box.createVerticalGlue());

        // =========================
        // BUTTONS
        // =========================
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(font(13, Font.BOLD));
        cancelButton.setForeground(BURGUNDY);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BURGUNDY),
                        new EmptyBorder(10, 22, 10, 22)
                )
        );

        JButton saveButton = new JButton("Save Food");
        saveButton.setFont(font(13, Font.BOLD));
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(BURGUNDY);
        saveButton.setFocusPainted(false);
        saveButton.setBorder(
                new EmptyBorder(11, 24, 11, 24)
        );

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        formCard.add(buttonPanel);

        centerWrapper.add(formCard);

        main.add(centerWrapper, BorderLayout.CENTER);

        add(main, BorderLayout.CENTER);
    }

    // =========================
    // NAV BUTTON
    // =========================
    private JButton createNavButton(String text, boolean active) {

        JButton button = new JButton(text);

        button.setFont(font(13, Font.BOLD));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setMaximumSize(new Dimension(200, 42));

        if (active) {
            button.setBackground(new Color(0x7A, 0x32, 0x40));
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(BURGUNDY);
            button.setForeground(new Color(235, 215, 218));
        }

        button.setBorder(
                new EmptyBorder(10, 12, 10, 12)
        );

        return button;
    }

    // =========================
    // MAIN
    // =========================
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MotivaAddFavoriteFood window =
                    new MotivaAddFavoriteFood();

            window.setVisible(true);
        });
    }
}
