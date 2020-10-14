package Demo.APIRestful;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class dadama {

	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableEntryException {
		
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
	
	//RestAPI GET Call from endpoint 
	
	 Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	 
	   //   Response response   = get("https://reqres.in/api/users?page=2\"");
	  	   
	     //	 Response response   = post("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576"); 
	      //  Response response   = get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");
		
//		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
	 
		
		System.out.println(response.getBody().print());

		
	  	int StatusCode = (response. getStatusCode());
	 	 	 	
	 	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
		
			}
	
	//RestAPI POST Call from endpoint 
	
	 
		
}
		
		
		
 
 
 


 
 
		