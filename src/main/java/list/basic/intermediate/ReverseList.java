package list.basic.intermediate;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Charlie");
        studentNames.add("David");
        studentNames.add("Eve");

        System.out.println("Original list: " + studentNames);

        // Problem 6: Reverse a List without Collections.reverse()
        for (int i = 0; i < studentNames.size() / 2; i++) {
            String temp = studentNames.get(i);
         //   System.out.println(temp+":"+studentNames.get(i));
            studentNames.set(i, studentNames.get(studentNames.size() - 1 - i));
            //System.out.println(temp+":"+studentNames.get(i)+"studentNames.get(studentNames.size() - 1 - i"+(studentNames.get(studentNames.size() - 1 - i));

            studentNames.set(studentNames.size() - 1 - i, temp);
        }

        System.out.println("Reversed list: " + studentNames);
    }
}
