package coding.problems.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Palindrome {

    public static boolean isPalindrome(String str){
        if(str==null || str.isEmpty()){
            return false;
        }

        str=str.replaceAll("\\s","").toLowerCase();

        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);

    }
    public static void main(String[] args) {
        //Using List
        List<String> stringList = new ArrayList<>(List.of(
                "madam","radar","racecar","level","rotor","civic","Java","Programming","Fucker","Sucker","Hooker","Musician"));
        Palindrome checkPalindrome = new Palindrome();

            for(String str: stringList){
                boolean palindromeres = checkPalindrome.isPalindrome(str);

                System.out.println(str+" is Palindrome? =>"+palindromeres);
            }


    }
}
