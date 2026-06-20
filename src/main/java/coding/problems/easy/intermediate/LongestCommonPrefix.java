package coding.problems.easy.intermediate;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] inputString) {
        if (inputString == null || inputString.length == 0) {
            return "";
        }

        String result = inputString[0];

        for (int i = 1; i < inputString.length; i++) {
            while (inputString[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                System.out.println(result);
                if (result.isEmpty()) {
                    return "";
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String inputString[] = {"flower", "flow", "flight"};

        System.out.println("The Longest Common Prefix is:" + longestCommonPrefix(inputString));
    }
}
