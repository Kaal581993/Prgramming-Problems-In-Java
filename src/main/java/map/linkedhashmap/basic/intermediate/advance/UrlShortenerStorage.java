package map.linkedhashmap.basic.intermediate.advance;

import java.util.LinkedHashMap;
import java.util.Map;

public class UrlShortenerStorage {
    // Using LinkedHashMap allows seeing URLs in the order they were created.
    private final Map<String, String> shortToLong = new LinkedHashMap<>();
    private static final String BASE_URL = "http://short.url/";
    private long counter = 0; // Use a simple counter for unique keys

    public String shortenUrl(String longUrl) {
        String shortKey = Long.toHexString(++counter);
        shortToLong.put(shortKey, longUrl);
        return BASE_URL + shortKey;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return shortToLong.getOrDefault(shortKey, "Short URL not found.");
    }
    
    public void displayUrls() {
        System.out.println("--- Stored URLs (in creation order) ---");
        shortToLong.forEach((k, v) -> System.out.println(BASE_URL + k + " -> " + v));
    }

    public static void main(String[] args) {
        // Problem 15: Implement URL shortener storage using LinkedHashMap.
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();
        urlShortener.shortenUrl("https://example.com/page1");
        urlShortener.shortenUrl("https://google.com");
        urlShortener.shortenUrl("https://example.com/page2");

        urlShortener.displayUrls();
    }
}
