package ui;

import controller.TaskManager;
import model.Task;
import observer.TaskEventListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame implements TaskEventListener {

    private TaskManager taskManager;
    private JPanel taskListPanel;

    public MainFrame(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.taskManager.addTaskEventListener(this);

        setTitle("Task Master Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton addSampleTaskBtn = new JButton("Add Sample Task");
        addSampleTaskBtn.addActionListener(e -> addSampleTask());

        add(addSampleTaskBtn, BorderLayout.SOUTH);
    }

    private void addSampleTask() {
        Task sampleTask = factory.TaskFactory.createTask(model.TaskType.SIMPLE, "Read 10 pages", 5);
        taskManager.addTask(sampleTask);
        taskManager.startTask(sampleTask);
    }

    private void refreshTasks(List<Task> tasks) {
        taskListPanel.removeAll();
        for (Task task : tasks) {
            JLabel label = new JLabel(task.getName() + " - " + (task.isCompleted() ? "Completed" : "Pending"));
            taskListPanel.add(label);
        }
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    @Override
    public void onTaskAdded(Task task) {
        refreshTasks(taskManager.getTasks());
    }

    @Override
    public void onTaskRemoved(Task task) {
        refreshTasks(taskManager.getTasks());
    }

    @Override
    public void onTaskStarted(Task task) {
        refreshTasks(taskManager.getTasks());
    }

    @Override
    public void onTaskCompleted(Task task) {
        refreshTasks(taskManager.getTasks());
    }

    @Override
    public void onTaskCancelled(Task task) {
        refreshTasks(taskManager.getTasks());
    }

    @Override
    public void onTaskConflict(Task task, Task conflictingWith) {
        JOptionPane.showMessageDialog(this,
                "Conflict between tasks: " + task.getName() + " and " + conflictingWith.getName(),
                "Task Conflict", JOptionPane.WARNING_MESSAGE);
    }
}
