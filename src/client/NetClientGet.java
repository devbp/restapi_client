package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.*;


public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

	  try {

		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London&&APPID={56a392acfe9530330af0ca6840e1cb9a}");
		//URL url= new URL("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID={APIKEY}");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
	
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		String weatherjson="";
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			//System.out.println(output);
			weatherjson+=output;
		}
		JSONObject obj = new JSONObject(weatherjson);
		//String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        String desc="";
		JSONArray arr = obj.getJSONArray("weather");
		for (int i = 0; i < arr.length(); i++)
		{
		    desc = arr.getJSONObject(i).getString("description");
		    
		}
		System.out.println(desc);
        System.out.println(weatherjson);
		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  } catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}