package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.List;

public class ArmStrongNumberCheck {


    public static void armStrongAnalyserDirectStream(String s) {

        System.out.println("The selected Number is: " + s);

        int armStrongCalculator = s.chars() // 1. Get IntStream of character codes (ASCII)
                .map(ch -> ch - '0') // 2. Convert character code to numeric digit
                .peek(System.out::println) // 3. Print the digit (matching original code)
                .map(digit -> { // 4. Calculate cube and print details
                    int cube = digit * digit * digit;
                    System.out.println("The Cube of " + digit + " is :" + cube);
                    return cube;
                }).sum();


        System.out.println("The sum of the cubes is: " + armStrongCalculator);
        if (Integer.parseInt(s) == armStrongCalculator) {
            System.out.println("\n The given number : " + s + " is an ArmStrong number \n");
        } else {
            System.out.println("\n The given number : " + s + " is not an ArmStrong number \n");

        }
    }

    private static boolean isArmstrong(String s) {
        int sumOfCubes = s.chars()
                .map(ch -> ch - '0')
                .map(digit -> digit * digit * digit)
                .sum();

        return Integer.parseInt(s) == sumOfCubes;
    }

    private static boolean isArmstrongGeneralized(String s) {
        int length = s.length();
        int sum = s.chars()
                .map(ch -> ch - '0')
                .map(digit -> (int) Math.pow(digit, length))
                .sum();

        return Integer.parseInt(s) == sum;
    }
    public static void main(String[] args) {

        List<String> arstrongList = new ArrayList<>(List.of(
                "153", "370", "371" , "407", "587","357","968"
        ));

        for(String s : arstrongList){
            armStrongAnalyser(s);
        }

    }

    private static void  armStrongAnalyser(String s) {
//        int length = s.length();
        Integer[] stringToInt= new Integer[s.length()];

        int cube[] = new int[s.length()];

        int armStrongCalculator = 0;
        System.out.println("The selected Number is: "+s);

        for(int i=0; i<s.length();i++){
            stringToInt[i] = s.charAt(i) - '0';
            System.out.println(stringToInt[i]);

            cube[i]= stringToInt[i]*stringToInt[i]*stringToInt[i];

            System.out.println("The Cube of "+stringToInt[i]
                    +" is :"+cube[i]);

            armStrongCalculator = armStrongCalculator + cube[i];



        }

        System.out.println("The sum of the cubes is: "+armStrongCalculator);


        if (Integer.parseInt(s) == armStrongCalculator) {
            System.out.println("\n The given number : " + s + " is an ArmStrong number \n");
        }else {
            System.out.println("\n The given number : " + s + " is not an ArmStrong number \n");
        }

        //return Arrays.toString(stringToInt);

    }


}
