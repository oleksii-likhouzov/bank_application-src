package org.test;


public abstract class AbstractAccount implements Account {
    private float balance;

    public void deposit(float x) {
        balance = balance + x;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void printReport() {
        System.out.println("balance:" + balance);
    }

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "balance=" + balance +
                '}';
    }
}
