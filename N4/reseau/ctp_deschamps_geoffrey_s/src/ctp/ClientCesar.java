package ctp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientCesar {

	private File fichierConfig;
	private Socket socket;
	
	public ClientCesar(int port) throws  IOException {
		//this.socket = new Socket(InetAddress.getLocalHost(),port);
	}
	
	public void traitementFichier() throws IOException {
		File source = new File("src/clientConfiguration.txt");
		FileInputStream input = new FileInputStream(source);
		String contenu = "";
		byte[] buffer = new byte[(int) source.length()];
		int lu = 0;
		while ((lu = input.read(buffer)) >= 0) {
			for (int i = 0; i < buffer.length; i++) {
				contenu += buffer[i];
			}
			contenu += "\n";
			buffer = new byte[(int) source.length()];
		}
		System.out.println(contenu);
		input.close();
	}
	
	public static void main(String[] args) throws IOException {
		ClientCesar c = new ClientCesar(0);
		c.traitementFichier();
	}
	
}