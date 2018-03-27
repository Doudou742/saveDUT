package exo4Tp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class ServeurUDP {
	private DatagramSocket dgSocket;

	ServeurUDP(int pSrv) throws IOException {
		dgSocket = new DatagramSocket(pSrv);
	}

	void go ( ) throws IOException {
		byte[] buffer = new byte[8000];
		DatagramPacket dgPacket = new DatagramPacket (buffer , buffer.length) ;
		String str;
		while ( true ) {
			dgSocket.receive(dgPacket);
			String res = new String (dgPacket.getData(),0, dgPacket.getLength());
			
			Integer nbRepetition = 0;
			String tmp = "";
			int codeRetour = 1;
			int cpt = 0;
			int cpt2 = 1;
			// si la chaine recu ne commence pas par un chiffre
			try {
				String[] tab = res.split(":");
				//System.out.println(tab[0] + " nb rep");
				nbRepetition = Integer.parseInt(tab[0]);
				/*
				while (res.substring(cpt,cpt2) != ":") {
					cpt2++;
				}
				*/
				//nbRepetition = Integer.parseInt(res.substring(cpt,cpt2));
				//System.out.println(nbRepetition + " nb rep");
				if (nbRepetition == 0) {
					tmp = " 0";
					codeRetour = 0;
				}
				else {
					tmp = " " + res;
				}
			} catch(Exception e) {
				tmp = codeRetour + " " + nbRepetition + " erreur format";
			}
			System.out.println(tmp);
			String chaine = res.substring(1,res.length());
			String stock = 0 + " ";
			//System.out.println(chaine);
			if (nbRepetition != 0) {
				int indiceDernierMot = 0;
				for (int i = 0; i < chaine.length(); i++) {
					String chaineARepeter = "";
					if (chaine.charAt(i) == ' ' || i == chaine.length()) {
						chaineARepeter = chaine.substring(indiceDernierMot,i);
						indiceDernierMot = i;
						for (int j = 0; j < nbRepetition; j++) {
							stock += chaineARepeter + " ";
						}
					}
				}
			} else {
				stock = 1 + " erreur format";
			}
			
			buffer = stock.getBytes();
			dgPacket.setData(buffer,0,buffer.length);
			dgSocket.send(dgPacket);
			
		}
	}

	public static void main ( String [] args ) throws IOException {
		final int DEFAULT_PORT = 9876 ;
		new ServeurUDP (args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0])).go() ;
	}
}