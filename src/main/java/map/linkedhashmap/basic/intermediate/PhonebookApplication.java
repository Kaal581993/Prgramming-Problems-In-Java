package map.linkedhashmap.basic.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;

public class PhonebookApplication {
    // LinkedHashMap will maintain the order in which contacts were added.
    private final Map<String, String> phonebook = new LinkedHashMap<>();

    public void addContact(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts (in insertion order) ---");
        phonebook.forEach((name, number) -> System.out.println(name + ": " + number));
    }

    public static void main(String[] args) {
        // Problem 9: Implement phonebook application using LinkedHashMap.
        PhonebookApplication phonebookApp = new PhonebookApplication();
        phonebookApp.addContact("Alice", "123-456-7890");
        phonebookApp.addContact("Charlie", "555-1234");
        phonebookApp.addContact("Bob", "987-654-3210");

        phonebookApp.displayAllContacts();
    }
}
