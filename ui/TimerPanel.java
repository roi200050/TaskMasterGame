package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPanel extends JPanel {

    private final JLabel timeLabel;
    private int timeLeft; // in seconds
    private Timer timer;

    public TimerPanel(int totalTimeSeconds) {
        this.timeLeft = totalTimeSeconds;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        timeLabel = new JLabel("Time left: " + formatTime(timeLeft));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(timeLabel);
    }

    public void startTimer(Runnable onFinish) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (timeLeft <= 0) {
                    timer.cancel();
                    onFinish.run();
                } else {
                    timeLeft--;
                    SwingUtilities.invokeLater(() -> timeLabel.setText("Time left: " + formatTime(timeLeft)));
                }
            }
        }, 0, 1000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private String formatTime(int seconds) {
        int mins = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}
