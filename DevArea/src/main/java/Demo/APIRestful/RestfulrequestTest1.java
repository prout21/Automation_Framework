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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;




/**
 * @author p.rout 
 *
 */
public class RestfulrequestTest1 {
	

           
     String endpoint = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	  
    //  String endpoint = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult";
	  
      
  //    String endpoint = "https://reqres.in/api/users?page=2\"";
      
	@Test
	
	public void VerifyHitRESTfulGETRequestResponseSuccessfully() throws ClientProtocolException, IOException {
		
		//HttpClient client =  HttpClientBuilder.create().build(); 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response = client.execute(request);
		
  		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()))); 
  		String response1 = br.readLine(); 
 		
  		System.out.println("response details "  +  response); 
 	 	System.out.println(response.toString());
 	
 	 
		
	//     	String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
	 	
	  //  	String response1 = responseString.readLine(); 
 	    //	System.out.println("response" + response); 
 		


 		    
		   
	 //     JSONObject responseJson = new JSONObject(br);
          
	   //    JSONArray jsonArray = new JSONArray(br);
	     
		//   JSONObject responseJson = new JSONObject(br);
		   
		   System.out.println("Response Json from API-->+ responseJson");
		   
		   Header[]  headersArray = response.getAllHeaders();
		   
		   HashMap<String,String> allHeaders = new  HashMap<String,String>();
		   
		   for(Header header : headersArray ) {
		   
		   allHeaders.put(header.getName(), header.getValue());
		    
		 
	    	System.out.println("Headers Arry----> +allHeaders");
		
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//		String line="";
//		StringBuffer  sb = new StringBuffer();
//		while((line=br.readLine())!=null)
//		{
//		sb.append(line);
//		}
//    	System.out.println(response.getStatusLine());
//		
 	 	int StatusCode = (response.getStatusLine().getStatusCode());
		
	
		
    //	System.out.println(response.getStatusLine().getStatusCode());
    	
//		  System.out.println(sb);
//    	
      	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
      	
//      	PrintWriter pw = new PrintWriter(System.getProperty("user.dir")+"//Response//DML.json");
//      	//		pw.write(sb.toString());
//         		pw.write(br.toString());
//      			pw.close();
//      			pw.flush();
  
  	   
		   }
 		}
	}
 


    	
 
	 
 

 
