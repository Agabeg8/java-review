import java.util.HashSet;
import java.util.Set;

public class SetReview {
    public static void main(String[] args) {
        Set<Student> mySet = new HashSet<>();

        mySet.add(new Student(7, "Jack"));
        mySet.add(new Student(8, "John"));
        mySet.add(new Student(9, "David"));
        mySet.add(new Student(9, "David"));

        System.out.println(mySet);

        Set<Integer> numSet =  new HashSet<>();
        numSet.add(1);
        numSet.add(2);
        System.out.println(numSet);
        System.out.println(numSet.add(2));
        System.out.println("First repeating: "+firstRepeatingChar("Java developer.."));
    }
    public static Character firstRepeatingChar(String str){

        Set<Character> chars = new HashSet<>();
        for (Character ch:str.toCharArray()) if(!chars.add(ch)) return ch;
        return null;
    }

}
