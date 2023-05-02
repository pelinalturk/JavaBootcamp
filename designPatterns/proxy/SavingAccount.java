package designPatterns.proxy;

public class SavingAccount implements BankAccount {

    private int balance;

    public SavingAccount(int balance) {
        this.balance = balance;
    }

    boolean validate() {
        return balance >= 5;
    }

    @Override
    public void debit() {
        if (validate()) {
            balance -= 5;
            System.out.println("5 TL withdrawn from SavingAccount");
        } else {
            System.out.println("Not enough balance");
        }
    }
}
