package doublecolonoperator;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarTest {
    public static void main(String[] args) {

        //Zero Argument
        Supplier<Car> c1 = () -> new Car();
        System.out.println(c1.get().getModel());

        Supplier<Car> c2 = Car::new;
        System.out.println(c2.get().getModel());

        //One Argument
        Function<Integer,Car> f1 = model -> new Car(model);
        Car bmw = f1.apply(2000);
        System.out.println(bmw.getModel());

        Function<Integer,Car> f2 = Car::new;
        Car bmw2 = f2.apply(2006);
        System.out.println(bmw2.getModel());

        //Two Argument
        BiFunction<String, Integer, Car> b1 = (make, model) -> new Car(make, model);
        Car volvo = b1.apply("Volvo", 2018);
        System.out.println(volvo.getMake() + " " + volvo.getModel());

        BiFunction<String,Integer,Car> b2 = Car::new;
        Car mercedes = b2.apply("Mercedes", 2022);
        System.out.println(mercedes.getMake() + " " + mercedes.getModel());



    }
}
