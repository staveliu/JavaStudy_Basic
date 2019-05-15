package OOP2Homework.bank;

public class Account {
    private int ID;
    private double balance;
    private double annualInterestRate;
    public Account(int ID, double balance, double annualInterestRate){
        this.ID = ID;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    public Account(){

    }
    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getID() {
        return ID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public void withdraw(double amount){
        balance-=amount;
    }
    public void deposit(double amount){
        balance+=amount;
    }
    public double getMonthlyInterest(){
        double amount = balance * annualInterestRate / 12;
        return amount;
    }
}
