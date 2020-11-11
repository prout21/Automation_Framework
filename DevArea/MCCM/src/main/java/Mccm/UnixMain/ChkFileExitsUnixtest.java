package Mccm.UnixMain;

import java.util.Properties;
import java.util.Vector;
import org.testng.annotations.Test;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
public class ChkFileExitsUnixtest     {

	 @Test
    public void Filechkunix() throws Exception
    {
	//public static void main(String[] args) throws JSchException, InterruptedException {
		JSch jsch      = new JSch();
		Session session = null;
		Channel channel1  = null;
		
		String privateKeyPath = "C:\\Users\\prout21\\putty\\PuTTY\\converted.ppk";
		
       try {
		
		jsch.addIdentity(privateKeyPath);
		session = jsch.getSession("dxc_dev", "3.120.110.152",18881);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
       } catch (JSchException e) { 
    	   throw new RuntimeException ("failed to create Jsch Session object.", e);
       } 
		session.connect();
		System.out.println("Connect successful");
       
		 try {
		
		 channel1  = session.openChannel("exec");
		((ChannelExec) channel1) .setCommand("ssh mccm02@10.0.4.99");
		((ChannelExec) channel1) .setCommand("unix11");
		 channel1.connect();
  	     System.out.println("command successful");
		
		} catch (Exception e) { 
	    	   throw new RuntimeException ("failed to create Command.", e);
	    	     
		}
    }
 
	 @Test
           public void Filelskunix() throws Exception {
	        System.out.println("Connect1successful");
 	        JSch jsch      = new JSch();
	        Session session1 = null;
	        Channel channel2  = null;
	        ChannelSftp  sftp = null;
	
	 try {
			 //session1.connect();
			 System.out.println("Connect2 successful");
			 channel2 = session1.openChannel("sftp");
			 channel2.connect();
		     sftp = (ChannelSftp) channel2;
			System.out.println("Check1 successful");
			
	       Vector<LsEntry>  files = sftp.ls("/home/dxc_dev");  
			//Vector<LsEntry>  files = sftp.ls("/opt/SP/mccm/SYSN/mccm_dataload/import/input");
		   //Vector<LsEntry> files =  sftp.ls("/opt/SP/mccm/SYSN/mccm_dataload/import/input");
			
	       System.out.println("Check2 successful");
	       System.out.println(files.get(0));
					
	       } catch (Exception e) { 
	    	   throw new RuntimeException ("failed to create file exits.", e);
	       }   	   
}
}