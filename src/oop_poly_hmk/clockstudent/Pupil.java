package oop_poly_hmk.clockstudent;

public class Pupil extends Student{

    public Pupil(String name) {
        super(name);
    }

    @Override
    public void goToSchool() {
        super.setType("Pupil");
        System.out.println(super.getType() + ": Please go to school");
    }

    @Override
    public void clockMe() {
        super.setType("Pupil");
        System.out.println(super.getType() + ": Please make some exercise!");
    }
}
