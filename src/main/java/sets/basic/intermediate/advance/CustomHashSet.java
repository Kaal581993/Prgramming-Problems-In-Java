package sets.basic.intermediate.advance;

import java.util.HashMap;

public class CustomHashSet<E> {
    // A HashSet is internally backed by a HashMap
    private final HashMap<E, Object> map;

    // A dummy value to associate with the keys in the map
    private static final Object PRESENT = new Object();

    public CustomHashSet() {
        map = new HashMap<>();
    }

    public boolean add(E e) {
        // The key is not present if put() returns null
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(Object o) {
        // The key was present if remove() returns our dummy object
        return map.remove(o) == PRESENT;
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public int size() {
        return map.size();
    }

    public void clear() {
        map.clear();
    }

    public static void main(String[] args) {
        // Problem 11: Implement custom HashSet.
        CustomHashSet<String> set = new CustomHashSet<>();
        System.out.println("Adding 'Apple': " + set.add("Apple"));
        System.out.println("Adding 'Banana': " + set.add("Banana"));
        System.out.println("Adding 'Apple' again: " + set.add("Apple")); // Should be false

        System.out.println("\nSet contains 'Apple': " + set.contains("Apple"));
        System.out.println("Set size: " + set.size());

        System.out.println("\nRemoving 'Apple': " + set.remove("Apple"));
        System.out.println("Set contains 'Apple': " + set.contains("Apple"));
        System.out.println("Set size: " + set.size());
    }
}
