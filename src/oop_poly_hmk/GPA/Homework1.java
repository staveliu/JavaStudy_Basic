package oop_poly_hmk.GPA;

import java.util.Scanner;

public class Homework1 {
    public static Student[] getStudent(int num){
        Student[] Students = new Student[num];
        for (int i=0;i<num;i++){
            Students[i] =new Student(null,null,-1);
        }
        return Students;
    }
    public static void showStudent(Student[] Students){
        for (Student temp : Students){
            System.out.println("Name: "+temp.getName());
            System.out.println("Major: "+temp.getMajor());
            System.out.println("Grade: "+temp.getGrade());
            System.out.println("Level: "+temp.getGradeLevel());
            System.out.println("GPA: "+temp.getGPA());
        }
    }
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        System.out.println("How many students would you want to input?");
        int num = a.nextInt();

        Student[] Students = getStudent(num);
        for (int i=0;i<num;i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("NO."+(i+1));
            System.out.println("Please input Name");
            String name = sc.nextLine();
            System.out.println("Please input Major");
            String major = sc.nextLine();
            System.out.println("Please input grade");
            double grade = sc.nextDouble();
            Students[i].setName(name);
            Students[i].setMajor(major);
            Students[i].setGrade(grade);
            System.out.println();
        }
        showStudent(Students);
    }
}
