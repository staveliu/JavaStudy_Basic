package threadhmk.bank;

public class BankThread implements Runnable{
    private Account account;
    private String action;
    private double amount;
    private boolean status = false;

    public BankThread(Account account, String action, double amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (action.equals("withdraw")){
            this.status = account.withdraw(this.amount);
        }
        if (action.equals("deposit")){
            this.status = account.deposit(this.amount);
        }
        if (this.status){
            System.out.println("ThreadName: "+Thread.currentThread().getName()+"========"+this.action+"========"+"Successful");
        }else{
            System.out.println("ThreadName: "+Thread.currentThread().getName()+"========"+this.action+"========"+"Failed");
        }
    }
}
