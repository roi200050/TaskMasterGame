package model;

public class SimpleTask extends AbstractTask {

    public SimpleTask(String name, int duration) {
        super(name, duration);
    }

    @Override
    public boolean isConflicting(Task other) {
        // Simple tasks by default are not conflicting unless specified
        return false;
    }
}
