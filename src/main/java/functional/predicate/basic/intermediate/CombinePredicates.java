package functional.predicate.basic.intermediate;

import java.util.function.Predicate;

public class CombinePredicates {
    public static void main(String[] args) {
        // Problem 8: Combine multiple conditions using and().
        Predicate<String> hasLengthGreaterThan5 = str -> str.length() > 5;
        Predicate<String> containsS = str -> str.contains("s");

        // Combine the two predicates
        Predicate<String> combinedPredicate = hasLengthGreaterThan5.and(containsS);

        String str1 = "success";
        String str2 = "failure";
        String str3 = "test";

        System.out.println("'" + str1 + "' > 5 chars AND contains 's'? " + combinedPredicate.test(str1));
        System.out.println("'" + str2 + "' > 5 chars AND contains 's'? " + combinedPredicate.test(str2));
        System.out.println("'" + str3 + "' > 5 chars AND contains 's'? " + combinedPredicate.test(str3));
    }
}
