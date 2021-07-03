package net.mithunmathew.codingpractice.socketprogramming.singleclient;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;
	
	public Server(int port) {
		
		try {
			System.out.println("Starting Server");
			server = new ServerSocket(port);
			System.out.println("Server Started\n");
			
			System.out.println("Waiting for Client");
			socket = server.accept();
			System.out.println("Accepted connection from Client\n");
			
			input = new DataInputStream(socket.getInputStream());
			String received = "";
			
			while(!received.equals("end")) {
				received = input.readUTF();
				System.out.println(received);
			}
			
			System.out.println("\nClosing connection to client");
			socket.close();
			input.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String args[]) {		
		Server server = new Server(6000);		
	}

}
