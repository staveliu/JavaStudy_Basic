package maphomework.studentmanage;

import java.util.*;

public class StudManage {
    public static void main(String[] args){
        Map<String, Student> students = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int opera;
        while(true){
            System.out.println("---------------------------------\n" +
                    "1.查询所有学生信息\n" +
                    "2.根据学号查询信息\n" +
                    "3.增加学生信息\n" +
                    "4.根据学号修改信息\n" +
                    "5.根据学号删除信息\n" +
                    "6.退出系统\n" +
                    "----------------------------------");
            opera = in.nextInt();
            switch(opera){
                case 1:{
                    Set<String> studnos = students.keySet();
                    System.out.println("---------------------------------\nStudent Info:");
                    if (students.isEmpty()){
                        System.out.println("\tEmpty!");
                        System.out.println("---------------------------------");
                    }
                    for (String studno:studnos){
                        System.out.println("\tName: "+students.get(studno).getName());
                        System.out.println("\tSex: "+students.get(studno).getSex());
                        System.out.println("\tAge: "+students.get(studno).getAge());
                        System.out.println("\tMajor: "+students.get(studno).getMajor());
                        System.out.println("\tClassNo: "+students.get(studno).getClassNo());
                        System.out.println("\tAddress: "+students.get(studno).getAddress());
                        System.out.println("---------------------------------");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Please input Student No:");
                    String studno = in.next();
                    if (students.containsKey(studno)){
                        System.out.println("---------------------------------\nStudent Info:");
                        System.out.println("\tName: "+students.get(studno).getName());
                        System.out.println("\tSex: "+students.get(studno).getSex());
                        System.out.println("\tAge: "+students.get(studno).getAge());
                        System.out.println("\tMajor: "+students.get(studno).getMajor());
                        System.out.println("\tClassNo: "+students.get(studno).getClassNo());
                        System.out.println("\tAddress: "+students.get(studno).getAddress());
                        System.out.println("---------------------------------");
                    }else{
                        System.out.println("Student No Invalid");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Please input student number:");
                    String studno = in.next();
                    System.out.println("Please input name:");
                    String name = in.next();
                    System.out.println("Please input sex:");
                    int sex = in.nextInt();
                    System.out.println("Please input age:");
                    int age = in.nextInt();
                    System.out.println("Please input major:");
                    String major = in.next();
                    System.out.println("Please input ClassNo:");
                    String classNo = in.next();
                    System.out.println("Please input address:");
                    String address = in.next();
                    Student newStud = new Student(studno,name,sex,age,major,classNo,address);
                    if (!students.containsKey(studno)){
                        students.put(studno,newStud);
                        System.out.println("Successful");
                    }else{
                        System.out.println("Student No Exist.");
                    }
                    break;
                }
                case 4:{
                    System.out.println("Please input a Student No You want to change:");
                    String studno = in.next();
                    if (!students.containsKey(studno)){
                        System.out.println("Not exist.");
                        break;
                    }
                    System.out.println("Please input new name:");
                    String name = in.next();
                    System.out.println("Please input new sex:");
                    int sex = in.nextInt();
                    System.out.println("Please input new age:");
                    int age = in.nextInt();
                    System.out.println("Please input new major:");
                    String major = in.next();
                    System.out.println("Please input new ClassNo:");
                    String classNo = in.next();
                    System.out.println("Please input new address:");
                    String address = in.next();
                    Student newStud = new Student(studno,name,sex,age,major,classNo,address);
                    students.put(studno,newStud);
                    System.out.println("Successful");
                    break;
                }
                case 5:{
                    System.out.println("Please input a Student No You want to change:");
                    String studno = in.next();
                    if (!students.containsKey(studno)){
                        students.remove(studno);
                        System.out.println("Successful");
                    }else{
                        System.out.println("Student No Exist.");
                    }
                }
                case 6:{
                    System.out.println("Good bye!");
                    System.exit(0);
                }
            }
        }
    }
}
