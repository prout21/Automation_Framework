package DemoEtEFlow.Inbound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
import java.sql.*;  

import org.testng.annotations.Test;

public class DB2ScaleQuery2 {
	
	@Test
	
	public void Verify2ScaleDBupdatedSuccessfully() {
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");     
	        
	        System.out.println("Driver loaded");
	        
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:10000:MCCMSYSN","MCCMEXTMKTINT","MCCMEXTMKTINT");  
 	       
 	    //  Connection con = DriverManager.getConnection("jdbc:oracledriver://localhost:10000/MCCMSYSN","MCCMEXTMKTINT","MCCMEXTMKTINT");
 	        
 	      
 	      
 	    // 3.120.110.152 for systest  = ip-172.27.2.203 ,  tablespace-TBS_EXTMKT_TAB   , db name -MCCMEXTMKTINT  host name int=-46.190.227.196 , MCCM UPG-SYS EXTMKT
 	       
 	        System.out.println("Connected to DB");
 	       
 	       
	        
	    } catch(Exception e){ System.out.println(e);}
	}

}
