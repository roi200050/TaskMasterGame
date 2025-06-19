# 🎮 Task Master Game

Task Master Game is a Java-based desktop game where players must complete as many tasks as possible under time pressure. The game demonstrates Object-Oriented Programming principles and key Java concepts such as interfaces, inheritance, multithreading, design patterns, and GUI with Swing.

---

## 🚀 How to Run

### Requirements:
- Java 11+
- VS Code with the following extensions:
  - Language Support for Java™ by Red Hat
  - Debugger for Java

### Steps:
1. Open the project folder in VS Code.
2. Open `Main.java`.
3. Click the green "Run" button or right-click and choose `Run Java`.

---

## 📂 Project Structure

### Root
| File             | Description |
|------------------|-------------|
| `Main.java`      | Entry point of the application. Launches the GUI with `MainFrame`. |

---

### `controller/`
| File              | Description |
|-------------------|-------------|
| `TaskManager.java`| Central manager that tracks tasks, starts/cancels them, and notifies observers. |

---

### `model/`
| File              | Description |
|-------------------|-------------|
| `Task.java`       | Interface for all task types. Defines `start`, `complete`, `cancel`, and status methods. |
| `AbstractTask.java`| Base class for all task implementations with default logic. |
| `SimpleTask.java` | Task with fixed duration and simple status. |
| `ComplexTask.java`| Task that includes a list of `SimpleTask` sub-tasks. |
| `StudyTask.java`  | Task representing a study activity. Conflicts with `FitnessTask`. |
| `HouseholdTask.java`| Task for house chores. Conflicts with other household tasks. |
| `FitnessTask.java`| Task for exercising. Conflicts with study or other fitness tasks. |
| `TaskType.java`   | Enum listing all supported task types. |

---

### `factory/`
| File               | Description |
|--------------------|-------------|
| `TaskFactory.java` | Implements Factory Pattern to dynamically create tasks by type. |

---

### `observer/`
| File                    | Description |
|-------------------------|-------------|
| `TaskEventListener.java`| Interface for UI components to receive task state updates. |
| `TaskObserver.java`     | Manages listeners and notifies them of task changes. |

---

### `ui/`
| File              | Description |
|-------------------|-------------|
| `MainFrame.java`  | Main GUI window. Displays task list and control buttons. |
| `TaskPanel.java`  | Represents a single task visually. Shows name + status. |
| `TimerPanel.java` | Displays a countdown timer for the session. |

---

### `util/`
| File                      | Description |
|---------------------------|-------------|
| `TaskConflictChecker.java`| Utility to check if two tasks conflict using their `isConflicting()` logic. |

---

## ✅ What Works Now
- Tasks can be added using the **"Add Sample Task"** button.
- Tasks run in separate threads and show state transitions: Pending → Running → Completed.
- Task list updates in real time.
- Timer countdown display included.

---

## 🧠 To-Do Features / Ideas

### 🔧 1. Add Real Task Form
Replace the dummy sample task button with a form:
- Add a `JDialog` or popup that lets user choose:
  - Task name
  - Task type (`Simple`, `Study`, etc.)
  - Duration (seconds)

Then call:
```java
Task task = TaskFactory.createTask(type, name, duration);
taskManager.addTask(task);
taskManager.startTask(task);
```

### 🎯 2. Add Cancel Button
In `TaskPanel.java`, add a `JButton("Cancel")` and attach an `ActionListener` that calls:
```java
taskManager.cancelTask(taskPanel.getTask());
```

### 🧪 3. Complex Tasks
Enable user to build a `ComplexTask` by grouping multiple `SimpleTask`s together in a sublist.

### 🎨 4. Improve GUI
- Color code tasks: Pending (gray), Running (blue), Completed (green)
- Add icons or animations

---

## 🏁 Credits
Created as a course project to demonstrate:
- Java OOP
- GUI (Swing)
- Threading
- Design Patterns (Factory, Observer)
 
