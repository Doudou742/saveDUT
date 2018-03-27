class jdmouton extends Program{

    final char GAUCHE = '<';
    final char DROITE = '>';
    final char VIDE = '_';
    //final char[] GAGNANT = new char{'<','<','<','_','>','>','>'};
    char[] plateau = new char[7];
    char[] plateauNewge = new char[7];
    
    

    char[] initialiser(char[] tab){
	for ( int i = 0; i < length(tab); i++ ){
	    if ( i < 3 ){
		tab[i] = '>';
	    }
	    else if ( i == 3 ){
		tab[i] = '_';
	    }
	    else {
		tab[i] = '<';
	    }
	}
	return tab;
    }

    boolean estValide(int i){
	if ( i >= 0 && i <= 6 ){
	    return true;
	}
	else
	    return false;
    }

    int saisie(){
	boolean flag = false;
	int s = -1;

	do {
	    s = readInt();
	    
	    
	}
	while ( !estValide(s) );

	return s;
	/*
	while (!flag){
	    println("saisir un entier: ");
	    s = readInt();
	    if ( estValide(s) ){
		flag = true;
	    }
	    else{
		flag = false;
	    }
	}
	return s;
	*/
	
    }
    

    void affichage(char[] tab){
	for ( int i = 0; i < length(tab); i++ ){
	    print(tab[i]);
	}
    }

    
    boolean avancer(int indiceMouton, char[] tab, char[] newTab){

	for ( int i = 0; i < tab.length; i++){
	    newTab[i] = tab[i];
	}

	//pour mouton vers droite
	if ( tab[indiceMouton] == '>' &&  estValide(indiceMouton+1) && tab[indiceMouton+1] == '_' ){
	    newTab[indiceMouton+1] = '>';
	    newTab[indiceMouton] = '_';
	    return true;
	}

	else if ( tab[indiceMouton] == '>' && estValide(indiceMouton+2)  && tab[indiceMouton+2] == '_' ){
	    newTab[indiceMouton+2] = '>';
	    newTab[indiceMouton] = '_';
	    return true;
	}



	//pour mouton vers gauche
	else if ( tab[indiceMouton] == '<' && estValide(indiceMouton-1)  && tab[indiceMouton-1] == '_' ){
	    newTab[indiceMouton-1] = '<';
	    newTab[indiceMouton] = '_';
	    return true;
	}

	else if ( tab[indiceMouton] == '<' && estValide(indiceMouton-2) && tab[indiceMouton-2] == '_' ){
	    newTab[indiceMouton-2] = '<';
	    newTab[indiceMouton] = '_';
	    return true;
	}

	return false;
	
    }

    
    boolean victoire(char[] tab){
	return tab[0] == '<' && tab[1] == '<' && tab[2] == '<' && tab[3] == '_' && tab[4] == '>' && tab[5] == '>' && tab[6] == '>';
    }

    //return true si blocage
    /*
    boolean blocage(char[]tab){
	for ( int i = 0; i < tab.length; i++ ){
	    if ( tab[i] == '>' ){
		if ( (tab[i+1] != '_' && tab[i+2] != '_') &&( tab[i+1] == tab.length || tab[i+2] == tab.length ) ){
		    return true;
		}
	    }
	    else if ( tab[i] == '<') {
		if (  (tab[i-1] != '_' && tab[i-2] != '_') && ( tab[i-1] == tab.length || tab[i-2] == tab.length )){
		    return true;
		}
	    }
	    
	}
	return false;
    }
    */

    boolean blocage(char[] tab){
	for ( int i = 0; i < tab.length; i++ ){
	    if ( tab[i] == '_' && tab[i-1] == '<' && tab[i+1] == '>' ){
		return true;
	    }
	}
	return false;
    }

    void algorithm(){

	int Saisie = -1;
	boolean fini = false;
	plateau = initialiser(plateau);

	while(!fini && !victoire(plateau) && !blocage(plateauNewge) ){
	    

	    clearScreen();
	    affichage(plateau);
	    println();
	    Saisie = saisie();
	    avancer(Saisie,plateau,plateauNewge);
	    println();
	    affichage(plateauNewge);
	    //fini = blocage(plateauNewge);

	    for ( int i = 0; i < plateau.length; i++ ){
		plateau[i] = plateauNewge[i];
	    }
	    
	}
	
	
	
    }

}
