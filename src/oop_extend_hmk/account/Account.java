package oop_extend_hmk.account;

public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount){
        balance-=amount;
        showAccount();
    }
    public void deposit(double amount){
        balance-=amount;
        showAccount();
    }
    public void showAccount(){
        System.out.println("Account: "+id+" Balance: "+balance);
    }
}
