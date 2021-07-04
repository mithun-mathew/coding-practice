package net.mithunmathew.codingpractice.socketprogramming.chatapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private Socket socket = null;
	private Scanner scan = null;
	private DataOutputStream output = null;
	private DataInputStream input = null;
	
	public Client(InetAddress ip, int port) {
		
		try {
			System.out.println("Trying to connect to Server");
			socket = new Socket(ip, port);
			System.out.println("Connected to Server\n");
			
			scan = new Scanner(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
		
			Thread sendMessage = new Thread(new Runnable() {
				public void run() {
					while(true) {
						String msg = scan.nextLine();
						try {
							output.writeUTF(msg);
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						if(msg.equals("end")) {
							try {
	
								socket.close();
								input.close();
								output.close();
								scan.close();
								break;
							}
							catch(Exception e) {
								System.out.println(e);
							}
						}
					}
				}
			});
			
			Thread receiveMessage = new Thread(new Runnable() {
				public void run() {
					while(true) {
						try {
							String msg = input.readUTF();
							System.out.println(msg);
						}
						catch(Exception e) {
							System.out.println(e);
							break;
						}
					}
				}
			});
			
			sendMessage.start();
			receiveMessage.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) {	
		
		try {
			InetAddress ip = InetAddress.getByName("localhost");
			int port = 6000;
			Client client = new Client(ip, port);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
