package es.upm.dit.isst.inube.dao;

import es.upm.dit.isst.inube.dao.model.Client;
import es.upm.dit.isst.inube.dao.model.Transaction;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImplementation implements ClientDAO {
    private static ClientDAOImplementation ourInstance = new ClientDAOImplementation();

    public static ClientDAOImplementation getInstance() {

        return ourInstance;
    }

    private ClientDAOImplementation() {
    }


    @Override
    public List<Transaction> readTransactions() {
        Session session = SessionFactoryService.get().openSession();
        List<Transaction> transactions = new ArrayList<>();

        try {
            session.beginTransaction();
            transactions.addAll(session.createQuery("from Transaction ").list());
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


        return transactions;
    }

    @Override
    public void createClient(Client client) {
        Session session = SessionFactoryService.get().openSession();

        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public Client readClient(int clientId) {
        Session session = SessionFactoryService.get().openSession();

        Client client = null;


        try {
            session.beginTransaction();
            client = session.get(Client.class, clientId);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


        return client;
    }

    @Override
    public void updateClient(Client client) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteClient(Client client) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }


}
