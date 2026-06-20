package exception_handling;

public class DivideTwoNumbers {

    public static void main(String[] args) {
        int a=10;
        int b=0;
        int d=0;

        try{
            d=a/b;

            // Perform and print the division result
            System.out.println(d);

        }catch (ArithmeticException ae){
            System.out.println("Invalid Division! cannot divide a number by 0");
        }

        divideByZeroException(a,b);
    }

    public static int divideByZeroException(int a, int b) throws ArithmeticException{

//        try{
//            return a/b;
//        }catch (ArithmeticException ae){
//            System.out.println("Invalid Division! cannot divide a number by 0");
//
//        }  //All of this is not required
        return a/b;
    }
}

