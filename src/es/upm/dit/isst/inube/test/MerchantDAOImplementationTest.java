package es.upm.dit.isst.inube.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.inube.dao.model.Client;
import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

public class MerchantDAOImplementationTest {

	
	private Client client;
	private Merchant merchant;
	private Transaction transaction;
	
	
	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setClientId(0);
		client.setCodigoPostal(28015);
		client.setTransactions(null);
		
		merchant = new Merchant();
		merchant.setCodigoPostal(28017);
		merchant.setMerchantId("1");
		merchant.setNombreNegocio("Manolo");
		merchant.setTransactions(null);
		
		transaction = new Transaction();
		transaction.setClient(client);
		transaction.setImporte(100);
		transaction.setFecha("12");
		transaction.setMerchant(merchant);
		transaction.setTransactionId(2);
		
	}

	@After
	public void tearDown() throws Exception {
		ClientDAOImplementation.getInstance().deleteClient(client);
		MerchantDAOImplementation.getInstance().deleteMerchant(merchant);
		TransactionDAOImplementation.getInstance().deleteTransaction(transaction);
		client = null;
		merchant = null;
		transaction = null;
	}
	

	@Test
	public void testGetInstance() {
		MerchantDAO dao = MerchantDAOImplementation.getInstance();
		MerchantDAO dao2 = MerchantDAOImplementation.getInstance();
		assertEquals(dao, dao2);
	}

	@Test
	public void testLoginMerchant() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMerchant() {
		MerchantDAO dao = MerchantDAOImplementation.getInstance();

		Merchant merchant2 = new Merchant();
		merchant2.setCodigoPostal(28025);
		merchant2.setMerchantId("3");
		merchant2.setNombreNegocio("Manoloss");
		merchant2.setTransactions(null);
	
		dao.createMerchant(merchant2);
		
		Merchant merchant3 = dao.readMerchant("3");

		dao.deleteMerchant(merchant2);
		assertEquals(merchant2.getMerchantId(),merchant3.getMerchantId());
		assertEquals(merchant2.getCodigoPostal(), merchant3.getCodigoPostal());
		assertEquals(merchant2.getTransactions(),merchant3.getTransactions());
	}

	@Test
	public void testReadMerchant() {
		/*MerchantDAO dao = MerchantDAOImplementation.getInstance();
		//Leo el tfg que esta en la base de datos
		merchant merchant2 = dao.readMerchant(1);
		//Compruebo si se ha leido bien
		assertEquals(merchant.getMerchantId(),merchant2.getMerchantId());
		assertEquals(merchant.getCodigoPostal(), merchant2.getCodigoPostal());
		assertEquals(merchant.getNombreNegocio(), merchant2.getNombreNegocio());*/
	}

	@Test
	public void testUpdateMerchant() {
		merchant.setCodigoPostal(28090);
		
		MerchantDAO dao =  MerchantDAOImplementation.getInstance();
		dao.updateMerchant(merchant);
		Merchant merchantUpdated = dao.readMerchant(merchant.getMerchantId());
		
		assertEquals(merchant.getMerchantId(),merchantUpdated.getMerchantId());
		assertEquals(merchant.getCodigoPostal(), merchantUpdated.getCodigoPostal());
	}

	@Test
	public void testDeleteMerchant() {
		MerchantDAO dao = MerchantDAOImplementation.getInstance();
		dao.deleteMerchant(merchant);
		
		Merchant merchantDel= dao.readMerchant(merchant.getMerchantId());
		assertNull(merchantDel);
	}

	@Test
	public void testGetNumberOfMerchants() {
		fail("Not yet implemented");
	}

}

