import model.Profile;
import service.AppData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Welcomes the student to Motiva and gathers the basic profile details needed
 * before they can enter the rest of the application.
 *
 * This screen introduces the app, captures the student's name and year level,
 * saves the information locally, and then opens the dashboard when the user is
 * ready to continue.
 */
public class MotivaWelcome extends JFrame {


    private static final Color BURGUNDY =
            new Color(0x62, 0x24, 0x2F);

    private static final Color DEEP_BURGUNDY =
            new Color(0x46, 0x19, 0x21);

    private static final Color BACKGROUND =
            new Color(0xFA, 0xF7, 0xF3);

    private static final Color WHITE =
            Color.WHITE;

    private static final Color TEXT =
            new Color(0x1F, 0x24, 0x2B);

    private static final Color SECONDARY_TEXT =
            new Color(0x67, 0x6E, 0x78);

    private static final Color BORDER =
            new Color(0xE4, 0xE2, 0xE0);

    private static final Color LIGHT_BURGUNDY =
            new Color(0xF4, 0xE7, 0xE9);

    private static final Color SOFT_WHITE =
            new Color(0xFC, 0xF8, 0xF8);



    private static final Font FONT =
            new Font(
                    "Inter",
                    Font.PLAIN,
                    14
            );

    private static final Font FONT_BOLD =
            new Font(
                    "Inter",
                    Font.BOLD,
                    14
            );

    private static final Font FONT_TITLE =
            new Font(
                    "Inter",
                    Font.BOLD,
                    34
            );

    private static final Font FONT_SECTION =
            new Font(
                    "Inter",
                    Font.BOLD,
                    12
            );

    private static final Font FONT_SMALL =
            new Font(
                    "Inter",
                    Font.PLAIN,
                    12
            );

    private static final Font FONT_PROGRAM =
            new Font(
                    "Inter",
                    Font.BOLD,
                    18
            );



    /**
     * Builds the welcome screen and arranges the branding, onboarding content,
     * and profile form into a polished single-page layout.
     */
    public MotivaWelcome() {

        setTitle(
                "Motiva — Welcome"
        );

        setSize(
                1280,
                800
        );

        setMinimumSize(
                new Dimension(
                        1100,
                        700
                )
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        JPanel root =
                new JPanel(
                        new BorderLayout()
                );

        root.setBackground(
                BACKGROUND
        );

        root.add(
                createLeftPanel(),
                BorderLayout.WEST
        );

        root.add(
                createRightPanel(),
                BorderLayout.CENTER
        );

        setContentPane(root);
    }



    /**
     * Creates the left side of the welcome screen, which carries the app's brand,
     * motivational messaging, and the short benefits summary for students.
     */
    private JPanel createLeftPanel() {

        JPanel panel =
                new JPanel();

        panel.setPreferredSize(
                new Dimension(
                        480,
                        800
                )
        );

        panel.setBackground(
                BURGUNDY
        );

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        48,
                        48,
                        42,
                        48
                )
        );



        JLabel logo =
                new JLabel(
                        "Motiva"
                );

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        34
                )
        );

        logo.setForeground(
                Color.WHITE
        );

        logo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel logoSubtitle =
                new JLabel(
                        "Student Motivation System"
                );

        logoSubtitle.setFont(
                FONT_SMALL
        );

        logoSubtitle.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        logoSubtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(
                logo
        );

        panel.add(
                Box.createVerticalStrut(
                        5
                )
        );

        panel.add(
                logoSubtitle
        );



        panel.add(
                Box.createVerticalGlue()
        );


        JLabel smallHeading =
                new JLabel(
                        "YOUR PROGRESS STARTS HERE"
                );

        smallHeading.setFont(
                FONT_SECTION
        );

        smallHeading.setForeground(
                new Color(
                        220,
                        194,
                        199
                )
        );

        smallHeading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(
                smallHeading
        );

        panel.add(
                Box.createVerticalStrut(
                        14
                )
        );


        JLabel mainMessage =
                new JLabel(
                        "<html>" +
                        "Make progress.<br>" +
                        "Stay motivated.<br>" +
                        "Reward yourself." +
                        "</html>"
                );

        mainMessage.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        34
                )
        );

        mainMessage.setForeground(
                Color.WHITE
        );

        mainMessage.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(
                mainMessage
        );


        panel.add(
                Box.createVerticalStrut(
                        18
                )
        );


        JLabel description =
                new JLabel(
                        "<html>" +
                        "A simple space to organize your tasks,<br>" +
                        "manage your time, and keep yourself going." +
                        "</html>"
                );

        description.setFont(
                FONT
        );

        description.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        description.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(
                description
        );


        panel.add(
                Box.createVerticalStrut(
                        30
                )
        );



        JPanel cardsPanel =
                new JPanel();

        cardsPanel.setOpaque(
                false
        );

        cardsPanel.setLayout(
                new BoxLayout(
                        cardsPanel,
                        BoxLayout.Y_AXIS
                )
        );

        cardsPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        cardsPanel.add(
                createMotivationCard(
                        "01",
                        "Organize",
                        "Keep your tasks in one place."
                )
        );

        cardsPanel.add(
                Box.createVerticalStrut(
                        10
                )
        );

        cardsPanel.add(
                createMotivationCard(
                        "02",
                        "Focus",
                        "Plan your time and stay on track."
                )
        );

        cardsPanel.add(
                Box.createVerticalStrut(
                        10
                )
        );

        cardsPanel.add(
                createMotivationCard(
                        "03",
                        "Reward",
                        "Celebrate every completed goal."
                )
        );


        panel.add(
                cardsPanel
        );


        panel.add(
                Box.createVerticalGlue()
        );



        JLabel footer =
                new JLabel(
                        "Built exclusively for BSCpE students"
                );

        footer.setFont(
                FONT_SMALL
        );

        footer.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );

        footer.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(
                footer
        );


        return panel;
    }



    private JPanel createMotivationCard(
            String number,
            String title,
            String description
    ) {

        JPanel card =
                new RoundedPanel(
                        14,
                        new Color(
                                255,
                                255,
                                255,
                                22
                        )
                );

        card.setLayout(
                new BorderLayout(
                        14,
                        0
                )
        );

        card.setBorder(
                new EmptyBorder(
                        13,
                        15,
                        13,
                        15
                )
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        65
                )
        );

        card.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel numberLabel =
                new JLabel(
                        number
                );

        numberLabel.setFont(
                FONT_SECTION
        );

        numberLabel.setForeground(
                new Color(
                        225,
                        190,
                        196
                )
        );

        numberLabel.setPreferredSize(
                new Dimension(
                        25,
                        30
                )
        );


        card.add(
                numberLabel,
                BorderLayout.WEST
        );


        JPanel textPanel =
                new JPanel();

        textPanel.setOpaque(
                false
        );

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
                FONT_BOLD
        );

        titleLabel.setForeground(
                Color.WHITE
        );


        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setFont(
                FONT_SMALL
        );

        descriptionLabel.setForeground(
                new Color(
                        235,
                        220,
                        222
                )
        );


        textPanel.add(
                titleLabel
        );

        textPanel.add(
                Box.createVerticalStrut(
                        2
                )
        );

        textPanel.add(
                descriptionLabel
        );


        card.add(
                textPanel,
                BorderLayout.CENTER
        );


        return card;
    }



    /**
     * Creates the right side of the welcome screen, where the student enters
     * their profile information and confirms that they are ready to continue.
     */
    private JPanel createRightPanel() {

        JPanel panel =
                new JPanel(
                        new GridBagLayout()
                );

        panel.setBackground(
                BACKGROUND
        );

        panel.setBorder(
                new EmptyBorder(
                        45,
                        55,
                        45,
                        55
                )
        );


        JPanel content =
                new JPanel();

        content.setOpaque(
                false
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setPreferredSize(
                new Dimension(
                        500,
                        600
                )
        );



        JLabel title =
                new JLabel(
                        "Welcome to Motiva"
                );

        title.setFont(
                FONT_TITLE
        );

        title.setForeground(
                TEXT
        );

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel subtitle =
                new JLabel(
                        "Let's get your student profile ready."
                );

        subtitle.setFont(
                FONT
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        content.add(
                title
        );

        content.add(
                Box.createVerticalStrut(
                        7
                )
        );

        content.add(
                subtitle
        );


        content.add(
                Box.createVerticalStrut(
                        25
                )
        );



        RoundedPanel profileCard =
                new RoundedPanel(
                        20,
                        WHITE
                );

        profileCard.setLayout(
                new BoxLayout(
                        profileCard,
                        BoxLayout.Y_AXIS
                )
        );

        profileCard.setBorder(
                new EmptyBorder(
                        28,
                        30,
                        30,
                        30
                )
        );

        profileCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );



        JLabel profileHeading =
                new JLabel(
                        "YOUR PROFILE"
                );

        profileHeading.setFont(
                FONT_SECTION
        );

        profileHeading.setForeground(
                BURGUNDY
        );

        profileHeading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel profileSubheading =
                new JLabel(
                        "Tell us a little about yourself."
                );

        profileSubheading.setFont(
                FONT_SMALL
        );

        profileSubheading.setForeground(
                SECONDARY_TEXT
        );

        profileSubheading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        profileCard.add(
                profileHeading
        );

        profileCard.add(
                Box.createVerticalStrut(
                        5
                )
        );

        profileCard.add(
                profileSubheading
        );


        profileCard.add(
                Box.createVerticalStrut(
                        25
                )
        );



        JLabel nameLabel =
                createSectionLabel(
                        "NAME"
                );

        profileCard.add(
                nameLabel
        );


        profileCard.add(
                Box.createVerticalStrut(
                        7
                )
        );


        JTextField name =
                new JTextField();

        name.setFont(
                FONT
        );

        name.setForeground(
                TEXT
        );

        name.setBackground(
                SOFT_WHITE
        );

        name.setCaretColor(
                BURGUNDY
        );

        name.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                11,
                                13,
                                11,
                                13
                        )
                )
        );

        name.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );

        name.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        profileCard.add(
                name
        );


        profileCard.add(
                Box.createVerticalStrut(
                        23
                )
        );



        JLabel programLabel =
                createSectionLabel(
                        "PROGRAM"
                );

        profileCard.add(
                programLabel
        );


        profileCard.add(
                Box.createVerticalStrut(
                        8
                )
        );


        JPanel programPanel =
                new RoundedPanel(
                        12,
                        LIGHT_BURGUNDY
                );

        programPanel.setLayout(
                new BoxLayout(
                        programPanel,
                        BoxLayout.Y_AXIS
                )
        );

        programPanel.setBorder(
                new EmptyBorder(
                        12,
                        14,
                        12,
                        14
                )
        );

        programPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        67
                )
        );

        programPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel programCode =
                new JLabel(
                        "BSCpE"
                );

        programCode.setFont(
                FONT_PROGRAM
        );

        programCode.setForeground(
                BURGUNDY
        );


        JLabel programName =
                new JLabel(
                        "Bachelor of Science in Computer Engineering"
                );

        programName.setFont(
                FONT_SMALL
        );

        programName.setForeground(
                SECONDARY_TEXT
        );


        programPanel.add(
                programCode
        );

        programPanel.add(
                Box.createVerticalStrut(
                        2
                )
        );

        programPanel.add(
                programName
        );


        profileCard.add(
                programPanel
        );


        profileCard.add(
                Box.createVerticalStrut(
                        23
                )
        );



        JLabel yearLabel =
                createSectionLabel(
                        "YEAR LEVEL"
                );

        profileCard.add(
                yearLabel
        );


        profileCard.add(
                Box.createVerticalStrut(
                        7
                )
        );


        JComboBox<String> yearLevel =
                new JComboBox<>(
                        new String[]{
                                "1st Year",
                                "2nd Year",
                                "3rd Year",
                                "4th Year"
                        }
                );

        yearLevel.setFont(
                FONT
        );

        yearLevel.setForeground(
                TEXT
        );

        yearLevel.setBackground(
                SOFT_WHITE
        );

        yearLevel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );

        yearLevel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        profileCard.add(
                yearLevel
        );


        profileCard.add(
                Box.createVerticalStrut(
                        25
                )
        );



        JSeparator separator =
                new JSeparator();

        separator.setForeground(
                BORDER
        );

        separator.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        1
                )
        );

        separator.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        profileCard.add(
                separator
        );


        profileCard.add(
                Box.createVerticalStrut(
                        20
                )
        );



        // Validates the entered student information, saves it locally, and opens
        // the main dashboard when the user has completed the onboarding form.
        JButton enterButton =
                new JButton(
                        "Enter Motiva"
                );

        enterButton.setFont(
                FONT_BOLD
        );

        enterButton.setForeground(
                Color.WHITE
        );

        enterButton.setBackground(
                BURGUNDY
        );

        enterButton.setFocusPainted(
                false
        );

        enterButton.setBorderPainted(
                false
        );

        enterButton.setOpaque(
                true
        );

        enterButton.setBorder(
                new EmptyBorder(
                        13,
                        25,
                        13,
                        25
                )
        );

        enterButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        enterButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );

        enterButton.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );



        enterButton.addActionListener(
                event -> {

                    String studentName =
                            name.getText().trim();

                    String selectedYearLevel =
                            (String)
                                    yearLevel.getSelectedItem();



                    if (studentName.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please enter your name.",
                                "Profile Required",
                                JOptionPane.WARNING_MESSAGE
                        );

                        name.requestFocus();

                        return;
                    }


                    if (selectedYearLevel == null) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Please select your year level.",
                                "Profile Required",
                                JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }



                    boolean saved =
                            AppData.profileManager
                                    .updateProfile(
                                            studentName,
                                            "BSCpE",
                                            selectedYearLevel
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



                    Profile profile =
                            AppData.profileManager
                                    .getProfile();


                    System.out.println(
                            "Profile created:"
                    );

                    System.out.println(
                            "Name: "
                                    + profile.getName()
                    );

                    System.out.println(
                            "Program: "
                                    + profile.getProgram()
                    );

                    System.out.println(
                            "Year Level: "
                                    + profile.getYearLevel()
                    );



                    SwingUtilities.invokeLater(
                            () -> {

                                try {

                                    MotivaDashboard dashboard =
                                            new MotivaDashboard();

                                    dashboard.setVisible(
                                            true
                                    );

                                    dispose();

                                } catch (Exception e) {

                                    e.printStackTrace();

                                    JOptionPane.showMessageDialog(
                                            this,
                                            "Profile saved successfully, " +
                                            "but the dashboard could not be opened.",
                                            "Navigation Error",
                                            JOptionPane.ERROR_MESSAGE
                                    );
                                }
                            }
                    );
                }
        );


        profileCard.add(
                enterButton
        );



        profileCard.add(
                Box.createVerticalStrut(
                        12
                )
        );


        JLabel localNote =
                new JLabel(
                        "Your profile is saved locally on this computer."
                );

        localNote.setFont(
                FONT_SMALL
        );

        localNote.setForeground(
                SECONDARY_TEXT
        );

        localNote.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        profileCard.add(
                localNote
        );


        content.add(
                profileCard
        );



        content.add(
                Box.createVerticalStrut(
                        17
                )
        );


        JLabel bottomText =
                new JLabel(
                        "Your journey starts with one small step."
                );

        bottomText.setFont(
                FONT_SMALL
        );

        bottomText.setForeground(
                SECONDARY_TEXT
        );

        bottomText.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        content.add(
                bottomText
        );


        panel.add(
                content
        );


        return panel;
    }



    /**
     * Reusable label style used for small field headings such as name, program,
     * and year level within the profile form.
     */
    private JLabel createSectionLabel(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );

        label.setFont(
                FONT_SECTION
        );

        label.setForeground(
                SECONDARY_TEXT
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }



    /**
     * A lightweight helper panel that draws rounded corners so the interface can
     * maintain a softer, more modern visual design without relying on external
     * libraries.
     */
    private static class RoundedPanel
            extends JPanel {

    private final int radius;
    private final Color backgroundColor;


    public RoundedPanel(
                int radius,
                Color backgroundColor
        ) {

            this.radius =
                    radius;

            this.backgroundColor =
                    backgroundColor;

            setOpaque(
                    false
            );
        }


        @Override
    protected void paintComponent(
                Graphics graphics
        ) {

            Graphics2D g2 =
                    (Graphics2D)
                            graphics.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(
                    backgroundColor
            );

            g2.fill(
                    new RoundRectangle2D.Float(
                            0,
                            0,
                            getWidth(),
                            getHeight(),
                            radius,
                            radius
                    )
            );

            g2.dispose();

            super.paintComponent(
                    graphics
            );
        }
    }



    /**
     * Starts the application by opening the welcome screen in the Swing event
     * dispatch thread, which is the standard way to launch a desktop UI safely.
     */
    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    MotivaWelcome app =
                            new MotivaWelcome();

                    app.setVisible(
                            true
                    );
                }
        );
    }
}