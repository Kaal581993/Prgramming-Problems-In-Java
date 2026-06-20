package functional.bifunction.bipredicate.intermediate;

import java.time.LocalDate;
import java.util.function.BiPredicate;

public class CompareDates {
    public static void main(String[] args) {
        // Problem 8: Compare two dates (e.g., is the first date before the second).
        BiPredicate<LocalDate, LocalDate> isBefore = LocalDate::isBefore;

        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 5, 10);

        System.out.println(date1 + " is before " + date2 + "? " + isBefore.test(date1, date2));
        System.out.println(date2 + " is before " + date1 + "? " + isBefore.test(date2, date1));
    }
}
