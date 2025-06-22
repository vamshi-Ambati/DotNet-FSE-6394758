package myPackage;

public class TaskManagementSystem {
    private Task head = null;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public Task searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) return; // no tasks to delete
        if (head.taskId == taskId) {
            //temp = head;
            head = head.next;
            //delete(temp);
            return;
        }

        Task prev = null;
        Task curr = head;
        while (curr != null && curr.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        } else {
            System.out.println("Task not found.");
        }
    }

    public void displayTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
