package OOPHomework1.shapes;

public class TestBall {
    public static void main(String[] args){
        Ball ball1 = new Ball();
        ball1.setColor("red");
        ball1.setRadius(2.0f);
        Ball ball2 = new Ball();
        ball2.setColor("green");
        ball2.setRadius(4.0f);
        System.out.println("球体列表\n-----------------------------------");
        ball1.display();
        ball2.display();
    }
}
