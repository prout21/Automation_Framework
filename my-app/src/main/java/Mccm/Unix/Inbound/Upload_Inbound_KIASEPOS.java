	package Mccm.Unix.Inbound;

	import com.jcraft.jsch.ChannelSftp;
	import com.jcraft.jsch.ChannelSftp.LsEntry;
	import com.jcraft.jsch.JSch;
	import com.jcraft.jsch.Session;

import java.io.File;
import java.io.File.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



import com.jcraft.jsch.SftpProgressMonitor;
	
	public class Upload_Inbound_KIASEPOS extends App_Inbound_KIASEPOS_Test
 {
	//public class Upload extends App
//	public static String PROJECT_FOLDER_PATH1;
//	public static String TEST_ENV1;
//	public static String user;
 //	public static String host;	
	private static XSSFWorkbook wb;
	
	@Test
	
		
	   // static String name = " ";

    public static void main( String[] args )
	    	    {
 	
	    	    		    	
	    	 try { 	
	        //Object myObject = null;
	       // String user = "";
	        //string SftpException="""""
	        //String pass = "";
	        Properties config = new Properties();
	        config.put("StrictHostKeyChecking","no");
	        //String host = "localhost";
	      //  boolean filefound = false;
	      //  String name11= " ";
	       // int k;

	        JSch jSch = new JSch();
	        Session session = jSch.getSession(user,host,9022);
	        session.setPassword(pass);
	        session.setConfig(config);
	        session.connect();
	        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
	        channelSftp.connect();
	      //  String lcd="C:\\ToUpload";
	        //String localFile = ("C:\\ToUpload\\ADDRESSBAN_20200515010201.csv");
	       // String remoteDir = ("C:\\ToUpload1\\");	        
	        //channelSftp.cd(lcd);
	      // File f = new File("ADDRESSBAN_20200515010201.csv");
	      //  channelSftp.put(new FileInputStream(f), f.getName());
	      //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs///");
	        Vector fileList = channelSftp.ls("/opt/SP/mccm/SYSN/input/KIASEPOS");
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	        
	       	System.out.println("The available files are : ");
	           System.out.println("");  
//	           for (int i = 0; i < fileList.size(); i++) {
//	               ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
//	               System.out.println(lsEntry.getFilename()); 
//	           		}
	           //String curDir=("C:\\oracle\\");
	             File f = null;
	           File curDir = new File("C:\\NBA_Inbound\\KIASEPOS");  
	           File[] filesList1 = curDir.listFiles();
	           for(File f1 : filesList1){
//	               if(f.isDirectory())
//	                   System.out.println(f1.getName());
	               if(f1.isFile())
	               {
	                   System.out.println(f1.getName());
	               }
	           }   
	        //   String[] name = {"custdata1", "BUILDING", "CALENDAR", "CLINTVIEWEXPORTREVENUEEST", "CLINTVIEWEXPORTREVENUE", "CLINTVIEWREFOPTPRODUCT", "CLINTVIEWVWOPTRUN", "CONTACTLIST", "CONTACTOFFER", "CONTACTSTATUS", "CONTRACT", "CUSTOMER", "CUSTREL", "FLAGS", "GEOFOOTPRINT", "HOUSEHOLD", "LEGPPRCRATE", "LEGPRODUCT", "LEGSOCDISCOUNT", "LEGVOTYPE", "MEMOTYPE", "PERMISSIONS", "PRODUCT", "REPORTINGSERVICEPRODUCT", "SALESCHANNEL", "SALESORGANIZATION", "SCHIERARCHY", "SCORES", "SUBSCRIPTION", "TOHIERARCHY"};
		     String[] name = {"DWH.3MMC.SUBSCRIBER_TIP_HIS"};
	           
	    //      String[] name = {"BUILDING"};//, "BUILDING", "CALENDAR", "CLINTVIEWEXPORTREVENUEEST", "CLINTVIEWEXPORTREVENUE", "CLINTVIEWREFOPTPRODUCT", "CLINTVIEWVWOPTRUN", "CONTACTLIST", "CONTACTOFFER", "CONTACTSTATUS", "CONTRACT", "CUSTOMER", "CUSTREL", "FLAGS", "GEOFOOTPRINT", "HOUSEHOLD", "LEGPPRCRATE", "LEGPRODUCT", "LEGSOCDISCOUNT", "LEGVOTYPE", "MEMOTYPE", "PERMISSIONS", "PRODUCT", "REPORTINGSERVICEPRODUCT", "SALESCHANNEL", "SALESORGANIZATION", "SCHIERARCHY", "SCORES", "SUBSCRIPTION", "TOHIERARCHY"};
	           
	           int l = 0;
	           for (int i = 0; i < name.length; i++) 
	           {
	        	   boolean  filefound = false;
	            int k;
		           File curDir2 = new File("C:\\NBA_Inbound\\KIASEPOS");
		           File[] filesList2 = curDir2.listFiles();
		           //File f2 = new File(".");
//	            String filename1 = "";
//	            File f1 : filesList1            
				//for (int j = 0; j < filesList2.length; j++)
				for (File f2 : filesList2) 
	            
	            {
					//   ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(j);
	                String name11 = (f2.getName()); 
	 //                if (lsEntry.getFilename()).contains(name[i]) { 
	                if (name11.contains(name[i])) { 
	                 	 filefound = true;
	                 	 k=i+1;
	                	 System.out.println("The file [" + k +"]:" + name[i] + " is found in the input folder");
	           	      //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/temp/cassandra");
	                	 //filename1=("C:\\oracle\\" + name11);
	                	// channelSftp.put("C:\\oracle\\cusdata1.csv", "/opt/SP/data/mccm02/logs/temp/cassandra/");
	                	 //channelSftp.put(filesList2[j].getPath(), "/opt/SP/data/mccm02/logs/temp/cassandra/"+f2.getName());
	                	// channelSftp.put(f2.getPath(), "/opt/SP/data/mccm02/logs/temp/cassandra/"+f2.getName(),new progressMonitor());
	                	 channelSftp.put(f2.getPath(), "/opt/SP/mccm/SYSN/input/KIASEPOS/"+f2.getName(),new progressMonitor());
	                	 
	                	 System.out.println("The file [" + k +"]:" + name[i] + " UPLOAD done to the  KIASEPOS input folder");
	                	 Thread.sleep(2000);
	                	 
	                	}
	                 
	          
       

	        }
	            
	            if (!filefound)
	            {
	 
//	                 System.out.println("The Keyword :file_list_oracle: is not found in the path");
	            	 k=i+1;
	            	  l = i+1;
	           	 System.out.println("The file [" + k +"]: " + name[i] + " is NOT found in the input folder");
	           	 System.out.println("The file [" + k +"]: " + name[i] + " Upload failed as file is missing");            	
	           	 
	           //	 System.out.println("The file :" + name[i] + ": is not found in given path");
	          	 
	            }
	           }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	           
	       
	//       channelSftp.put("", "/opt/SP/data/mccm02/logs/temp/cassandra/cusdata1.csv");
//	       channelSftp.put("C:\\oracle\\cusdata2.csv", "/opt/SP/data/mccm02/logs///");	       
//	       channelSftp.put("C:\\oracle\\cusdata3.csv", "/opt/SP/data/mccm02/logs///");	       
//	       
	        //channelSftp.put(localFile, remoteDir + "jschFile.txt");       
	        //channelSftp.put()
	        //f.delete();
	           	 System.out.println("The file upload completed with missing files : " + l);         	
            channelSftp.disconnect();
            session.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
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
//}