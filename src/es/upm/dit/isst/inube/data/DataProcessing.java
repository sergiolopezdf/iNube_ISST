package es.upm.dit.isst.inube.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.*;

import es.upm.dit.isst.inube.dao.ClientDAOImplementation;
import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Client;
import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

public class DataProcessing {
	
	private final String merchantId = "MerchantID";
	private final String clientId = "MerchantID";
	private final String id = "Id";
	private final String importe = "Import";
	
	private JsonArray dataFromJson;
	private String path;
	

	public DataProcessing(String path) {
		this.path = path;
	}
	
	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public JsonArray getDataFromJson() {
		return dataFromJson;
	}



	public void setDataFromJson(JsonArray dataFromJson) {
		this.dataFromJson = dataFromJson;
	}



	public void processNewJSON() {
		
		String data = "";
		
		
		try {
			
			InputStream io = new FileInputStream(this.getPath());
		
			JsonReader reader = Json.createReader(io);
			
			setDataFromJson(reader.readArray());
			
			reader.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		} 
		
		
	}
	
	public void storeDataFromJSON(String randomDay) {
		
		for(JsonValue tValue : this.dataFromJson) {
			
			JsonObject transactionJson = (JsonObject) tValue;
			
			int clientId = Integer.parseInt(transactionJson.get(this.clientId).toString());
			String merchantId = transactionJson.get(this.merchantId).toString();
			
			Merchant merchant = MerchantDAOImplementation.getInstance().readMerchand(merchantId);
			Client client = ClientDAOImplementation.getInstance().readClient(clientId);
			
			if(merchant == null) {
				return;
			}
			
			if(client == null) {
				client = new Client();
				client.setClientId(clientId);
				client.setCodigoPostal(00000);
				ClientDAOImplementation.getInstance().createClient(client);
			}
			
			Float importe = Float.parseFloat(transactionJson.get(this.importe).toString());
			int transactionId = Integer.parseInt(transactionJson.get(this.id).toString());
			
			Transaction t = new Transaction();
			t.setFecha(randomDay);
			t.setImporte(importe);
			t.setTransactionId(transactionId);
			t.setClient(client);
			t.setMerchant(merchant);
			
			TransactionDAOImplementation.getInstance().createTransaction(t);
						
		}

		
	}
	
	
	
	public static void main(String[] args) {
		DataProcessing dp = new DataProcessing("src/es/upm/dit/isst/inube/json/data1.json");
		dp.processNewJSON();
		dp.storeDataFromJSON("1");

	}

}