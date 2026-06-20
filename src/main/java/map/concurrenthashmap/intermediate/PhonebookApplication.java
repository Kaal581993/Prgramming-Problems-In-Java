package map.concurrenthashmap.intermediate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PhonebookApplication {
    // ConcurrentHashMap is perfect for a phonebook that can be read/written by multiple threads.
    private final Map<String, String> phonebook = new ConcurrentHashMap<>();

    public void addContact(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    public String findPhoneNumber(String name) {
        return phonebook.get(name);
    }

    public static void main(String[] args) {
        // Problem 9: Implement a thread-safe phonebook application.
        PhonebookApplication phonebookApp = new PhonebookApplication();

        // Simulate concurrent writes
        new Thread(() -> phonebookApp.addContact("Alice", "111-222-3333")).start();
        new Thread(() -> phonebookApp.addContact("Bob", "444-555-6666")).start();

        // Allow some time for writes to complete
        try { Thread.sleep(100); } catch (InterruptedException e) {}

        // Simulate concurrent reads
        new Thread(() -> System.out.println("Alice's number: " + phonebookApp.findPhoneNumber("Alice"))).start();
    }
}
