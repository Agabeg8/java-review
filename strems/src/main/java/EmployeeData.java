import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class EmployeeData {

    public static Stream<Employee> readAll(){
        return Stream.of(
                new Employee(100, "Mike", "mike@gmail.com", Arrays.asList("2030456432","2567587534")),
                new Employee(100, "Aga", "aga@gmail.com", Arrays.asList("7540456432","2034587534")),
                new Employee(100, "Peter", "peter@gmail.com", Arrays.asList("7959045643","3224587534"))
        );
    }
}
