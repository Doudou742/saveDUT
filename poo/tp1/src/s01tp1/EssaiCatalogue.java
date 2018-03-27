package s01tp1;
import tps.*;
import java.util.*;
public class EssaiCatalogue{
    public static void main(String[] arg){
	Catalogue cata  = new Catalogue("catalogue");
	cata.ajouter("xdf10");
	cata.ajouter("koz106",30);
	cata.changerPrix("koz106",100);
	cata.ajouter("xdf10",10);
	cata.enlever(10,"koz106");
	cata.changerPrix("xdf10",10);
	cata.ajouter("qwerty",3);
	cata.changerPrix("qwerty",33);
	

	String[] tab = new String[cata.size()];
	tab = cata.getIdentifiants();
	boolean t = false;
	for(int i = 0; i < tab.length; i++){
	    if(tab[i].equals("azerty")){
		t = true;
	    }
	}
	if (!t){
	    System.out.println("non");
	}
	else{
	    System.out.println("oui");
	}

	cata.enlever(5,"qwerty");
	System.out.println(cata.toString());

	int cumul = 0;
	for(int j = 0; j < tab.length; j++){
	    cumul += cata.get(tab[j]).getNbExemplaires() * cata.get(tab[j]).getPrix();
	}
	System.out.println("somme totale = " + cumul);
    
    }
}
