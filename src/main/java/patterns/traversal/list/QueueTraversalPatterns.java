package patterns.traversal.list;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTraversalPatterns {
    public static void main(String[] args) {
        Queue<Integer> queue =
                new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        //Read Without Removal

        for (Integer num : queue) {
            System.out.println(num);
        }

        //Consume Queue

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        /**
         *
         * Used in:
         *
         * BFS
         * Scheduling
         *
         * */


    }
}
