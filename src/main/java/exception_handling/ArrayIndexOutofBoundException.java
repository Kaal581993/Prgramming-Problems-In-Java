package exception_handling;

public class ArrayIndexOutofBoundException {

    public static void main(String[] args) {

        int[] arr = {10,20,30};
        int index = 5;

        try {

            for(int i=0;i<=index;i++){
                System.out.println(arr[i]);
                //or
                System.out.println(arr[5]);
            }

        }catch (ArrayIndexOutOfBoundsException aie){
            System.out.println("Invalid array index.");
        }
    }
}
