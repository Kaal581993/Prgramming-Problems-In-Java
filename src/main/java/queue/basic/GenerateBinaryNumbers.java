package queue.basic;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        // Problem 3: Generate binary numbers using queue.
        int n = 10;
        System.out.println("Generating binary numbers from 1 to " + n);
        generateBinary(n);
    }

    public static void generateBinary(int n) {
        if (n <= 0) {
            return;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 1; i <= n; i++) {
            String current = queue.poll();
            System.out.println(current);

            // Append "0" and add to the queue
            queue.add(current + "0");
            // Append "1" and add to the queue
            queue.add(current + "1");
        }
    }
}
