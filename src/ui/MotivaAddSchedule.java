import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Schedule;
import model.Task;
import service.AppData;

/** Form for adding an entry to the schedule. */
public class MotivaAddSchedule extends JFrame {


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
            new Color(0xF2, 0xE7, 0xE9);


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
                    26
            );

    private static final Font FONT_SMALL =
            new Font(
                    "Inter",
                    Font.PLAIN,
                    12
            );


    private JRadioButton taskOption;
    private JRadioButton eventOption;

    private JPanel taskPanel;
    private JPanel eventPanel;

    private JComboBox<Task> taskComboBox;

    private JTextField eventTitleField;

    private JTextField dateField;
    private JTextField timeField;

    private JComboBox<String> categoryComboBox;
    private JComboBox<String> priorityComboBox;

    private JTextArea notesArea;


    public MotivaAddSchedule() {

        setTitle(
                "Motiva — Add Schedule"
        );

        setSize(
                650,
                720
        );

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
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
                createHeader(),
                BorderLayout.NORTH
        );

        root.add(
                createForm(),
                BorderLayout.CENTER
        );

        root.add(
                createBottomButtons(),
                BorderLayout.SOUTH
        );

        setContentPane(root);

        loadTasks();

        updateFormVisibility();
    }


    private JPanel createHeader() {

        JPanel header =
                new JPanel();

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        header.setBackground(
                Color.WHITE
        );

        header.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        20,
                        30
                )
        );

        JLabel title =
                new JLabel(
                        "Add to Schedule"
                );

        title.setFont(
                FONT_TITLE
        );

        title.setForeground(
                TEXT
        );

        JLabel subtitle =
                new JLabel(
                        "Add a task or a separate event to your schedule."
                );

        subtitle.setFont(
                FONT
        );

        subtitle.setForeground(
                SECONDARY_TEXT
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(5)
        );

        header.add(subtitle);

        return header;
    }


    private JPanel createForm() {

        JPanel outer =
                new JPanel(
                        new BorderLayout()
                );

        outer.setBackground(
                BACKGROUND
        );

        outer.setBorder(
                new EmptyBorder(
                        20,
                        30,
                        10,
                        30
                )
        );

        JPanel form =
                new JPanel();

        form.setLayout(
                new BoxLayout(
                        form,
                        BoxLayout.Y_AXIS
                )
        );

        form.setBackground(
                Color.WHITE
        );

        form.setBorder(
                new EmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );


        JLabel typeLabel =
                createLabel(
                        "What do you want to add?"
                );

        form.add(typeLabel);

        form.add(
                Box.createVerticalStrut(10)
        );

        JPanel typePanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        typePanel.setOpaque(false);

        taskOption =
                new JRadioButton(
                        "Task"
                );

        eventOption =
                new JRadioButton(
                        "Event / Other"
                );

        styleRadioButton(
                taskOption
        );

        styleRadioButton(
                eventOption
        );

        ButtonGroup typeGroup =
                new ButtonGroup();

        typeGroup.add(taskOption);
        typeGroup.add(eventOption);

        taskOption.setSelected(true);

        taskOption.addActionListener(
                e -> updateFormVisibility()
        );

        eventOption.addActionListener(
                e -> updateFormVisibility()
        );

        typePanel.add(taskOption);
        typePanel.add(eventOption);

        form.add(typePanel);

        form.add(
                Box.createVerticalStrut(20)
        );


        taskPanel =
                new JPanel();

        taskPanel.setLayout(
                new BoxLayout(
                        taskPanel,
                        BoxLayout.Y_AXIS
                )
        );

        taskPanel.setOpaque(false);

        JLabel taskLabel =
                createLabel(
                        "Select Task"
                );

        taskComboBox =
                new JComboBox<>();

        styleComboBox(
                taskComboBox
        );

        taskPanel.add(taskLabel);

        taskPanel.add(
                Box.createVerticalStrut(7)
        );

        taskPanel.add(
                taskComboBox
        );

        form.add(taskPanel);


        eventPanel =
                new JPanel();

        eventPanel.setLayout(
                new BoxLayout(
                        eventPanel,
                        BoxLayout.Y_AXIS
                )
        );

        eventPanel.setOpaque(false);

        JLabel eventTitleLabel =
                createLabel(
                        "Event Title"
                );

        eventTitleField =
                new JTextField();

        styleTextField(
                eventTitleField
        );

        eventPanel.add(
                eventTitleLabel
        );

        eventPanel.add(
                Box.createVerticalStrut(7)
        );

        eventPanel.add(
                eventTitleField
        );

        eventPanel.add(
                Box.createVerticalStrut(15)
        );

        form.add(eventPanel);


        JLabel dateLabel =
                createLabel(
                        "Date"
                );

        dateField =
                new JTextField();

        dateField.setText(
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern(
                                "MMMM d, yyyy"
                        )
                )
        );

        styleTextField(
                dateField
        );

        form.add(
                dateLabel
        );

        form.add(
                Box.createVerticalStrut(7)
        );

        form.add(
                dateField
        );

        form.add(
                Box.createVerticalStrut(15)
        );


        JLabel timeLabel =
                createLabel(
                        "Time"
                );

        timeField =
                new JTextField();

        timeField.setText(
                "10:00 AM"
        );

        styleTextField(
                timeField
        );

        form.add(
                timeLabel
        );

        form.add(
                Box.createVerticalStrut(7)
        );

        form.add(
                timeField
        );

        form.add(
                Box.createVerticalStrut(15)
        );


        JLabel categoryLabel =
                createLabel(
                        "Category"
                );

        categoryComboBox =
                new JComboBox<>(
                        new String[]{
                                "School",
                                "Personal",
                                "Study",
                                "Other"
                        }
                );

        styleComboBox(
                categoryComboBox
        );

        form.add(
                categoryLabel
        );

        form.add(
                Box.createVerticalStrut(7)
        );

        form.add(
                categoryComboBox
        );

        form.add(
                Box.createVerticalStrut(15)
        );


        JLabel priorityLabel =
                createLabel(
                        "Priority"
                );

        priorityComboBox =
                new JComboBox<>(
                        new String[]{
                                "Low",
                                "Medium",
                                "High"
                        }
                );

        styleComboBox(
                priorityComboBox
        );

        priorityComboBox.setSelectedItem(
                "Medium"
        );

        form.add(
                priorityLabel
        );

        form.add(
                Box.createVerticalStrut(7)
        );

        form.add(
                priorityComboBox
        );

        form.add(
                Box.createVerticalStrut(15)
        );


        JLabel notesLabel =
                createLabel(
                        "Notes"
                );

        notesArea =
                new JTextArea(
                        4,
                        20
                );

        notesArea.setFont(
                FONT
        );

        notesArea.setForeground(
                TEXT
        );

        notesArea.setLineWrap(true);

        notesArea.setWrapStyleWord(true);

        notesArea.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                8,
                                10,
                                8,
                                10
                        )
                )
        );

        JScrollPane notesScroll =
                new JScrollPane(
                        notesArea
                );

        notesScroll.setBorder(null);

        form.add(
                notesLabel
        );

        form.add(
                Box.createVerticalStrut(7)
        );

        form.add(
                notesScroll
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        form
                );

        scrollPane.setBorder(null);

        scrollPane.setBackground(
                BACKGROUND
        );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        outer.add(
                scrollPane,
                BorderLayout.CENTER
        );

        return outer;
    }


    private void loadTasks() {

        taskComboBox.removeAllItems();

        ArrayList<Task> tasks =
                AppData.taskManager.getTasks();

        for (
                Task task :
                tasks
        ) {

            if (!task.isCompleted()) {

                taskComboBox.addItem(
                        task
                );
            }
        }

        if (
                taskComboBox.getItemCount()
                        == 0
        ) {

            taskComboBox.addItem(
                    null
            );
        }

        taskComboBox.setRenderer(
                new DefaultListCellRenderer() {

                    @Override
                    public Component getListCellRendererComponent(
                            JList<?> list,
                            Object value,
                            int index,
                            boolean isSelected,
                            boolean cellHasFocus
                    ) {

                        super.getListCellRendererComponent(
                                list,
                                value,
                                index,
                                isSelected,
                                cellHasFocus
                        );

                        if (value instanceof Task) {

                            Task task =
                                    (Task) value;

                            setText(
                                    task.getTitle()
                                            + " (ID "
                                            + task.getId()
                                            + ")"
                            );

                        } else {

                            setText(
                                    "No incomplete tasks available"
                            );
                        }

                        return this;
                    }
                }
        );
    }


    private void updateFormVisibility() {

        if (taskPanel == null) {
            return;
        }

        boolean isTask =
                taskOption.isSelected();

        taskPanel.setVisible(
                isTask
        );

        eventPanel.setVisible(
                !isTask
        );

        revalidate();

        repaint();
    }


    private JPanel createBottomButtons() {

        JPanel bottom =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                15
                        )
                );

        bottom.setBackground(
                Color.WHITE
        );

        bottom.setBorder(
                new EmptyBorder(
                        0,
                        30,
                        10,
                        30
                )
        );

        JButton cancel =
                new JButton(
                        "Cancel"
                );

        styleSecondaryButton(
                cancel
        );

        cancel.addActionListener(
                e -> dispose()
        );

        JButton save =
                new JButton(
                        "Save Schedule"
                );

        stylePrimaryButton(
                save
        );

        save.addActionListener(
                e -> saveSchedule()
        );

        bottom.add(cancel);

        bottom.add(save);

        return bottom;
    }


    private void saveSchedule() {

        String date =
                dateField.getText().trim();

        String time =
                timeField.getText().trim();

        String category =
                (String)
                        categoryComboBox
                                .getSelectedItem();

        String priority =
                (String)
                        priorityComboBox
                                .getSelectedItem();

        String notes =
                notesArea.getText().trim();


        if (date.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a date.",
                    "Missing Date",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        if (time.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a time.",
                    "Missing Time",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        if (taskOption.isSelected()) {

            Task selectedTask =
                    (Task)
                            taskComboBox
                                    .getSelectedItem();

            if (selectedTask == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a task.",
                        "No Task Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int scheduleId =
                    AppData.scheduleManager
                            .getNextScheduleId();

            Schedule schedule =
                    new Schedule(
                            scheduleId,
                            selectedTask.getTitle(),
                            category,
                            date,
                            time,
                            priority,
                            "TASK",
                            "TASK",
                            selectedTask.getId(),
                            notes
                    );

            AppData.scheduleManager
                    .addSchedule(
                            schedule
                    );

            JOptionPane.showMessageDialog(
                    this,
                    "Task added to your schedule!",
                    "Schedule Added",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }


        else {

            String eventTitle =
                    eventTitleField
                            .getText()
                            .trim();

            if (eventTitle.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter an event title.",
                        "Missing Event Title",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int scheduleId =
                    AppData.scheduleManager
                            .getNextScheduleId();

            Schedule schedule =
                    new Schedule(
                            scheduleId,
                            eventTitle,
                            category,
                            date,
                            time,
                            priority,
                            "EVENT",
                            "EVENT",
                            null,
                            notes
                    );

            AppData.scheduleManager
                    .addSchedule(
                            schedule
                    );

            JOptionPane.showMessageDialog(
                    this,
                    "Event added to your schedule!",
                    "Schedule Added",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        dispose();
    }


    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                FONT_BOLD
        );

        label.setForeground(
                TEXT
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }


    private void styleTextField(
            JTextField field
    ) {

        field.setFont(
                FONT
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
                                10,
                                9,
                                10
                        )
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );
    }


    private void styleComboBox(
            JComboBox<?> comboBox
    ) {

        comboBox.setFont(
                FONT
        );

        comboBox.setForeground(
                TEXT
        );

        comboBox.setBackground(
                Color.WHITE
        );

        comboBox.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );
    }


    private void styleRadioButton(
            JRadioButton button
    ) {

        button.setFont(
                FONT_BOLD
        );

        button.setForeground(
                TEXT
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    private void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(
                FONT_BOLD
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                BURGUNDY
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setOpaque(true);

        button.setBorder(
                new EmptyBorder(
                        11,
                        20,
                        11,
                        20
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    private void styleSecondaryButton(
            JButton button
    ) {

        button.setFont(
                FONT_BOLD
        );

        button.setForeground(
                BURGUNDY
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                9,
                                18,
                                9,
                                18
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    MotivaAddSchedule app =
                            new MotivaAddSchedule();

                    app.setVisible(true);
                }
        );
    }
}