package coding.problems.easy.intermediate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFreqElements {

    public static void main(String[] args) {
        List<Integer> integerElements = new ArrayList<>(List.of(
                1,1,1,2,2,3,3,3,3,3
        ));


        int frequencyNumber = 3;


        Map<Integer, Long> frequencyMap = integerElements
                                .stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println("Frequent Elements"+frequencyMap);



        List<Integer> topK = frequencyMap.entrySet().stream().sorted(
                Map.Entry.<Integer, Long> comparingByValue().reversed())
                        .limit(frequencyNumber)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());


        System.out.println("Highest Count K Elements: "+topK);


        System.out.println("\nBy using Priority Queue\n");


        PriorityQueue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>(
                (a,b) -> a.getValue().compareTo(b.getValue())
        );

        for(Map.Entry<Integer, Long> entry: frequencyMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > frequencyNumber){
                minHeap.poll();
            }
        }

        List<Integer> topk2 = new ArrayList<>();

        while (!minHeap.isEmpty()){
            topk2.add(minHeap.poll().getKey());
        }

        Collections.reverse(topk2);

        System.out.println("Highest Count K Elements: "+topk2);


//        System.out.println("PriorityQueue Elements"+queueElements);

//        int result = Math.toIntExact(queueElements.stream().distinct().count());

//        System.out.println("Highest Count K Elements: "+result);

    }
}
