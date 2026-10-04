import model.FoodReward;
import service.AppData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Provides a separate, alternate version of the food reward form for adding a
 * favorite item in a different layout or workflow. This screen keeps the same
 * core purpose as the main reward form while offering a slightly different UI
 * presentation for usability or testing purposes.
 */
class MotivaAddFavoriteFoodCopy extends JFrame {

    private JTextField foodNameField;

    public MotivaAddFavoriteFoodCopy() {

        setTitle("Motiva - Add Favorite Food");

        setSize(
                1280,
                800
        );

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                new Color(
                        250,
                        247,
                        243
                )
        );



        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                new Color(
                        98,
                        36,
                        47
                )
        );

        header.setPreferredSize(
                new Dimension(
                        1280,
                        80
                )
        );


        JLabel title =
                new JLabel(
                        "Add Favorite Food"
                );

        title.setForeground(
                Color.WHITE
        );

        title.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        26
                )
        );

        title.setBorder(
                new EmptyBorder(
                        0,
                        40,
                        0,
                        0
                )
        );

        header.add(
                title,
                BorderLayout.WEST
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
                new Color(
                        250,
                        247,
                        243
                )
        );

        content.setBorder(
                new EmptyBorder(
                        70,
                        150,
                        70,
                        150
                )
        );



        JLabel pageTitle =
                new JLabel(
                        "Create a Favorite Food"
                );

        pageTitle.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        30
                )
        );

        pageTitle.setForeground(
                new Color(
                        70,
                        25,
                        33
                )
        );

        pageTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        content.add(
                pageTitle
        );


        content.add(
                Box.createVerticalStrut(
                        12
                )
        );



        JLabel subtitle =
                new JLabel(
                        "Add a food that can become one of your rewards."
                );

        subtitle.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        16
                )
        );

        subtitle.setForeground(
                new Color(
                        100,
                        95,
                        90
                )
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



        JPanel card =
                new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        220,
                                        215
                                )
                        ),
                        new EmptyBorder(
                                40,
                                45,
                                40,
                                45
                        )
                )
        );

        card.setMaximumSize(
                new Dimension(
                        700,
                        260
                )
        );



        JLabel foodLabel =
                new JLabel(
                        "Food Name"
                );

        foodLabel.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        16
                )
        );

        foodLabel.setForeground(
                new Color(
                        70,
                        25,
                        33
                )
        );

        card.add(
                foodLabel
        );


        card.add(
                Box.createVerticalStrut(
                        12
                )
        );



        foodNameField =
                new JTextField();

        foodNameField.setFont(
                new Font(
                        "Inter",
                        Font.PLAIN,
                        16
                )
        );

        foodNameField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        48
                )
        );

        card.add(
                foodNameField
        );


        card.add(
                Box.createVerticalStrut(
                        30
                )
        );



        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                12,
                                0
                        )
                );

        buttons.setOpaque(
                false
        );



        JButton cancelButton =
                new JButton(
                        "Cancel"
                );

        cancelButton.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        cancelButton.addActionListener(
                e -> dispose()
        );



        JButton saveButton =
                new JButton(
                        "Add Food"
                );

        saveButton.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        14
                )
        );

        saveButton.setForeground(
                Color.WHITE
        );

        saveButton.setBackground(
                new Color(
                        98,
                        36,
                        47
                )
        );

        saveButton.setFocusPainted(
                false
        );

        saveButton.addActionListener(
                e -> saveFoodReward()
        );


        buttons.add(
                cancelButton
        );

        buttons.add(
                saveButton
        );

        card.add(
                buttons
        );

        content.add(
                card
        );



        mainPanel.add(
                content,
                BorderLayout.CENTER
        );

        add(
                mainPanel
        );
    }



    private void saveFoodReward() {

        String foodName =
                foodNameField
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

            return;
        }



        int id =
                AppData.rewardManager
                        .getNextRewardId();



        FoodReward reward =
                new FoodReward(
                        id,
                        foodName
                );



        AppData.rewardManager
                .addFoodReward(
                        reward
                );



        JOptionPane.showMessageDialog(
                this,
                "Favorite food added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );



        dispose();
    }
}