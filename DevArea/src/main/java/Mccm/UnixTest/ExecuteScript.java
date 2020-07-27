package Mccm.UnixTest;

	import com.jcraft.jsch.ChannelSftp;
	import com.jcraft.jsch.ChannelSftp.LsEntry;
	import com.jcraft.jsch.JSch;
	import com.jcraft.jsch.Session;

	import java.util.Properties;
	import java.util.Vector;

import org.testng.annotations.Test;

	/*import java.util.ArrayList;
	import com.jcraft.jsch.Channel;
	import com.jcraft.jsch.ChannelExec;
	import com.jcraft.jsch.ChannelSftp;
	import com.jcraft.jsch.JSch;
	import com.jcraft.jsch.Session;
	*/
	public class ExecuteScript {

	@Test
	
		public void unixscript() {
	        try { 	
	            String user = "mccm02";
	            String user1 = "pegat02";
	            //string SftpException="""""
	            String pass = "unix11";
	            Properties config = new Properties();
	            config.put("StrictHostKeyChecking","no");
	            String host = "localhost";
	            String host1 = "46.190.224.85";

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
	            System.out.println("connected");            

//	            Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/temp/cassandra");
//	            for (int i = 0; i < fileList.size(); i++) {
//	                ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
//	                System.out.println(lsEntry.getFilename());
	                
	               Vector fileList = channelSftp.ls("/opt/SP/mccm/SYSN/mccm_dataload/import/input");
	             //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/cassandra");
	              
	            	//Vector fileList = channelSftp.ls("/opt/SP/data/pegat02");
	               System.out.println("The available files are : ");
	               System.out.println("hi");            
	            
	                for (int i = 0; i < fileList.size(); i++) {
	                    ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
	                   // LsEntry name = lsEntry
//	                    try {
//	                        channelSftp.lstat((String) fileList.get(i));
//	                    } catch (Exception e){
//	                        if(e.hashCode() == ChannelSftp.SSH_FX_NO_SUCH_FILE){
//	                        // file doesn't exist
//	                        } else {
//	                        // something else went wrong
//	                            throw e;
//	                        }
//	                    }
	                    
	                    ///opt/SP/mccm/SYSN/mccm_dataload/import/input
//	                    x = lsentry.getfilename()
//	                    		for each x in 
//	                    		if x(i)= "abc"
//	                   System.out.println(x);
//	                   System.out.println (fifle 'x' available at /opt/SP/mccm/SYSN/mccm_dataload/import/input)
	                    System.out.println(lsEntry.getFilename());                    
	              

	            }
	                
	                
	                //fileList = channelSftp.ls("C:\\ToUpload");
	               //String dir = "C:\\ToUpload";
	                
	                //  Vector fileList = channelSftp.ls("/opt/SP/data/mccm02/logs/temp/cassandra");
	                 
	/*               	//Vector fileList = channelSftp.ls("/opt/SP/data/pegat02");
	                  System.out.println("The available files are : ");
	                  System.out.println("");            
	               
	                   for (int i = 0; i < fileList.size(); i++) {
	                       ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
	                      // LsEntry name = lsEntry
//	                       try {
//	                           channelSftp.lstat((String) fileList.get(i));
//	                       } catch (Exception e){
//	                           if(e.hashCode() == ChannelSftp.SSH_FX_NO_SUCH_FILE){
//	                           // file doesn't exist
//	                           } else {
//	                           // something else went wrong
//	                               throw e;
//	                           }
//	                       }
	                       
	                       ///opt/SP/mccm/SYSN/mccm_dataload/import/input
//	                       x = lsentry.getfilename()
//	                       		for each x in 
//	                       		if x(i)= "abc"
//	                      System.out.println(x);
//	                      System.out.println (fifle 'x' available at /opt/SP/mccm/SYSN/mccm_dataload/import/input)
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
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        
	        
	// Oracle Load        
	        System.out.println("load ");            
	        /*//     	System.out.println("Case 2:");        	        
	        ZippingFiles.main(args);
	        System.out.println("");            
	    //    System.out.println("Case 3:");\
	          System.out.println("");
	          FilesAvailabilityCheck.main(args);       
	        //    System.out.println("Case 3:");\
	            ScriptsExecution.main(args);  
	            // Cassandra load start
	            System.out.println("");            	
	            //    System.out.println("Case 3:");\
	            DBCheck_Mccm.main(args);  
////////////////////////////	            
	            System.out.println("Cassandra load start");    
	            System.out.println("");          
				
				 * // System.out.println("Case 2:");
				 * FilesAvailabilityCheck_Cassandra.main(args); System.out.println(""); //
				 * System.out.println("Case 3:");\ ZippingFiles_Cassandra.main(args);
				 * System.out.println(""); // System.out.println("Case 3:");\
				 * ZippingFiles_Cassandra.main(args); System.out.println("");
				           	
	              //    System.out.println("Case 3:");\
	              DBCheck_Cassandra.main(args);  */  

	}


}