package functionalinterfaces;

import java.util.function.*;

public class Examples {
    public static void main(String[] args) {

        //************PREDICATE************//
//        Predicate<Integer> lesserThan = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer<18;
//            }
//        };
//        lesserThan.test(50);
        Predicate<Integer> lesserThan = a -> a < 18; //Implementation of test method that belongs to Predicate interface
        Boolean result = lesserThan.test(50);
        System.out.println(result);

        //************CONSUMER************//
        Consumer<Integer> display = i -> System.out.println(i);
        display.accept(50);

        //************BICONSUMER************//
        BiConsumer<Integer, Integer> addTwo = (x,y) -> System.out.println(x+y);
        addTwo.accept(300,200);

        //************FUNCTION************//
        Function<String,String> fun = s -> "Hello " + s;
        String str = fun.apply("Aga");
        System.out.println(str);

        //************SUPPLIER************//
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

    }
}
