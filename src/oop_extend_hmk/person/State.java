package oop_extend_hmk.person;

public class State extends Person {
    private String name;

    public State() {
        super();
    }

    public State(String name, String sex, int age, String name1) {
        super(name, sex, age);
        this.name = name1;
    }
    public State(String name, String sex, int age) {
        super(name, sex, age);
        this.name = "China";
    }

    @Override
    public void showMessage() {
        super.showMessage();
        System.out.println("Country: "+this.name);
        System.out.println();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
