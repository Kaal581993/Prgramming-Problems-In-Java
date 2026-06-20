package multi_threading;

public class JoinThreads {

    public static void main(String[] args) {

        // 1. Create a worker thread with a simulated task

        Thread worker = new Thread(() -> {
            System.out.println("[Worker] Starting task...");
            try {
                // Simulate 2 seconds of work
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("[Worker] Task was interrupted.");
            }
            System.out.println("[Worker] Task completed.");
        });

        // 2. Start the worker thread
        System.out.println("[Main] Starting worker thread.");
        worker.start();

        // 3. Force the main thread to wait for the worker thread
        System.out.println("[Main] Waiting for worker thread to complete...");
        try {
            worker.join(); // The main thread pauses here
        } catch (InterruptedException e) {
            System.out.println("[Main] Interrupted while waiting.");
        }


        // 4. Continue execution only after the worker thread is finished
        System.out.println("[Main] Worker thread has finished. Main thread completing.");

    }
}
