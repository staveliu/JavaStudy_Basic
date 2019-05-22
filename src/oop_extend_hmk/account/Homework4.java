package oop_extend_hmk.account;

public class Homework4 {
    public static void main(String[] args){
        CheckingAccount acc1 = new CheckingAccount(10001,10000.0);
        SavingAccount acc2 = new SavingAccount(10002,10000.0);
        acc1.withdraw(8000);
        acc2.withdraw(8000);
        acc1.withdraw(5000);
        acc2.withdraw(5000);
        acc1.deposit(3000);
        acc2.deposit(3000);
        acc1.withdraw(6000);
        acc2.withdraw(6000);
    }
}
