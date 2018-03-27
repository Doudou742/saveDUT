package exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientBeg {

	private Socket socket;
	private final int PORT = 9876;
	
	
	public ClientBeg() throws  IOException {
		this.socket = new Socket(InetAddress.getLocalHost(),PORT);
	}
	
	private void traitement() throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		String rep = "";
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("entrez phrase: ");
			String phraseARepeter = scan.nextLine();
			if (phraseARepeter.equals("FIN") || phraseARepeter.equals(".")) {
				break;
			}
			System.out.println("niveau de beg: ");
			String nbARepeter = scan.nextLine();
			rep = nbARepeter + " :" + phraseARepeter;
			System.out.println("DEBUG: "+rep);
			pw.print(rep);
			pw.println();
			System.out.println(br.readLine());
		}
		System.out.println("client deco");
		socket.close();
		//Thread.sleep(6000);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		ClientBeg clientBeg = new ClientBeg();
		clientBeg.traitement();
	}
	
}
