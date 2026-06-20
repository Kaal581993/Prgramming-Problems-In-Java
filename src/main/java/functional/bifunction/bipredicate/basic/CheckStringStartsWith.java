package functional.bifunction.bipredicate.basic;

import java.util.function.BiPredicate;

public class CheckStringStartsWith {
    public static void main(String[] args) {
        // Problem 2: Check if one string starts with another.
        // We can use a method reference for this.
        BiPredicate<String, String> startsWith = String::startsWith;

        String text = "Hello World";
        String prefix1 = "Hello";
        String prefix2 = "Goodbye";

        System.out.println("Does '" + text + "' start with '" + prefix1 + "'? " + startsWith.test(text, prefix1));
        System.out.println("Does '" + text + "' start with '" + prefix2 + "'? " + startsWith.test(text, prefix2));
    }
}
