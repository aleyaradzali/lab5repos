package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.lang.*;
import counter.Counter;

public class CounterClientApp {

	public static void main(String[] args) {
		
		// The server port to which the client socket is going to connect
		final int SERVERPORT = 50001;
		
		int bufferSize = 1024;
		
		System.out.println("Client-Side Word Counter Application\n");
		
		try {
			
			Scanner input = new Scanner(System.in);
			Counter count = new Counter();
			// Create client socket
		    DatagramSocket clientSocket = new DatagramSocket();
		    
		    // Get the IP address of the server
		    InetAddress serverAddress = InetAddress.getByName("localhost");
		    
		    // Creating corresponding buffer to send data
		    byte outDataBuffer[] = new byte[bufferSize];
		    
		    // Converting data to bytes and storing them in the sending buffer
		    System.out.println("Enter your sentence below :-");
		    String sentence = input.nextLine();
		    outDataBuffer = sentence.getBytes();
		    
		    // Creating a UDP packet 
		    DatagramPacket outPacket = new DatagramPacket(outDataBuffer,
		    		outDataBuffer.length, serverAddress, SERVERPORT);
		    
		    
		    // Sending UDP packet to the server
		    System.out.println("Sending '" + sentence + "'. ");
		    clientSocket.send(outPacket);
		    
		    count.setText(sentence);
		    // Display the output (word counted)		    
		    int word = count.getWordCount();
		    System.out.println("\nSentence '" + count.getText() + "' has " + word + " words counted.");
		    
		    // Closing the socket connection with the server
		    clientSocket.close();
		    
		} catch (Exception ex) {
			
			System.out.println("Durian Tunggal... we got problem");
			ex.printStackTrace();
		}
		
		System.out.println("\nProgram at client-side ends");

	}

}
