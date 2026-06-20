package map.weakhashmap.basic.intermediate;

import java.util.Map;
import java.util.WeakHashMap;

public class PhonebookApplication {
    public static void main(String[] args) {
        // Problem 9: Implement phonebook application using WeakHashMap.
        // This is a very poor use case. You don't want your phonebook entries to disappear randomly.
        Map<String, String> phonebook = new WeakHashMap<>();

        phonebook.put(new String("Alice"), "123-456-7890");
        phonebook.put(new String("Bob"), "987-654-3210");

        System.out.println("Phonebook before GC: " + phonebook);
        System.gc();
        
        // The entries might disappear, which is not desired for a phonebook.
        System.out.println("Phonebook after GC: " + phonebook);
    }
}
