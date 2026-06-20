package map.weakhashmap.basic;

import java.util.Map;
import java.util.WeakHashMap;

public class WordsFrequency {
    public static void main(String[] args) throws InterruptedException {
        // Problem 1: Count frequency of words using WeakHashMap.
        // This is a poor use case. String literals are held in the string pool and won't be garbage collected.
        Map<String, Integer> wordFrequencies = new WeakHashMap<>();

        // Using "new String()" to create non-interned strings to demonstrate GC
        String word1 = new String("apple");
        String word2 = new String("banana");

        wordFrequencies.put(word1, 1);
        wordFrequencies.put(word2, 1);

        System.out.println("Map before GC: " + wordFrequencies);

        // Remove strong references
        word1 = null;
        
        // Hint to the JVM to run garbage collection
        System.gc();
        Thread.sleep(100); // Give GC time to run

        // The entry for "apple" may be removed by the GC.
        System.out.println("Map after GC: " + wordFrequencies);
    }
}
