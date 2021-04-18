package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import counter.Counter;
import java.lang.*;

public class CounterServerApp {

	public static void main(String[] args) {
		
		
		// Server UDP socket runs at this port
		final int serverPort=50001;
		
		int bufferSize = 1024;
		
		System.out.println("Server-Side Word Counter Application\n");
		
		try {
			
			// Create a new DatagramSocket to receive responses from the client
		    DatagramSocket serverSocket = new DatagramSocket(50001);
		    
		    Counter count = new Counter();
		    
		    // Create buffer to hold receiving data.
		    byte[] inData = new byte[bufferSize];
		    
		    // Create a UDP packet to store the client data using the buffer 
		    // for receiving data
		    DatagramPacket inputPacket = new DatagramPacket(inData, inData.length);
		    System.out.println("Ready to receive connection... ");
		    
		    // Receive data from the client and store in inputPacket
		    serverSocket.receive(inputPacket);
		    
		    // Printing out the client sent data
		    String data = new String(inputPacket.getData());
		    System.out.println("Sentence from the client: " + data);
		    
		    //send data to Counter.java 
		    //
		    
		    //get word counted from Counter.java
		    count.setText(data);
		    int word = count.getWordCount();
		    
		    //send word counted to client
		    
		    
		    System.out.println("\nSentence is counted : " + count.getWordCount() + " words." );
		    
		    // Close the socket connection
		   // serverSocket.close();
		      
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
		
		System.out.println("\nProgram at server-side ends");

	}

}
