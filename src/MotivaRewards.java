package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaRewards extends JFrame {

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

    private static final Font FONT = new Font("Inter", Font.PLAIN, 14);
    private static final Font FONT_BOLD = new Font("Inter", Font.BOLD, 14);
    private static final Font FONT_TITLE = new Font("Inter", Font.BOLD, 28);
    private static final Font FONT_SMALL = new Font("Inter", Font.PLAIN, 12);

    public MotivaRewards() {

        setTitle("Motiva — Rewards");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BACKGROUND);

        // =========================
        // SIDEBAR
        // =========================
        root.add(createSidebar(), BorderLayout.WEST);

        // =========================
        // MAIN CONTENT
        // =========================
        root.add(createMainContent(), BorderLayout.CENTER);

        setContentPane(root);
    }

    // ============================================================
    // SIDEBAR
    // ============================================================

    private JPanel createSidebar() {

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(240, 800));
        sidebar.setBackground(BURGUNDY);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(28, 20, 25, 20));

        // Logo
        JLabel logo = new JLabel("Motiva");
        logo.setFont(new Font("Inter", Font.BOLD, 25));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel("Student Motivation System");
        subtitle.setFont(new Font("Inter", Font.PLAIN, 11));
        subtitle.setForeground(new Color(235, 220, 222));
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(3));
        sidebar.add(subtitle);

        sidebar.add(Box.createVerticalStrut(40));

        // Navigation
        sidebar.add(createNavButton("Dashboard", false));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("My Tasks", false));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("Schedule", false));
        sidebar.add(Box.createVerticalStrut(8));

        // Active Rewards
        sidebar.add(createNavButton("Rewards", true));
        sidebar.add(Box.createVerticalStrut(8));

        sidebar.add(createNavButton("Settings", false));

        sidebar.add(Box.createVerticalGlue());

        // Today's Note
        JPanel note = new JPanel();
        note.setLayout(new BoxLayout(note, BoxLayout.Y_AXIS));
        note.setBackground(DEEP_BURGUNDY);
        note.setBorder(new EmptyBorder(16, 15, 16, 15));
        note.setMaximumSize(new Dimension(200, 115));
        note.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel noteTitle = new JLabel("Today's Note");
        noteTitle.setFont(FONT_BOLD);
        noteTitle.setForeground(Color.WHITE);

        JLabel noteText = new JLabel(
                "<html>Small progress is still<br>progress. Keep going.</html>"
        );
        noteText.setFont(FONT_SMALL);
        noteText.setForeground(new Color(235, 220, 222));

        note.add(noteTitle);
        note.add(Box.createVerticalStrut(8));
        note.add(noteText);

        sidebar.add(note);

        sidebar.add(Box.createVerticalStrut(20));

        // Profile
        JPanel profile = new JPanel(new BorderLayout(10, 0));
        profile.setOpaque(false);
        profile.setMaximumSize(new Dimension(200, 45));
        profile.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel avatar = new JLabel("L");
        avatar.setHorizontalAlignment(SwingConstants.CENTER);
        avatar.setVerticalAlignment(SwingConstants.CENTER);
        avatar.setFont(new Font("Inter", Font.BOLD, 14));
        avatar.setForeground(BURGUNDY);
        avatar.setBackground(Color.WHITE);
        avatar.setOpaque(true);
        avatar.setPreferredSize(new Dimension(38, 38));

        JPanel profileText = new JPanel();
        profileText.setOpaque(false);
        profileText.setLayout(new BoxLayout(profileText, BoxLayout.Y_AXIS));

        JLabel name = new JLabel("Lei");
        name.setFont(FONT_BOLD);
        name.setForeground(Color.WHITE);

        JLabel program = new JLabel("BSCpE Student");
        program.setFont(FONT_SMALL);
        program.setForeground(new Color(235, 220, 222));

        profileText.add(name);
        profileText.add(program);

        profile.add(avatar, BorderLayout.WEST);
        profile.add(profileText, BorderLayout.CENTER);

        sidebar.add(profile);

        return sidebar;
    }

    // ============================================================
    // NAV BUTTON
    // ============================================================

    private JButton createNavButton(String text, boolean active) {

        JButton button = new JButton(text);

        button.setFont(FONT_BOLD);
        button.setForeground(Color.WHITE);
        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setBackground(active ? DEEP_BURGUNDY : BURGUNDY);

        button.setBorder(
                new EmptyBorder(12, 15, 12, 15)
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

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(BACKGROUND);
        main.setBorder(new EmptyBorder(35, 40, 35, 40));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Rewards");
        title.setFont(FONT_TITLE);
        title.setForeground(TEXT);

        JLabel description = new JLabel(
                "Your favorite things to look forward to."
        );
        description.setFont(FONT);
        description.setForeground(SECONDARY_TEXT);

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(6));
        titlePanel.add(description);

        header.add(titlePanel, BorderLayout.WEST);

        // Profile on top right
        JPanel topProfile = createTopProfile();
        header.add(topProfile, BorderLayout.EAST);

        main.add(header, BorderLayout.NORTH);

        // Content
        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BorderLayout());

        content.setBorder(
                new EmptyBorder(35, 0, 0, 0)
        );

        // Reward explanation card
        content.add(createRewardInfo(), BorderLayout.NORTH);

        // Foods
        JPanel foods = new JPanel();
        foods.setOpaque(false);

        foods.setLayout(
                new GridLayout(2, 3, 18, 18)
        );

        foods.setBorder(
                new EmptyBorder(22, 0, 0, 0)
        );

        foods.add(
                createFoodCard(
                        "Milk Tea",
                        "Classic comfort drink",
                        "🥤"
                )
        );

        foods.add(
                createFoodCard(
                        "French Fries",
                        "Crispy and salty",
                        "🍟"
                )
        );

        foods.add(
                createFoodCard(
                        "Chickenjoy",
                        "A classic favorite",
                        "🍗"
                )
        );

        foods.add(
                createFoodCard(
                        "Chocolate Cake",
                        "Something sweet",
                        "🍰"
                )
        );

        foods.add(
                createFoodCard(
                        "Takoyaki",
                        "Warm comfort food",
                        "🐙"
                )
        );

        foods.add(
                createAddFoodCard()
        );

        content.add(foods, BorderLayout.CENTER);

        main.add(content, BorderLayout.CENTER);

        return main;
    }

    // ============================================================
    // TOP PROFILE
    // ============================================================

    private JPanel createTopProfile() {

        JPanel profile = new JPanel();
        profile.setOpaque(false);

        profile.setLayout(
                new BoxLayout(profile, BoxLayout.X_AXIS)
        );

        JLabel avatar = new JLabel("L");
        avatar.setHorizontalAlignment(SwingConstants.CENTER);
        avatar.setVerticalAlignment(SwingConstants.CENTER);
        avatar.setFont(new Font("Inter", Font.BOLD, 14));
        avatar.setForeground(Color.WHITE);
        avatar.setBackground(BURGUNDY);
        avatar.setOpaque(true);
        avatar.setPreferredSize(new Dimension(38, 38));

        JLabel name = new JLabel("Lei");
        name.setFont(FONT_BOLD);
        name.setForeground(TEXT);

        profile.add(avatar);
        profile.add(Box.createHorizontalStrut(10));
        profile.add(name);

        return profile;
    }

    // ============================================================
    // REWARD INFO
    // ============================================================

    private JPanel createRewardInfo() {

        JPanel card = new JPanel(new BorderLayout(20, 0));

        card.setBackground(Color.WHITE);
        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(22, 24, 22, 24)
                )
        );

        // Icon
        JLabel icon = new JLabel("★");
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setFont(new Font("Inter", Font.BOLD, 28));
        icon.setForeground(GOLD);
        icon.setBackground(new Color(0xF9, 0xF2, 0xE5));
        icon.setOpaque(true);
        icon.setPreferredSize(new Dimension(58, 58));

        card.add(icon, BorderLayout.WEST);

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(
                new BoxLayout(textPanel, BoxLayout.Y_AXIS)
        );

        JLabel title = new JLabel(
                "Complete a task. Earn a reward."
        );
        title.setFont(
                new Font("Inter", Font.BOLD, 18)
        );
        title.setForeground(TEXT);

        JLabel description = new JLabel(
                "<html>When you complete a task, Motiva will randomly choose one<br>" +
                "of your favorite foods as your reward.</html>"
        );
        description.setFont(FONT);
        description.setForeground(SECONDARY_TEXT);

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(7));
        textPanel.add(description);

        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    // ============================================================
    // FOOD CARD
    // ============================================================

    private JPanel createFoodCard(
            String foodName,
            String description,
            String emoji
    ) {

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        JLabel foodIcon = new JLabel(emoji);
        foodIcon.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 38)
        );
        foodIcon.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel name = new JLabel(foodName);
        name.setFont(
                new Font("Inter", Font.BOLD, 16)
        );
        name.setForeground(TEXT);
        name.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel desc = new JLabel(description);
        desc.setFont(FONT_SMALL);
        desc.setForeground(SECONDARY_TEXT);
        desc.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(foodIcon);
        card.add(Box.createVerticalStrut(12));
        card.add(name);
        card.add(Box.createVerticalStrut(5));
        card.add(desc);

        return card;
    }

    // ============================================================
    // ADD FOOD CARD
    // ============================================================

    private JPanel createAddFoodCard() {

        JPanel card = new JPanel();
        card.setBackground(LIGHT_BURGUNDY);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(0xE4, 0xCC, 0xD0)
                        ),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        JLabel plus = new JLabel("+");
        plus.setFont(
                new Font("Inter", Font.BOLD, 32)
        );
        plus.setForeground(BURGUNDY);
        plus.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Add Favorite Food");
        title.setFont(
                new Font("Inter", Font.BOLD, 16)
        );
        title.setForeground(BURGUNDY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel description = new JLabel(
                "<html>Add something you<br>look forward to.</html>"
        );
        description.setFont(FONT_SMALL);
        description.setForeground(SECONDARY_TEXT);
        description.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(plus);
        card.add(Box.createVerticalStrut(12));
        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(description);

        return card;
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MotivaRewards app = new MotivaRewards();

            app.setVisible(true);
        });
    }
}