import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4,5,3,9);
        int result = numbers.stream().reduce(0,(a,b) -> a+b);
        System.out.println(result);

        //NO INITIAL VALUE
        Optional<Integer> result2 = numbers.stream().reduce((a, b) -> a+b);
        System.out.println(result2);

        //MAX AND MIN
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        System.out.println("Min: "+min.get());
        System.out.println("Max: "+max.get());
        System.out.println("Sum: "+sum.get());




    }
}
