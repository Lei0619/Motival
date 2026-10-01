import model.FoodReward;
import service.AppData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Lets the student review and manage saved food rewards. */
public class MotivaRewards extends JFrame {

    private JPanel rewardsPanel;

        // Shared palette for this screen.
    private final Color BURGUNDY =
            new Color(98, 36, 47);

    private final Color DEEP_BURGUNDY =
            new Color(70, 25, 33);

    private final Color BACKGROUND =
            new Color(250, 247, 243);

    private final Color SECONDARY_TEXT =
            new Color(110, 100, 95);


    public MotivaRewards() {

        setTitle(
                "Motiva - Rewards"
        );

        setSize(
                1100,
                750
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );

        buildUI();
    }


        /** Builds the page layout and loads the saved rewards. */
    private void buildUI() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                BACKGROUND
        );



        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        190,
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
                        26
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
                e -> refreshRewards()
        );

        settingsButton.addActionListener(
                e -> MotivaNavigation.goToSettings(this)
        );



        JPanel content =
                new JPanel(
                        new BorderLayout()
                );

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



        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                BACKGROUND
        );


        JLabel title =
                new JLabel(
                        "Favorite Food Rewards"
                );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(
                BURGUNDY
        );


        JLabel subtitle =
                new JLabel(
                        "Small rewards for big accomplishments."
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


        JPanel titlePanel =
                new JPanel();

        titlePanel.setBackground(
                BACKGROUND
        );

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );


        titlePanel.add(
                title
        );

        titlePanel.add(
                Box.createVerticalStrut(
                        5
                )
        );

        titlePanel.add(
                subtitle
        );


        JButton addButton =
                new JButton(
                        "+ Add Food"
                );

        stylePrimaryButton(
                addButton
        );


        addButton.addActionListener(
                e -> {

                    MotivaAddFavoriteFood window =
                            new MotivaAddFavoriteFood();

                    // Reload after the form closes so the new reward appears.
                    window.addWindowListener(
                            new java.awt.event.WindowAdapter() {

                                @Override
                                public void windowClosed(
                                        java.awt.event.WindowEvent e
                                ) {

                                    refreshRewards();
                                }
                            }
                    );

                    window.setVisible(
                            true
                    );
                }
        );


        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        header.add(
                addButton,
                BorderLayout.EAST
        );


        content.add(
                header,
                BorderLayout.NORTH
        );



        rewardsPanel =
                new JPanel();

        rewardsPanel.setBackground(
                BACKGROUND
        );

        rewardsPanel.setLayout(
                new GridLayout(
                        0,
                        3,
                        20,
                        20
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(
                        rewardsPanel
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        scrollPane.setBackground(
                BACKGROUND
        );


        content.add(
                scrollPane,
                BorderLayout.CENTER
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


        refreshRewards();
    }


        /** Reloads saved rewards and refreshes the list shown on screen. */
    public void refreshRewards() {

        if (
                rewardsPanel == null
        ) {

            return;
        }


        rewardsPanel.removeAll();


        ArrayList<FoodReward> rewards =
                AppData
                        .rewardManager
                        .getFoodRewards();


        if (
                rewards.isEmpty()
        ) {

            JLabel emptyLabel =
                    new JLabel(
                            "No favorite foods yet. Add one as a reward!"
                    );

            emptyLabel.setFont(
                    new Font(
                            "SansSerif",
                            Font.PLAIN,
                            16
                    )
            );

            emptyLabel.setForeground(
                    SECONDARY_TEXT
            );

            emptyLabel.setHorizontalAlignment(
                    SwingConstants.CENTER
            );


            rewardsPanel.add(
                    emptyLabel
            );

        } else {

            for (
                    FoodReward reward
                    : rewards
            ) {

                rewardsPanel.add(
                        createFoodCard(
                                reward
                        )
                );
            }
        }


        rewardsPanel.revalidate();

        rewardsPanel.repaint();
    }


        /** Builds a card with the reward name, caption, and actions. */
    private JPanel createFoodCard(
            FoodReward reward
    ) {

        JPanel card =
                new JPanel();


        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        216,
                                        208
                                )
                        ),
                        BorderFactory.createEmptyBorder(
                                20,
                                15,
                                15,
                                15
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel icon =
                new JLabel(
                        "🍽"
                );

        icon.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        42
                )
        );

        icon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        card.add(
                icon
        );

        card.add(
                Box.createVerticalStrut(
                        10
                )
        );


        JLabel foodName =
                new JLabel(
                        reward.getFoodName()
                );

        foodName.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        foodName.setForeground(
                DEEP_BURGUNDY
        );

        foodName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        card.add(
                foodName
        );


        String captionText =
                reward.getCaption();


        if (
                captionText == null
                        || captionText.trim().isEmpty()
        ) {

            captionText =
                    "A little treat for your hard work.";
        }


        JLabel caption =
                new JLabel(
                        "<html><center>"
                                + escapeHtml(
                                captionText
                        )
                                + "</center></html>"
                );

        caption.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        caption.setForeground(
                SECONDARY_TEXT
        );

        caption.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        card.add(
                Box.createVerticalStrut(
                        6
                )
        );

        card.add(
                caption
        );


        card.add(
                Box.createVerticalGlue()
        );



        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        buttonPanel.setBackground(
                Color.WHITE
        );


        JButton editButton =
                new JButton(
                        "Edit"
                );

        JButton deleteButton =
                new JButton(
                        "Remove"
                );


        styleSmallButton(
                editButton
        );

        styleSmallButton(
                deleteButton
        );


        buttonPanel.add(
                editButton
        );

        buttonPanel.add(
                deleteButton
        );


        card.add(
                Box.createVerticalStrut(
                        15
                )
        );

        card.add(
                buttonPanel
        );


        editButton.addActionListener(
                e -> {

                    MotivaEditFavoriteFood window =
                            new MotivaEditFavoriteFood(
                                    reward
                            );


                    window.addWindowListener(
                            new java.awt.event.WindowAdapter() {

                                @Override
                                public void windowClosed(
                                        java.awt.event.WindowEvent e
                                ) {

                                    refreshRewards();
                                }
                            }
                    );


                    window.setVisible(
                            true
                    );
                }
        );


        deleteButton.addActionListener(
                e -> {

                    // Confirm because this permanently removes the saved reward.
                    int result =
                            JOptionPane.showConfirmDialog(
                                    this,
                                    "Remove "
                                            + reward.getFoodName()
                                            + " from your rewards?",
                                    "Remove Reward",
                                    JOptionPane.YES_NO_OPTION
                            );


                    if (
                            result
                                    == JOptionPane.YES_OPTION
                    ) {

                        AppData
                                .rewardManager
                                .deleteFoodReward(
                                        reward.getId()
                                );


                        refreshRewards();
                    }
                }
        );


        return card;
    }


        /** Escapes user text so names and captions render safely inside HTML. */
    private String escapeHtml(
            String text
    ) {

        return text
                .replace(
                        "&",
                        "&amp;"
                )
                .replace(
                        "<",
                        "&lt;"
                )
                .replace(
                        ">",
                        "&gt;"
                )
                .replace(
                        "\"",
                        "&quot;"
                );
    }


        /** Creates one of the buttons used to move between screens. */
    private JButton createSidebarButton(
            String text
    ) {

        JButton button =
                new JButton(
                        text
                );


        button.setMaximumSize(
                new Dimension(
                        165,
                        45
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


        /** Applies the primary-action style to the Add Food button. */
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


        /** Applies the compact style used by each reward card's actions. */
    private void styleSmallButton(
            JButton button
    ) {

        button.setBackground(
                Color.WHITE
        );

        button.setForeground(
                BURGUNDY
        );

        button.setFocusPainted(
                false
        );

        button.setPreferredSize(
                new Dimension(
                        80,
                        32
                )
        );
    }
}