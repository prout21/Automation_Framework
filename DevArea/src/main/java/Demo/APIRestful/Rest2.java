/**
 * 
 */
package Demo.APIRestful;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.XMLObject;

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
public class Rest2 {
	
	@Test(priority=1)
	
public  void VerifyKeyStoreCerificateSuccessfully() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableEntryException {
		
		//Connect to server use Keystore Certificate
	
	KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		System.out.println("hi");
		char[] keyStorePassword = "password".toCharArray();  
		try(InputStream keyStoreData = new FileInputStream("C:\\Users\\prout21\\css1identity.jks"))
		{  //keystore.ks       //is the file from where we want to load the file  
			keystore.load(keyStoreData, keyStorePassword); 
			System.out.println(keyStoreData);
			System.out.println(keyStorePassword);
		}
	
	char[] keyPassword = "password".toCharArray();  
	KeyStore.ProtectionParameter entryPassword =  
	        new KeyStore.PasswordProtection(keyPassword);  
	System.out.println("hi1");
	KeyStore.Entry keyEntry = keystore.getEntry("keyAlias", entryPassword);  
	System.out.println("hi2");
	
	char[] keyStorePassword1 = "password".toCharArray();  
	try (FileOutputStream keyStoreOutputStream = new FileOutputStream("C:\\Users\\prout21\\jks\\css1identity.jks")) {  
	    keystore.store(keyStoreOutputStream, keyStorePassword1);
 
	}  
	
	}
	
 //	String url = "https://192.57.138.25:18576/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	String url = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	  
	@Test(priority=2)
	
	public void VerifyHitRESTfulGETRequestResponseSuccessfully() throws ClientProtocolException, IOException {
		
    //	 CloseableHttpClient httpClient = HttpClients.createDefault();
    	 
    	 CloseableHttpClient httpClient =  HttpClientBuilder.create().build();
	   
	     HttpGet httpget = new HttpGet(url);
	   
	//  CloseableHttpResponse    closeableHttpResponce  =   httpClient.execute(httpget);
			  
			  
   HttpResponse closeableHttpResponce = httpClient.execute(httpget);
	   
	   int StatusCode = (closeableHttpResponce.getStatusLine().getStatusCode());
	   
	   System.out.println("status code------>" + StatusCode);
	   
	   String responseString = EntityUtils.toString(closeableHttpResponce.getEntity(), "UTF-8");
	   
//	    String response1 = responseString.toString(); 
//	    
//	 	System.out.println("response" + response1); 
	 
	    
  
     JSONObject responseJson = new JSONObject(responseString);
   
//       
//      JSONArray jsonArray = new JSONArray(responseString);
	    
	   
	   System.out.println("Response Json from API-->+ responseJson");
	   
	   Header[]  headersArray = closeableHttpResponce.getAllHeaders();
	   
	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
	   
	   for(Header header : headersArray ) {
	   
	   allHeaders.put(header.getName(), header.getValue());
	    
	 
    	System.out.println("Headers Arry----> +allHeaders");
		
	   }
	}
	}
		
 
 
 


 
 