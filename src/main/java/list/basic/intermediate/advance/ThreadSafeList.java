package list.basic.intermediate.advance;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<E> {

    // Problem 14: Implement thread-safe List.


    private final List<E> list = new ArrayList<>();

    public synchronized void add(E element) {
        list.add(element);
    }

    public synchronized E get(int index) {
        return list.get(index);
    }

    public synchronized int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeList<Integer> safeList = new ThreadSafeList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeList.add(i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected size: 2000");
        System.out.println("Actual size: " + safeList.size());
    }
}
