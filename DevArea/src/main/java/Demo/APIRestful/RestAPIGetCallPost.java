/**
 * 
 */
package Demo.APIRestful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.XMLObject;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.JSON;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;



/**
 * @author p.rout 
 *
 */
public class RestAPIGetCallPost {
	
  

	@Test(priority=1)
	
	public void VerifyRESTAPIGETRequestResponseStatusCodeChkSuccessfully() {
		
     Response response =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	 
   //   Response response   = get("https://reqres.in/api/users?page=2\"");
  	   
    // Response response   = post("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576"); 
      //  Response response   = get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");
	
//	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());
 
	
	System.out.println(response.getBody().print());

	
  	int StatusCode = (response. getStatusCode());
 	 	 	
 	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	
		}
	
	@Test(priority=2)

	public void VerifyRESTAPIGETRequestResponseMessageSuccessfully() {

 	Map<String, String> postContent = new HashMap<>();
 
 	
 	postContent.put("name","Online");
 	postContent.put("type", "Inbound");
 	postContent.put("container", "CustomerOfferOnline");
 	postContent.put("schemeID", "MobileHashed");
 	postContent.put("characteristicName","Transaction");
 	postContent.put( "value","Prolongation");
 	postContent.put( "type","Intent");
 	postContent.put( "type","Intent");
	
 	
//	System.out.println(map);
	
//	JSONObject  request = new JSONObject(map);
		
	  JSONObject  request = new JSONObject();
	   
    // request.put("name" ,"MCC_3102;4G_SWAP");
 //	request.put("first_name","Michael");
    // map.put("container", "CustomerOfferOnline");
	  
	 System.out.println(request.toString());
 

      Response response   = get("https://reqres.in/api/users?page=2\"");
	 
 	
       //  Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
 	
	    
	//    Response response =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	    

		
 	    Headers  headersArray = response.getHeaders();
 	   
  	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
  	   
 	   for(io.restassured.http.Header header : headersArray ) {
     
  	   allHeaders.put(header.getName(), header.getValue());
 	    
  	 
    	System.out.println("Headers Arry----> +allHeaders");
//	
	// String container = "container";

   given().
   header("Content-Type", "application/json").
    //  given().header("Content-Type", "application/xml").
	       contentType(ContentType.JSON).
	       with()
	       .body(postContent).
	  //     accept(ContentType.JSON).
	  //   body("CustomerOfferOnline").
	    
	     when().
   //   post("https://reqres.in/api/users?page=2\"").
    
  //  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult").
        
  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction").
	         
	      then().
	      //statusCode(200).
	      log().all();
	   }
 	 	System.out.println(response.getStatusCode());
 	 	int StatusCode = (response. getStatusCode());
 	  	 	
 	  	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	 
	}
}

		
		



 
 