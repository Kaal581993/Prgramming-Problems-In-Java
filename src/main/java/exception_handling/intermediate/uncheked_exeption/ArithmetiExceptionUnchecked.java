package exception_handling.intermediate.uncheked_exeption;

public class ArithmetiExceptionUnchecked {

    public static void main(String[] args) {

        int numerator=34;
        int denominator=0;

        try{
            ArithmetiValdation(numerator,denominator);

        }catch (ArithmeticException ae){
            System.err.println("Failed Calulation"+ae.getMessage());
        }
    }

    public static int ArithmetiValdation(int numerator, int denominator)
            throws ArithmeticException{

        if(denominator<=0){
            throw new RuntimeException("Cannot Divide a number by 0");
        }

        return numerator/denominator;
    }

}

class ArithmeticException extends RuntimeException{
    public ArithmeticException(String message){
        super(message);
    }
}
