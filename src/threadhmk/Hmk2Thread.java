package threadhmk;

public class Hmk2Thread implements Runnable{
    private String message;

    public Hmk2Thread(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Message: "+this.message);
        System.out.println("========="+Thread.currentThread().getName()+": "+"This is the end of message.=========");
    }
}
