package Demo.APIRestful;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MetodVinodAPI {
	

	

	
	String url = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	
	@Test
	///GET call method///
	public static Response requestUtility(String url) {  
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header("Content-Type", "application/json").
			
			     when().
	 	        
		get(url);
			         
			 return resp;      
	}
	
	///post call method///
	
	@Test
	
public static Response requestUtilitypost(String url,Map<String,String>map) {  
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header("Content-Type", "application/json").params(map).
				
		//		.header("Content-Type", "application/json").parameters(map).
			
			     when().
	 	        
		post(url);
			         
			 return resp;      
	}
///post call method///
	
	@Test

public static Response requestUtilitypostold(String url,Map<String,String>map) {  
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header(" ", " ").
			     header(" ", " ").params(map).
			
			     when().
	 	        
	get(url);
			         
			 return resp;      
	}
///post call method///
	
	@Test

public static Response requestUtilitypostbody(String url,Map<String,String>map) {  
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header("Content-Type", "application/json").
			    header(" ", " ").
			     header(" ", " ").body(map).
			
			     when().
	 	        
		post(url);
			         
			 return resp;      
	}
///post call method///
	@Test

public static Response requestUtilitypostQuery(String url,Map<String,String>map) {  
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header("Content-Type", "application/json").
			    header("inputdata ", "inputdata ").
			     header("platfrom ", "androd ").queryParams(map).
		//	     header("platfrom ", "androd ").queryParameters(map).
			
			     when().
	 	        
		post(url);
			         
			 return resp;      
	}

}
