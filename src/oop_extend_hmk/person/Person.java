package oop_extend_hmk.person;

public class Person {
    private String name;
    private String sex;
    private int age;
    private static int count = 0;
    private int s;

    public Person() {
        this.name = null;
        this.sex = null;
        this.age = -1;
        count++;
        s=count;
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        count++;
        s=count;
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
    public void showMessage(){
        System.out.println("Show NO."+s+" personal information:");
        System.out.println("Sex: "+this.sex);
        System.out.println("Age: "+this.age);
    }

}
