package org.test;

public class CheckingAccount extends AbstractAccount {
    private float overdraft;

    public CheckingAccount(float overdraft) {
        setOverdraft(overdraft);
    }

    public void setOverdraft(float x) {
        overdraft = x;
    }

    public void withdraft(float x) {
        if ((getBalance() + overdraft - x) < 0) {
            throw new RuntimeException("Withdraw is not possible. \n" +
                    "Withdraft with value" +
                    x +
                    "  for account is not possible. Account balance: " +
                    getBalance() +
                    ". Account overdraft:" + overdraft);
        }
        setBalance(getBalance() - x);
    }

    @Override
    public void printReport() {
        super.printReport();
        System.out.println("Overdraft: " + overdraft);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                super.toString() +
                ", overdraft=" + overdraft +
                '}';
    }
}
