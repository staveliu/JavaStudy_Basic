package OOP2Homework.shapes;

public class TestBall {
    public static void main(String[] args){
        Ball ball1 = new Ball(2.0f,"red");
        Ball ball2 = new Ball(4.0f,"green");

        System.out.println("球体列表\n-----------------------------------");
        ball1.display();
        ball2.display();
    }
}
