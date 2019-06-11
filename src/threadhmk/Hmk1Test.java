package threadhmk;

public class Hmk1Test {
    public static void main(String[] args){
        Thread th1 = new Thread(new Hmk1Thread(),"Thread1");
        th1.start();
        Thread th2 = new Thread(new Hmk1Thread(),"Thread2");
        th2.start();
    }
}
