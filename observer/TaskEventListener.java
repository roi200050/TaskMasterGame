package observer;

import model.Task;

public interface TaskEventListener {
    void onTaskAdded(Task task);
    void onTaskRemoved(Task task);
    void onTaskStarted(Task task);
    void onTaskCompleted(Task task);
    void onTaskCancelled(Task task);
    void onTaskConflict(Task task, Task conflictingWith);
}
