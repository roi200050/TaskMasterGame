package model;

public abstract class AbstractTask implements Task {

    protected String name;
    protected int duration; // in seconds
    protected boolean isRunning;
    protected boolean isCompleted;
    protected boolean isCancelled;

    public AbstractTask(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.isRunning = false;
        this.isCompleted = false;
        this.isCancelled = false;
    }

    @Override
    public void start() {
        isRunning = true;
    }

    @Override
    public void complete() {
        isRunning = false;
        isCompleted = true;
    }

    @Override
    public void cancel() {
        isRunning = false;
        isCancelled = true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public boolean isConflicting(Task other) {
        return false; // default behavior, override in subclasses if needed
    }
}
