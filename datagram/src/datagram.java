import processing.core.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class datagram extends PApplet{
	public static String message;
	//static String theMessage = "nothing";
	int y = 125;
	int y2 = 125;
	boolean sent = false;
	int length;
	
	private int CLIENTPORT = 49999;
	private String ADDRESS = "127.0.0.1";
	private String MESSAGE;
	private DatagramSocket clientSocket = null;
	
	public void setup(){
		size(1000,200);
		background(100, 100, 100);
		DatagramServer server = new DatagramServer();
		server.start();
	}
	
	public void draw(){
		String oldMessage = null;
		//System.out.println(message);
		if(message!=null){
			length = message.length();
			textAlign(CENTER);
			background(100, 100, 100);
			textSize(20);
			fill(0);
			text(message, 500, y);
			textSize(20);
			fill(255, 255, 255);
			text(message,500,y2);
			y++;
			y2--;
			//System.out.println(y);
			if(y2<50){
				y2 = 100;
			}
			if (y > 200){
				y=100;
			}
			if (!message.equals(oldMessage)){
				send();
				sent = true;
				oldMessage = message;
			}
		}
		/*if (sent != true){
			send();
			sent = true;
		}*/
	}
	

	public void send(){
	ADDRESS = "192.168.1.121";
	MESSAGE = "diagonal "+(length/2)+" ascending "+length;
	println("Sending! to IP " + ADDRESS + " with message: " + MESSAGE);

	try {
	// create a datagram socket
	clientSocket = new DatagramSocket();

	// send request
	byte[] bufSend = MESSAGE.trim().getBytes();
	InetAddress inetAddress = InetAddress.getByName(ADDRESS);
	DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length, inetAddress, CLIENTPORT);
	clientSocket.send(packet);

	// get response
	byte[] bufReceive = new byte[1024];
	packet = new DatagramPacket(bufReceive, bufReceive.length);
	clientSocket.receive(packet);

	// display response
	String received = new String(packet.getData(), 0, packet.getLength());
	System.out.println(received);

	clientSocket.close();
	} catch (IOException ioe) {
	System.err.println("Error! Couldn't send message to " + ADDRESS + " on port " + CLIENTPORT);
	}

	}
}
