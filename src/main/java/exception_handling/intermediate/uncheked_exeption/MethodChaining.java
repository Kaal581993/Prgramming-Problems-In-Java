package exception_handling.intermediate.uncheked_exeption;

public class MethodChaining {
    public static void main(String[] args) {

        try{
            System.out.println("Calling Method A");
             methodA();
        }catch (customException ce){
            System.err.println("Transaction Failed: " + ce.getMessage());
        }

    }

    public static void methodA() throws customException{


            System.out.println("Calling method B");
            methodB();


    }
    public static void methodB() throws customException{
            System.err.println("Calling method C");
            methodC();

    }
    public static void methodC() throws customException{
            System.out.println("This is method C");
//            methodA();
        if(1==1){
            throw new customException("This is Custom Method Chaining Exception example");
        }

    }
}

class customException extends RuntimeException{

    public customException(String message){
        super(message);
    }
}
