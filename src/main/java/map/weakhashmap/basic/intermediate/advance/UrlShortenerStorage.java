package map.weakhashmap.basic.intermediate.advance;

import java.util.Map;
import java.util.WeakHashMap;

public class UrlShortenerStorage {
    // Using WeakHashMap for a URL shortener is a very bad idea.
    // The mapping from short to long URL would disappear unpredictably.
    private final Map<String, String> shortToLong = new WeakHashMap<>();

    public String shortenUrl(String longUrl) {
        String shortKey = new String(Integer.toHexString(longUrl.hashCode()));
        shortToLong.put(shortKey, longUrl);
        return "http://short.url/" + shortKey;
    }

    public static void main(String[] args) {
        // Problem 15: Implement URL shortener storage using WeakHashMap (demonstrating unsuitability).
        UrlShortenerStorage urlShortener = new UrlShortenerStorage();
        String shortUrl = urlShortener.shortenUrl("https://example.com");

        System.out.println("Short URL created: " + shortUrl);
        System.gc();
        
        // The mapping is now likely gone.
        System.out.println("The short URL probably won't work anymore.");
    }
}
