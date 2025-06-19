package model;

import java.util.ArrayList;
import java.util.List;

public class ComplexTask extends AbstractTask {

    private final List<SimpleTask> subTasks;

    public ComplexTask(String name) {
        super(name, 0);
        this.subTasks = new ArrayList<>();
    }

    public void addSubTask(SimpleTask subTask) {
        subTasks.add(subTask);
        this.duration += subTask.getDuration();
    }

    @Override
    public void start() {
        super.start();
        for (SimpleTask task : subTasks) {
            task.start();
            try {
                Thread.sleep(task.getDuration() * 1000L);
                task.complete();
            } catch (InterruptedException e) {
                task.cancel();
            }
        }
        complete();
    }

    @Override
    public boolean isConflicting(Task other) {
        // A complex task is conflicting if any of its sub-tasks conflict
        for (SimpleTask subTask : subTasks) {
            if (subTask.isConflicting(other)) {
                return true;
            }
        }
        return false;
    }

    public List<SimpleTask> getSubTasks() {
        return new ArrayList<>(subTasks);
    }
}
