//package exception_handling.intermediate;
//
//public class FinallyBlockExecution {
//    public static void main(String[] args) {
//
//        int index=0;
//
//        int arr[] = {12,45,35,68,95,43,69};
//
//        try{
//            for(int i=0;i<arr.length;i++){
//                System.out.println(arr[i]/index);
//            }
//        }catch (ArithmeticException ae){
//            System.out.println("Invalid index found");
//        } finally{
//            for(int i=0;i<arr.length;i++){
//                System.out.println(arr[i]/(index+1));
//            }
//        }
//    }
//}


/**
 *
 * Your original code did not fully solve the problem for a few reasons:
 *
 * No Exception case: The division by zero (arr[i] / index where index = 0)
 * was hardcoded, meaning it always threw an exception. It did not dynamically
 * test the path where no exception occurs.
 *
 *
 * Return statement inside try: It did not include a return statement
 * within the try block to demonstrate that the finally block executes even
 * when returning early.
 *
 * To fix this, I created a new implementation at
 * FinallyBlockExecution.java
 *  that defines three separate methods, one for each test
 *  case required by the problem.
 *
 * Corrected Implementation
 *
 * */


package exception_handling.intermediate;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        System.out.println("--- Test Case 1: No exception ---");
        testNoException();
        System.out.println();

        System.out.println("--- Test Case 2: Exception occurs ---");
        testExceptionOccurs();
        System.out.println();

        System.out.println("--- Test Case 3: Return statement inside try ---");
        int result = testReturnInsideTry();
        System.out.println("Returned value: " + result);
    }

    // Test Case 1: No exception occurs
    public static void testNoException() {
        try {
            System.out.println("Inside try: No exception will be thrown.");
            int a = 10 / 2;
            System.out.println("Division result: " + a);
        } catch (ArithmeticException e) {
            System.out.println("Inside catch: ArithmeticException caught.");
        } finally {
            System.out.println("Inside finally: This always executes.");
        }
    }

    // Test Case 2: Exception occurs
    public static void testExceptionOccurs() {
        try {
            System.out.println("Inside try: About to divide by zero.");
            int a = 10 / 0;
            System.out.println("Division result: " + a); // will not execute
        } catch (ArithmeticException e) {
            System.out.println("Inside catch: ArithmeticException caught.");
        } finally {
            System.out.println("Inside finally: This always executes.");
        }
    }

    // Test Case 3: Return statement inside try
    public static int testReturnInsideTry() {
        try {
            System.out.println("Inside try: About to execute return statement.");
            return 100;
        } catch (Exception e) {
            System.out.println("Inside catch.");
            return -1;
        } finally {
            System.out.println("Inside finally: Executing before returning from try.");
        }
    }
}