import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import model.FoodReward;

/** Shows the reward selected after a task is completed. */
public class MotivaRewardUnlocked extends JFrame {

    private final Color BURGUNDY =
            Color.decode("#62242F");

    private final Color DARK_BURGUNDY =
            Color.decode("#461921");

    private final Color BACKGROUND =
            Color.decode("#FAF7F3");

    private final Color GOLD =
            Color.decode("#C7A15A");

    private FoodReward reward;


    public MotivaRewardUnlocked(
            FoodReward reward
    ) {

        this.reward = reward;

        setTitle(
                "Motiva — Reward Unlocked"
        );

        setSize(
                1280,
                800
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        createMainContent();
    }


    private void createMainContent() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                BACKGROUND
        );


        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                DARK_BURGUNDY
        );

        header.setBorder(
                new EmptyBorder(
                        18,
                        25,
                        18,
                        30
                )
        );

        JLabel logo =
                new JLabel(
                        "MOTIVA"
                );

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        24
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        header.add(
                logo,
                BorderLayout.WEST
        );

        JLabel profile =
                new JLabel(
                        "Student"
                );

        profile.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        15
                )
        );

        profile.setForeground(
                Color.WHITE
        );

        header.add(
                profile,
                BorderLayout.EAST
        );

        mainPanel.add(
                header,
                BorderLayout.NORTH
        );


        JPanel content =
                new JPanel();

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setBackground(
                BACKGROUND
        );

        content.setBorder(
                new EmptyBorder(
                        70,
                        100,
                        70,
                        100
                )
        );


        JLabel title =
                new JLabel(
                        "Reward Unlocked!"
                );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        38
                )
        );

        title.setForeground(
                DARK_BURGUNDY
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        content.add(
                title
        );

        content.add(
                Box.createVerticalStrut(
                        15
                )
        );


        JLabel subtitle =
                new JLabel(
                        "You completed your task. Here's your reward!"
                );

        subtitle.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        17
                )
        );

        subtitle.setForeground(
                Color.GRAY
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        content.add(
                subtitle
        );

        content.add(
                Box.createVerticalStrut(
                        45
                )
        );


        JPanel rewardCard =
                new JPanel();

        rewardCard.setLayout(
                new BoxLayout(
                        rewardCard,
                        BoxLayout.Y_AXIS
                )
        );

        rewardCard.setBackground(
                Color.WHITE
        );

        rewardCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        220,
                                        215
                                )
                        ),
                        new EmptyBorder(
                                50,
                                60,
                                50,
                                60
                        )
                )
        );

        rewardCard.setMaximumSize(
                new Dimension(
                        700,
                        360
                )
        );

        rewardCard.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel rewardLabel =
                new JLabel(
                        "YOUR FOOD REWARD"
                );

        rewardLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        15
                )
        );

        rewardLabel.setForeground(
                GOLD
        );

        rewardLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        rewardCard.add(
                rewardLabel
        );

        rewardCard.add(
                Box.createVerticalStrut(
                        20
                )
        );


        JLabel foodName =
                new JLabel(
                        reward.getFoodName()
                );

        foodName.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        34
                )
        );

        foodName.setForeground(
                DARK_BURGUNDY
        );

        foodName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        foodName.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        rewardCard.add(
                foodName
        );

        rewardCard.add(
                Box.createVerticalStrut(
                        20
                )
        );


        JLabel message =
                new JLabel(
                        reward.getRewardMessage()
                );

        message.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        16
                )
        );

        message.setForeground(
                Color.DARK_GRAY
        );

        message.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        message.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        rewardCard.add(
                message
        );

        content.add(
                rewardCard
        );

        content.add(
                Box.createVerticalStrut(
                        40
                )
        );


        JButton continueButton =
                new JButton(
                        "Continue"
                );

        continueButton.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        15
                )
        );

        continueButton.setForeground(
                Color.WHITE
        );

        continueButton.setBackground(
                BURGUNDY
        );

        continueButton.setFocusPainted(
                false
        );

        continueButton.setBorder(
                new EmptyBorder(
                        13,
                        30,
                        13,
                        30
                )
        );

        continueButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        continueButton.addActionListener(
                e -> MotivaNavigation.goToDashboard(this)
        );

        content.add(
                continueButton
        );


        mainPanel.add(
                content,
                BorderLayout.CENTER
        );

        setContentPane(
                mainPanel
        );
    }


    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            FoodReward testReward =
                    new FoodReward(
                            1,
                            "Chicken McDo"
                    );

            new MotivaRewardUnlocked(
                    testReward
            ).setVisible(
                    true
            );
        });
    }
}