package exception_handling;

public class NumberParsing {
    public static void main(String[] args) {
        String string = "abc";


        try{

            int stringToInt = Integer.parseInt(string);

            System.out.println(stringToInt);

        }catch (NumberFormatException nfe){
            System.out.println("Invalid number format.");
        }
    }
}
