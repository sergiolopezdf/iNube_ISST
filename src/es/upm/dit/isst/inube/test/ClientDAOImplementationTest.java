package es.upm.dit.isst.inube.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import es.upm.dit.isst.inube.dao.ClientDAO;
import es.upm.dit.isst.inube.dao.ClientDAOImplementation;
import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.dao.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientDAOImplementationTest {
	
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
		ClientDAO dao = ClientDAOImplementation.getInstance();
		ClientDAO dao2 = ClientDAOImplementation.getInstance();
		assertEquals(dao, dao2);
	}

	
	@Test
	public void testCreateClient() {
		ClientDAO dao = ClientDAOImplementation.getInstance();

		Client client2= new Client();
		client2.setClientId(2);
		client2.setCodigoPostal(28019);
		client2.setTransactions(null);
		
		dao.createClient(client2);
		
		Client client3 = dao.readClient(2);

		dao.deleteClient(client2);
		assertEquals(client2.getClientId(),client3.getClientId());
		assertEquals(client2.getCodigoPostal(), client3.getCodigoPostal());
		assertEquals(client2.getTransactions(),client3.getTransactions());
	
	}
	
	@Test
	public void testReadTransactions() {
	}


	@Test
	public void testReadClient() {
		ClientDAO dao = ClientDAOImplementation.getInstance();
		//Leo el tfg que esta en la base de datos
		Client client2 = dao.readClient(0);
		//Compruebo si se ha leido bien
		assertEquals(client.getClientId(),client2.getClientId());
		assertEquals(client.getCodigoPostal(), client2.getCodigoPostal());
		assertEquals(client.getTransactions(), client2.getTransactions());
	}

	@Test
	public void testUpdateClient() {
		client.setCodigoPostal(28090);
		
		ClientDAO dao =  ClientDAOImplementation.getInstance();
		dao.updateClient(client);
		Client clientUpdated = dao.readClient(client.getClientId());
		
		assertEquals(client.getClientId(),clientUpdated.getClientId());
		assertEquals(client.getCodigoPostal(), clientUpdated.getCodigoPostal());

	}

	@Test
	public void testDeleteClient() {
		ClientDAO dao = ClientDAOImplementation.getInstance();
		dao.deleteClient(client);
		
		Client clientDel = dao.readClient(client.getClientId());
		assertNull(clientDel);
	}

}