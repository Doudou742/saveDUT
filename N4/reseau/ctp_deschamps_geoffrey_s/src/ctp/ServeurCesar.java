package ctp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class ServeurCesar {

	private ServerSocket serveur;
	private ServerSocket serveurBis;
	
	static int idc;
	
	public ServeurCesar(int port) throws IOException {
		this.serveur = new ServerSocket(port);
	}
	
	public static String transform(String str, int shift) {
		String result = "";
		for (char c : str.toCharArray())
			result += transform(c, shift);
		return result;
	}

	private static char transform(char c, int shift) {
		int startVal;
		if (('a' <= c) && (c <= 'z'))
			startVal = 'a';
		else if (('A' <= c) && (c <= 'Z'))
			startVal = 'A';
		else
			return c;
		return (char) ((c - startVal + (shift < 0 ? shift + 26 : shift)) % 26 + startVal);
	}
	
	public int tirageIDC() {
		Random random = new Random();
		return (int) random.nextInt(2000000);
	}
	
	public void traitement() throws IOException {
		Socket socketBis = null;
		String transport = "";
		
		while (true) {
			//attente d'un client
			Socket client = serveur.accept();
			
			/* Client connecté */
			BufferedReader reception = null;
			PrintWriter envoi = new PrintWriter(client.getOutputStream(), true);
			reception = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			envoi.println("vous êtes connecté au serveur");
			envoi.println("choisissez mode de transport: udp ou tcp");
			
			while (true) {
				String recu = "";
				String messageCode = "";
				int decalage = 0;
				try {
					recu = reception.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					envoi.println("erreur dans le readLine");
					client.close();
					break;
				}
				try {
					if (recu.equals("udp") || recu.equals("UDP")) {
						System.out.println("le choix est udp");
						idc = tirageIDC();
						transport = "udp";
						envoi.println(idc+":"+transport+":9876");
						//new Thread(new MyThread(client)).start();
						recu = traitementCesar(client, reception, envoi, recu, messageCode);
						
					}
					else if (recu.equals("tcp") || recu.equals("TCP")) {
						System.out.println("le choix est tcp");
						idc = tirageIDC();
						transport = "tcp";
						envoi.println(idc+":"+transport+":9876");
						recu = traitementCesar(client, reception, envoi, recu, messageCode);
						
					}
					else {
						System.out.println("mauvaise saisie");
						envoi.println("mauvaise saisie au revoir");
						client.close();
						break;
					}
					System.out.println(recu);
				} catch(Exception e) {
					//e.printStackTrace();
					System.out.println("client déco");
					client.close();
					break;
				}
			}
			
		}
	}

	private String traitementCesar(Socket client, BufferedReader reception, PrintWriter envoi, String recu,
			String messageCode) {
		int decalage;
		try {
			while (true) {
				envoi.println("choisir le decalage: ");
				try {
					recu = reception.readLine();
					decalage = Integer.valueOf(recu);
				} catch(Exception e2) {
					decalage = 0;
					e2.printStackTrace();
				}
				envoi.println("saisir votre message: ");
				try {
					recu = reception.readLine();
				} catch (Exception e3) {
					e3.printStackTrace();
					envoi.println("mauvais message");
				}
				String tmpIdc = idc + "";
				if (recu.equals(tmpIdc)) {
					envoi.println("au revoir");
					client.close();
					System.out.println("client deco");
					break;
				}
				messageCode = transform(recu, decalage);
				envoi.println(messageCode);
				
			}
			//new Thread(new MyThread(client)).start();
		} catch (Exception e) {
			e.printStackTrace();
			//System.exit(1);
		}
		return recu;
	}
	
	public static void main(String[] args) throws IOException {
		ServeurCesar serv = new ServeurCesar(12345);
		serv.traitement();
	}
	
}