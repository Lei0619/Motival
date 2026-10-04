import model.FoodReward;
import service.AppData;

import javax.swing.*;
import java.awt.*;

/**
 * Lets the student add a favorite food reward and save it locally so it can be
 * shown later on the rewards screen and tied to progress milestones.
 */
public class MotivaAddFavoriteFood extends JFrame {

    private JTextField foodField;
    private JComboBox<String> categoryBox;

    private final Color BURGUNDY =
            new Color(98, 36, 47);

    private final Color DEEP_BURGUNDY =
            new Color(70, 25, 33);

    private final Color BACKGROUND =
            new Color(250, 247, 243);

    private final Color GOLD =
            new Color(199, 161, 90);

    private final Color SECONDARY_TEXT =
            new Color(110, 100, 95);

    public MotivaAddFavoriteFood() {

        setTitle(
                "Add Favorite Food"
        );

        setSize(
                600,
                700
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                DISPOSE_ON_CLOSE
        );

        buildUI();
    }

    private void buildUI() {

        JPanel mainPanel =
                new JPanel();

        mainPanel.setLayout(
                new BorderLayout()
        );

        mainPanel.setBackground(
                BACKGROUND
        );


        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        170,
                        0
                )
        );

        sidebar.setBackground(
                DEEP_BURGUNDY
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel logo =
                new JLabel(
                        "MOTIVA"
                );

        logo.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        24
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(
                Box.createVerticalStrut(
                        35
                )
        );

        sidebar.add(
                logo
        );

        sidebar.add(
                Box.createVerticalStrut(
                        50
                )
        );

        JButton dashboardButton =
                createSidebarButton(
                        "Dashboard"
                );

        JButton scheduleButton =
                createSidebarButton(
                        "Schedule"
                );

        JButton rewardsButton =
                createSidebarButton(
                        "Rewards"
                );

        JButton settingsButton =
                createSidebarButton(
                        "Settings"
                );

        sidebar.add(
                dashboardButton
        );

        sidebar.add(
                scheduleButton
        );

        sidebar.add(
                rewardsButton
        );

        sidebar.add(
                settingsButton
        );

        dashboardButton.addActionListener(
                e -> MotivaNavigation.goToDashboard(this)
        );

        scheduleButton.addActionListener(
                e -> MotivaNavigation.goToSchedule(this)
        );

        rewardsButton.addActionListener(
                e -> MotivaNavigation.goToRewards(this)
        );

        settingsButton.addActionListener(
                e -> MotivaNavigation.goToSettings(this)
        );


        JPanel content =
                new JPanel();

        content.setBackground(
                BACKGROUND
        );

        content.setBorder(
                BorderFactory.createEmptyBorder(
                        35,
                        40,
                        35,
                        40
                )
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Add Favorite Food"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(
                BURGUNDY
        );

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(
                title
        );

        content.add(
                Box.createVerticalStrut(
                        8
                )
        );

        JLabel subtitle =
                new JLabel(
                        "Add a food reward for your hard work."
                );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(
                subtitle
        );

        content.add(
                Box.createVerticalStrut(
                        35
                )
        );


        JLabel foodLabel =
                createLabel(
                        "Food Name"
                );

        content.add(
                foodLabel
        );

        content.add(
                Box.createVerticalStrut(
                        8
                )
        );

        foodField =
                new JTextField();

        styleTextField(
                foodField
        );

        content.add(
                foodField
        );

        content.add(
                Box.createVerticalStrut(
                        25
                )
        );


        JLabel categoryLabel =
                createLabel(
                        "Category"
                );

        content.add(
                categoryLabel
        );

        content.add(
                Box.createVerticalStrut(
                        8
                )
        );

        categoryBox =
                new JComboBox<>(
                        new String[]{
                                "Snack",
                                "Meal",
                                "Dessert",
                                "Drink",
                                "Other"
                        }
                );

        categoryBox.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        categoryBox.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(
                categoryBox
        );

        content.add(
                Box.createVerticalGlue()
        );


        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                BACKGROUND
        );

        buttonPanel.setLayout(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        10,
                        0
                )
        );

        JButton cancelButton =
                new JButton(
                        "Cancel"
                );

        JButton saveButton =
                new JButton(
                        "Save Food"
                );

        styleSecondaryButton(
                cancelButton
        );

        stylePrimaryButton(
                saveButton
        );

        buttonPanel.add(
                cancelButton
        );

        buttonPanel.add(
                saveButton
        );

        content.add(
                buttonPanel
        );


        cancelButton.addActionListener(
                e -> dispose()
        );

        saveButton.addActionListener(
                e -> saveFood()
        );


        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                content,
                BorderLayout.CENTER
        );

        setContentPane(
                mainPanel
        );
    }


        /** Assigns a new ID and saves the food reward. */
    private void saveFood() {

        String foodName =
                foodField
                        .getText()
                        .trim();

        if (
                foodName.isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a food name.",
                    "Missing Food Name",
                    JOptionPane.WARNING_MESSAGE
            );

            foodField.requestFocus();

            return;
        }

        int id =
                AppData
                        .rewardManager
                        .getNextRewardId();

        FoodReward reward =
                new FoodReward(
                        id,
                        foodName
                );

        AppData
                .rewardManager
                .addFoodReward(
                        reward
                );

        JOptionPane.showMessageDialog(
                this,
                "Food reward saved successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        dispose();
    }


    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(
                DEEP_BURGUNDY
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }

    private void styleTextField(
            JTextField field
    ) {

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        field.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        field.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        215,
                                        205,
                                        198
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                8,
                                10,
                                8,
                                10
                        )
                )
        );
    }

    private JButton createSidebarButton(
            String text
    ) {

        JButton button =
                new JButton(
                        text
                );

        button.setMaximumSize(
                new Dimension(
                        150,
                        42
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                DEEP_BURGUNDY
        );

        button.setBorderPainted(
                false
        );

        button.setFocusPainted(
                false
        );

        return button;
    }

    private void stylePrimaryButton(
            JButton button
    ) {

        button.setBackground(
                BURGUNDY
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setBorderPainted(
                false
        );

        button.setPreferredSize(
                new Dimension(
                        120,
                        40
                )
        );
    }

    private void styleSecondaryButton(
            JButton button
    ) {

        button.setBackground(
                Color.WHITE
        );

        button.setForeground(
                DEEP_BURGUNDY
        );

        button.setFocusPainted(
                false
        );

        button.setPreferredSize(
                new Dimension(
                        100,
                        40
                )
        );
    }
}