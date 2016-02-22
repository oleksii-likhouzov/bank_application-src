package org.test;


public class SavingAccount extends AbstractAccount {


    public void withdraft(float x) {
        if ((getBalance() - x) < 0) {
            throw new RuntimeException("Withdraw is not possible. \n" +
                    "Withdraft with value" +
                    x +
                    "  for account is not possible. Account balance: " +
                    getBalance());
        }
        setBalance(getBalance() - x);
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                super.toString() +
                "}";
    }
}
