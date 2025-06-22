package myPackage;

public class Task {
    int taskId;
    String taskName;
    String status;
    Task next; 

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return taskId + " | " + taskName + " | " + status;
    }
}

