package multi_threading;

public class RunnableApproach implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable): " + i);
            try {
                Thread.sleep(100); // Sleep briefly to demonstrate thread scheduling
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
