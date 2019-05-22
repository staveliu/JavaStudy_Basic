package oop_extend_hmk.car;

public class CarHonda extends Car {
    private String produce;
    private static int count=0;
    private int s;
    public CarHonda(String color, String model, String produce){
        super(color,model);
        this.produce = produce;
        count++;
        s=count;
    }
    public CarHonda(){
        this("Blue");
    }

    public CarHonda(String color){
        super.setColor(color);
        this.produce = "GuangZhou Honda";
        count++;
        s=count;
    }


    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public void display(){
        System.out.println("The "+s+" car is:");
        System.out.println("\tProduce: "+this.produce);
        System.out.println("\tColor: "+super.getColor());
        System.out.println("\tModel: "+super.getModel()+"\n");
    }
}
