package Mccm.UnixMain;

import java.util.Properties;
import java.util.Vector;
import org.testng.annotations.Test;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
public class ChkFileExitsUnixSuccessful     {

	 @Test
    public void Filechkunix() throws Exception
    {
	//public static void main(String[] args) throws JSchException, InterruptedException {
		JSch jsch      = new JSch();
		Session session = null;
		Channel channel = null;
		ChannelSftp  sftp = null;
		
		String privateKeyPath = "C:\\Users\\prout21\\putty\\PuTTY\\converted.ppk";
       try {
		
		jsch.addIdentity(privateKeyPath);
		session = jsch.getSession("mccm02", "10-0-4-99",22);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
       } catch (JSchException e) { 
    	   throw new RuntimeException ("failed to create Jsch Session object.", e);
       }
       try {
		session.connect();
		System.out.println("Connect successful");
		channel = session.openChannel("sftp");
		channel.connect();
		sftp = (ChannelSftp) channel;
		System.out.println("Check1 successful");
		
        Vector<LsEntry>  files = sftp.ls("/home/dxc_dev");
		
	   System.out.println("Check2 successful");
       System.out.println(files.get(0));
				
       } catch (Exception e) { 
    	   throw new RuntimeException ("failed to create file exits.", e);
	}
    }
}

