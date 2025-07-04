package LinkedList.CircularLinkedList;

class Process {
    int processID;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void removeProcess(int pid) {
        if (head == null)
            return;
        Process current = head, prev = tail;
        do {
            if (current.processID == pid) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head)
                        head = current.next;
                    if (current == tail)
                        tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null)
            return;
        int currentTime = 0;
        Process current = head;
        while (head != null) {
            if (current.remainingTime > 0) {
                int timeSpent = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= timeSpent;
                currentTime += timeSpent;
                System.out.println("Process " + current.processID + " executed for " + timeSpent + " units. Remaining: "
                        + current.remainingTime);
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    System.out.println("Process " + current.processID + " completed. Turnaround Time: "
                            + current.turnaroundTime + ", Waiting Time: " + current.waitingTime);
                    int nextId = current.next.processID;
                    removeProcess(current.processID);
                    current = getProcessById(nextId);
                    if (current == null && head != null)
                        current = head;
                    continue;
                }
            }
            current = current.next;
        }
    }

    public void displayProcesses() {
        if (head == null)
            return;
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: "
                    + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    private Process getProcessById(int pid) {
        if (head == null)
            return null;
        Process temp = head;
        do {
            if (temp.processID == pid)
                return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        int timeQuantum = 4;
        System.out.println("Initial Process List:");
        scheduler.displayProcesses();
        System.out.println("\nStarting Round Robin Scheduling with Time Quantum = " + timeQuantum);
        scheduler.simulateRoundRobin(timeQuantum);
    }
}
