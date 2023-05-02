package designPatterns.proxy;

public class DebitCardProxy implements BankAccount{

    private SavingAccount savingAccount;

    public DebitCardProxy(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public void debit() {
        if (savingAccount.validate()) {
                savingAccount.debit();
                System.out.println("Transaction via DebitCardProxy");
        } else {
                System.out.println("DebitCardProxy: Not enough balance");
        }
    }
}
