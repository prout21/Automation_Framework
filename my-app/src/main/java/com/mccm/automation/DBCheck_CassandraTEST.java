package com.mccm.automation;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.apache.commons.io.IOUtils;
 

public class DBCheck_CassandraTEST extends App {


	/**
	 	 */
@Test	
	public static void main(Object args)
//public  void main() 

	{
	    String host="localhost";
	    String user="mccm02";
	    String password="unix11";
        String Status="COMPLETED";
        String FCA="FCA_cass_20200707010201.csv";
        String SCA="SCA_cass_20200707010201.csv";
        
	    
	  //  String command="ls -lrt";
	//	   String command="/opt/SP/oracle/Oracle_Client/12.2/sqlplus";
//		   
	//	    String command="gzip /opt/SP/mccm/SYSN/mccm_dataload/import/input/CLOSING_FILE_ORACLE1.csv";
	   String command="sh /opt/SP/data/mccm02/temp/cassandra.sh";
	   //String command="ksh /opt/SP/mccm/SYSN/mccm_dataload/import/mccm1.ksh";

	    try{
	    	
	        //Channel channel = getChannelSftp(host, user, password);

	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 9022);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	        //channel.connect();
	        //ChannelSftp channelSftp = (ChannelSftp) channel;
	    	
	    	System.out.println("Connected");
	    	
	        //channelSftp.cd(filepath);
	       // channel = session.openChannel("sftp");   
	    	//Channel channel=session.openChannel("sftp");
	        //ChannelSftp channelSftp = (ChannelSftp) Channel;
	    	//ChannelSftp.cd(filepath);
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command);
	        //((ChannelExec)channel).setCommand(command1);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        
	       String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
	     //    String contents = new String(null, in.read(), 0;
	         
	         //System.out.println(contents);

	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}catch(Exception ee){}
	        }
	        
	         System.out.println(contents);
	         System.out.println();
	         
            if (contents.contains(FCA))
            { 
           	 System.out.println("The file:" + FCA +  ":  loaded to Cassandra DB  successfully.");
            }else { 
               	 System.out.println("The file:" + FCA +  ":  Not loaded  successfully.");
 
			}	    
            if (contents.contains(SCA)) { 
            	System.out.println();
            	System.out.println("The file:" + SCA +":  loaded to Cassandra DB  successfully.");
            }
            	else { 
                  	 System.out.println("The file:" + SCA +  ":  Not loaded to Cassandra DB  successfully.");
                	
   			}
	            if (contents.contains(Status)) { 
	            	 System.out.println();
	              	 System.out.println("The file status updated successfully as : " + Status + " at Cassandra.");
	   			}            
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    	
}
}