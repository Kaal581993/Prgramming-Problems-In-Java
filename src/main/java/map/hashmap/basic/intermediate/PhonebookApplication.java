package map.hashmap.basic.intermediate;

import java.util.HashMap;
import java.util.Map;

public class PhonebookApplication {
    private final Map<String, String> phonebook = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
        System.out.println("Added contact: " + name);
    }

    public String findPhoneNumber(String name) {
        return phonebook.getOrDefault(name, "Contact not found.");
    }

    public void displayAllContacts() {
        System.out.println("\n--- All Contacts ---");
        phonebook.forEach((name, number) -> System.out.println(name + ": " + number));
    }

    public static void main(String[] args) {
        // Problem 9: Implement phonebook application using HashMap.
        PhonebookApplication phonebookApp = new PhonebookApplication();
        phonebookApp.addContact("Alice", "123-456-7890");
        phonebookApp.addContact("Bob", "987-654-3210");

        System.out.println("\nSearching for Bob's number: " + phonebookApp.findPhoneNumber("Bob"));
        phonebookApp.displayAllContacts();
    }
}
