package es.upm.dit.isst.inube.dao;

import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

import java.util.List;

public interface TransactionDAO {

    //CRUD
    public void createTransaction(Transaction transaction);

    public Transaction readTransaction(int transactionId);

    public void updateTransaction(Transaction transaction);

    public void deleteTransaction(Transaction transaction);


    public List<Transaction> readAllTransactionsFromCompetencia(Merchant merchant);

    public List<Transaction> readAllTransactionsFromMerchant(Merchant merchant);

    public List<Long> readAllTransactionsFromZones();

}
