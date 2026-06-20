package queue.basic.intermediate.advance;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RateLimiter {
    private final int maxRequests;
    private final long timeWindowInMillis;
    private final Queue<Long> requestTimestamps = new ConcurrentLinkedQueue<>();

    public RateLimiter(int maxRequests, long timeWindowInMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowInMillis = timeWindowInMillis;
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        // Remove timestamps that are outside the current time window
        while (!requestTimestamps.isEmpty() && currentTime - requestTimestamps.peek() > timeWindowInMillis) {
            requestTimestamps.poll();
        }

        if (requestTimestamps.size() < maxRequests) {
            requestTimestamps.add(currentTime);
            return true; // Request is allowed
        } else {
            return false; // Request is denied
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Design rate limiter using queue.
        // Allow 5 requests per 10 seconds
        RateLimiter limiter = new RateLimiter(5, 10000);

        // Simulate 7 quick requests
        for (int i = 1; i <= 7; i++) {
            if (limiter.allowRequest()) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " denied. Rate limit exceeded.");
            }
            Thread.sleep(500);
        }

        // Wait for the window to slide
        System.out.println("\nWaiting for 10 seconds...");
        Thread.sleep(10000);

        // Try another request
        if (limiter.allowRequest()) {
            System.out.println("Request 8 allowed after waiting.");
        } else {
            System.out.println("Request 8 denied.");
        }
    }
}
