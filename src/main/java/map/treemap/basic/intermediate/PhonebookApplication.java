package map.treemap.basic.intermediate;

import java.util.Map;
import java.util.TreeMap;

public class PhonebookApplication {
    // TreeMap will keep the phonebook sorted by contact name.
    private final Map<String, String> phonebook = new TreeMap<>();

    public void addContact(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    public String findPhoneNumber(String name) {
        return phonebook.getOrDefault(name, "Contact not found.");
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts (Sorted by Name) ---");
        phonebook.forEach((name, number) -> System.out.println(name + ": " + number));
    }

    public static void main(String[] args) {
        // Problem 9: Implement phonebook application using TreeMap.
        PhonebookApplication phonebookApp = new PhonebookApplication();
        phonebookApp.addContact("Charlie", "555-1234");
        phonebookApp.addContact("Alice", "123-456-7890");
        phonebookApp.addContact("Bob", "987-654-3210");

        phonebookApp.displayAllContacts();
    }
}
