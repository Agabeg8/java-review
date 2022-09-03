package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserTest {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(User.builder().firstNama("Aga").lastName("Beg").age(30).build());
        users.add(User.builder().firstNama("Mike").lastName("Klein").age(37).build());
        users.add(User.builder().firstNama("Jerry").lastName("Capri").age(20).build());
        users.add(User.builder().firstNama("Jane").lastName("Eva").age(24).build());

        //printName(users, p -> true);

        printName(users, user -> user.getLastName().startsWith("E"));

    }
    private static void printName(List<User> users, Predicate<User> p){
        for (User user : users){
            if (p.test(user)){
                System.out.println(user.toString());
            }
        }
    }
}
