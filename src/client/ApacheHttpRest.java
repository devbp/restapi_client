package client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpRest {

	public void getrequest()
	{
		
	/*	
	try{
		@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/weather?"+URLEncoder.encode("q=shanghai&&APPID={56a392acfe9530330af0ca6840e1cb9a}"));
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);
		System.out.println(response.getStatusLine().getStatusCode());

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));

		String output;
		String weather="";
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			weather+=output;
		}
		System.out.println(weather);

		httpClient.getConnectionManager().shutdown();

	  } catch (ClientProtocolException e) {
	
		e.printStackTrace();

	  } catch (IOException e) {
	
		e.printStackTrace();
	  }
*/
		
		
		
		 HttpClient httpClient = new DefaultHttpClient();
		    try {
		      // this twitter call returns json results.
		      // see this page for more info: <a href="https://dev.twitter.com/docs/using-search" title="https://dev.twitter.com/docs/using-search">https://dev.twitter.com/docs/using-search</a>
		      // <a href="http://search.twitter.com/search.json?q=%40apple" title="http://search.twitter.com/search.json?q=%40apple">http://search.twitter.com/search.json?q=%40apple</a>
		 
		      // Example URL 1: this yahoo weather call returns results as an rss (xml) feed
		      //HttpGet httpGetRequest = new HttpGet("http://weather.yahooapis.com/forecastrss?p=80020&u=f");
		       
		      // Example URL 2: this twitter api call returns results in a JSON format
		      HttpGet httpGetRequest = new HttpGet("http://api.openweathermap.org/data/2.5/weather?"+URLEncoder.encode("q=London&&APPID={56a392acfe9530330af0ca6840e1cb9a}"));
		 
		      // Execute HTTP request
		      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
		 
		      System.out.println("----------------------------------------");
		      System.out.println(httpResponse.getStatusLine());
		      System.out.println("----------------------------------------");
		 
		      // Get hold of the response entity
		      HttpEntity entity = httpResponse.getEntity();
		 
		      // If the response does not enclose an entity, there is no need
		      // to bother about connection release
		      byte[] buffer = new byte[1024];
		      if (entity != null) {
		        InputStream inputStream = entity.getContent();
		        try {
		          int bytesRead = 0;
		          BufferedInputStream bis = new BufferedInputStream(inputStream);
		          while ((bytesRead = bis.read(buffer)) != -1) {
		            String chunk = new String(buffer, 0, bytesRead);
		            System.out.println(chunk);
		          }
		        } catch (IOException ioException) {
		          // In case of an IOException the connection will be released
		          // back to the connection manager automatically
		          ioException.printStackTrace();
		        } catch (RuntimeException runtimeException) {
		          // In case of an unexpected exception you may want to abort
		          // the HTTP request in order to shut down the underlying
		          // connection immediately.
		          httpGetRequest.abort();
		          runtimeException.printStackTrace();
		        } finally {
		          // Closing the input stream will trigger connection release
		          try {
		            inputStream.close();
		          } catch (Exception ignore) {
		          }
		        }
		      }
		    } catch (ClientProtocolException e) {
		      // thrown by httpClient.execute(httpGetRequest)
		      e.printStackTrace();
		    } catch (IOException e) {
		      // thrown by entity.getContent();
		      e.printStackTrace();
		    } finally {
		      // When HttpClient instance is no longer needed,
		      // shut down the connection manager to ensure
		      // immediate deallocation of all system resources
		      httpClient.getConnectionManager().shutdown();
		    }
		  }
	
	}

