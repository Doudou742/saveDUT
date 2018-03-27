class pendu extends Program{


    char[] motSaisie;
    char[] motEtoile;
    int nbVie = 5;
    boolean fini = false;
    char lettrePropose = ' ';

    char[] saisieQueDesLettres(){
	char[] mot;
	String tmp = "";
	println("saisir mot biloute: ");
	tmp = readString();


	//verifie qu'il y a bien que des lettres
	for ( int i = 0; i < tmp.length(); i++ ){
	    while ( (charAt(tmp,i) < 'a' || charAt(tmp,i) > 'z') && ( charAt(tmp,i) != 'é' || charAt(tmp,i) != 'è' || charAt(tmp,i) != 'ç' || charAt(tmp,i) != 'à' || charAt(tmp,i) != 'ù') ){
		
		println("j'ai demandé des lettres");
		tmp = readString();
		
	    }//while
	}//for

	
	mot = new char[tmp.length()];
	for ( int j = 0; j < tmp.length()-1; j ++ ){
	    mot[j] = charAt(tmp,j);
	}
	return mot;
    }

    
    char[] metMotEnEtoile(char[] tab){
	char[] rep = new char[tab.length];
	for ( int i = 0; i < tab.length; i++ ){
	    rep[i] = '*';
	    //println("mot en etoile: "  + rep[i]);
	}
	return rep;
    }

    boolean estPresent(char[] tab, char c){

	for ( int i = 0; i < tab.length; i++ ){
	    if ( tab[i] == c ){
		return true;
	    }
	}
	nbVie --;
	return false;
    }

    void afficheTabChar(char[] tab){
	for ( int i = 0; i < tab.length; i++ ){
	    print(tab[i]);
	}
    }

    char[] remplacement(char[] tab,char[] motEtoile, char c){
	
	for ( int i = 0; i < tab.length; i++ ){
	    if ( tab[i] == c ){
		//println("test remplacement  passe");
		motEtoile[i] = c;
	    }
	}
	return motEtoile;
    }


    boolean finDePartie(int nbVie, char[] tab){
	boolean tmp = false;

	if ( nbVie < 1 ){
	    return true;
	}

	for ( int i = 0; i < tab.length; i++ ){
	    if ( tab[i] == '*' ){
		return false;
	    }
	}
	return tmp;
	
    }

    


    void algorithm(){

	clearScreen();
	
	motSaisie = saisieQueDesLettres();
	motEtoile = metMotEnEtoile(motSaisie);

	println("mot etoile: "); 
	afficheTabChar(motEtoile);

	while ( !fini ){
	    println();
	    println("il vous reste: " + nbVie + " vies");
	    println("choisir un caractere pls: ");
	    lettrePropose = readChar();
	    //si char non present alors enleve une vie 
	    if ( estPresent(motSaisie,lettrePropose) ){
	        motEtoile = remplacement(motSaisie, motEtoile, lettrePropose);
	    }
	    println();
	    afficheTabChar(motEtoile);
	    fini = finDePartie(nbVie, motEtoile);
	  
	    // afficheTabChar(motEtoile);
	    
	    
	    
	}//fin while
	
	
    }

    
    
}
