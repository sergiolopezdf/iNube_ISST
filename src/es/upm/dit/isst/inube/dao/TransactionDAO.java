package es.upm.dit.isst.inube.dao;

import es.upm.dit.isst.inube.dao.model.Transaction;

import java.util.List;

public interface TransactionDAO {

    //CRUD
    public void createTransaction(Transaction transaction);

    public Transaction readTransaction(int transactionId);

    public void updateTransaction(Transaction transaction);

    public void deleteTransaction(Transaction transaction);


    public List<Transaction> readAllTransactions();

    public List<Transaction> readAllTransactionsFromClient(int clientId);

    public List<Transaction> readAllTransactionsFromZone(int codigoPostal);

}
