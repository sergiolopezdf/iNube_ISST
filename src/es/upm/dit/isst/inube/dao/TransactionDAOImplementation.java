package es.upm.dit.isst.inube.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

public class TransactionDAOImplementation implements TransactionDAO {
    private static TransactionDAOImplementation ourInstance = new TransactionDAOImplementation();

    public static TransactionDAOImplementation getInstance() {
        return ourInstance;
    }

    private TransactionDAOImplementation() {
    }


    @Override
    public void createTransaction(Transaction transaction) {
        Session session = SessionFactoryService.get().openSession();

        try {
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public Transaction readTransaction(int transactionId) {
        Session session = SessionFactoryService.get().openSession();

        Transaction transaction = null;


        try {
            session.beginTransaction();
            transaction = session.get(Transaction.class, transactionId);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


        return transaction;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteTransaction(Transaction transaction) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public List<Transaction> readAllTransactionsFromCompetencia(Merchant merchant) {
        Session session = SessionFactoryService.get().openSession();
        List<Transaction> transactions = new ArrayList<>();

        try {
            session.beginTransaction();
            //transactions.addAll(session.createQuery("from Transaction ").list());
            List res = session.createQuery("FROM Transaction T WHERE T.merchant != :m ").setParameter("m", merchant).list();
            transactions.addAll(res); 	
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


        return transactions;
    }

    @Override
    public List<Transaction> readAllTransactionsFromMerchant(Merchant merchant) {
    	
    	 Session session = SessionFactoryService.get().openSession();
         List<Transaction> transactions = new ArrayList<>();
         
         try {
 			session.beginTransaction();
 			List res = session.createQuery("FROM Transaction T WHERE T.merchant = :m ").setParameter("m", merchant).list();
 	
 			transactions.addAll(res); 				
					
			session.getTransaction().commit();
			
 		} catch (Exception e) {
 			// manejar excepciones
 		} finally {
 			session.close();
 		}
         
         
         return transactions;
    }

    @Override
    public List<Transaction> readAllTransactionsFromZone(int codigoPostal) {
        return null;
    }
}
