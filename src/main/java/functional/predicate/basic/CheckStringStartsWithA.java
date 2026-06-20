package functional.predicate.basic;

import java.util.function.Predicate;

public class CheckStringStartsWithA {
    public static void main(String[] args) {
        // Problem 2: Check if string starts with "A".
        Predicate<String> startsWithA = str -> str != null && !str.isEmpty() && str.startsWith("A");

        String str1 = "Apple";
        String str2 = "Banana";

        System.out.println("Does '" + str1 + "' start with 'A'? " + startsWithA.test(str1));
        System.out.println("Does '" + str2 + "' start with 'A'? " + startsWithA.test(str2));
    }
}
