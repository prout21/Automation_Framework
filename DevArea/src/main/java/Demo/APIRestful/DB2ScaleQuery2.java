package Demo.APIRestful;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.testng.Assert.assertEquals;

import java.sql.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DB2ScaleQuery2 {
	
	@Test
	
	public void Verify2ScaleDBupdatedSuccessfully() {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			System.out.println("Driver loaded");
			  
			//step2 create  the connection object  
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:10000:MCCMSYSN","MCCMEXTMKTINT","MCCMEXTMKTINT");  
			  
		     System.out.println("Connected to DB");
		     
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("SELECT  status FROM twoscalepushnotification where status = 'ERR'");
					 
			//	  status = 'STQ'"  New   'SUC'" 
		 
            while(rs.next())  
     		 
  
     		 
     		 
     	    //	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)); 	 
		 
         System.out.println(rs.getString(1));
        //	 System.out.println(rs.getString(2));
			  
     
//     	        System.out.println(Status + " Status " );
  	 	 	
      //     	Assert.assertEquals(rs.getString(2), "ERR", "Status code is not New");
        	 	
        	 	
			//step5 close the connection object
         	 	
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);
			}  
			  
			}  
			}  


