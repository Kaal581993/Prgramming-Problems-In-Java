package queue.basic;

import java.util.LinkedList;
import java.util.Queue;

public class TicketCounterQueue {
    public static void main(String[] args) {
        // Problem 1: Implement ticket counter queue.
        Queue<String> ticketQueue = new LinkedList<>();

        // People arriving at the counter
        ticketQueue.add("Person 1");
        ticketQueue.add("Person 2");
        ticketQueue.add("Person 3");
        ticketQueue.add("Person 4");

        System.out.println("People in queue: " + ticketQueue);

        // Serving people one by one
        while (!ticketQueue.isEmpty()) {
            String servedPerson = ticketQueue.poll();
            System.out.println("Serving: " + servedPerson);
        }

        System.out.println("Queue is now empty: " + ticketQueue);
    }
}
