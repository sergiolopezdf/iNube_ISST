package es.upm.dit.isst.inube.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.inube.dao.model.Client;
import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

public class TransactionDAOImplementationTest {
	
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
		TransactionDAO dao = TransactionDAOImplementation.getInstance();
		TransactionDAO dao2 = TransactionDAOImplementation.getInstance();
		assertEquals(dao, dao2);
	}

	@Test
	public void testCreateTransaction() {
		TransactionDAO dao = TransactionDAOImplementation.getInstance();

		Transaction transaction2 = new Transaction();
		transaction2.setClient(client);
		transaction2.setImporte(150);
		transaction2.setFecha("11");
		transaction2.setMerchant(merchant);
		transaction2.setTransactionId(3);
		
		dao.createTransaction(transaction2);
		
		Transaction transaction3 = dao.readTransaction(3);
		
		dao.deleteTransaction(transaction2);
		assertEquals(transaction2.getClient(),transaction3.getClient());
		assertEquals(transaction2.getFecha() ,transaction3.getFecha());
		//assertEquals(transaction2.getImporte(),transaction3.getImporte());
		assertEquals(transaction2.getMerchant(),transaction3.getMerchant());
		assertEquals(transaction2.getTransactionId(),transaction3.getTransactionId());
		
	}

	@Test
	public void testReadTransaction() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTransaction() {
		transaction.setFecha("11");
		
		TransactionDAO dao =  TransactionDAOImplementation.getInstance();
		dao.updateTransaction(transaction);
		Transaction transactionUpdated = dao.readTransaction(transaction.getTransactionId());
		
		assertEquals(transaction.getTransactionId(),transactionUpdated.getTransactionId());
		assertEquals(transaction.getFecha(), transactionUpdated.getFecha());
	}

	@Test
	public void testDeleteTransaction() {
		TransactionDAO dao =  TransactionDAOImplementation.getInstance();
		dao.deleteTransaction(transaction);
		
		Transaction transactionDel = dao.readTransaction(transaction.getTransactionId());
		assertNull(transactionDel);
	}

	@Test
	public void testReadAllTransactionsFromCompetencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllTransactionsFromMerchant() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllTransactionsFromZones() {
		fail("Not yet implemented");
	}

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
		TransactionDAO dao = TransactionDAOImplementation.getInstance();
		TransactionDAO dao2 = TransactionDAOImplementation.getInstance();
		assertEquals(dao, dao2);
	}

	@Test
	public void testCreateTransaction() {
		TransactionDAO dao = TransactionDAOImplementation.getInstance();

		Transaction transaction2 = new Transaction();
		
	}

	@Test
	public void testReadTransaction() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTransaction() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTransaction() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllTransactionsFromCompetencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllTransactionsFromMerchant() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAllTransactionsFromZones() {
		fail("Not yet implemented");
	}

}
