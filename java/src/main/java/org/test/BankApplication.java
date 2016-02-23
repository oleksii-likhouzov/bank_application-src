package org.test;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BankApplication {
    private static final Logger log = LogManager.getLogger(BankApplication.class);
    private Bank bank;


    private void addClient(String clientName ) {
        Client client = new Client();
        try {
            client.setName(clientName);
            bank.addClient(client);

        }   catch (ClientExistsException exception)
        {
            log.log(Level.ERROR, "Duplicate client name: \""+clientName+"\"");
        }
    }
    private void addClient(String clientName, float initialOverdraft ) {
        Client client = new Client(initialOverdraft);
        try {
            client.setName(clientName);
            bank.addClient(client);

        }   catch (ClientExistsException exception)
        {
            log.log(Level.ERROR, "Duplicate client name: \""+clientName+"\"");
        }
    }
    public void initialize()
    {
        bank = new Bank();
        addClient("First Client");
        addClient("Second Client",100);
        addClient("Third Client",0);
        addClient("Third Client",-1);
        List<Client> clients =  bank.getClients();
        Client tmpClient = clients.get(2);
        tmpClient.addAccount( tmpClient.createAccount(Client.CLIENT_SAVING_ACCOUNT_TYPE));
        tmpClient.addAccount( tmpClient.createAccount(Client.CLIENT_CHECKING_ACCOUNT_TYPE));

        for(Client client: clients) {
            List<Account> accounts = client.getAccounts();
            for (Account account : accounts) {
                account.deposit(((int) (Math.random() * 100 * 100)) / 100.f);
            }
            for (Account account : accounts) {
                if (account != null &&
                        account instanceof CheckingAccount) {
                    try {
                        account.withdraft(
                                2* account.getBalance() + (int) (((CheckingAccount) account).getOverdraft()));
                    }
                    catch (OverDraftLimitExceededException exception) {
                        log.log(Level.WARN,
                        "Withdraft with value " +
                                exception.getWithdraft() +
                                "  for account is not possible. Account balance: " +
                                exception.getBalance() +
                                ". Account overdraft:" + exception.getOverdraft());

                        try {
                            account.withdraft(
                                    account.getBalance() + (int) (((CheckingAccount) account).getOverdraft()) / 2);
                        } catch (NotEnoughFundsException innerException) {
                            log.log(Level.ERROR, exception);
                        }
                    }
                    catch (NotEnoughFundsException exception ) {
                        try {
                            account.withdraft(
                                    account.getBalance() + (int) (((CheckingAccount) account).getOverdraft()) / 2);
                        } catch (NotEnoughFundsException innerException) {
                            log.log(Level.ERROR, exception);
                        }

                    }
                }

            }
        }
    }
    public void printBankReport()
    {
       if (bank!=null) {
           bank.printReport();
       } else {
           log.log(Level.ERROR, "Bank application is not initialized.");
           throw new RuntimeException("Bank application is not initialized.");
       }

    }
    public static void main(String [] argv)
    {
        BankApplication bankApplication = new BankApplication();
        bankApplication.initialize();
        bankApplication.printBankReport();
    }
}
