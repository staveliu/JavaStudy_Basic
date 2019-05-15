package OOP2Homework.bank;

public class TestBank {
    public static void main(String[] args) {
        Account testAccount = new Account(1110, 20000.0f, 0.045f);
        for (int i = 1; i <= 12; i++) {
            double interest = testAccount.getMonthlyInterest();
            testAccount.setBalance(testAccount.getBalance()+interest);
            if (i==5){
                testAccount.withdraw(5000);
            }
            if (i==7){
                testAccount.deposit(3000);
            }
            System.out.printf("%d\t%.2f\t%.2f\n", i, interest, testAccount.getBalance());

        }
    }
}
