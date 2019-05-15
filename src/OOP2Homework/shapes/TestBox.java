package OOP2Homework.shapes;

public class TestBox {
    public static void main(String[] args){
        Box box1 = new Box(1.0f,1.0f,1.0f);
        Box box2 = new Box(4.0f,2.0f,1.0f);
        System.out.println("长方体列表\n-----------------------------------");
        box1.display();
        box2.display();
    }
}
