//import com.jcraft.jsch.ChannelSftp;
package Mccm.Unix.Inbound;


import java.util.ArrayList;

import org.testng.annotations.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FileExistChk_Inbound_KIASEPOS extends App_Inbound_KIASEPOS_Test {

ChannelExec channelExec = null;
static Channel channel = null;

static String host = "localhost";
//static String user = "pegat02";
static String user = "mccm02";
static String password = "unix11";

@Test

public static void main(String[] args) {
	
//String filename = "file_list_oracle1.lst";
	String[] filename = {"DWH.3MMC.SUBSCRIBER_TIP_HIS.20170129 _9.A901"};//, "file_list_oracle.lst";
//pr	String[] filename = {"SCA_cass_20200722010201.csv.gz", "FCA_cass_202007220010201.csv.gz"};//, "file_list_oracle.lst";

    String filepath = "/opt/SP/mccm/SYSN/input/KIASEPOS";
  //pr  String filepath = "/opt/SP/mccm/SYSN/mccm_data/csv_cassandrafile/";
    try {
    	
        Channel  channel = getChannelSftp(host, user, password);
        channel.connect();
        ChannelSftp channelSftp = (ChannelSftp) channel;
        channelSftp.cd(filepath);
     	//System.out.println("Case 2:");     	
     	int i;
     	String dir=null;
        String path=null;
		for (i = 0; i < filename.length; i++) {
			path = channelSftp.ls(filename[i]).toString();
        if (!path.contains(filename[i])) {
            System.out.println("File doesn't exist." + filename[i]);
        } else
        	//            System.out.println("");            
           // System.out.println("Case 2: File exist at the path -/opt/SP/mccm/SYSN/mccm_dataload/import/input.---  " + filename);
        dir  = channelSftp.pwd().toString();
        System.out.println("File: " + filename[i] + " exist at the path ---  " + dir);        
           // System.out.println("---  " + filename[i]);
		}

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