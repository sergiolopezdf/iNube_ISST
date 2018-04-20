package es.upm.dit.isst.inube.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.*;

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
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		DataProcessing dp = new DataProcessing("src/es/upm/dit/isst/inube/json/data1.json");
		dp.processNewJSON();

	}

}