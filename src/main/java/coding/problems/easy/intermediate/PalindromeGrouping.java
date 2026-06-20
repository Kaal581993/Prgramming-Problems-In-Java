package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import  java.util.List;
import java.util.stream.Collectors;


public class PalindromeGrouping {

    public static void main(String[] args) {
        String[] stringList = {
                "madam", "hello", "level", "java"
        };

        Collection<List<String>> result =
                Arrays.stream(stringList).collect(
                        Collectors.groupingBy(
                                str -> {
                                    StringBuilder reverseString =new StringBuilder(
                                            Arrays.toString(stringList)).reverse();
                                    List<String> palindrome = new ArrayList<>();
                                    for( String strs: stringList){
                                        if (str.equals(stringList)){
                                            palindrome.add(strs);
                                        }
                                    }

                                    return palindrome;
                                })
                        ).values();

      //  System.out.println(reverseString);


        System.out.println("The palindrome List:"+result);

        // using filter in streams

        System.out.println("\nThe output using filter in streams\n");
        List<String> palindromes = Arrays.stream(stringList)
                .filter(str -> {
                    String reversed = new StringBuilder(str).reverse().toString();
                    return str.equals(reversed);
                })
                .collect(Collectors.toList());

        System.out.println("The palindrome List:"+palindromes);
    }
}
