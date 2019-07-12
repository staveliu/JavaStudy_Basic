package 刘文杰homework_old.onclassTest;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person {
    private int age;
    private String sex;

    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
            "age=" + age +
            ", sex='" + sex + '\'' +
            '}';
    }

    public static List<Person> filter(List<Person> person, Predicate<Person> p){
        return person.stream().filter(p).collect(Collectors.toList());
    }
}
