package coding.problems.easy.intermediate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetFibonacciSeriesOfaNumber {
    public static void main(String[] args) {
        int number =10;

        getFibonacciSeriesBasic(number);

        getFibonacciSeriesBasicUsingStreams(number);
    }

    public static void getFibonacciSeriesBasicUsingStreams(int number) {
        int num1=0;

        int num2 = 1;

        List<Integer> fibonacciseries
                = Stream
                .iterate(new int[]{0,1}, f ->
                    new int[]{f[1], f[0]+f[1]})
                .limit(number)
                .map(f-> f[0])
                .collect(Collectors.toList());

        System.out.println(fibonacciseries);
    }


    public static void getFibonacciSeriesBasic(int number) {

        Integer[] fibonacciseries = new Integer[number];
        int num1 = 0;
        int num2 = 1;

        for (int i = 0; i < number; i++) {

            ;
            fibonacciseries[i] = num1;

            // Calculate next number and shift the values
            int fiboit  = num1 + num2;
            num1 = num2;
            num2 = fiboit;

        }

        System.out.println(java.util.Arrays.toString(fibonacciseries));    }
}
