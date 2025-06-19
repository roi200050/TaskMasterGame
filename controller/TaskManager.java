
package controller;

import model.Task;
import observer.TaskEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {

    private final List<Task> taskList;
    private final List<TaskEventListener> listeners;

    public TaskManager() {
        this.taskList = new CopyOnWriteArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        notifyTaskAdded(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
        notifyTaskRemoved(task);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(taskList);
    }

    public void startTask(Task task) {
        if (task.isRunning() || task.isCompleted()) return;

        // Check for conflicts
        for (Task t : taskList) {
            if (t.isRunning() && t.isConflicting(task)) {
                notifyTaskConflict(task, t);
                return;
            }
        }

        Thread taskThread = new Thread(() -> {
            try {
                task.start();
                notifyTaskStarted(task);
                Thread.sleep(task.getDuration() * 1000L);
                task.complete();
                notifyTaskCompleted(task);
            } catch (InterruptedException e) {
                task.cancel();
                notifyTaskCancelled(task);
            }
        });

        taskThread.start();
    }

    public void cancelTask(Task task) {
        task.cancel();
        notifyTaskCancelled(task);
    }

    public void addTaskEventListener(TaskEventListener listener) {
        listeners.add(listener);
    }

    private void notifyTaskAdded(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskAdded(task);
        }
    }

    private void notifyTaskRemoved(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskRemoved(task);
        }
    }

    private void notifyTaskStarted(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskStarted(task);
        }
    }

    private void notifyTaskCompleted(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskCompleted(task);
        }
    }

    private void notifyTaskCancelled(Task task) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskCancelled(task);
        }
    }

    private void notifyTaskConflict(Task task, Task conflictingWith) {
        for (TaskEventListener listener : listeners) {
            listener.onTaskConflict(task, conflictingWith);
        }
    }
}
