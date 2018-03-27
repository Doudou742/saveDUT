package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Client {
	
	/**
	 * socketPi est la socket de contrôle interprète les commandes reçues du client (sur le canal de controle)
	 * socketDTP est la socket de transfert des fichiers à fermer après chaque fin de transfert
	 * PORTPI est le port utilisé pour la socket PI
	 * PORTDTP est le port utilisé pour la socket DTP
	 * userName correspond au login demandé lors de la connection 
	 */
	
	private Socket socketPi; 
	private Socket socketDTP;
	
	private final int PORTPI = 9876;
	private final int PORTDTP = 9875;
	
	/**
	 * Constructeur d'un client qui init les deux sockets (DTP et PI)
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Client() throws UnknownHostException, IOException {
		this.socketPi = new Socket("172.18.48.164",PORTPI);
		//this.socketDTP = new Socket("172.18.48.143",PORTDTP);
	}
	
	public void traitement() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(socketPi.getInputStream()));
		PrintWriter pw = new PrintWriter(socketPi.getOutputStream(),true);
		String rep = "";
		Scanner scan = new Scanner(System.in);
		String recu = "";
		
		receptionDonnees(recu,  br);
		
		while (true) {
			System.out.println("CMD >> ");
			rep = saisieDonnees(scan);
			
			if (rep.equals(null) || rep == " " || rep == "" || rep == "\n") {
				break;
			}
			
			pw.println(rep);
			
			receptionDonnees(recu, br);
			/*
			while ((recu = br.readLine()) != null || recu == "\n") {
				System.out.println(recu);
			}*/
		}
		this.socketPi.close();
	}
	
	public String saisieDonnees(Scanner scan) {
		String donnees = "";
		donnees = scan.nextLine();
		return donnees;
	}
	
	public void receptionDonnees(String reception, BufferedReader br){
		char buffer [] = new char[10000];
		try {
			while ((reception = br.readLine()) != null) {
				System.out.println(reception);
			}
			
			int temp = br.read(buffer, 0, 10000);
			System.out.println("apres le read");
			afficheTableauChar(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void afficheTableauChar(char buffer[]) {
		String rep = "";
		for (int i = 0; i < buffer.length; i++) {
			rep += buffer[i];
		}
		System.out.print(rep);
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.traitement();
	}
	
}
