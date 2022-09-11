import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {

        //Print all emails - One employee has one email - One to One
        EmployeeData.readAll()
                .map(Employee::getEmEmail)
                .forEach(System.out::println);

        //Print all phone numbers
        System.out.println("=================");
        EmployeeData.readAll()
                .map(Employee::getEmPhoneNumber)
                .forEach(System.out::println);

        System.out.println("=================");
        EmployeeData.readAll()
                .flatMap(employee -> employee.getEmPhoneNumber().stream())
                .forEach(System.out::println);

        System.out.println("=================");
        EmployeeData.readAll()
                .map(Employee::getEmPhoneNumber)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }
}
