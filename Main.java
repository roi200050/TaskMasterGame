

import controller.TaskManager;
import ui.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskManager taskManager = new TaskManager();
            MainFrame mainFrame = new MainFrame(taskManager);
            mainFrame.setVisible(true);
        });
    }
}