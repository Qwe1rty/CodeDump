/* [ChatProgramServer.java]
 * Description: This is an example of a chat server.
 * The program  waits for a client and accepts a message. 
 * It then responds to the message and quits.
 * This server demonstrates how to employ multithreading to accepts multiple clients
 * @author Mangat
 * @version 1.0a
 */

//imports for network communication
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatProgramServer {

	// List of connected clients
	ArrayList<ConnectionHandler> clients = new ArrayList<ConnectionHandler>();

	ServerSocket serverSock;// server socket for connection

	static Boolean running = true;  // controls if the server is accepting clients

	/** Main
	 * @param args parameters from command line
	 */
	public static void main(String[] args) { 
		new ChatProgramServer().go(); //start the server
	}

	/** Go
	 * Starts the server
	 */
	public void go() { 
		while (true) {
			
			System.out.println("Waiting for a client connection..");

			Socket client = null;//hold the client connection

			try {
				serverSock = new ServerSocket(5000);  //assigns an port to the server
//				serverSock.setSoTimeout(10000);  //5 second timeout
				while (running) {  //this loops to accept multiple clients
					client = serverSock.accept();  //wait for connection
					System.out.println("Client connected");
					//Note: you might want to keep references to all clients if you plan to broadcast messages
					//Also: Queues are good tools to buffer incoming/outgoing messages
					
//					ConnectionHandler dank = new ConnectionHandler(client);
					clients.add(new ConnectionHandler(client));
					Thread t = new Thread(clients.get(clients.size() - 1)); //create a thread for the new client and pass in the socket
//					Thread t= new Thread(dank);
					t.start();
					
					System.out.println(clients.size());
//					System.out.println(clients);
				}
				
			} catch (Exception e) { 
//							 System.out.println("Error accepting connection");
				//close all and quit
				try {
					client.close();
				} catch (Exception e1) { 
					System.out.println("Failed to close socket");
				}
				System.exit(-1);
			}
			
		} 
	}

//	public void clearClosedSockets() {
//		for (int i = 0; i < clients.size(); i++) {
//			try {
//				clients.get(i).output.write(("CONNECTION STATUS TEST"));
//				clients.get(i).output.newLine();
//			} catch (Exception e) {
//				clients.remove(i);
//			}
//		}
//	}
	
	public void broadcast(String message) {
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).send(message);
		}
	}

	//***** Inner class - thread for client connection
	class ConnectionHandler implements Runnable { 
		private BufferedWriter output; //assign printwriter to network stream
		private BufferedReader input; //Stream for network input
		private Socket socket;  //keeps track of the client socket

		private boolean running;
		/* ConnectionHandler
		 * Constructor
		 * @param the socket belonging to this client connection
		 */    
		ConnectionHandler(Socket s) { 
			try {
				socket = s;  //constructor assigns client to this
				socket.setSoTimeout(600000);
				output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch(IOException e) {
				System.out.println("Failed to establish I/O streams");
			}            
			running = true;
		} //end of constructor

		/* run
		 * executed on start of thread
		 */
		public void run() {  

			//Get a message from the client
			while(running) {  // loop unit a message is received  

				try {
					if (input.ready()) { //check for an incoming messge
						String message = input.readLine();  //get a message from the client
						System.out.println("Message received: " + message); 
						//						running=false; //stop receving messages
						
						// Broadcast to all other clients
						broadcast(message);
					}
				} catch (IOException e) { 
					System.out.println("Failed to receive msg from the client");
					e.printStackTrace();
				}
			}    

//			//close the socket
//			try {
//				input.close();
//				output.close();
//				socket.close();
//			} catch (Exception e) { 
//				System.out.println("Failed to close socket");
//			}
		} // end of run()

		public void send(String message) {
			try {
				output.write(message);
				output.newLine();
				output.flush();
			} catch (Exception e) {
			}
		}
		
		public boolean isClosed() {
			return socket.isClosed();
		}

	} //end of inner class   
} //end of ChatProgramServer class