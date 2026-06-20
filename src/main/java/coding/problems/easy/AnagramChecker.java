package coding.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class AnagramChecker {

    public static boolean AnagramChecker2Strings(String str1, String str2){

        if((str1==null ||  str1.isEmpty()) && (str2==null ||str2.isEmpty())){
            return false;
        }

        str1=str1.replaceAll("\\s","").toLowerCase();
        str2=str2.replaceAll("\\s","").toLowerCase();

        if (str1.length() != str2.length()){
            System.out.println("The given string is not an Anagram");
            return false;
        }

        // Count character frequency
        int[] charCount = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            // increment for str1
            charCount[str2.charAt(i) - 'a']--;
            // decrement for str2
        }

        // If anagram — all counts should be 0
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;

    }

    public static boolean AnagramCheckers(String str){
        if((str==null ||  str.isEmpty())){
            return false;
        }

        str=str.toLowerCase();

        String[] words = str.split("\\s");

        if(words.length !=2){
            return false;
        }
        String str1 = words[0].toLowerCase();
        String str2 = words[1].toLowerCase();

        // Length check
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);


    }

        public static void main(String[] args) {
        //Using List
        List<String> stringList1 = new ArrayList<>(List.of(
                "listen","race","heart","cat","pat","genre","dance"
        ));

        //Using List - with valid anagrams
        List<String> stringList2 = new ArrayList<>(List.of(
             "silent","care","earth","act","tap","genes","mance"
        ));

        for(int i = 0; i < stringList1.size() && i < stringList2.size(); i++){
            String str1 = stringList1.get(i);
            String str2 = stringList2.get(i);
            boolean checkAnagramres = AnagramChecker2Strings(str1, str2);

            System.out.println(str1+" is Anagram? =>"+checkAnagramres);
        }

        // for single input check
            System.out.println();
            System.out.println("for single input check \n");

            List<String> stringList = new ArrayList<>(List.of(
                    "listen silent", "race care", "heart earth", "cat act", "pat tap", "genre genes", "dance mance"
            ));
        AnagramChecker anagramCheckers = new AnagramChecker();
        boolean checkSingleLineAnagram;
        for(String str: stringList){
            checkSingleLineAnagram = anagramCheckers.AnagramCheckers(str);
            System.out.println(str+" is Anagram? =>"+checkSingleLineAnagram);
        }
     }
}
