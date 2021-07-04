package net.mithunmathew.codingpractice.socketprogramming.chatapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
	
	public Server(int port) {		
		
		try {
			System.out.println("Starting Server");
			server = new ServerSocket(port);
			System.out.println("Server Started");
			int clientCount = 0;
			
			while(true) {
				
				System.out.println("\nWaiting for next Client");
				socket = server.accept();
				System.out.println("Accepted connection from Client " + ++clientCount);
				System.out.println("Client details\n" + socket);
				
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				
				System.out.println("Assigning new thread for Client " + clientCount);
				
				ClientHandler t = new ClientHandler(socket, input, output, clientCount);
				clients.add(t);
				t.start();
			}
		}
		catch(Exception e) {
			System.out.println("\nClosing connection to client");
			System.out.println(e);
		}
		
	}
	
	public static void main(String args[]) {		
		Server server = new Server(6000);		
	}

}

class ClientHandler extends Thread{

	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private int ClientId;

	ClientHandler(Socket socket, DataInputStream input, DataOutputStream output, int clientId){
		
		this.socket = socket;
		this.input = input;
		this.output = output;
		this.ClientId = clientId;
		
	}
	
	public void run() {
		
		while(true) {
			try {
				String msg = input.readUTF();
				System.out.println("Received from Client " + this.ClientId + ": " + msg);
				
				if(msg.equals("end")) {
					System.out.println("Removing Client: " + this.ClientId + "\n");
					this.socket.close();
					Server.clients.remove(this);
					break;
				}
				
				for(ClientHandler ch: Server.clients) {
					if(!this.equals(ch)) {
						ch.output.writeUTF("Client " + this.ClientId + ": " + msg);
					}
				}
			}
			catch(Exception e) {
				System.out.println(e);
				break;
			}
		}
		
	}
	
}
