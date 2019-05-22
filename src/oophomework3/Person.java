package oophomework3;

public class Person {
    private String name,sex;
    private int age;
    private static int count=0;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        count++;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display(){
        System.out.println("Object "+ count+":");
        System.out.println("\tName = "+name);
        System.out.println("\tSex = "+sex);
        System.out.println("\tAge = "+age);
        System.out.println("------------------------------");

    }
}
