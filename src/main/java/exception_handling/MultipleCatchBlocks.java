//package exception_handling;
//
//public class MultipleCatchBlocks {
//
//    public static void main(String[] args) {
//
//        int numerator=20;
//        int[] arr ={23,45,67,87,87};
//        int index=35;
//
//        String stringValue="CFG INF TIFF";
//
//        try{
//            int Q=numerator/0;
//
//        }catch (ArithmeticException ae){
//            System.out.println("Connot divide a number with zero");
//        }try{
//            System.out.println(arr[35]);
//        }catch (ArrayIndexOutOfBoundsException aiobe){
//            System.out.println("Invalid index of the array");
//        }try{
//            int stringToInt = Integer.parseInt(stringValue);
//        }catch (NumberFormatException nfe){
//            System.out.println("Invalid number format");
//
//        }
//    }
//} This solution is partially correct


package exception_handling;

public class MultipleCatchBlocks {

    public static void main(String[] args) {
        // Run three different cases to trigger and catch each exception individually
        System.out.println("--- Scenario 1: Arithmetic Exception ---");
        runTest("arithmetic");

        System.out.println("\n--- Scenario 2: Array Index Out of Bounds ---");
        runTest("array");

        System.out.println("\n--- Scenario 3: Number Format Exception ---");
        runTest("format");
    }

    public static void runTest(String scenario) {
        int numerator = 20;
        int[] arr = {23, 45, 67, 87, 87};
        int index = 35;
        String stringValue = "CFG INF TIFF";

        try {
            if (scenario.equals("arithmetic")) {
                int Q = numerator / 0; // Throws ArithmeticException
            } else if (scenario.equals("array")) {
                System.out.println(arr[index]); // Throws ArrayIndexOutOfBoundsException
            } else if (scenario.equals("format")) {
                int stringToInt = Integer.parseInt(stringValue); // Throws NumberFormatException
            }
        } catch (ArithmeticException ae) {
            System.out.println("Error: Cannot divide a number by zero.");
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println("Error: Invalid index of the array.");
        } catch (NumberFormatException nfe) {
            System.out.println("Error: Invalid number format.");
        }
    }
}
