/*
 * package com.mccm.automation; import com.jcraft.jsch.ChannelSftp; import
 * com.jcraft.jsch.ChannelSftp.LsEntry; import com.jcraft.*; import
 * com.jcraft.jsch.Session;
 * 
 * import java.util.Properties; import java.util.Vector;
 * 
 * public class Filupload {
 * 
 * private void upload(String[] args) { try {
 * 
 * String user = "mccm02"; String pass = "unix11"; Properties config = new
 * Properties(); config.put("StrictHostKeyChecking","no"); String host =
 * "localhost"; JSch jsch = new JSch(); Session session = jsch.getSession(user,
 * host, 9022); session.setPassword(pass);
 * 
 * //java.util.Properties config = new java.util.Properties();
 * config.put("StrictHostKeyChecking", "no"); session.setConfig(config);
 * session.connect();
 * 
 * Channel channel = session.openChannel("sftp"); channel.connect(); ChannelSftp
 * channelSftp = (ChannelSftp) channel; // channelSftp.cd(workingDirectory); //
 * channelSftp.cd(workingDirectory); channelSftp.cd("C:\\ToUpload"); // File f =
 * new File(filename); File f = new File("ADDRESSBAN_20200515010201.csv");
 * 
 * channelSftp.put(new FileInputStream(f), f.getName());
 * 
 * f.delete();
 * 
 * } catch (Exception ex) { ex.printStackTrace(); } }
 * 
 * 
 * }
 */