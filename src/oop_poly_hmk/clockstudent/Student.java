package oop_poly_hmk.clockstudent;

public class Student {
    private String name;
    private String type;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo(){
        System.out.println("Student Name: "+name);
        System.out.println("Student Type: "+type);
    }
    public void goToSchool(){

    }
    public void clockMe(){

    }
}
