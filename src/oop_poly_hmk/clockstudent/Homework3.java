package oop_poly_hmk.clockstudent;

import java.util.Date;

public class Homework3 {
    public static void main(String[] args) {
        Student pupil1 = new Pupil("Susan");
        Student student2 = new University("Tom");
        pupil1.showInfo();
        student2.showInfo();
        Date dt = new Date();
        int hours = dt.getHours();
        if (hours==5||hours==6) {
            pupil1.clockMe();
            System.exit(0);
        }
        if (hours==5||hours==6||hours==7){
            student2.clockMe();
            System.exit(0);
        }
        if (hours>7){
            pupil1.goToSchool();
            student2.goToSchool();
            System.exit(0);
        }
        System.out.println("You don't need to do anything at this time!");
    }
}
