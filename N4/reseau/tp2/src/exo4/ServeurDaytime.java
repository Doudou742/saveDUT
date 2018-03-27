package exo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class ServeurDaytime {

	private ServerSocket serveurSocket;
	
	public ServeurDaytime(int port) throws IOException {
		this.serveurSocket = new ServerSocket(port);
	}
	
	public void traitement() throws IOException {
		Socket socket = serveurSocket.accept();
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		LocalDate date = LocalDate.now();
		pw.println("date aujourd'hui " + date.toString());
	}
	
	public static void main(String[] args) throws IOException {
		final int PORT = 9876;
		ServeurDaytime sd = new ServeurDaytime(PORT);
		sd.traitement();
	}
	
}