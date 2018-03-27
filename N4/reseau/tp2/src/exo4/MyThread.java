package exo4;

import java.io.BufferedReader;
import java.io.IOException;
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
			while(true) {
				try {
					reception = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream(),true);
					while(true) {
						if(socket==null) {
							socket.close();
							break;
						}
						String recu = reception.readLine();
						String[] comp = recu.split(":");				
						if(comp.length < 2 || comp[0].equals("") || comp[0] == null) {
							out.println("1Erreur");
						}else {
							int nb=0;
							String[] compPhrase= new String[0];
							try {
								 nb = Integer.parseInt(comp[0]);
								 compPhrase = comp[1].split(" ");
							}catch(Exception e) {
								out.println("1Erreur");
							}
							String res ="0";
							for(int c = 0 ; c < compPhrase.length ; c ++) {
								for(int i = 0 ; i < nb ; i++) {
									res += compPhrase[c]+" "; 
								}
							}
							out.println(res);
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
	

	}
}
