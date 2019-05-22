package oop_poly_hmk.GPA;

public class Student {
    private String name;
    private String major;
    private double grade;
    private char gradeLevel=' ';
    private double GPA=0;

    public Student(String name, String major, double grade) {
        this.name = name;
        this.major = major;
        this.grade = grade;

    }

    public void show(){
        System.out.printf("Name:%s\nMajor:%s\n",name,major);
    }
    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public char getGradeLevel() {
        if (grade>=90&&grade<=100){
            this.gradeLevel = 'A';
        }else if (grade>=80&&grade<90){
            this.gradeLevel = 'B';
        }else if (grade>=70&&grade<80){
            this.gradeLevel = 'C';
        }else if (grade>=60&&grade<70){
            this.gradeLevel = 'D';
        }else if (grade>=0&&grade<60){
            this.gradeLevel = 'F';
        }
        return gradeLevel;
    }

    public void setGradeLevel(char gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGPA() {
        if (grade>=90&&grade<=100){
            this.GPA = 4.0;
        }else if (grade>=80&&grade<90){
            this.GPA = 2.75;
        }else if (grade>=70&&grade<80){
            this.GPA = 1.75;
        }else if (grade>=60&&grade<70){
            this.GPA = 0.75;
        }else if (grade>=0&&grade<60){
            this.GPA = 0;
        }else{
            this.GPA = -1;
        }
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
