//import com.jcraft.jsch.ChannelSftp;
package com.mccm.automation;


import java.util.ArrayList;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FilesAvailabilityCheck {

ChannelExec channelExec = null;
static Channel channel = null;

static String host = "localhost";
//static String user = "pegat02";
static String user = "mccm02";
static String password = "unix11";

public static void main(Object	 args) {
//String filename = "file_list_oracle1.lst";
		String filename = "file_list_oracle.lst";

    String filepath = "/opt/SP/mccm/SYSN/mccm_dataload/import/input";
    try {
    	
        Channel  channel = getChannelSftp(host, user, password);
        channel.connect();
        ChannelSftp channelSftp = (ChannelSftp) channel;
        channelSftp.cd(filepath);
        String path = channelSftp.ls(filename).toString();
        if (!path.contains(filename)) {
            System.out.println("File doesn't exist." + filename);
        } else
        	//            System.out.println("");            
         	System.out.println("Case 2:");     	
           // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
        String dir= channelSftp.pwd().toString();
        System.out.println("File exist at the path ---  " + dir);        
            System.out.println("---  " + filename);


    } catch (Exception e) {
        e.printStackTrace();
    }

}

private static Channel getChannelSftp(String host, String user, String password) 
{
    try {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 9022);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
        session.setConfig(config);
        session.setPassword(password);
        session.connect();
        channel = session.openChannel("sftp");

    } catch (Exception e) {
        System.out.println("Failed to get sftp channel. " + e);
    }
    return channel;
}
}