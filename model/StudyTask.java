package model;

public class StudyTask extends AbstractTask {

    public StudyTask(String name, int duration) {
        super(name, duration);
    }

    @Override
    public boolean isConflicting(Task other) {
        // Study tasks conflict with other study or fitness tasks
        return other instanceof StudyTask || other instanceof FitnessTask;
    }
}
