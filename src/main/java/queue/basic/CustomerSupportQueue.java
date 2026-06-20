package queue.basic;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerSupportQueue {
    public static void main(String[] args) {
        // Problem 5: Implement customer support queue.
        Queue<String> supportTickets = new LinkedList<>();

        // New support requests are added to the queue
        supportTickets.add("Ticket-001: Cannot log in");
        supportTickets.add("Ticket-002: Website is slow");
        supportTickets.add("Ticket-003: Payment failed");

        System.out.println("Open support tickets: " + supportTickets);

        // Support agents handle tickets in the order they were received
        while (!supportTickets.isEmpty()) {
            String ticket = supportTickets.poll();
            System.out.println("Handling ticket: " + ticket);
        }

        System.out.println("All support tickets have been handled.");
    }
}
