package oop_extend_hmk.person;

public class Homework2 {
    public static void main(String[] args){
        State person1 = new State();
        State person2 = new State("Stave","Male",20,"China");
        State person3 = new State("Linda","Female",18);
        State person4 = new State("Marry","Female",20,"USA");
        person1.showMessage();
        person2.showMessage();
        person3.showMessage();
        person4.showMessage();
    }
}
