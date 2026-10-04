import model.Profile;
import service.AppData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Gives the student a simple way to update their saved profile information,
 * especially their name and year level, so the app stays aligned with their
 * current academic details.
 */
public class MotivaEditProfile extends JFrame {


    private static final Color BURGUNDY =
            new Color(0x62, 0x24, 0x2F);

    private static final Color BACKGROUND =
            new Color(0xFA, 0xF7, 0xF3);

    private static final Color TEXT =
            new Color(0x1F, 0x24, 0x2B);

    private static final Color BORDER =
            new Color(0xE4, 0xE2, 0xE0);


    private JTextField nameField;
    private JComboBox<String> yearLevelBox;


    private Font font(
            float size,
            int style
    ) {

        return new Font(
                "Inter",
                style,
                (int) size
        );
    }


    public MotivaEditProfile() {

        setTitle(
                "Motiva - Edit Profile"
        );

        setSize(
                520,
                500
        );

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);

        setLayout(
                new BorderLayout()
        );


        JPanel header =
                new JPanel();

        header.setBackground(
                BURGUNDY
        );

        header.setBorder(
                new EmptyBorder(
                        24,
                        28,
                        24,
                        28
                )
        );

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Edit Profile"
                );

        title.setFont(
                font(
                        22,
                        Font.BOLD
                )
        );

        title.setForeground(
                Color.WHITE
        );

        JLabel subtitle =
                new JLabel(
                        "Update your student information."
                );

        subtitle.setFont(
                font(
                        12,
                        Font.PLAIN
                )
        );

        subtitle.setForeground(
                new Color(
                        235,
                        215,
                        218
                )
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(5)
        );

        header.add(subtitle);

        add(
                header,
                BorderLayout.NORTH
        );


        JPanel form =
                new JPanel();

        form.setBackground(
                BACKGROUND
        );

        form.setBorder(
                new EmptyBorder(
                        28,
                        32,
                        20,
                        32
                )
        );

        form.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        16,
                        0
                );


        JLabel nameLabel =
                createLabel(
                        "Full Name"
                );

        gbc.gridx = 0;
        gbc.gridy = 0;

        form.add(
                nameLabel,
                gbc
        );

        nameField =
                new JTextField();

        styleTextField(
                nameField
        );

        gbc.gridy = 1;

        form.add(
                nameField,
                gbc
        );


        JLabel yearLabel =
                createLabel(
                        "Year Level"
                );

        gbc.gridy = 2;

        form.add(
                yearLabel,
                gbc
        );

        yearLevelBox =
                new JComboBox<>(
                        new String[]{
                                "1st Year",
                                "2nd Year",
                                "3rd Year",
                                "4th Year"
                        }
                );

        styleComboBox(
                yearLevelBox
        );

        gbc.gridy = 3;

        form.add(
                yearLevelBox,
                gbc
        );


        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttons.setOpaque(false);

        JButton cancelButton =
                new JButton(
                        "Cancel"
                );

        styleSecondaryButton(
                cancelButton
        );

        cancelButton.addActionListener(
                e -> dispose()
        );

        JButton saveButton =
                new JButton(
                        "Save Changes"
                );

        stylePrimaryButton(
                saveButton
        );

        saveButton.addActionListener(
                e -> saveProfile()
        );

        buttons.add(
                cancelButton
        );

        buttons.add(
                saveButton
        );

        gbc.gridy = 4;

        gbc.insets =
                new Insets(
                        8,
                        0,
                        0,
                        0
                );

        form.add(
                buttons,
                gbc
        );

        add(
                form,
                BorderLayout.CENTER
        );


        loadProfile();

        getRootPane().setDefaultButton(
                saveButton
        );
    }


    private void loadProfile() {

        Profile profile =
                AppData.profileManager
                        .getProfile();

        if (profile == null) {

            nameField.setText(
                    ""
            );

            yearLevelBox.setSelectedItem(
                    "1st Year"
            );

            return;
        }


        nameField.setText(
                profile.getName()
        );


        String yearLevel =
                profile.getYearLevel();

        if (yearLevel != null) {

            yearLevelBox.setSelectedItem(
                    yearLevel
            );
        }

    }


    private void saveProfile() {

        String name =
                nameField
                        .getText()
                        .trim();

        String yearLevel =
                String.valueOf(
                        yearLevelBox
                                .getSelectedItem()
                );

        Profile profile =
                AppData.profileManager
                        .getProfile();

        String program =
                profile == null
                        || profile.getProgram() == null
                        || profile.getProgram().trim().isEmpty()
                        ? "BSCpE"
                        : profile.getProgram();


        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name.",
                    "Invalid Profile",
                    JOptionPane.WARNING_MESSAGE
            );

            nameField.requestFocus();

            return;
        }


        final boolean saved =
                AppData.profileManager
                        .updateProfile(
                                name,
                                yearLevel,
                                program
                        );

        if (!saved) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save your profile.",
                    "Save Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        JOptionPane.showMessageDialog(
                this,
                "Profile updated successfully!",
                "Profile Updated",
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
                font(
                        12,
                        Font.BOLD
                )
        );

        label.setForeground(
                TEXT
        );

        return label;
    }


    private void styleTextField(
            JTextField field
    ) {

        field.setFont(
                font(
                        13,
                        Font.PLAIN
                )
        );

        field.setForeground(
                TEXT
        );

        field.setBackground(
                Color.WHITE
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                9,
                                12,
                                9,
                                12
                        )
                )
        );
    }


    private void styleComboBox(
            JComboBox<String> box
    ) {

        box.setFont(
                font(
                        13,
                        Font.PLAIN
                )
        );

        box.setForeground(
                TEXT
        );

        box.setBackground(
                Color.WHITE
        );

        box.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );
    }


    private void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(
                font(
                        12,
                        Font.BOLD
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                BURGUNDY
        );

        button.setFocusPainted(
                false
        );

        button.setBorder(
                new EmptyBorder(
                        10,
                        18,
                        10,
                        18
                )
        );
    }


    private void styleSecondaryButton(
            JButton button
    ) {

        button.setFont(
                font(
                        12,
                        Font.BOLD
                )
        );

        button.setForeground(
                BURGUNDY
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BURGUNDY
                        ),
                        new EmptyBorder(
                                9,
                                17,
                                9,
                                17
                        )
                )
        );
    }


    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    MotivaEditProfile window =
                            new MotivaEditProfile();

                    window.setVisible(
                            true
                    );
                }
        );
    }
}