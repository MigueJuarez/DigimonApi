package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class DigimonManager {

	
	static String endpointDigimon = "https://digimon-api.herokuapp.com/api/digimon/name/";
	//"https://digimon-api.herokuapp.com/api/digimon";




	public String getDigimon(String nombre) {
		//request
		HttpClientBuilder clientBuilder = HttpClients.custom();
		HttpClient client = clientBuilder.build();
		HttpGet requestDigimon = new HttpGet(endpointDigimon + nombre);
		
		//parametros del request
		requestDigimon.addHeader("Content-Type", "application/json");
		requestDigimon.addHeader("Accept", "application/json");
		
		//response
		try {
			HttpResponse response = client.execute(requestDigimon);
			//traigo la info del response
			BufferedReader buferReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			//leyendo la info del response
			StringBuilder infoResponse = new StringBuilder();
			String linea = "";
			
			while( (linea = buferReader.readLine()) != null) {
				infoResponse.append(linea);
			}
			System.out.println(nombre + ":" + infoResponse.toString());
			return infoResponse.toString();
		
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No se encontro Digimon";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No se encontro Digimon";
		}
	}
}
