//package exception_handling.intermediate;
//
//public class NestedTryCatch {
//    public static void main(String[] args) {
//
//        int[] nums={35,45,32,56,78,98,56,45};
//        int index =nums.length ;
//        int[] result;
//
//        try{
//            for(int i=0, j=nums.length-1; i<100 && j>=0; i++, j--){
//                      result= new int[]{nums[i] / index};
//                        index --;
//                System.out.println(result);
//
//                try {
//                    System.out.println(nums[i]);
//                } catch (ArrayIndexOutOfBoundsException aIOBE) {
//                    System.out.println("Invalid Array Index");
//                }
//            }
//        }catch (ArithmeticException ae){
//            System.out.println("Invalid Arithmetic Operation divide by 0");
//        }
//
//
//    }
//}
/**
 *
 * No, this solution also does not work and will cause the program to crash.
 * It introduces new bugs that prevent it from demonstrating the requested
 * exception handling.
 *
 * Here is a detailed breakdown of the issues:
 *
 * 1. Critical Crash: ArrayIndexOutOfBoundsException on the Second Iteration
 * On line 14, result is initialized as an array of size 1:
 * result = new int[]{nums[i] / index};.
 * On line 16, the code attempts to print the value: System.out.println(result[i]);.
 * On the first iteration (i = 0), this works because it accesses result[0].
 *
 * On the second iteration (i = 1), it attempts to access result[1] from an
 * array of size 1. This throws an ArrayIndexOutOfBoundsException on line 16.
 *
 * Because line 16 is outside the inner try block (which only starts on line 18)
 * and the outer catch only handles ArithmeticException, the program crashes
 * immediately with an unhandled exception.
 *
 * 2. ArithmeticException is Never Triggered
 * The loop is bound by the condition j >= 0 where j starts at
 * nums.length - 1 (7) and decrements.
 * This means the loop will run exactly 8 times (for i from 0 to 7).
 * Since index starts at 8 and decrements once per loop iteration,
 * it will go from 8 down to 1. It will never reach 0.
 * Therefore, the division-by-zero scenario (ArithmeticException)
 * is never triggered.
 *
 * 3. Misplaced Catch Blocks
 * The inner try block only protects System.out.println(nums[i]);.
 * However, the array access nums[i] on line 14 is outside of the inner
 * try block. If i were to exceed the bounds of the array, the program
 * would crash before ever reaching the inner try-catch block.
 * Recommended Corrected Approach
 * To correctly demonstrate nested try-catches where both blocks can
 * actually be executed and catch their respective exceptions, you should
 * trigger the exceptions safely inside their designated blocks:
 * */


package exception_handling.intermediate;

public class NestedTryCatch {
    public static void main(String[] args) {
        int[] nums = {35, 45, 32, 56, 78, 98, 56, 45};

        // Outer Try: Designed to handle ArithmeticException
        try {
            int num = 50;
            int divisor = 0; // Triggering division by zero

            System.out.println("Outer Try: Attempting division...");
            int result = num / divisor;
            System.out.println("Result: " + result);

        } catch (ArithmeticException ae) {
            System.out.println("Outer Catch: Invalid Arithmetic Operation (divide by 0).");

            // Nested Inner block inside the catch block (or inside the outer try)
            // accessing invalid array element
            try {
                System.out.println("Inner Try: Attempting to access out-of-bounds array element...");
                System.out.println(nums[10]); // Throws ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException aIOBE) {
                System.out.println("Inner Catch: Invalid Array Index accessed.");
            }
        }

        System.out.println("Execution finished cleanly.");
    }
}