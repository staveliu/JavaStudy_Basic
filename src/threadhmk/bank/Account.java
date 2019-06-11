package threadhmk.bank;

public class Account {
    private int id;
    private double amount;

    public Account(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean withdraw(double n) {
        synchronized (this) {
            if (this.amount < n) {
                return false;
            } else {
                this.amount-=n;
                return true;
            }
        }
    }
    public boolean deposit(double n){
        synchronized (this){
            this.amount+=n;
            return true;
        }
    }
}
