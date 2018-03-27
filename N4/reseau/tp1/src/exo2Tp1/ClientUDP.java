package exo2Tp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {

	
	private final int TAILLE_MAX_BUFFER = 2018;
	
	public ClientUDP(){
		
	}
	
	void go() throws IOException {
		Scanner scanne = new Scanner(System.in);
			DatagramSocket dgSocket = new DatagramSocket();
			InetAddress iplocale = InetAddress.getLocalHost();
			byte[] buffer = scanne.nextLine().getBytes();
			DatagramPacket dgPacket = new DatagramPacket(buffer, buffer.length, iplocale, 9876);
			dgSocket.send(dgPacket);

			byte[] bufferReception = new byte[TAILLE_MAX_BUFFER];
			dgPacket = new DatagramPacket(bufferReception, bufferReception.length);
			dgSocket.receive(dgPacket);
			String res = new String (dgPacket.getData(),0, dgPacket.getLength());
		
			System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		ClientUDP client = new ClientUDP();
		client.go();
	}
	
}
