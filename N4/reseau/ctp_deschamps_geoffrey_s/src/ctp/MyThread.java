package ctp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable {

	Socket socket;
	PrintWriter out;
	BufferedReader reception;

	public MyThread(Socket client) {
		this.socket = client;
	}
	
	@Override
	public void run() {
		System.out.println("dans le run");
		int decalage;
		String recu = "";
		String messageCode = "";
		while (true) {
			try {
				reception = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				while (true) {
					if (socket == null) {
						socket.close();
						break;
					}
					out.println("choisir le décalage: ");
					try {
						Thread.sleep(4000);
						System.out.println("avant readline");
						Thread.sleep(4000);
						recu = reception.readLine();
						Thread.sleep(4000);
						System.out.println(recu);
				
						decalage = Integer.valueOf(recu);
						System.out.println(decalage);
					} catch (Exception e2) {
						decalage = 0;
						e2.printStackTrace();
					}
					out.println("entrez un message: ");
					try {
						recu = reception.readLine();
					} catch (Exception e3) {
						e3.printStackTrace();
						out.println("erreur dans la phrase souhaitée");
						recu = "erreur";
					}
					//stock l'idc dans un string
					String tmpIdc = ServeurCesar.idc + "";
					if (recu.equals(tmpIdc)) {
						System.out.println("socket close");
						socket.close();
						break;
					}
					messageCode = ServeurCesar.transform(recu, decalage);
					out.println(messageCode);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
