package coding.problems.easy.intermediate.advance.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class LongestSubstringWithoutRepeatingCharacters {



    /**
     * Method 1: Sliding Window using the Collections Framework (HashMap)
     */
    public static int lengthOfLongestSubstringCollections(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        int left = 0;


        // Map to store character -> its last seen index
        Map<Character, Integer> lastSeen = new HashMap<>();


        for (int right = 0; right < s.length(); right++) {

            System.out.println("Right: "+right);
            char currChar = s.charAt(right);
            System.out.println("Current Char: "+currChar);
            // If character is a duplicate and is inside the current window
            if (
                    lastSeen.containsKey(currChar)
                            &&
                    lastSeen.get(currChar) >= left
            ) {
                // Move the left boundary past the last occurrence of currChar
                left = lastSeen.get(currChar) + 1;
                System.out.println("Left: "+left);
            }
            // Update/insert the last seen index
            lastSeen.put(currChar, right);
            System.out.println("LastSeen"+lastSeen);
            // Track the maximum length

            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println("MaxLength"+maxLength);

        }
        return maxLength;
    }


    /**
     * Method 2: Stateful Stream-based implementation
     */
    public static int lengthOfLongestSubstringStreams(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Custom state container to track sliding window state

        class WindowState {
            int left = 0;
            int maxLength = 0;
            final Map<Character, Integer> lastSeen = new HashMap<>();
            // Accumulator function for processing each index (right pointer)
            void accept(int right) {
                char currChar = s.charAt(right);
                // If duplicate found within current window, shift left pointer
                if (lastSeen.containsKey(currChar) && lastSeen.get(currChar) >= left) {
                    left = lastSeen.get(currChar) + 1;
                }
                lastSeen.put(currChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            // Combiner function (required for parallel capability,
            // though not used here)
            WindowState combine(WindowState other) {
                throw new UnsupportedOperationException("Parallel execution is not supported.");
            }
        }
        // Run the stream sequentially over indices and collect
        // into our custom state
        WindowState finalState = IntStream.range(0, s.length())
                .boxed()
                .collect(
                        WindowState::new,
                        WindowState::accept,
                        WindowState::combine
                );
        return finalState.maxLength;
    }




    public static void main(String[] args) {

        String inputString ="abcabcbb";

        //lengthOfLongestSubstringCollections(inputString);
        lengthOfLongestSubstringStreams(inputString);
//        Stream<Character> charStream = inputString.chars()
//                .mapToObj(c -> (char) c);


//        String distinctChar =charStream
//                .distinct().toString().;
//
//        System.out.println(Arrays.toString(distinctChar.toString()));

       // Map<Character, Integer> characterConversion =



    }
}
