package factory;

import model.*;

public class TaskFactory {

    public static Task createTask(TaskType type, String name, int duration) {
        switch (type) {
            case SIMPLE:
                return new SimpleTask(name, duration);
            case STUDY:
                return new StudyTask(name, duration);
            case HOUSEHOLD:
                return new HouseholdTask(name, duration);
            case FITNESS:
                return new FitnessTask(name, duration);
            default:
                throw new IllegalArgumentException("Unsupported task type: " + type);
        }
    }
}
