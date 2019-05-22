package oop_extend_hmk.account;

public class CheckingAccount extends Account {
    private final double OVERDRAFT = 5000.0;
    private double draft = 5000.0;

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }


    public double getDraft() {
        return draft;
    }

    public void setDraft(double draft) {
        this.draft = draft;
    }
    public void deposit(double amount){
        if (amount > (OVERDRAFT-draft)){
            super.setBalance(super.getBalance()+(amount-(OVERDRAFT-draft)));
            draft = 5000.0;
        }else{
            draft+=amount;
        }
        showAccount();
    }
    public void withdraw(double amount){
        if (amount > draft){

            super.setBalance(super.getBalance()-(amount - draft));
            draft = 0.0;
        }else{
            draft-=amount;
        }
        showAccount();
    }
    public void showAccount(){
        System.out.println("Account: "+super.getId()+" Balance: "+super.getBalance()+" Draft: "+draft);
    }
}
