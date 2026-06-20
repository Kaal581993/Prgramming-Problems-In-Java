package map.concurrenthashmap.basic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordsFrequency {
    public static void main(String[] args) throws InterruptedException {
        // Problem 1: Count frequency of words using ConcurrentHashMap.
        String[] text = "the quick brown fox jumps over the lazy dog the fox".split(" ");
        // ConcurrentHashMap is ideal when multiple threads are updating the map simultaneously.
        Map<String, Integer> wordFrequencies = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String word : text) {
            executor.submit(() -> {
                wordFrequencies.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Word Frequencies (from concurrent execution): " + wordFrequencies);
    }
}
