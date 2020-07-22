package com.mccm.automation;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ScriptsExecution {

	// static String filepath = "/opt/SP/mccm/SYSN/mccm_dataload/import/scripts";

	/**
	 	 */
	public static void main(Object args) {
	    String host="localhost";
	    String user="mccm02";
	    String password="unix11";
	    //String command="ls -lrt";
		//   String command="gzip /opt/SP/mccm/SYSN/mccm_dataload/import/input/";	    
		   // String command="gzip /opt/SP/mccm/SYSN/mccm_dataload/import/input/";
	  //  String command="ksh /opt/SP/mccm/SYSN/mccm_dataload/import/scripts/";
	    String command="ksh /opt/SP/mccm/SYSN/mccm_dataload/import/scripts/mccm_oracle_file_Distribution.ksh";
	    String command1="ksh /opt/SP/mccm/SYSN/mccm_dataload/import/scripts/mccm_synonyms_switch.ksh";


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
	       // ((ChannelExec)channel).setCommand(command1);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
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
	          try{Thread.sleep(3000);}catch(Exception ee){}

	          
	        }
//	        channel.disconnect();
//	        session.disconnect();
//	        System.out.println("DONE");
//	    }catch(Exception e){
//	    	e.printStackTrace();
	    
	    	 channel=session.openChannel("exec");
        ((ChannelExec)channel).setCommand(command1);
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);
        
        //InputStream  
        in=channel.getInputStream();
        channel.connect();
        //byte[]  
        		tmp=new byte[1024];
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
        channel.disconnect();
        session.disconnect();
        System.out.println("DONE");
    }catch(Exception e){
    	e.printStackTrace();
    }	    
	}

}


