package net.mithunmathew.codingpractice.socketprogramming.singleclient;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private Socket socket = null;
	private Scanner scan = null;
	private DataOutputStream output = null;
	
	public Client(String ip, int port) {
		
		try {
			System.out.println("Trying to connect to Server");
			socket = new Socket(ip, port);
			System.out.println("Connected to Server\n");
			
			scan = new Scanner(System.in);
			output = new DataOutputStream(socket.getOutputStream());
		
			String input = new String();
			
			while(!input.equals("end")) {
				input = scan.next();
				output.writeUTF(input);
			}
			
			socket.close();
			scan.close();
			output.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) {		
		Client client = new Client("127.0.0.1", 6000);		
	}

}
