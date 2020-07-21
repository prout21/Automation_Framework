package Mccm.UnixTest;
import java.util.Properties;

import org.testng.annotations.Test;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class AuthJshUnix {
	
	@Test
     public void Jshconnectunix() throws JSchException, InterruptedException
     {
	//public static void main(String[] args) throws JSchException, InterruptedException {
       
		String privateKeyPath = "C:\\Users\\prout21\\putty\\PuTTY\\converted.ppk";
        
		JSch jsch = new JSch();
		
		jsch.addIdentity(privateKeyPath);
		Session session = jsch.getSession("dxc_dev", "3.120.110.152",18881);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		System.out.println("Session connect");
		Thread.sleep(1000);
		session.disconnect();
		System.out.println("Session disconnect");
	} 
}

