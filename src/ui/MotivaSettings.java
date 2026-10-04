import model.Profile;
import service.AppData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Opens the settings screen where the student can review and update their profile
 * details, manage personal preferences, and keep the app tailored to their needs.
 */
public class MotivaSettings extends JFrame {

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

        /** Program saved with profiles created or updated here. */
    private static final String PROGRAM =
            "BSCpE";

    private JLabel headerName;
    private JLabel headerDetails;
    private JLabel headerAvatar;

    private JLabel profileAvatar;
    private JLabel profileName;
    private JLabel profileYear;

    private JLabel sidebarStudent;
    private JLabel sidebarYear;

        /** Builds a font with the requested size and style. */
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

        /** Builds the window and loads the current profile. */
    public MotivaSettings() {

        setTitle(
                "Motiva - Settings"
        );

        setSize(
                1280,
                800
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(
                new BorderLayout()
        );

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        240,
                        800
                )
        );

        sidebar.setBackground(
                BURGUNDY
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        28,
                        20,
                        24,
                        20
                )
        );

        JLabel logo =
                new JLabel(
                        "Motiva"
                );

        logo.setForeground(
                Color.WHITE
        );

        logo.setFont(
                font(
                        26,
                        Font.BOLD
                )
        );

        logo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel tagline =
                new JLabel(
                        "Student Motivation System"
                );

        tagline.setForeground(
                new Color(
                        235,
                        215,
                        218
                )
        );

        tagline.setFont(
                font(
                        11,
                        Font.PLAIN
                )
        );

        tagline.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(4)
        );

        sidebar.add(tagline);

        sidebar.add(
                Box.createVerticalStrut(38)
        );

        sidebar.add(
                createNavButton(
                        "⌂   Dashboard",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "✓   My Tasks",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "▣   Schedule",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "★   Rewards",
                        false
                )
        );

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(
                createNavButton(
                        "⚙   Settings",
                        true
                )
        );

        sidebar.add(
                Box.createVerticalGlue()
        );

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
                        14,
                        14,
                        14,
                        14
                )
        );

        note.setMaximumSize(
                new Dimension(
                        200,
                        100
                )
        );

        note.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel noteTitle =
                new JLabel(
                        "TODAY'S NOTE"
                );

        noteTitle.setForeground(
                GOLD
        );

        noteTitle.setFont(
                font(
                        10,
                        Font.BOLD
                )
        );

        JLabel noteText =
                new JLabel(
                        "<html>Small progress is still<br>progress.</html>"
                );

        noteText.setForeground(
                Color.WHITE
        );

        noteText.setFont(
                font(
                        12,
                        Font.PLAIN
                )
        );

        note.add(noteTitle);

        note.add(
                Box.createVerticalStrut(7)
        );

        note.add(noteText);

        sidebar.add(note);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        sidebarStudent =
                new JLabel();

        sidebarStudent.setForeground(
                Color.WHITE
        );

        sidebarStudent.setFont(
                font(
                        12,
                        Font.BOLD
                )
        );

        sidebarStudent.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebarYear =
                new JLabel();

        sidebarYear.setForeground(
                new Color(
                        220,
                        200,
                        204
                )
        );

        sidebarYear.setFont(
                font(
                        11,
                        Font.PLAIN
                )
        );

        sidebarYear.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        sidebar.add(
                sidebarStudent
        );

        sidebar.add(
                Box.createVerticalStrut(3)
        );

        sidebar.add(
                sidebarYear
        );

        add(
                sidebar,
                BorderLayout.WEST
        );

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                BACKGROUND
        );

        main.setBorder(
                new EmptyBorder(
                        38,
                        45,
                        38,
                        45
                )
        );

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);

        JPanel titlePanel =
                new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Settings"
                );

        title.setFont(
                font(
                        28,
                        Font.BOLD
                )
        );

        title.setForeground(
                TEXT
        );

        JLabel subtitle =
                new JLabel(
                        "Manage your profile and Motiva preferences."
                );

        subtitle.setFont(
                font(
                        14,
                        Font.PLAIN
                )
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );

        titlePanel.add(title);

        titlePanel.add(
                Box.createVerticalStrut(7)
        );

        titlePanel.add(subtitle);

        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        JPanel headerProfile =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        headerProfile.setOpaque(false);

        JPanel avatar =
                new JPanel(
                        new GridBagLayout()
                );

        avatar.setPreferredSize(
                new Dimension(
                        42,
                        42
                )
        );

        avatar.setBackground(
                LIGHT_BURGUNDY
        );

        headerAvatar =
                new JLabel();

        headerAvatar.setFont(
                font(
                        16,
                        Font.BOLD
                )
        );

        headerAvatar.setForeground(
                BURGUNDY
        );

        avatar.add(
                headerAvatar
        );

        JPanel headerText =
                new JPanel();

        headerText.setOpaque(false);

        headerText.setLayout(
                new BoxLayout(
                        headerText,
                        BoxLayout.Y_AXIS
                )
        );

        headerName =
                new JLabel();

        headerName.setFont(
                font(
                        13,
                        Font.BOLD
                )
        );

        headerName.setForeground(
                TEXT
        );

        headerDetails =
                new JLabel();

        headerDetails.setFont(
                font(
                        11,
                        Font.PLAIN
                )
        );

        headerDetails.setForeground(
                SECONDARY_TEXT
        );

        headerText.add(
                headerName
        );

        headerText.add(
                headerDetails
        );

        headerProfile.add(avatar);

        headerProfile.add(headerText);

        header.add(
                headerProfile,
                BorderLayout.EAST
        );

        main.add(
                header,
                BorderLayout.NORTH
        );

        JPanel content =
                new JPanel();

        content.setOpaque(false);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setBorder(
                new EmptyBorder(
                        28,
                        0,
                        0,
                        0
                )
        );

        content.add(
                createProfileCard()
        );

        content.add(
                Box.createVerticalStrut(18)
        );

        content.add(
                createPreferencesCard()
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        content
                );

        scrollPane.setBorder(null);

        scrollPane.setOpaque(false);

        scrollPane
                .getViewport()
                .setOpaque(false);

        scrollPane
                .getVerticalScrollBar()
                .setUnitIncrement(16);

        main.add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                main,
                BorderLayout.CENTER
        );

        refreshProfile();
    }

        /** Builds the profile summary and opens its edit form. */
    private JPanel createProfileCard() {

        JPanel card =
                createWhiteCard();

        JLabel title =
                new JLabel(
                        "Profile"
                );

        title.setFont(
                font(
                        18,
                        Font.BOLD
                )
        );

        title.setForeground(
                TEXT
        );

        JLabel description =
                new JLabel(
                        "Your student information."
                );

        description.setFont(
                font(
                        12,
                        Font.PLAIN
                )
        );

        description.setForeground(
                SECONDARY_TEXT
        );

        card.add(title);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(description);

        card.add(
                Box.createVerticalStrut(22)
        );

        JPanel body =
                new JPanel(
                        new BorderLayout(
                                20,
                                0
                        )
                );

        body.setOpaque(false);

        profileAvatar =
                new JLabel(
                        "?",
                        SwingConstants.CENTER
                );

        profileAvatar.setPreferredSize(
                new Dimension(
                        72,
                        72
                )
        );

        profileAvatar.setOpaque(true);

        profileAvatar.setBackground(
                LIGHT_BURGUNDY
        );

        profileAvatar.setForeground(
                BURGUNDY
        );

        profileAvatar.setFont(
                font(
                        26,
                        Font.BOLD
                )
        );

        body.add(
                profileAvatar,
                BorderLayout.WEST
        );

        JPanel info =
                new JPanel();

        info.setOpaque(false);

        info.setLayout(
                new BoxLayout(
                        info,
                        BoxLayout.Y_AXIS
                )
        );

        profileName =
                new JLabel(
                        "No Profile"
                );

        profileName.setFont(
                font(
                        18,
                        Font.BOLD
                )
        );

        profileName.setForeground(
                TEXT
        );

        JLabel studentType =
                new JLabel(
                        "BSCpE Student"
                );

        studentType.setFont(
                font(
                        11,
                        Font.PLAIN
                )
        );

        studentType.setForeground(
                SECONDARY_TEXT
        );

        info.add(
                profileName
        );

        info.add(
                Box.createVerticalStrut(3)
        );

        info.add(
                studentType
        );

        info.add(
                Box.createVerticalStrut(16)
        );

        JLabel yearLabel =
                new JLabel(
                        "YEAR LEVEL"
                );

        yearLabel.setFont(
                font(
                        10,
                        Font.BOLD
                )
        );

        yearLabel.setForeground(
                SECONDARY_TEXT
        );

        profileYear =
                new JLabel(
                        "-"
                );

        profileYear.setFont(
                font(
                        13,
                        Font.BOLD
                )
        );

        profileYear.setForeground(
                TEXT
        );

        info.add(
                yearLabel
        );

        info.add(
                Box.createVerticalStrut(4)
        );

        info.add(
                profileYear
        );

        body.add(
                info,
                BorderLayout.CENTER
        );

        JButton editButton =
                new JButton(
                        "Edit Profile"
                );

        editButton.setFont(
                font(
                        12,
                        Font.BOLD
                )
        );

        editButton.setForeground(
                BURGUNDY
        );

        editButton.setBackground(
                Color.WHITE
        );

        editButton.setFocusPainted(
                false
        );

        editButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        editButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BURGUNDY
                        ),
                        new EmptyBorder(
                                9,
                                18,
                                9,
                                18
                        )
                )
        );

        editButton.addActionListener(
                e -> openEditProfileDialog()
        );

        JPanel buttonPanel =
                new JPanel(
                        new GridBagLayout()
                );

        buttonPanel.setOpaque(false);

        buttonPanel.add(
                editButton
        );

        body.add(
                buttonPanel,
                BorderLayout.EAST
        );

        card.add(body);

        return card;
    }

    /**
     * Creates the preference controls. Their initial values are currently
     * display-only; changing a checkbox does not persist a setting.
    */
    private JPanel createPreferencesCard() {

        JPanel card =
                createWhiteCard();

        JLabel title =
                new JLabel(
                        "Preferences"
                );

        title.setFont(
                font(
                        18,
                        Font.BOLD
                )
        );

        title.setForeground(
                TEXT
        );

        JLabel description =
                new JLabel(
                        "Customize how Motiva behaves for you."
                );

        description.setFont(
                font(
                        12,
                        Font.PLAIN
                )
        );

        description.setForeground(
                SECONDARY_TEXT
        );

        card.add(title);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(description);

        card.add(
                Box.createVerticalStrut(20)
        );

        card.add(
                createSettingRow(
                        "Task reminders",
                        "Get reminders for upcoming tasks.",
                        true
                )
        );

        card.add(
                Box.createVerticalStrut(12)
        );

        card.add(
                createSettingRow(
                        "Reward system",
                        "Show a reward after completing a task.",
                        true
                )
        );

        card.add(
                Box.createVerticalStrut(12)
        );

        card.add(
                createSettingRow(
                        "Personal tasks",
                        "Include chores, hobbies, and personal plans.",
                        true
                )
        );

        card.add(
                Box.createVerticalStrut(12)
        );

        card.add(
                createSettingRow(
                        "Quiet mode",
                        "Reduce reminders when you need uninterrupted time.",
                        false
                )
        );

        return card;
    }

    /**
     * Copies the current profile into the header, profile card, and sidebar.
     * Missing profiles and blank profile values are rendered with fallbacks.
    */
    private void refreshProfile() {

        Profile profile =
                AppData.profileManager
                        .getProfile();

        if (profile == null) {

            headerName.setText(
                    "No Profile"
            );

            headerDetails.setText(
                    PROGRAM
                            + " • "
                            + "Profile not set"
            );

            headerAvatar.setText(
                    "?"
            );

            profileAvatar.setText(
                    "?"
            );

            profileName.setText(
                    "No profile found"
            );

            profileYear.setText(
                    "-"
            );

            sidebarStudent.setText(
                    "Student • " + PROGRAM
            );

            sidebarYear.setText(
                    "Profile not set"
            );

            return;
        }

        String name =
                safeText(
                        profile.getName()
                );

        String yearLevel =
                safeText(
                        profile.getYearLevel()
                );

        headerName.setText(
                name
        );

        headerDetails.setText(
                PROGRAM
                        + " • "
                        + yearLevel
        );

        headerAvatar.setText(
                getInitial(name)
        );

        profileAvatar.setText(
                getInitial(name)
        );

        profileName.setText(
                name
        );

        profileYear.setText(
                yearLevel
        );

        sidebarStudent.setText(
                name
                        + " • "
                        + PROGRAM
        );

        sidebarYear.setText(
                yearLevel
                        + " Student"
        );
    }

    /**
     * Opens a modal editor for the name and year level. The program is fixed
     * by this screen and is supplied when the profile manager saves changes.
    */
    private void openEditProfileDialog() {

        Profile currentProfile =
                AppData.profileManager
                        .getProfile();

        JDialog dialog =
                new JDialog(
                        this,
                        "Edit Profile",
                        true
                );

        dialog.setSize(
                430,
                350
        );

        dialog.setResizable(false);

        dialog.setLocationRelativeTo(this);

        dialog.setLayout(
                new BorderLayout()
        );

        JPanel dialogHeader =
                new JPanel();

        dialogHeader.setBackground(
                BURGUNDY
        );

        dialogHeader.setLayout(
                new BoxLayout(
                        dialogHeader,
                        BoxLayout.Y_AXIS
                )
        );

        dialogHeader.setBorder(
                new EmptyBorder(
                        20,
                        25,
                        20,
                        25
                )
        );

        JLabel title =
                new JLabel(
                        "Edit Profile"
                );

        title.setForeground(
                Color.WHITE
        );

        title.setFont(
                font(
                        20,
                        Font.BOLD
                )
        );

        JLabel subtitle =
                new JLabel(
                        "Update your student information."
                );

        subtitle.setForeground(
                new Color(
                        235,
                        215,
                        218
                )
        );

        subtitle.setFont(
                font(
                        12,
                        Font.PLAIN
                )
        );

        dialogHeader.add(title);

        dialogHeader.add(
                Box.createVerticalStrut(4)
        );

        dialogHeader.add(subtitle);

        dialog.add(
                dialogHeader,
                BorderLayout.NORTH
        );

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(
                Color.WHITE
        );

        form.setBorder(
                new EmptyBorder(
                        20,
                        25,
                        10,
                        25
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        JLabel nameLabel =
                createFormLabel(
                        "Full Name"
                );

        gbc.gridy = 0;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        5,
                        0
                );

        form.add(
                nameLabel,
                gbc
        );

        JTextField nameField =
                new JTextField();

        nameField.setFont(
                font(
                        13,
                        Font.PLAIN
                )
        );

        nameField.setPreferredSize(
                new Dimension(
                        350,
                        36
                )
        );

        if (currentProfile != null) {

            nameField.setText(
                    safeText(
                            currentProfile.getName()
                    )
            );
        }

        gbc.gridy = 1;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        16,
                        0
                );

        form.add(
                nameField,
                gbc
        );

        JLabel yearLabel =
                createFormLabel(
                        "Year Level"
                );

        gbc.gridy = 2;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        5,
                        0
                );

        form.add(
                yearLabel,
                gbc
        );

        JComboBox<String> yearBox =
                new JComboBox<>(
                        new String[]{
                                "1st Year",
                                "2nd Year",
                                "3rd Year",
                                "4th Year",
                                "5th Year"
                        }
                );

        yearBox.setFont(
                font(
                        13,
                        Font.PLAIN
                )
        );

        yearBox.setPreferredSize(
                new Dimension(
                        350,
                        36
                )
        );

        if (currentProfile != null) {

            String existingYear =
                    currentProfile
                            .getYearLevel();

            if (
                    existingYear != null
                    && !existingYear
                            .trim()
                            .isEmpty()
            ) {

                yearBox.setSelectedItem(
                        existingYear
                );
            }
        }

        gbc.gridy = 3;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        5,
                        0
                );

        form.add(
                yearBox,
                gbc
        );

        dialog.add(
                form,
                BorderLayout.CENTER
        );

        JPanel buttons =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                12
                        )
                );

        buttons.setBackground(
                Color.WHITE
        );

        JButton cancelButton =
                new JButton(
                        "Cancel"
                );

        cancelButton.setFocusPainted(
                false
        );

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );

        JButton saveButton =
                new JButton(
                        "Save Changes"
                );

        saveButton.setForeground(
                Color.WHITE
        );

        saveButton.setBackground(
                BURGUNDY
        );

        saveButton.setFocusPainted(
                false
        );

        saveButton.setBorder(
                new EmptyBorder(
                        9,
                        16,
                        9,
                        16
                )
        );

        saveButton.addActionListener(
                e -> {

                    String name =
                            nameField
                                    .getText()
                                    .trim();

                    String yearLevel =
                            String.valueOf(
                                    yearBox
                                            .getSelectedItem()
                            );

                    if (name.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                dialog,
                                "Please enter your name.",
                                "Invalid Profile",
                                JOptionPane.WARNING_MESSAGE
                        );

                        nameField.requestFocus();

                        return;
                    }

                    boolean saved =
                            AppData.profileManager
                                    .updateProfile(
                                            name,
                                            yearLevel,
                                            PROGRAM
                                    );

                    if (!saved) {

                        JOptionPane.showMessageDialog(
                                dialog,
                                "Unable to save your profile.",
                                "Save Error",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }

                    refreshProfile();

                    dialog.dispose();
                }
        );

        buttons.add(
                cancelButton
        );

        buttons.add(
                saveButton
        );

        dialog.add(
                buttons,
                BorderLayout.SOUTH
        );

        dialog.setVisible(true);
    }

    /** Creates a consistently styled label for the profile editor. */
    private JLabel createFormLabel(
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

    /** Creates a preference row with descriptive text and a checkbox. */
    private JPanel createSettingRow(
            String title,
            String description,
            boolean selected
    ) {

        JPanel row =
                new JPanel(
                        new BorderLayout()
                );

        row.setOpaque(false);

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        55
                )
        );

        JPanel textPanel =
                new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(
                        title
                );

        titleLabel.setFont(
                font(
                        13,
                        Font.BOLD
                )
        );

        titleLabel.setForeground(
                TEXT
        );

        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setFont(
                font(
                        11,
                        Font.PLAIN
                )
        );

        descriptionLabel.setForeground(
                SECONDARY_TEXT
        );

        textPanel.add(
                titleLabel
        );

        textPanel.add(
                Box.createVerticalStrut(3)
        );

        textPanel.add(
                descriptionLabel
        );

        JCheckBox checkBox =
                new JCheckBox();

        checkBox.setSelected(
                selected
        );

        checkBox.setOpaque(false);

        checkBox.setFocusPainted(
                false
        );

        row.add(
                textPanel,
                BorderLayout.WEST
        );

        row.add(
                checkBox,
                BorderLayout.EAST
        );

        return row;
    }

    /** Creates the shared white panel used for settings content sections. */
    private JPanel createWhiteCard() {

        JPanel card =
                new JPanel();

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                22,
                                24,
                                22,
                                24
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return card;
    }

    /** Returns the first uppercase character of a name, or '?' if unavailable. */
    private String getInitial(
            String name
    ) {

        if (
                name == null
                || name.trim().isEmpty()
                || name.equals("-")
        ) {

            return "?";
        }

        return name
                .trim()
                .substring(
                        0,
                        1
                )
                .toUpperCase();
    }

    /** Trims profile text and converts null or blank values to a display dash. */
    private String safeText(
            String value
    ) {

        if (
                value == null
                || value.trim().isEmpty()
        ) {

            return "-";
        }

        return value.trim();
    }

    /**
     * Creates a sidebar button and routes supported destinations through the
     * shared navigation helper. The settings destination is intentionally inert.
    */
    private JButton createNavButton(
            String text,
            boolean active
    ) {

        JButton button =
                new JButton(
                        text
                );

        button.setFont(
                font(
                        13,
                        Font.BOLD
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFocusPainted(
                false
        );

        button.setBorderPainted(
                false
        );

        button.setOpaque(
                true
        );

        button.setMaximumSize(
                new Dimension(
                        200,
                        42
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        if (active) {

            button.setBackground(
                    new Color(
                            0x7A,
                            0x32,
                            0x40
                    )
            );

            button.setForeground(
                    Color.WHITE
            );

        } else {

            button.setBackground(
                    BURGUNDY
            );

            button.setForeground(
                    new Color(
                            235,
                            215,
                            218
                    )
            );
        }

        button.setBorder(
                new EmptyBorder(
                        10,
                        12,
                        10,
                        12
                )
        );

        button.addActionListener(
                event -> {

                    if (
                            text.contains(
                                    "Dashboard"
                            )
                            || text.contains(
                                    "My Tasks"
                            )
                    ) {

                        MotivaNavigation
                                .goToDashboard(
                                        this
                                );

                    } else if (
                            text.contains(
                                    "Schedule"
                            )
                    ) {

                        MotivaNavigation
                                .goToSchedule(
                                        this
                                );

                    } else if (
                            text.contains(
                                    "Rewards"
                            )
                    ) {

                        MotivaNavigation
                                .goToRewards(
                                        this
                                );
                    }
                }
        );

        return button;
    }

    /** Starts the Swing window on the event dispatch thread. */
    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    MotivaSettings window =
                            new MotivaSettings();

                    window.setVisible(true);
                }
        );
    }
}