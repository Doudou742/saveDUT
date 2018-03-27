package exo2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopieText {
	private String src;
	private String dst;
	
	public CopieText(String src, String dst) {
		this.src = src;
		this.dst = dst;
	}
	
	public boolean verifieExistenceFichierSource(File f) {
		if (f.exists() && f.isFile()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifieExistenceFichierDestination(File f) {
		if (f.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void copie() throws IOException {
		File source = new File(src);
		File destination = new File(dst);
		FileInputStream input = null;
		FileOutputStream output = null;
		if (verifieExistenceFichierSource(source) && !verifieExistenceFichierDestination(destination)) {
			input = new FileInputStream(source);
			
			output = new FileOutputStream(destination);
			byte[] buffer = new byte[(int) source.length()];
			int lu = 0;
			while ((lu = input.read(buffer)) >= 0) {
				output.write(buffer);
				buffer = new byte[(int) source.length()];
			}
		}
		else {
			System.out.println("fichier destination déjà existant");
		}
		try {
			input.close();
			output.close();
		} catch(Exception e) {
			System.out.println("erreur de fermeture de fichier");
			e.printStackTrace();
		}
		
		
		//System.out.println(verifieExistenceFichierSource(new File("/home/infoetu/deschamg")));
	}
	
	public static void main(String[] args) throws IOException {
		CopieText cb = new CopieText(args[0], args[1]);
		cb.copie();
	}
	
}
