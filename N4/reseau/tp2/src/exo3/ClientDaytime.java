package exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDaytime {

	private Socket socket;
	private final int PORT = 13;
	
	
	public ClientDaytime() throws IOException {
		this.socket = new Socket(InetAddress.getLocalHost(),PORT);
	}
	
	public String recuperationDonnees() throws IOException {
		String rep = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		rep = br.readLine();
		return rep;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ClientDaytime client = new ClientDaytime();
		System.out.println(client.recuperationDonnees());
	}
	
	
	
}
