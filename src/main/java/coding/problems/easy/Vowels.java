package coding.problems.easy;

import java.util.List;

public class Vowels {

    public static void main(String[] args) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        String input = "Demo String to test Vowels";

        List<String> words = List.of(input.toLowerCase().split("\\s"));

        int vowelcounter=0;

        for(String str: words){
            if(str.matches(".*[aeiouAEIOU].*")){
                System.out.println(str+" contains vowels");
                vowelcounter++;
            }
        }

        System.out.println("\nVowel counter"+vowelcounter);

        System.out.println("\n By using Stream API \n");

        long vowelCount = input.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();

        System.out.println("Total No. of Vowels in the given String:" + vowelCount);
    }
}
