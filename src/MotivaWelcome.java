package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MotivaWelcome extends JFrame {

    // =========================
    // MOTIVA COLORS
    // =========================

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

    private static final Color BORDER =
            new Color(0xE4, 0xE2, 0xE0);

    private static final Color LIGHT_BURGUNDY =
            new Color(0xF4, 0xE7, 0xE9);


    // =========================
    // FONTS
    // =========================

    private static final Font FONT =
            new Font("Inter", Font.PLAIN, 14);

    private static final Font FONT_BOLD =
            new Font("Inter", Font.BOLD, 14);

    private static final Font FONT_TITLE =
            new Font("Inter", Font.BOLD, 34);

    private static final Font FONT_SMALL =
            new Font("Inter", Font.PLAIN, 12);


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public MotivaWelcome() {

        setTitle("Motiva — Welcome");

        setSize(1280, 800);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        JPanel root =
                new JPanel(new BorderLayout());

        root.setBackground(BACKGROUND);

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


    // ============================================================
    // LEFT PANEL
    // ============================================================

    private JPanel createLeftPanel() {

        JPanel panel =
                new JPanel();

        panel.setPreferredSize(
                new Dimension(470, 800)
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
                        55,
                        55,
                        55,
                        55
                )
        );


        // =========================
        // LOGO
        // =========================

        JLabel logo =
                new JLabel("Motiva");

        logo.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        32
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
                new Color(235, 220, 222)
        );

        logoSubtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        panel.add(logo);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(logoSubtitle);


        panel.add(
                Box.createVerticalGlue()
        );


        // =========================
        // MAIN MESSAGE
        // =========================

        JLabel message =
                new JLabel(
                        "<html><div style='text-align:center'>" +
                        "Make progress.<br>" +
                        "Stay motivated.<br>" +
                        "Reward yourself." +
                        "</div></html>"
                );

        message.setFont(
                new Font(
                        "Inter",
                        Font.BOLD,
                        30
                )
        );

        message.setForeground(
                Color.WHITE
        );

        message.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(message);


        panel.add(
                Box.createVerticalStrut(20)
        );


        JLabel description =
                new JLabel(
                        "<html><div style='text-align:center'>" +
                        "A simple space to organize your tasks,<br>" +
                        "manage your time, and keep yourself going." +
                        "</div></html>"
                );

        description.setFont(
                FONT
        );

        description.setForeground(
                new Color(235, 220, 222)
        );

        description.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(description);


        panel.add(
                Box.createVerticalGlue()
        );


        // =========================
        // FOOTER
        // =========================

        JLabel footer =
                new JLabel(
                        "Built for BSCpE students"
                );

        footer.setFont(
                FONT_SMALL
        );

        footer.setForeground(
                new Color(235, 220, 222)
        );

        footer.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(footer);


        return panel;
    }


    // ============================================================
    // RIGHT PANEL
    // ============================================================

    private JPanel createRightPanel() {

        JPanel panel =
                new JPanel();

        panel.setBackground(
                BACKGROUND
        );

        panel.setLayout(
                new GridBagLayout()
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

        content.setPreferredSize(
                new Dimension(
                        470,
                        560
                )
        );


        // =========================
        // TITLE
        // =========================

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
                        "Let's set up your student profile."
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


        content.add(title);

        content.add(
                Box.createVerticalStrut(8)
        );

        content.add(subtitle);


        content.add(
                Box.createVerticalStrut(32)
        );


        // =========================
        // NAME
        // =========================

        content.add(
                createLabel("Name")
        );


        JTextField name =
                new JTextField();

        name.setFont(FONT);

        name.setForeground(TEXT);

        name.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                11,
                                12,
                                11,
                                12
                        )
                )
        );

        name.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );


        content.add(name);


        content.add(
                Box.createVerticalStrut(20)
        );


        // =========================
        // PROGRAM
        // =========================

        content.add(
                createLabel("Program")
        );


        JComboBox<String> program =
                new JComboBox<>(
                        new String[]{
                                "BSCpE"
                        }
                );

        program.setFont(FONT);

        program.setForeground(TEXT);

        program.setBackground(
                Color.WHITE
        );

        program.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        program.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );


        content.add(program);


        content.add(
                Box.createVerticalStrut(20)
        );


        // =========================
        // YEAR LEVEL
        // =========================

        content.add(
                createLabel("Year level")
        );


        JComboBox<String> yearLevel =
                new JComboBox<>(
                        new String[]{
                                "1st Year",
                                "2nd Year",
                                "3rd Year",
                                "4th Year",
                                "5th Year"
                        }
                );

        yearLevel.setFont(FONT);

        yearLevel.setForeground(TEXT);

        yearLevel.setBackground(
                Color.WHITE
        );

        yearLevel.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        yearLevel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );


        content.add(yearLevel);


        content.add(
                Box.createVerticalStrut(30)
        );


        // =========================
        // ENTER MOTIVA BUTTON
        // =========================

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

        enterButton.setFocusPainted(false);

        enterButton.setBorderPainted(false);

        enterButton.setOpaque(true);

        enterButton.setBorder(
                new EmptyBorder(
                        13,
                        25,
                        13,
                        25
                )
        );

        enterButton.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        content.add(enterButton);


        content.add(
                Box.createVerticalStrut(15)
        );


        JLabel note =
                new JLabel(
                );

        note.setFont(FONT_SMALL);

        note.setForeground(
                SECONDARY_TEXT
        );

        note.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        content.add(note);


        panel.add(content);

        return panel;
    }


    // ============================================================
    // LABEL
    // ============================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(FONT_BOLD);

        label.setForeground(TEXT);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        label.setBorder(
                new EmptyBorder(
                        0,
                        0,
                        7,
                        0
                )
        );

        return label;
    }


    // ============================================================
    // MAIN
    // ============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(() -> {

            MotivaWelcome app =
                    new MotivaWelcome();

            app.setVisible(true);
        });
    }
}
