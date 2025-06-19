package ui;

import model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel {

    private final Task task;
    private final JLabel nameLabel;
    private final JLabel statusLabel;

    public TaskPanel(Task task) {
        this.task = task;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        setPreferredSize(new Dimension(300, 50));

        nameLabel = new JLabel(task.getName());
        statusLabel = new JLabel(getStatusText());

        add(nameLabel, BorderLayout.WEST);
        add(statusLabel, BorderLayout.EAST);
    }

    private String getStatusText() {
        if (task.isCompleted()) return "Completed";
        if (task.isRunning()) return "Running";
        return "Pending";
    }

    public void refresh() {
        statusLabel.setText(getStatusText());
        repaint();
    }

    public Task getTask() {
        return task;
    }
}
