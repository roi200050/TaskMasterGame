package util;

import model.Task;

public class TaskConflictChecker {

    public static boolean areConflicting(Task task1, Task task2) {
        return task1.isConflicting(task2) || task2.isConflicting(task1);
    }
}
