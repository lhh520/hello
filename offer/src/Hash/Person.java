package Hash;
import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                int num = person1.getAge() - person2.getAge();
                return Integer.compare(num, 0);
            }
        });
        treeMap.put(new Person(3), "person1");
        treeMap.put(new Person(18), "person2");
        treeMap.put(new Person(35), "person3");
        treeMap.put(new Person(16), "person4");
        List<Person> bookList = new ArrayList<>();
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println(myList.toString());
        //List<String> myList = Arrays.asList("Apple","Banana", "Orange");
    }

}
