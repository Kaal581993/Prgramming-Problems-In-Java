package coding.problems.easy.intermediate.advance.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;




public class MinimumWindowSubstring {


    
    public static void minWindow (String s, String t){

//        if (s == null || t == null || s.length() < t.length()) {
//            return "";
//        }

        int left=0;

        int right=0;

        // 'formed' tracks how many unique characters
        // in the window match the required frequency in t




        Character c;
        Map<Character, Long> targetCounts = new HashMap<>();

         IntStream.range(0, t.length())
                 .forEach( i->{char currChar = t.charAt(i);
                     targetCounts.put(
                             currChar, targetCounts.getOrDefault(
                                 (Object) currChar, 0L)+1);}
                 );


        int requiredUniqueChars = targetCounts.size();
        AtomicInteger formed = new AtomicInteger();
        // Track the best window details: {length, leftIndex, rightIndex}
        int minLength = Integer.MAX_VALUE;
        int bestLeft = 0;
        int bestRight = 0;
            // Add the character on the right to the window


        System.out.println(targetCounts);
        Map<Object, Long> windowCounts = new HashMap<>();

        IntStream.range(0, s.length())
                .forEach(i ->{
                    char rightChar = s.charAt(right);
                    windowCounts
                            .put(rightChar,
                                    windowCounts
                                            .getOrDefault(rightChar,
                                                    0L) + 1);

                    if (targetCounts.containsKey(rightChar) &&
                            windowCounts.get(rightChar)
                                    .equals(targetCounts.get(rightChar))) {
                        formed.getAndIncrement();
                    }


                });

        System.out.println(windowCounts);


       // return targetCounts;
    }
    public static void main(String[] args) {
        String s="ADOBECODEBANC";

        String t="ABC";

        minWindow(s,t);

    }
}
