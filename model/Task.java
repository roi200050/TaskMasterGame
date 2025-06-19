package model;

public interface Task {
    void start();
    void complete();
    void cancel();
    boolean isRunning();
    boolean isCompleted();
    String getName();
    int getDuration(); // in seconds
    boolean isConflicting(Task other);
}
