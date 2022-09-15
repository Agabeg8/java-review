import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavCollectors {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,4,5,6,6,7);

        //toCollection(Supplier): is used to create a collection using collector
        System.out.println("========TOCOLLOCTION=======");
        List<Integer> numberList = numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(numberList);

        Set<Integer> numberSet = numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(numberSet);

        //toList() : return a CCollector interface that gathers the input data into a new list

        System.out.println("========TOLIST=======");
        List<Integer> numberList2 = numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toList());

        System.out.println(numberList2);

        //toSet : return a Collector interface that gathers the input data into a new set
        System.out.println("========TOSET=======");
        Set<Integer> numberSet2 = numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toSet());

        System.out.println(numberSet2);

        //toMap(Function, Function) : return a Collector interface that gathers the input data into a new map
        System.out.println("========TOMAP=======");
        Map<String, Integer> dishMap = DishData.getAll().stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));

        System.out.println(dishMap);

        //counting()  : returns a Collector that counts the number of the elements
        System.out.println("========COUNTING=======");
        Long evenCount = numbers.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.counting());

        System.out.println(evenCount);

        //summingInt(ToIntFunction) : returns a Collector that produces the sum of a integer-valued func
        Integer sum = DishData.getAll().stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);

    }
}
