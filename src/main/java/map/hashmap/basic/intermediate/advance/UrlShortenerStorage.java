package map.hashmap.basic.intermediate.advance;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerStorage {
    // Two HashMaps for quick lookups in both directions
    private final Map<String, String> shortToLong = new HashMap<>();
    private final Map<String, String> longToShort = new HashMap<>();
    private static final String BASE_URL = "http://short.url/";

    private String generateShortKey(String longUrl) {
        // A simple hash-based key. Real systems need more robust, collision-free generation.
        return Integer.toHexString(longUrl.hashCode());
    }

    public String shortenUrl(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return BASE_URL + longToShort.get(longUrl);
        }

        String shortKey = generateShortKey(longUrl);
        shortToLong.put(shortKey, longUrl);
        longToShort.put(longUrl, shortKey);
        
        System.out.println("Shortened URL for: " + longUrl);
        return BASE_URL + shortKey;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return shortToLong.getOrDefault(shortKey, "Short URL not found.");
    }

    public static void main(String[] args) {
        // Problem 15: Implement URL shortener storage using HashMap.
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();
        String longUrl = "https://example.com/a-very-long-path/that-needs-shortening";

        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Expanded URL: " + urlShortener.expandUrl(shortUrl));
    }
}
