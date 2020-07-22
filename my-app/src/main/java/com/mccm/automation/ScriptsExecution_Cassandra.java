package com.mccm.automation;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ScriptsExecution_Cassandra {

	// static String filepath = "/opt/SP/mccm/SYSN/mccm_dataload/import/scripts";

	/**
	 	 */
	public static void main(String[] args) {
	    String host="localhost";
	    String user="mccm02";
	    String password="unix11";
	    //String command="ls -lrt";
		//   String command="gzip /opt/SP/mccm/SYSN/mccm_dataload//input/	    
		   // String command="gzip /opt/SP/mccm/SYSN/mccm_dataload/import/input/";
	  //  String command="ksh /opt/SP/mccm/SYSN/mccm_dataload//scripts/h";
	    String command="sh /opt/SP/mccm/SYSN/loadernode/scripts/cassandra/temp/zip.sh";

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
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }

	}

}

//
////import com.jcraft.jsch.ChannelSftp;
//
//
//import java.util.ArrayList;
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelExec;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//
//public class Main {
//
//ChannelExec channelExec = null;
//static Channel channel = null;
//
//static String host = "";
////static String user = "";
//static String user = "";
//static String password = "";
//
//public static void main(String[] args) {
////		String filename = ".lst";
//		String filename = "";
//
//    String filepath = "/opt/t";
//    try {
//    	
//        Channel channel = getChannelSftp(host, user, password);
//        channel.connect();
//        ChannelSftp channelSftp = (ChannelSftp) channel;
//        channelSftp.cd(filepath);
//        String path = channelSftp.ls(filename).toString();
//        if (!path.contains(filename)) {
//            System.out.println("File doesn't exist.");
//        } else
//            System.out.println("File already exist.");
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//}
//
//private static Channel getChannelSftp(String host, String user, String password) {
//    try {
//        JSch jsch = new JSch();
//        Session session = jsch.getSession(user, host, 9022);
//        java.util.Properties config = new java.util.Properties();
//        config.put("StrictHostKeyChecking", "no");
//        config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
//        session.setConfig(config);
//        session.setPassword(password);
//        session.connect();
//        channel = session.openChannel("sftp");
//
//    } catch (Exception e) {
//        System.out.println("Failed to get sftp channel. " + e);
//    }
//    return channel;
//}
//}*//
