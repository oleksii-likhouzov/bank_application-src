package org.test;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractAccount implements Account {
    private final Logger log = LogManager.getLogger(this.getClass());
    private float balance;

    public void deposit(float x) {
        if (x < 0.) {
            log.log(Level.ERROR, "Value of \"balance\" = " + x + "  < 0. ");
            throw new IllegalArgumentException("Value of \"balance\" = " + x + "  < 0. ");
        }
        balance = balance + x;
    }

    public float getBalance() {
        return balance;
    }

    protected void setBalance(float balance) {
        this.balance = balance;
    }

    public void printReport() {
        System.out.println("  Balance:" + balance);
    }

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "balance=" + balance +
                '}';
    }
}
