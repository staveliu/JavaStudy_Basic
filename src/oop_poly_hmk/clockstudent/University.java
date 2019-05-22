package oop_poly_hmk.clockstudent;

public class University extends Student{
    public University(String name) {
        super(name);
    }

    @Override
    public void goToSchool() {
        super.setType("University Student");
        System.out.println(super.getType() + ": Please go to school");
    }

    @Override
    public void clockMe() {
        super.setType("University Student");
        System.out.println(super.getType() + ": Please make some exercise!");
    }
}
