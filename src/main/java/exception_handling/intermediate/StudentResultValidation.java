package exception_handling.intermediate;

public class StudentResultValidation{

    public static void main(String[] args) {


       int marks = 30;
       try {
           marksValidation(marks);
       } catch (FailException e) {
           System.err.println("Student has Failed: " + e.getMessage());
       }
    }
    private static void marksValidation(int marks) throws FailException {
        if (marks < 35) {
            throw new FailException("User is Failed in this partiular Subject");
        }
     }
    }


 class FailException extends Exception{
    public FailException(String message) {
        super(message);
    }
}