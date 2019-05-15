package OOPHomework1.shapes;

public class TestBox {
    public static void main(String[] args){
        Box box1 = new Box();
        Box box2 = new Box();
        box1.setLength(1.0f);
        box1.setHeight(1.0f);
        box1.setWidth(1.0f);
        box2.setLength(4.0f);
        box2.setWidth(2.0f);
        box2.setHeight(1.0f);
        System.out.println("长方体列表\n-----------------------------------");
        box1.display();
        box2.display();
    }
}
