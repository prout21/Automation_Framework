package Mccm.UnixTest;

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
public class ChkFileExitsUnixCmd     {

	 @Test
    public void Filechkunix() throws Exception
    {
	//public static void main(String[] args) throws JSchException, InterruptedException {
		JSch jsch      = new JSch();
		Session session = null;
		 Channel channel = null;
		 Channel channel1 = null;
		 ChannelSftp  sftp = null;
		
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
       try {
		session.connect();
		System.out.println("Connect successful");
		
		  channel1  = session.openChannel("exec");
	 ((ChannelExec) channel1) .setCommand("ssh mccm02@10.0.4.99");
		((ChannelExec) channel1) .setCommand("unix11");
		
		  channel1.connect(); 
		  System.out.println("Command successful");
		} catch (Exception e) { 
	    	   throw new RuntimeException ("failed to create Command.", e);
		}
	   
        }
       }
 
 
  
 

