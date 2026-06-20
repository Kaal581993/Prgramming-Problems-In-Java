package coding.problems.easy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(List.of(
                "Programming","Madam","Jhonny"
        ));

        System.out.println("The String List"+stringList);
        //Set<Character> uniqueChar = new LinkedHashSet();

        for(int i=0; i<stringList.size(); i++){
            //char[] chars = str.toCharArray();
            String original = stringList.get(i);
            Set<Character> uniqueChar = new LinkedHashSet();
                for (int j=0;j<original.length();j++){
                    uniqueChar.add(original.charAt(j));
                }

                StringBuilder sb = new StringBuilder();
                for(Character ch: uniqueChar){
                    sb.append(ch);
                }

                stringList.set(i, sb.toString());
        }

        System.out.println("\n After string modification \n"+stringList);

        System.out.println("\n Solution using Streams");

        List<String> result = stringList.stream()
                .map(str -> str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        .stream()
                        .collect(StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append)
                        .toString())
                .collect(Collectors.toList());

        System.out.println(result);



    }
}
