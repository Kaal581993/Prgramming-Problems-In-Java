package multi_threading;

public class CreateThread implements Runnable {

    public static void main(String[] args) {

        Thread t1 = new Thread();

        t1.start();
        t1.run();
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
        System.out.println(t1.getStackTrace());
        System.out.println(t1.getState());
        System.out.println(t1.getThreadGroup());
        System.out.println(t1.getUncaughtExceptionHandler());
        System.out.println(t1.getId());
        System.out.println(t1.getClass());
        System.out.println(t1.getContextClassLoader());
        System.out.println(t1.getThreadGroup());


        CreateThread ct = new CreateThread();
        ct.run();


    }

    public void run() {
        Runnable runnable = () -> {
            System.out.println("This is runnable method");
        };


    }
}
