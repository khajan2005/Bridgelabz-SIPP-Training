class Task {
    int taskId, priority;
    String taskName, dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addFirst(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addLast(Task newTask) {
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(Task newTask, int position) {
        if (position <= 0 || head == null) {
            addFirst(newTask);
            return;
        }
        Task temp = head;
        for (int i = 1; i < position && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeById(int taskId) {
        if (head == null)
            return;

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Task last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewNextTask() {
        if (current == null) {
            current = head;
        } else {
            current = current.next;
        }
        if (current != null) {
            System.out.println("Current Task: " + current.taskId + " " + current.taskName + " Priority: "
                    + current.priority + " Due: " + current.dueDate);
        }
    }

    public void displayTasks() {
        if (head == null)
            return;
        Task temp = head;
        do {
            System.out.println(
                    temp.taskId + " " + temp.taskName + " Priority: " + temp.priority + " Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null)
            return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " " + temp.taskName + " Due: " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addLast(new Task(1, "Design", 2, "2025-07-10"));
        scheduler.addLast(new Task(2, "Develop", 1, "2025-07-11"));
        scheduler.addFirst(new Task(3, "Review", 3, "2025-07-09"));

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nView Tasks One-by-One:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        System.out.println("\nSearch Tasks with Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID 2");
        scheduler.removeById(2);
        scheduler.displayTasks();
    }
}
