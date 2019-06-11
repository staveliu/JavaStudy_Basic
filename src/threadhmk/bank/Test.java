package threadhmk.bank;


public class Test {
    public static void main(String[] args){
        Account account = new Account(1000,3000);
        Thread atm = new Thread(new BankThread(account,"withdraw",2000.3),"ATM-withdraw");
        atm.start();
        Thread counter = new Thread(new BankThread(account,"withdraw",1000.5),"COUNTER-withdraw");
        counter.start();
        Thread atm1 = new Thread(new BankThread(account,"deposit",1024.33),"ATM-deposit");
        atm1.start();
        System.out.println("After operation, The amount of your account: "+account.getAmount());
    }
}

