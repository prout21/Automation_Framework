
package Mccm.UnixMain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Scripttest1 {

/**
 
 * This class executes the shell script on the remote server
 
 * Requires the jSch java library
  */
 //public static void main(String[] args) throws JSchException, InterruptedException {

 

 //private static String USERNAME ="mccm02"; // username for remote host

 //private static String PASSWORD ="unix11"; // password of the remote host

 //private static String host = "ip-10-0-4-99.eu-central-1.compute.internal"; // remote host address
// private static String host = "10-0-4-99.eu-central-1.compute.internal"; // remote host address

 private static int port=18881;
 private static String USERNAME ="dxc_dev"; // username for remote host

 //private static String PASSWORD ="unix11"; // password of the remote host

 //private static String host = "ip-10-0-4-99.eu-central-1.compute.internal"; // remote host address
 private static String host = "3.120.110.152"; // remote host address
  

 /**
 
  * This method will execute the script file on the server.
 
  * This takes file name to be executed as an argument
 
  * The result will be returned in the form of the list
 
  * @param scriptFileName
 
  * @return
 
  */

 public List<String> executeFile(String scriptFileName)
  {
      List<String> result = new ArrayList<String>();


     try

     {

 

         /**
 
         * Create a new Jsch object
 
         * This object will execute shell commands or scripts on server
 
         */

         JSch jsch = new JSch();

         /*

         * Open a new session, with your username, host and port

         * Set the password and call connect.

         * session.connect() opens a new connection to remote SSH server.

         * Once the connection is established, you can initiate a new channel.

         * this channel is needed to connect to remotely execution program

         */

         Session session = jsch.getSession(USERNAME, host, port);
 
         session.setConfig("StrictHostKeyChecking", "no");
 
         //session.setPassword(PASSWORD);
 
         session.connect();
 
          System.out.println("test1");
 
         //create the excution channel over the session
 
         ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
 
         System.out.println("test2");
 
         // Gets an InputStream for this channel. All data arriving in as messages from the remote side can be read from this stream.
 
         InputStream in = channelExec.getInputStream();
 
         System.out.println("test3");
 
         // Set the command that you want to execute
 
         // In our case its the remote shell script
 
         channelExec.setCommand("sh "+scriptFileName);
         //channelExec.setCommand("sh "+"aaaa");
 
         System.out.println("test4");
 
         // Execute the command
 
         channelExec.connect();
 
         System.out.println("test5");
 
         // Read the output from the input stream we set above
 
         BufferedReader reader = new BufferedReader(new InputStreamReader(in));
 
         String line;
 
         System.out.println("test6");
 
         //Read each line from the buffered reader and add it to result list
 
         // You can also simple print the result here
 
         while ((line = reader.readLine()) != null)
 
         {
 
             result.add(line);
 
         }
 
 
         System.out.println("test7");
         //retrieve the exit status of the remote command corresponding to this channel
 
         int exitStatus = channelExec.getExitStatus();
 
 
 
         //Safely disconnect channel and disconnect session. If not done then it may cause resource leak
 
         channelExec.disconnect();
 
         session.disconnect();
 
         System.out.println("test8");
 
         if(exitStatus < 0){
 
            // System.out.println("Done, but exit status not set!");
 
         }
 
         else if(exitStatus > 0){
 
            // System.out.println("Done, but with error!");
 
         }
 
         else{
 
            // System.out.println("Done!");
 
         }
 
     }
 
     catch(Exception e)
 
     {
 
         System.err.println("Error: " + e);
       
     }
 
     return result;
  
 }
public static void main(String[] args) throws JSchException, InterruptedException {
	Scripttest1  obj = new Scripttest1();
	   obj.executeFile("aaa");
	
	
}
     
}
