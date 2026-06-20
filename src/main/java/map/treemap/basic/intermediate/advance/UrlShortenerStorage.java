package map.treemap.basic.intermediate.advance;

import java.util.Map;
import java.util.TreeMap;

public class UrlShortenerStorage {
    // TreeMap is generally not a good choice for a URL shortener due to O(log n) lookups.
    // HashMap's O(1) is much preferred. This is for demonstration.
    private final Map<String, String> shortToLong = new TreeMap<>();

    private String generateShortKey(String longUrl) {
        return Integer.toHexString(longUrl.hashCode());
    }

    public String shortenUrl(String longUrl) {
        String shortKey = generateShortKey(longUrl);
        shortToLong.put(shortKey, longUrl);
        return "http://short.url/" + shortKey;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = shortUrl.replace("http://short.url/", "");
        // This get() operation is O(log n), which is slower than HashMap's O(1).
        return shortToLong.getOrDefault(shortKey, "Short URL not found.");
    }

    public static void main(String[] args) {
        // Problem 15: Implement URL shortener storage using TreeMap.
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();
        String longUrl = "https://example.com/some/path";

        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Expanded URL: " + urlShortener.expandUrl(shortUrl));
    }
}
