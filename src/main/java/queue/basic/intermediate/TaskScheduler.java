package queue.basic.intermediate;

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    private String name;
    private int priority; // Lower number means higher priority

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + '}';
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        // Problem 9: Implement task scheduler.
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task("Process payments", 2));
        taskQueue.add(new Task("Send email notifications", 3));
        taskQueue.add(new Task("Run database backup", 1)); // Highest priority

        System.out.println("Tasks to be executed: " + taskQueue);

        while (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll();
            System.out.println("Executing: " + nextTask);
        }
    }
}
