package exo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServeurChargen {

	private ServerSocket socket;
	
	public ServeurChargen() throws UnknownHostException, IOException {
		this.socket = new ServerSocket(9876);
	}
	
	public void afficheAscii() throws UnknownHostException, IOException {
		Socket tmp = socket.accept();
		PrintWriter envoie = new PrintWriter(tmp.getOutputStream());
		int code = 32;
		while (true) {
			envoie.print((char) code);
			code++;
			if (code == 127) {
				code = 32;
			}
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ServeurChargen chargen = new ServeurChargen();
		chargen.afficheAscii();
	}
	
}