package queue.basic;

import java.util.LinkedList;
import java.util.Queue;

public class PrinterJobScheduling {
    public static void main(String[] args) {
        // Problem 4: Implement printer job scheduling.
        Queue<String> printerQueue = new LinkedList<>();

        // Adding print jobs
        printerQueue.add("Document1.pdf");
        printerQueue.add("Image.png");
        printerQueue.add("Report.docx");
        printerQueue.add("Spreadsheet.xlsx");

        System.out.println("Current printer queue: " + printerQueue);

        // Processing print jobs in FIFO order
        while (!printerQueue.isEmpty()) {
            String job = printerQueue.poll();
            System.out.println("Printing: " + job);
            // Simulate printing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All print jobs have been completed.");
    }
}
