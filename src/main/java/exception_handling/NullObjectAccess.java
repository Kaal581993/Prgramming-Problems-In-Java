package exception_handling;

public class NullObjectAccess {
    public static void main(String[] args) {
        String nullString = null;

        handlingNullPointerException(nullString);

    }

    public static void handlingNullPointerException(String s){
        try{
            System.out.println(s);
        }catch(NullPointerException npe){
            npe.printStackTrace();
        }
    }
}
