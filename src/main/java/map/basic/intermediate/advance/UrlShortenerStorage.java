package map.basic.intermediate.advance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UrlShortenerStorage {
    private final Map<String, String> shortToLongUrl = new ConcurrentHashMap<>();
    private final Map<String, String> longToShortUrl = new ConcurrentHashMap<>(); // For reverse lookups
    private static final String BASE_URL = "http://short.url/";

    // Simple hash function to generate a short key (in a real system, this would be more robust)
    private String generateShortKey(String longUrl) {
        return Integer.toHexString(longUrl.hashCode());
    }

    public String shortenUrl(String longUrl) {
        if (longToShortUrl.containsKey(longUrl)) {
            return BASE_URL + longToShortUrl.get(longUrl);
        }

        String shortKey = generateShortKey(longUrl);
        // In a real system, you'd need to handle collisions
        shortToLongUrl.put(shortKey, longUrl);
        longToShortUrl.put(longUrl, shortKey);
        
        System.out.println("Shortened " + longUrl + " to " + BASE_URL + shortKey);
        return BASE_URL + shortKey;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return shortToLongUrl.getOrDefault(shortKey, "Short URL not found.");
    }

    public static void main(String[] args) {
        // Problem 15: Implement URL shortener storage.
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();
        String longUrl = "https://www.verylongurl.com/with/a/lot/of/path/segments";

        String shortUrl = urlShortener.shortenUrl(longUrl);
        String expandedUrl = urlShortener.expandUrl(shortUrl);

        System.out.println("\nOriginal URL: " + longUrl);
        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Expanded URL: " + expandedUrl);
    }
}
