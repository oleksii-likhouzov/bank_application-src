package org.test;


import java.util.ArrayList;
import java.util.List;

public class Bank implements Report {
    private List<Client> clients = new ArrayList<Client>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void printReport() {
        System.out.println("Bank report:");
        System.out.println("Client lists (client counts:"+ clients.size() +"):");
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
