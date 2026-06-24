package patterns.traversal.interview_level.reverse_traversal;

public class LongestIncreasingContinuousSegment {
    /**
     * Finds the length of the longest continuously
     * increasing segment in an array.
     * Uses window-like traversal with two pointers.
     *
     * @param arr the input array
     * @return the length of the longest increasing continuous segment
     */
    public static int findLongestIncreasingSegment(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length-1;
        int start = 0;      // Start of current window
        int end = 0;        // End of current window
        int maxLength = 1;   // Minimum length is 1 (single element)

        while (end<n){

            if(arr[end]<arr[end+1]){
                end++;
            }else{
                int currentSegmentLength=end-start+1;
                maxLength = Math.max(maxLength, currentSegmentLength);
                start=end+1;
                end=start;
            }

        }


        // Check the last segment
        int currentLength = end - start + 1;
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 4};

        int maxLength = findLongestIncreasingSegment(arr);
        System.out.println(
                "Longest Increasing Continuous Segment: "
                        + maxLength);
    }


}



