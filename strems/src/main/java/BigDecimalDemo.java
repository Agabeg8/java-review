import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {

        double d1 = 174.45;
        double d2 = 174.23;

        System.out.println(d1-d2);

        BigDecimal b1 = new BigDecimal("174.45");
        BigDecimal b2 = new BigDecimal("174.23");

        System.out.println(b1.subtract(b2));



        //Scaling and Rounding
        BigDecimal number1 = new BigDecimal(23.12);
        System.out.println(number1.setScale(1, RoundingMode.CEILING));
        System.out.println(number1.setScale(2, RoundingMode.CEILING));
        System.out.println(number1.setScale(2, RoundingMode.FLOOR));

        System.out.println(new BigDecimal("2").compareTo(new BigDecimal("2")));
        System.out.println(new BigDecimal("2").compareTo(new BigDecimal("3")));
        System.out.println(new BigDecimal("3").compareTo(new BigDecimal("2")));

        //BigDecimal are immutable

    }
}
