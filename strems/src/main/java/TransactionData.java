import java.util.Arrays;
import java.util.List;

public class TransactionData {

    public static List<Transaction> getAll(){
        Trader raul = new Trader("Raul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        return Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raul,2012,1000),
                new Transaction(raul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );


    }
}
