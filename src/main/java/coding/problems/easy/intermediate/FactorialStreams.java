package coding.problems.easy.intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactorialStreams {
    public static void main(String[] args) {
        int number =10;

        List<Integer> factorial = Stream
                .iterate(new int[] {1,1}, f -> new int[]{
                        f[0] + 1,
                        f[1] * (f[0] + 1)
                })
                .limit(number)
                .map(f-> f[0])
                .collect(Collectors.toList());

        System.out.println("The factorial of "+number+" is: "+factorial);
    }
}
