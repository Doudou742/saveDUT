import tps.Carte;
import java.util.*;
public class EssaiCarte{
    public static void main(String[] arg){
	int min = 0;
	Carte[] paquet = new Carte[32];
	
	for (int i = 0; i < 4; i++){
	    for (int j = 0; j < 8; j++){
		System.out.println(new Carte(i,j));
		paquet[i] = new Carte(i,j);
	    }
	}


	
	Carte tmp = new Carte(0,0);
	Carte[] paquet2 = new Carte[3];
	for (int i = 0; i < 3; i++){
	    paquet2[i] = new Carte(new Random().nextInt(4), new Random().nextInt(8));
	}
	int acc = 0;
	while ( acc < 3 ){
	for (int j = 0; j < paquet2.length-1; j++){
	    if ( ! paquet2[j].precede(paquet2[j+1]) ){
		tmp = paquet2[j];
		paquet2[j] = paquet2[j+1];
		paquet2[j+1] = tmp;
      	    }	    
	}
	acc++;
	}
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
	for (int cpt = paquet2.length-1; cpt >= 0; cpt--){
	    System.out.println(paquet2[cpt]);
	}

	System.out.println();
	System.out.println();
	System.out.println();
	
	
	Carte[] paquet3;
	int taille = new Random().nextInt(9)+11;
	paquet3 = new Carte[taille];
	for (int i = 0; i < paquet3.length; i++){
	    
	    paquet3[i] = new Carte(new Random().nextInt(4), new Random().nextInt(8));
	    for ( int j = 0; j < i; j++ ){
		if ( paquet3[i].compareTo(paquet3[j]) == 0 ){
		    paquet3[i] = new Carte(new Random().nextInt(4), new Random().nextInt(8));
		}
	    }
	    
	    System.out.println(paquet3[i].toString());
	}
	int max = 0;
	for ( int j = 1;j < paquet3.length; j++){
	    if ( paquet3[max].compareTo(paquet3[j]) < 0 ){
		max = j;
	    }
	}
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println(paquet3[max]);
	
	
    }
}
