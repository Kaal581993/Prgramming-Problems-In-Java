package patterns.traversal.list.two_pointer_traversal;

public class CountMatchingPairs {
    public static void main(String[] args) {

        int [] arr={1,2,2,1,1,3,3,1};

        int count=0;

        // For each element, pair it with all elements to its right
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;



            while (j < arr.length) {
                System.out.println(arr[i]+","+arr[j]);
                // Check if elements at i and j form a matching pair
                if (arr[i] == arr[j]) {
                    count++;
                }
                j++;
            }
        }

        System.out.println(count);
    }
}
