package threadhmk;

public class Hmk2Test {
    public static void main(String[] args){
        Thread msg1 = new Thread(new Hmk2Thread("Test\nTest\ne2e2e33333"),"MessageThread1");
        Thread msg2 = new Thread(new Hmk2Thread("I'am pig \n1113w1e1e3"),"MessageThread2");
        Thread msg3 = new Thread(new Hmk2Thread("You are pig \n 2e2e2e"),"MessageThread3");
        try {
            msg1.start();
            msg1.join();
            msg2.start();
            msg2.join();
            msg3.start();
            msg3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
