package multi_threading;


class ThreadClassApproach2 extends Thread{

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
          //  System.out.println(getName() + " (Thread Class): " + i);
            System.out.println(i);
            try {
                Thread.sleep(1000);
                // Sleep briefly to demonstrate thread scheduling
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
public class ThreadSleep {

    public static void main(String[] args) {
        ThreadClassApproach2 t2 = new ThreadClassApproach2();
        t2.start();
        // Only call start() to execute it on a separate thread

        //t2.run();
    }
}

