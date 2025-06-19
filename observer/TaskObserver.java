package observer;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskObserver {

    private final List<TaskEventListener> listeners = new ArrayList<>();

    public void addListener(TaskEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(TaskEventListener listener) {
        listeners.remove(listener);
    }

    public void notifyTaskAdded(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskAdded(task);
        }
    }

    public void notifyTaskRemoved(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskRemoved(task);
        }
    }

    public void notifyTaskStarted(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskStarted(task);
        }
    }

    public void notifyTaskCompleted(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskCompleted(task);
        }
    }

    public void notifyTaskCancelled(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskCancelled(task);
        }
    }

    public void notifyTaskConflict(Task task, Task conflictingWith) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskConflict(task, conflictingWith);
        }
    }
}
