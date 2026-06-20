package multi_threading;

public class PrintNumbers1to10 {

    public static void main(String[] args) {
        // 1. Thread class approach
        ThreadClassApproach t1 = new ThreadClassApproach();
        t1.setName("Thread-1");
        t1.start(); // start() registers the thread and internally
        // calls run() on a new execution path
        // 2. Runnable interface approach
        RunnableApproach runnableTarget = new RunnableApproach();
        Thread t2 = new Thread(runnableTarget, "Thread-2");
        t2.start(); // start() runs the Runnable's run() method in a new thread

    }
}
