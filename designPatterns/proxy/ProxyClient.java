package designPatterns.proxy;

public class ProxyClient {
    public static void main(String[] args) {
        BankAccount bankAccount = new DebitCardProxy(new SavingAccount(2));
        bankAccount.debit();
    }
}
