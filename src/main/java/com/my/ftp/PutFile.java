package com.my.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class PutFile {

	public static void main(String[] args) {
		FTPClient ftp = new FTPClient();

		try {
			ftp.connect("C668HCN.int.thomsonreuters.com");//whether success
			System.out.println("connecting to server ...");
			int reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)){
				System.out.println("FTP server refused connection.");
				return;
			}
			
			if(!ftp.login("pcadmin", "Hgg41kkt")){
				System.out.println("log in failed");
				return;
			};//whether succeed
			System.out.println("log in successfully ...");
			
			InputStream output = new FileInputStream("target/1.txt");
			ftp.appendFile("testfolder/2.txt", output);
			System.out.println("transfer file... done ...");
			output.close();
			ftp.noop();
			ftp.logout();
			System.out.println("log out server ...");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
