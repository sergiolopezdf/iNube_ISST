package es.upm.dit.isst.inube.dao;

import es.upm.dit.isst.inube.dao.model.Merchant;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class MerchantDAOImplementation implements MerchantDAO {
    private static MerchantDAOImplementation ourInstance = new MerchantDAOImplementation();

    public static MerchantDAOImplementation getInstance() {
        return ourInstance;
    }

    private MerchantDAOImplementation() {
    }

    @Override
    public Merchant loginMerchant(String merchantId) {

        Session session = SessionFactoryService.get().openSession();
        Merchant merchant = null;

        try {
            session.beginTransaction();
            merchant = (Merchant) session.createQuery("select m from Merchant m where m.id = :merchantId")
                    .setParameter("merchantId", merchantId)
                    .getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

        return merchant;
    }

    @Override
    public void createMerchant(Merchant merchant) {
        Session session = SessionFactoryService.get().openSession();

        try {
            session.beginTransaction();
            session.save(merchant);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


    }

    @Override
    public Merchant readMerchand(String merchantId) {
        Session session = SessionFactoryService.get().openSession();

        Merchant merchant = null;


        try {
            session.beginTransaction();
            merchant = session.get(Merchant.class, merchantId);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }


        return merchant;
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(merchant);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

    @Override
    public void deleteMerchant(Merchant merchant) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(merchant);
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }

    }

	@Override
	public int getNumberOfMerchants() {
		Session session = SessionFactoryService.get().openSession();
		int nMerchant = 0;
		
		List<Long> nm = new ArrayList<>();
		
        try {
            session.beginTransaction();
         
            
            nm  = session.createQuery("SELECT COUNT(*) FROM Merchant").list();
          
          
            session.getTransaction().commit();
        } catch (Exception e) {
            // manejar excepciones
        } finally {
            session.close();
        }
        
        System.out.println(nm.get(0));
        
        nMerchant = nm.get(0).intValue();
        
        return nMerchant;
	}
}


