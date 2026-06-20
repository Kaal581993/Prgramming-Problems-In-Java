package linkedlist.basic.intermediate;

import java.util.LinkedList;

public class BrowserHistory {
    private LinkedList<String> history = new LinkedList<>();
    private int currentIndex = -1;

    public void visit(String url) {
        // Remove forward history
        while (history.size() > currentIndex + 1) {
            history.removeLast();
        }
        history.add(url);
        currentIndex++;
        System.out.println("Visited: " + url);
    }

    public String back(int steps) {
        int newIndex = Math.max(0, currentIndex - steps);
        currentIndex = newIndex;
        System.out.println("Navigated back " + steps + " steps.");
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        int newIndex = Math.min(history.size() - 1, currentIndex + steps);
        currentIndex = newIndex;
        System.out.println("Navigated forward " + steps + " steps.");
        return history.get(currentIndex);
    }

    public static void main(String[] args) {
        // Problem 8: Implement browser history using LinkedList.
        BrowserHistory browser = new BrowserHistory();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("facebook.com");
        System.out.println("Current page: " + browser.history.get(browser.currentIndex));
        System.out.println("Back 1: " + browser.back(1));
        System.out.println("Forward 1: " + browser.forward(1));
    }
}
