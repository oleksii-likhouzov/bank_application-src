package org.test;


import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Account> accounts= new ArrayList<Account>();
    private Account activeAccount;
    private float initialOverdraft;
    final static int INITIAL_OVERDRTAFT = 300;
    final static String CLIENT_CHECKING_ACCOUNT_TYPE = "checking";
    final static String CLIENT_SAVING_ACCOUNT_TYPE = "saving";

    public Client() {
        this(INITIAL_OVERDRTAFT);
    }

    public Client(float initialOverdraft) {
        Account account= createAccount(initialOverdraft==0?CLIENT_SAVING_ACCOUNT_TYPE:CLIENT_CHECKING_ACCOUNT_TYPE);
        this.initialOverdraft = initialOverdraft;
        if (account != null &&
            account instanceof CheckingAccount) {
            ((CheckingAccount) account).setOverdraft(initialOverdraft);
        }
        setActiveAccount(account);
        accounts.add(account);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public void deposit(float x) {
        if (activeAccount != null) {
            activeAccount.deposit(x);
        } else {
            throw new RuntimeException("Deposit is not possible. \n" +
                    "Ddeposit with value" +
                    x +
                    "  for active account is not possible. Account not defined. ");
        }
    }

    public void withdraw(float x) {
        if (activeAccount != null) {
            activeAccount.withdraft(x);
        } else {
            throw new RuntimeException("Withdraft( is not possible. \n" +
                    "Withdraft with value" +
                    x +
                    "  for active account is not possible. Account not defined. ");
        }
    }

    public Account createAccount(String accountType) {
        Account newAccout = null;
        if (!accountType.equals(CLIENT_CHECKING_ACCOUNT_TYPE) && !accountType.equals(CLIENT_SAVING_ACCOUNT_TYPE)) {
            throw new RuntimeException("Account creation is not possible. \n" +
                    "Defined accountType: " +
                    accountType +
                    "  is not accessible. Accessible list(" +
                    CLIENT_CHECKING_ACCOUNT_TYPE + ", " +
                    CLIENT_SAVING_ACCOUNT_TYPE +
                    ". ");

        } else {
            if (accountType.equals(CLIENT_CHECKING_ACCOUNT_TYPE)) {
                newAccout = new CheckingAccount(initialOverdraft);
            } else {
                newAccout = new SavingAccount();
            }
        }
        return newAccout;
    }
    public List<Account> getAccounts()
    {
        return accounts;
    }

    public float getBalance() {
        Account tmpAccount;
        float result = 0.f;
        for (int i = 0; i < accounts.size(); i++) {
            tmpAccount = accounts.get(i);
            if (tmpAccount !=null) {
                result = result + tmpAccount.getBalance();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                ", activeAccount=" + activeAccount +
                ", initialOverdraft=" + initialOverdraft +
                '}';
    }
}
