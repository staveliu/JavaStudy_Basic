package oop_extend_hmk.car;

public class Car {
    private String color;
    private String model;

    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }
    public Car(){
        this.color = "Red";
        this.model = "Sedan";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
