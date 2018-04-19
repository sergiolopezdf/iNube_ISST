package es.upm.dit.isst.inube.dao;

import es.upm.dit.isst.inube.dao.model.Client;
import es.upm.dit.isst.inube.dao.model.Transaction;

import java.util.List;

public interface ClientDAO {

    public List<Transaction> readTransactions();

    //CRUD
    public void createClient(Client client);

    public Client readClient(String clientId);

    public void updateClient(Client client);

    public void deleteClient(Client client);

}
