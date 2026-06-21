package patterns.traversal.list.basic_forward_traversal.array_problems;

public class PrintAllElements {
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50};

        for(int element :arr){
            System.out.println(element);
        }
        System.out.println();

        for (int i=0; i <arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
