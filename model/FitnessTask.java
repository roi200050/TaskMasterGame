package model;

public class FitnessTask extends AbstractTask {

    public FitnessTask(String name, int duration) {
        super(name, duration);
    }

    @Override
    public boolean isConflicting(Task other) {
        // Fitness tasks conflict with other fitness or study tasks
        if (other instanceof FitnessTask || other instanceof StudyTask) {
            return true;
        }
        return false;
    }
}
