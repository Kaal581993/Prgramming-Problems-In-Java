package map.concurrenthashmap.advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortenerStorage {
    // ConcurrentHashMap is essential for a high-throughput, thread-safe URL shortener.
    private final Map<String, String> shortToLong = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(); // Thread-safe counter
    private static final String BASE_URL = "http://short.url/";

    public String shortenUrl(String longUrl) {
        // A real system might check if the longUrl already exists to avoid duplicates.
        String shortKey = Long.toHexString(counter.incrementAndGet());
        shortToLong.put(shortKey, longUrl);
        return BASE_URL + shortKey;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return shortToLong.get(shortKey);
    }

    public static void main(String[] args) {
        // Problem 15: Implement a thread-safe URL shortener storage.
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();

        // Simulate concurrent shortening requests
        new Thread(() -> System.out.println("Short URL: " + urlShortener.shortenUrl("https://google.com"))).start();
        new Thread(() -> System.out.println("Short URL: " + urlShortener.shortenUrl("https://bing.com"))).start();
    }
}
