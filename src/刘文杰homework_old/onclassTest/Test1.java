package 刘文杰homework_old.onclassTest;

import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args){
        List person = new LinkedList<>();
        person.add(new Person(10,"Male"));
        person.add(new Person(19,"Female"));
        person.add(new Person(20,"Male"));
        person.add(new Person(22,"Male"));
        List<Person> person2 = Person.filter(person,person1 -> person1.getSex().equals("Male")&&person1.getAge()>=18);
        System.out.println(person2);
    }
}
