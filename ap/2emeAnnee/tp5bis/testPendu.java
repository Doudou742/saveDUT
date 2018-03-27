class testPendu extends Program{


    boolean isLettre( char c ){
	return ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') );
    }


    
    boolean queDesLettres(String chaine){
	for ( int i = 0; i < chaine.length(); i++ ){
	    if ( !isLettre(charAt(chaine,i)) ){
		return false;
	    }
	}
	return true;
    }


    String readLettre(){
	String tmp = "", mot;
	do{
	    println("veuillez saisir un mot avec que des lettres");
	    tmp = readString();
	}
	while ( !queDesLettres(tmp) );
	mot = tmp;
	return mot;
    }

    String metUnMotEnEtoile(String mot){
	String tmp = "";
	for ( int i = 0; i < mot.length(); i++ ){
	    tmp += '*';
	}
	return tmp;
    }

    boolean isPresent(String chaine, char c){
	for ( int i = 0; i < chaine.length(); i++ ){
	    if ( charAt(chaine,i) == c ){
		return true;
	    }
	}
	return false;
    }


    
    String remplacement(String mot, String motEtoile, char c){
	String tmp = "";
	for ( int i = 0; i < mot.length(); i ++ ){
	    if ( charAt(mot,i) == c ){
		tmp += c;
	    }
	    else if ( charAt(motEtoile,i) >= 'a' && charAt(motEtoile,i) <= 'z' ){
		tmp += charAt(motEtoile,i);
	    }
	    else {
		tmp += '*';
	    }
	}
	return tmp;
    }


    
    boolean finPartie(int nbVie, String mot){

	if ( nbVie < 1 || queDesLettres(mot) ){
	    return true;
	}
	else {
	    return false;
	}
	
	
    }


    

    

    
    void algorithm(){
	String mot = "";
	String motEtoile = "";
	char lettreSaisie = ' ';
	boolean fini = false;
	int nbVie = 5;
	
	mot = readLettre();
	println(mot);
	motEtoile = metUnMotEnEtoile(mot);

	while ( !fini ){

	    
	    clearScreen();
	    println(motEtoile);
	    println("il vous reste: " + nbVie + " vie "); 
	    println("saisir une lettre");
	    lettreSaisie = readChar();
	    if ( isPresent(mot,lettreSaisie) ){
		motEtoile = remplacement(mot,motEtoile,lettreSaisie);
	    }

	    else {
		nbVie --;
		println("pas present");
	    }
	    println(motEtoile);

	    fini = finPartie(nbVie, motEtoile);
	
	}
	
	
    }


}