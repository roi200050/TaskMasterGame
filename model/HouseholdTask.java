package model;

public class HouseholdTask extends AbstractTask {

    public HouseholdTask(String name, int duration) {
        super(name, duration);
    }

    @Override
    public boolean isConflicting(Task other) {
        // Household tasks conflict with other household tasks only
        return other instanceof HouseholdTask;
    }
}
