package threadhmk;

public class Hmk1Thread implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("Hello======="+Thread.currentThread().getName()+"========"+i);
        }
    }
}
