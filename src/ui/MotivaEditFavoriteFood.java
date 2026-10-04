import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import model.FoodReward;
import service.AppData;

/**
 * Allows the student to either create a new food reward or edit the name of an
 * existing one without leaving the rewards workflow.
 */
public class MotivaEditFavoriteFood extends JFrame {

    private static final Color BURGUNDY = new Color(98, 36, 47);
    private static final Color DARK_BURGUNDY = new Color(70, 25, 33);
    private static final Color BACKGROUND = new Color(250, 247, 243);

    private JTextField foodNameField;

    private FoodReward rewardToEdit;

        /** Opens a blank form for a new reward. */
    public MotivaEditFavoriteFood() {
        this(null);
    }

        /** Opens the form with the selected reward's name filled in. */
    public MotivaEditFavoriteFood(FoodReward reward) {

        this.rewardToEdit = reward;

        setTitle(
                reward == null
                        ? "Add Favorite Food"
                        : "Edit Favorite Food"
        );

        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);


        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(230, 800));
        sidebar.setBackground(DARK_BURGUNDY);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("MOTIVA");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Inter", Font.BOLD, 28));
        logo.setBorder(new EmptyBorder(35, 25, 50, 10));

        sidebar.add(logo);

        JButton dashboardButton = createNavButton("Dashboard");
        JButton scheduleButton = createNavButton("Schedule");
        JButton rewardsButton = createNavButton("Rewards");
        JButton settingsButton = createNavButton("Settings");

        sidebar.add(dashboardButton);
        sidebar.add(scheduleButton);
        sidebar.add(rewardsButton);
        sidebar.add(settingsButton);

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

        JPanel content = new JPanel();
        content.setBackground(BACKGROUND);
        content.setBorder(new EmptyBorder(45, 55, 45, 55));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(
                rewardToEdit == null ? "Add Favorite Food" : "Edit Favorite Food"
        );
        title.setFont(new Font("Inter", Font.BOLD, 32));
        title.setForeground(DARK_BURGUNDY);

        JLabel subtitle = new JLabel(
                rewardToEdit == null
                        ? "Add a food that can become one of your rewards."
                        : "Update the details of your favorite food reward."
        );
        subtitle.setFont(new Font("Inter", Font.PLAIN, 16));
        subtitle.setForeground(new Color(110, 100, 95));

        content.add(title);
        content.add(Box.createVerticalStrut(10));
        content.add(subtitle);
        content.add(Box.createVerticalStrut(45));


        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 220, 215)
                        ),
                        new EmptyBorder(30, 35, 30, 35)
                )
        );

        formPanel.setLayout(
                new BoxLayout(formPanel, BoxLayout.Y_AXIS)
        );

        JLabel foodLabel = new JLabel("Food Name");

        foodLabel.setFont(
                new Font("Inter", Font.BOLD, 16)
        );

        foodLabel.setForeground(DARK_BURGUNDY);

        foodNameField = new JTextField();

        foodNameField.setFont(
                new Font("Inter", Font.PLAIN, 16)
        );

        foodNameField.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 45)
        );

        foodNameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 205, 200)
                        ),
                        new EmptyBorder(8, 12, 8, 12)
                )
        );

        if (rewardToEdit != null) {

            foodNameField.setText(
                    rewardToEdit.getFoodName()
            );
        }

        formPanel.add(foodLabel);
        formPanel.add(Box.createVerticalStrut(12));
        formPanel.add(foodNameField);

        content.add(formPanel);

        content.add(Box.createVerticalStrut(30));


        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        15,
                        0
                )
        );

        buttonPanel.setBackground(BACKGROUND);

        JButton cancelButton = new JButton("Cancel");

        cancelButton.setFont(
                new Font("Inter", Font.BOLD, 14)
        );

        cancelButton.setFocusPainted(false);

        cancelButton.addActionListener(e -> dispose());

        JButton saveButton = new JButton(
                rewardToEdit == null
                        ? "Add Food"
                        : "Save Changes"
        );

        saveButton.setFont(
                new Font("Inter", Font.BOLD, 14)
        );

        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(BURGUNDY);
        saveButton.setFocusPainted(false);

        saveButton.setBorder(
                new EmptyBorder(12, 25, 12, 25)
        );

        saveButton.addActionListener(e -> saveFood());

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        content.add(buttonPanel);

        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(content, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }


    private void saveFood() {

        String foodName =
                foodNameField.getText().trim();

        if (foodName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a food name.",
                    "Missing Food Name",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        if (rewardToEdit != null) {

            rewardToEdit.setFoodName(foodName);

            AppData.rewardManager.updateFoodReward(
                    rewardToEdit
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Favorite food updated successfully!"
            );

        }


        else {

            int id =
                    AppData.rewardManager
                            .getNextRewardId();

            FoodReward newReward =
                    new FoodReward(
                            id,
                            foodName
                    );

            AppData.rewardManager.addFoodReward(
                    newReward
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Favorite food added successfully!"
            );
        }

        dispose();
    }


    private JButton createNavButton(String text) {

        JButton button = new JButton(text);

        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setBorder(
                new EmptyBorder(10, 25, 10, 10)
        );

        button.setForeground(Color.WHITE);
        button.setBackground(DARK_BURGUNDY);

        button.setFont(
                new Font("Inter", Font.PLAIN, 15)
        );

        button.setFocusPainted(false);

        return button;
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MotivaEditFavoriteFood()
                    .setVisible(true);

        });
    }
}