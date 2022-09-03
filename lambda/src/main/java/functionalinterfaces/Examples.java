package functionalinterfaces;

import java.util.function.Predicate;

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
    }
}
