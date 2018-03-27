package exo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEcho {

	private Socket socket;
	private final int PORT = 7;
	
	
	public ClientEcho() throws IOException {
		this.socket = new Socket(InetAddress.getLocalHost(),PORT);
	}
	
	public void recuperationDonnees() throws IOException {
		String rep = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner scan = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		writer.println(scan.nextLine());
		while (! (rep = br.readLine()).equals("FIN")) {
			System.out.println(rep);
			writer.println(scan.nextLine());
		}
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ClientEcho client = new ClientEcho();
		client.recuperationDonnees();
	}
	
}
