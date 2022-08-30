import java.util.*;

public class ArrayListReview {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Jose"));
        students.add(new Student(2, "Aga"));
        students.add(new Student(3, "Mike"));
        students.add(new Student(4, "Bella"));

        System.out.println(students);

        for (int i = 0; i <students.size() ; i++) {
            System.out.println(students.get(i));
        }
        System.out.println("-------Printing with Iterator Forward------");
        Iterator iter = students.listIterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("-------Printing with Iterator Backward------");
        while (((ListIterator<?>) iter).hasPrevious()){
            System.out.println(((ListIterator<?>) iter).previous());
        }
        System.out.println("-------Printing with For each------");
        for (Student student:students) System.out.println(student);

        System.out.println("-------Printing with Lambda------");
        // Lambda
        students.forEach(student -> System.out.println(student));

        System.out.println("-------Printing with sorted List by comp------");
        Collections.sort(students,new sortByIdDesc());
        System.out.println(students);

        System.out.println("-------Printing with sorted List by Name Desc------");
        Collections.sort(students,new sortByNameIdDesc());
        System.out.println(students);

    }
    static class sortByIdDesc implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id;
        }
    }
    static class sortByNameIdDesc implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }

}
