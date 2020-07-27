package com.mycompany.app;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.mccm.automation.XLSXReadWrite;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
// import com.sun.tools.javac.util.Assert;
  

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Properties;
import java.util.Vector;
import org.testng.annotations.Test;

import com.mccm.automation.FileExistChk_Inbound_KIASEPOS;
import com.mccm.automation.MyAutomationConstants;
import com.mccm.automation.Upload;
import com.mccm.automation.Upload_Inbound_KIASEPOS;



/**	
 *
 */
//public class App extends MyAutomationConstants
//{

@Test

public class App_Inbound_KIASEPOS extends MyAutomationConstants {
//public class App {

//	@Test


	public static String PROJECT_FOLDER_PATH1;
	public static String TEST_ENV1;
	public static String user;
	public static String pass;
	public static String host;
	public static XSSFWorkbook wb;

   // static String name = " ";

  //  public static void main( String[] args )
//	 {
	
	      public void VerifyKIASEPOSFileLoadSuccessfully() throws InterruptedException, AWTException, SftpException {
		//   public void main() throws InterruptedException, AWTException, SftpException {
	//		public static void main() throws InterruptedException, AWTException {
	
//    	try
//		{
			//Create page objects and set the test result path
		//	SFDC_LoginPage sfdcLoginPageObject = new SFDC_LoginPage(getDriver());
		//	sfdcLoginPageObject.setResultPath(getOutputDirectory());
        	System.out.println("Case 1:");        	
        	System.out.println("PROJECT_FOLDER_PATH:");  
        	System.out.println("ENV_WIKI:");  
//    		PROJECT_FOLDER_PATH=general_ReadProperty("PROJECT_FOLDER_PATH");
    		PROJECT_FOLDER_PATH1=general_ReadProperty("PROJECT_FOLDER_PATH");
    		ENV_WIKI=general_ReadProperty("ENV_WIKI");
        	String path= (PROJECT_FOLDER_PATH1+ENV_WIKI);
			 TEST_ENV1=general_ReadProperty("TEST_ENV");
     	
//			XLSXReadWrite readFile = new XLSXReadWrite(PROJECT_FOLDER_PATH + ENV_WIKI);
			 XLSXReadWrite readFile = new XLSXReadWrite(path);
		
			int rowIndex=readFile.findRowIndex("EnvDetails", TEST_ENV1);
			int userNameColIndex=readFile.findColumnIndex("EnvDetails", "USER_NAME");
			int passwordColIndex=readFile.findColumnIndex("EnvDetails", "PASSWORD");
			//int passwordColIndex=readFile.findColumnIndex("EnvDetails", "UNIX-SERVER");
			int hostColIndex=readFile.findColumnIndex("EnvDetails", "UNIX-SERVER");
			
			user= readFile.getCellValue("EnvDetails", rowIndex, userNameColIndex); 
			pass= readFile.getCellValue("EnvDetails", rowIndex, passwordColIndex);
			host=readFile.getCellValue("EnvDetails", rowIndex, hostColIndex);

//			sfdcLoginPageObject.salesForce_Login(readFile.getCellValue("EnvDetails", rowIndex, userNameColIndex), readFile.getCellValue("EnvDetails", rowIndex, passwordColIndex));
//		//	Assert.assertTrue(true, "Login Successful");

//		}catch(Exception e)
//		{
//		//	result.setAttribute("ERROR", e.toString());
//			e.printStackTrace();
//		//Assert.fail("Login Not Successful");
//		}   	
//    	
    	
    	
    	
    	
    	
    	try { 	
        //Object myObject = null;
       // String user = "mccm02";
        //string SftpException="""""
        //String 	 = "unix11";
        Properties config = new Properties();
        config.put("StrictHostKeyChecking","no");
        //String host = "localhost";
        boolean filefound = false;
        String name11= " ";
        int k;
        //String host1 = "46.190.224.85";
        Upload_Inbound_KIASEPOS.main(null);//main();
        JSch jSch = new JSch();
        Session session = jSch.getSession(user,host,9022);
        //Session session = jSch.getSession(user1,host1,22);

        session.setPassword(pass);
        session.setConfig(config);
        session.connect();
        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
    	System.out.println("Case 1:");        	
    	//System.out.println("");     
      
        System.out.println("Session connected: "+session.isConnected());
        System.out.println("");            

        Vector fileList = channelSftp.ls("/opt/SP/mccm/SYSN/input/KIASEPOS");
        
//        for (int i = 0; i < fileList.size(); i++) {
//            ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
//            System.out.println(lsEntry.getFilename());
            
        //fileList = channelSftp.ls("/opt/SP/mccm/SYSN/mccm_dataload/import/input");
        fileList = channelSftp.ls("/opt/SP/mccm/SYSN/input/KIASEPOS");
          //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/cassandra");
          
        	//Vector fileList = channelSftp.ls("/opt/SP/data/pegat02");
        	System.out.println("The available files are : ");
           System.out.println("");  
           for (int i = 0; i < fileList.size(); i++) {
               ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
               System.out.println(lsEntry.getFilename()); 
           		}              
           String[] name = {"DWH.3MMC.SUBSCRIBER_TIP_HIS"};
           
           for (int i = 0; i < name.length; i++) 
           {
           	 filefound = false;
            for (int j = 0; j < fileList.size(); j++) 
            {
                ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(j);
                name11 = (lsEntry.getFilename()); 
 //                if (lsEntry.getFilename()).contains(name[i]) { 
                if (name11.contains(name[i])) { 
                 	 filefound = true;
                 	 k=i+1;
                	 System.out.println("The file [" + k +"]:" + name[i] + " is found in the input folder");
                	}
                 
          
              //   If (true) {
             //        name = (lsEntry.getFilename()); 
                 	
            //     }
                 
             //     name.contains("file_list_oracle.lst")
                 
          // //    }
//                try {
//                    channelSftp.lstat((String) fileList.get(i));
//                } catch (Exception e){
//                    if(e.hashCode() == ChannelSftp.SSH_FX_NO_SUCH_FILE){
//                    // file doesn't exist
//                    } else {
//                    // something else went wrong
//                        throw e;
//                    }
//                }
                
                ///opt/SP/mccm/SYSN/mccm_dataload/import/input
//                x = lsentry.getfilename()
//                		for each x in 
//                		if x(i)= "abc"
//               System.out.println(x);
//               System.out.println (fifle 'x' available at /opt/SP/mccm/SYSN/mccm_dataload/import/input)
               // System.out.println(lsEntry.getFilename());                    
              //  name = (lsEntry.getFilename()); 
               // if name.contains(lsEntry.getFilename());
             //   If (true) {
            //        name = (lsEntry.getFilename()); 
                	
           //     }
                
            //     name.contains("file_list_oracle.lst")
              //  {
                //
                  //        System.out.println("The Keyword :file_list_oracle: is found in given string");
            //    } 
                //  String name = " ";
                  
               //  String name1 = "file_list_oracle.lst";
                // String str1 = "Java string contains If else Example";
              //   if (str1.contains("example")) {
               //      System.out.println("The Keyword :example: is found in given string");
              //   } 
              //   if name	.contains(name1){
            //     Then 
              //   System.out.println("exist fifle  " + name1);                   

        }
            
            if (!filefound)
            {
 
//                 System.out.println("The Keyword :file_list_oracle: is not found in the path");
            	 k=i+1;
           	 System.out.println("The file [" + k +"]: " + name[i] + " is NOT found in the input folder");            	
           //	 System.out.println("The file :" + name[i] + ": is not found in given path");
          	 
            }
           }
    	// }           
            //fileList = channelSftp.ls("C:\\ToUpload");
           //String dir = "C:\\ToUpload";
            
            //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/cassandra");
             
/*               	//Vector fileList = channelSftp.ls("/opt/SP/data/pegat02");
              System.out.println("The available files are : ");
              System.out.println("");            
           
               for (int i = 0; i < fileList.size(); i++) {
                   ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
                  // LsEntry name = lsEntry
//                   try {
//                       channelSftp.lstat((String) fileList.get(i));
//                   } catch (Exception e){
//                       if(e.hashCode() == ChannelSftp.SSH_FX_NO_SUCH_FILE){
//                       // file doesn't exist
//                       } else {
//                       // something else went wrong
//                           throw e;
//                       }
//                   }
                   
                   ///opt/SP/mccm/SYSN/mccm_dataload/import/input
//                   x = lsentry.getfilename()
//                   		for each x in 
//                   		if x(i)= "abc"
//                  System.out.println(x);
//                  System.out.println (fifle 'x' available at /opt/SP/mccm/SYSN/mccm_dataload/import/input)
                   System.out.println(lsEntry.getFilename());  */                  
               //	channelSftp.put(dir,"/opt/SP/data/mccm02/logs/temp/cassandra");
             

        //   }
               
			/*
			 * channelSftp.put("C:\\oracle\\cusdata1.csv",
			 * "/opt/SP/data/mccm02/logs/temp/cassandra/cusdata1.csv");
			 * channelSftp.put("C:\\oracle\\cusdata2.csv",
			 * "/opt/SP/data/mccm02/logs/temp/cassandra/cusdata2.csv");
			 * channelSftp.put("C:\\oracle\\cusdata3-oracle.csv",
			 * "/opt/SP/data/mccm02/logs/temp/cassandra/cusdata3-oracle.csv");
			 */
           // System.out.println("Files uploaded successfully);

        channelSftp.disconnect();
        session.disconnect();
    }
    catch (Exception e){
     e.printStackTrace();
    }
    
    
//Oracle Load        
   	 Object args = null;
	
	  System.out.println(""); 
	  //System.out.println("Case 1:");
	//pr  ZippingFiles.main(args); 
		
		
		  System.out.println(""); 
		 // System.out.println("Case 2:");
		  System.out.println("");
		 // FilesAvailabilityCheck.main(args);
     	  System.out.println("Case 3:"); 
	//pr	  ScriptsExecution.main(args); // // Cassandra
		  //load start System.out.println(""); System.out.println("Case 4-5-6:");
	//pr	  DBCheck_Mccm.main(args); // ////////////////////////////
	//pr	  System.out.println("Cassandra load start"); System.out.println("");
		 
	    //pr    Upload_Cassandra.main(null);
		   System.out.println("Case 2:"); 
		///pr  FilesAvailabilityCheck_Cassandra.main(null);
		  FileExistChk_Inbound_KIASEPOS.main(null);
		 
			
     		  System.out.println(""); System.out.println("Case 3:"); //
			  
		//pr	  ZippingFiles_Cassandra.main(args); 
			  System.out.println(""); //
			//  System.out.println("Case 3:"); 
			  //ZippingFiles_Cassandra.main(args);
			  System.out.println(""); //// System.out.println("Case 4:");
		//	  DBCheck_Cassandra.main(args); //// //  prafulla commeted
			  
		//pr	  ScriptsExecution_Cassandra.main(args); //// //
			 			
	 //  PegaAppEndToEndFlow.RunNBACampaignEndToEndFlow();
			 
		 
		 
///////////////////////////////////            
	 // }
        
        
        /**
         * Checker prevents this from compiling...
         */
//        System.out.println("myObject: " + myObject.toString());
        /**
         * ... which is simply fantastic. It shows:
         *
         * error: [dereference.of.nullable] dereference of possibly-null
         * reference myObject
         *
         * http://checkerframework.org
         */
    	 
        System.out.println("Done...");
    }

	//*******************************************************************************************
	//*Function:	general_ReadProperty														*
	//*Arguments:	Property Key as String													 	*
	//*Return 		Poverty Value as String														*
	//*Descriptions: 																			*
	//*	This function will read the Properties file and return property value to based on key.	*
	//*Author: 														*
	//*******************************************************************************************
	public static String general_ReadProperty(String propertyKey)
	{
		String propertyValue="";
		File cfgfile = new File("configurationFile.properties");
		
		if(cfgfile.exists())
		{
			  Properties propties = new Properties();
			  FileInputStream propFile;

			  try {
				  propFile = new FileInputStream(cfgfile);
				  propties.load(propFile);
				  propertyValue=propties.getProperty(propertyKey);
				  } catch (Exception e1) {
					  
					  e1.printStackTrace();
				  } 
		 }
		return propertyValue;
		
	    
}
public static String getCellValue(String sheetName, int rowIndex, int cellIndex) {
	XSSFSheet sheet = wb.getSheet(sheetName);
	if (sheet == null) {
		return "sheet doesn't exist for sheet name : " + sheetName;
	}
	XSSFRow row = sheet.getRow(rowIndex);
	if (row == null) {
		return "row doesn't exist for index : " + rowIndex;
	}
	XSSFCell cell = row.getCell(cellIndex);
	if (cell == null) {
		return "";
	}
	return cell.toString().trim();
}

}
