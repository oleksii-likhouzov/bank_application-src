package org.test;


public class BankApplication {
    private Bank bank;

    public void initialize()
    {
        bank = new Bank();
        Client tmpClient = new Client();
        tmpClient.setName("First Client");
        bank.addClient(tmpClient);
        tmpClient = new Client(100);
        tmpClient.setName("Second Client");
        bank.addClient(tmpClient);
        tmpClient = new Client(0);
        tmpClient.setName("Third Client");
        bank.addClient(tmpClient);


    }
    public void printBankReport()
    {
       if (bank!=null) {
           bank.printReport();
       } else {
           throw new RuntimeException("ank application is not initialized.");
       }

    }
    public static void main(String [] argv)
    {
        BankApplication bankApplication = new BankApplication();
        bankApplication.initialize();
        bankApplication.printBankReport();
    }
}
