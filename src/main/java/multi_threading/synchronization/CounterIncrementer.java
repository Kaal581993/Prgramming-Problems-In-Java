//package multi_threading.synchronization;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class CounterIncrementer {
//
//    public static void main(String[] args) {
//
//
//        CounterIncrement cI1 = new CounterIncrement();
//
//        cI1.start();
//        cI1.run();
//
//        CounterIncrement cI2 = new CounterIncrement();
//
//        cI2.start();
//        cI2.run();
//
//        CounterIncrement cI3 = new CounterIncrement();
//
//        cI3.start();
//        cI3.run();
//
//        CounterIncrement cI4 = new CounterIncrement();
//
//        cI4.start();
//        cI4.run();
//
//
//        CounterIncrement cI5 = new CounterIncrement();
//
//        cI5.start();
//        cI5.run();
//
//        CounterIncrement cI6 = new CounterIncrement();
//
//        cI6.start();
//        cI6.run();
//
//        CounterIncrement cI7 = new CounterIncrement();
//
//        cI7.start();
//        cI7.run();
//
//        CounterIncrement cI8 = new CounterIncrement();
//
//        cI8.start();
//        cI8.run();
//
//        CounterIncrement cI9 = new CounterIncrement();
//
//        cI9.start();
//        cI9.run();
//
//        CounterIncrement cI10 = new CounterIncrement();
//
//        cI10.start();
//        cI10.run();
//
//    }
//}
//
//class CounterIncrement extends Thread{
//    AtomicInteger count= new AtomicInteger();
//
//    void setCount(){
//        this.count=count;
//    }
//
//
//    public void run() {
//
//        synchronized(this){
//            for(int i=0;i<1000; i++){
//                System.out.println("The Count is:"+count);
//                count.getAndIncrement();
//            }
//        }
//
//    };
//}


package multi_threading.synchronization;

// 1. A shared class containing the counter and the synchronized logic
class SharedCounter {
    private int count = 0;

    // The synchronized keyword ensures only one thread can execute this method at a time
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// 2. The task that each thread will execute
class IncrementTask implements Runnable {
    private final SharedCounter sharedCounter;

    public IncrementTask(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sharedCounter.increment();
        }
    }
}

public class CounterIncrementer {
    public static void main(String[] args) throws InterruptedException {

        // Create a single shared counter instance
        SharedCounter sharedCounter = new SharedCounter();

        // Create an array to hold our 10 threads
        Thread[] threads = new Thread[10];

        // Initialize and start 10 threads, all sharing the same counter instance
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(
                    new IncrementTask(sharedCounter)
            );
            threads[i].start(); // Starts the thread in the background, executing run()

            System.out.println(threads[i]);
        }

        // Wait for all 10 threads to finish execution before reading the final value
        for (int i = 0; i < 10; i++) {
            threads[i].join();
            System.out.println(threads[i]);
        }

        // Print the final count
        System.out.println("Expected count: 10000");
        System.out.println("Actual count:   " + sharedCounter.getCount());
    }
}