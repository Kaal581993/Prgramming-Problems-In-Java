package multi_threading;

public class ThreadNaming {

    public static void main(String[] args) {

        // 1. Create a task (Runnable) that print the current thread's name
        Runnable task = () -> {
            System.out.println("Inside thread: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();
        Thread thread4 = new Thread();
        Thread thread5 = new Thread();

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");
        thread4.setName("Thread 4");
        thread5.setName("Thread 5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
        System.out.println(thread3.getName());
        System.out.println(thread4.getName());
        System.out.println(thread5.getName());

        System.out.println("We're currently inside the thread"+Thread.currentThread().getName());



    }
}
