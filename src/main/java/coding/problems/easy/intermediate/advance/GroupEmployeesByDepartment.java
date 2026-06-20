package coding.problems.easy.intermediate.advance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        Map<String, String> employeeList = new HashMap<>(
                Map.ofEntries(
                        entry("Rahul","IT"),
                        entry("Ravi","IT"),
                        entry("Daniel","Accounting"),
                        entry("Sonny","Accounting"),
                        entry("Suniel","Admin"),
                        entry("David","Admin"),
                        entry("Bunny","Manager"),
                        entry("Ganesh","Manager")
                )
        );
      //  System.out.println(employeeList);
        // 2. Stream, group by the key (Department), and map the value (Name) to a list
// Now .stream() will work directly because List is a Collection
        Map<String, List<String>> groupedByDept =
                employeeList.entrySet().stream()
                        .collect(Collectors.groupingBy(
                                Map.Entry::getValue,
                                Collectors.mapping(
                                        Map.Entry::getKey,
                                        Collectors.toList())
                        ));


        System.out.println(groupedByDept);
        System.out.println();
        // Counting of employess per department

        // Group by Value (Employee Name) and Count
        Map<String, Long> countByDep = employeeList.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.counting()
                ));
        System.out.println(countByDep);


    }
}
