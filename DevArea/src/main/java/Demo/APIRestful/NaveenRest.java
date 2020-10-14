/**
 * 
 */
package Demo.APIRestful;

import static io.restassured.RestAssured.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.checkerframework.stubparser.JavaParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;




/**
 * @author p.rout 
 *
 */
public class NaveenRest {
	

           
  String url = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	  
//	String url = "https://reqres.in/api/users?page=2\"";
	
	
	@Test
	
	public void VerifyHitRESTfulGETRequestResponseSuccessfully() throws ClientProtocolException, IOException {
		
//	 CloseableHttpClient httpClient = HttpClients.createDefault();
	   
	     HttpGet httpget = new HttpGet(url);
	   
	    // closeableresponce=client.Getmethod(url);
         HttpClient httpClient = new DefaultHttpClient();
	   
	   HttpResponse closeablehttpresponse = httpClient.execute(httpget);
	   
	   int StatusCode = (closeablehttpresponse.getStatusLine().getStatusCode());
	   
	   System.out.println("status code------>" + StatusCode);
	   
	   String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
	   
	    String response1 = responseString.toString(); 
	    
	 	System.out.println("response" + response1); 
	 
	    
  
     JSONObject responseJson = new JSONObject(responseString);
   
//       
//      JSONArray jsonArray = new JSONArray(responseString);
	    
	   
	   System.out.println("Response Json from API-->+ responseJson");
	   
	   Header[]  headersArray = closeablehttpresponse.getAllHeaders();
	   
	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
	   
	   for(Header header : headersArray ) {
	   
	   allHeaders.put(header.getName(), header.getValue());
	    
	 
    	System.out.println("Headers Arry----> +allHeaders");
		
	   }
	}
}
		
	
	

 
