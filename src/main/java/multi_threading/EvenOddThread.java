package multi_threading;

//public class EvenOddThread {
//
//    public static void main(String[] args) {
//        int even=14; int odd=21;
//
//        EvenThread evenThread = new EvenThread();
//
//        evenThread.setI(even);
//        evenThread.run();
//        evenThread.start();
//
//        evenThread.setI(odd);
//        evenThread.run();
//        evenThread.start();
//        OddThread oddThread = new OddThread();
//
//        oddThread.setI(odd);
//        oddThread.run();
//        oddThread.start();
//
//        oddThread.setI(even);
//        oddThread.run();
//        oddThread.start();
//
//    }
//}
//
//class EvenThread extends Thread {
//
//    private static int i;
//    public void setI(int i){
//        this.i =i;
//    }
//    @Override
//    public void run() {
//        try {
//            if(i%2==0){
//                System.out.println("The given number "+i+"is even");
//            }else{
//                System.out.println("The given number "+i+"is not even");
//            }
//
//        }catch (Exception e){
//
//        }
//    }
//}
//
//class OddThread extends Thread{
//
//    private static int i;
//    public void setI(int i){
//        this.i =i;
//    }
//
//    @Override
//    public void run(){
//        try{
//            if(i%2!=0){
//                System.out.println("The given number "+i+"is odd");
//            }else{
//                System.out.println("The given number "+i+"is not odd");
//            }
//        }catch (Exception e){
//
//        }
//    }
//}


//the provided code does not solve the problem.

//Why the original code fails:
//No new threads are created: Calling .run() directly on a thread or
// runnable executes the code synchronously on the main thread. To spawn and
// run code in a new thread, you must call .start().

//Incorrect instantiation: EvenThread implements Runnable (rather than extending
// Thread), so it cannot be started directly. It must be passed to a Thread
// constructor (e.g., new Thread(new EvenThread()).start()).

//No synchronization/coordination: Even if both threads were correctly
// started concurrently, they do not coordinate. Thread scheduling is
// non-deterministic; without synchronization (wait() and notify()), the
// output order would be completely random instead of alternating.

//Unsafe static state: Using private static int i in both classes means
// all threads share the same variable. Running them concurrently will
// cause race conditions where one thread overwrites the value before the
// other reads it.

//Output format: The print statement formats do not match the expected
// Even: X / Odd: Y output.


//Solution:


public class EvenOddThread {
    private final int limit;
    private int number = 1;
    private boolean isEvenTurn = true; // Start with Even: 2

    public EvenOddThread(int limit) {
        this.limit = limit;
    }

    public void printEven() {
        synchronized (this) {
            while (number <= limit) {
                while (
                        !isEvenTurn
                                &&
                        number <= limit) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (number > limit) {
                    break;
                }

                System.out.println("Even: " + (number + 1));
                isEvenTurn = false;
                notifyAll();
            }
        }
    }

    public void printOdd() {
        synchronized (this) {
            while (number <= limit) {
                while (isEvenTurn && number <= limit) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (number > limit) {
                    break;
                }

                System.out.println("Odd: " + number);
                number += 2; // Advance to the next pair
                isEvenTurn = true;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int limit = 10;
        EvenOddThread printer = new EvenOddThread(limit);

        // Define threads pointing to the Runnable methods
        Thread evenThread = new Thread(printer::printEven, "EvenThread");
        Thread oddThread = new Thread(printer::printOdd, "OddThread");

        // Start threads concurrently
        evenThread.start();
        oddThread.start();
    }
}