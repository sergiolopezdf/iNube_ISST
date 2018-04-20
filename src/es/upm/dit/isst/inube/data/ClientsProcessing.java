package es.upm.dit.isst.inube.data;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.json.*;
import es.upm.dit.isst.inube.dao.ClientDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Client;


public class ClientsProcessing {
	
	private final String clientId = "ID";
	private final String codigoPostal = "CP";
	
	private JsonArray dataFromJson;
	private String path;
	

	public ClientsProcessing(String path) {
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
				
		try {
			
			InputStream io = new FileInputStream(this.getPath());
		
			JsonReader reader = Json.createReader(io);
			
			setDataFromJson(reader.readArray());
			
			reader.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			
		} 
		
		
	}
	
	public void storeDataFromJSON() {
		
		for(JsonValue tValue : this.dataFromJson) {
			
			JsonObject transactionJson = (JsonObject) tValue;
			
			int clientId = Integer.parseInt(transactionJson.get(this.clientId).toString());
			int codigoPostal = Integer.parseInt(transactionJson.get(this.codigoPostal).toString());
			
			Client client = ClientDAOImplementation.getInstance().readClient(clientId);
	
			
			if(client != null) {
				return;
			}
			
			client = new Client();
			client.setClientId(clientId);
			client.setCodigoPostal(codigoPostal);
			ClientDAOImplementation.getInstance().createClient(client);
			
						
		}

		
	}
	

	public static void main(String[] args) {
		ClientsProcessing dp = new ClientsProcessing("src/es/upm/dit/isst/inube/json/clients.json");
		dp.processNewJSON();
		dp.storeDataFromJSON();

	}

}