class morpion extends Program{

    //initialise le tablal à vide 
    void initialiser(char[][] plateau){
	for ( int ligne = 0; ligne < plateau.length; ligne++ ){
	    for ( int colonne = 0; colonne < plateau[0].length; colonne++ ){
		plateau[ligne][colonne] = ' ';
	    }
	}
    }

    //affiche un tablal de carac
    void afficher(char[][] plateau){
	for ( int ligne = 0; ligne < plateau.length; ligne++ ){
	    for ( int colonne = 0; colonne < plateau[0].length; colonne++ ){
		print(plateau[ligne][colonne]);
	    }
	    println();
	}

    }

    //permet une saisie entre 0 et 2, attention pas de vérif si plusieurs carac
    int saisie(){
	int saisie;
	saisie = readInt();
	while ( saisie < 0 || saisie > 2 ){
	    saisie = readInt();
	}
	return saisie;
    }


    //détermine si partie est over
    boolean finPartie(char[][] plateau, boolean j){

	int cpt = 0;
	int cpt2 = 0;
	
	for ( int idx = 0; idx < plateau.length; idx++ ){
	    if (  (plateau[idx][0] != ' ' && plateau[idx][0] == plateau[idx][1] && plateau[idx][1] == plateau[idx][2]) || (plateau[0][idx] != ' ' && plateau[0][idx] == plateau[1][idx] && plateau[1][idx] == plateau[2][idx]) ){
		return true;
	    }
	}

	/*
	//vérifie une diagonale
	for ( int ligne = 0; ligne < plateau.length; ligne++ ){
	    //  for ( int colonne = 0; colonne < plateau[0].length; colonne++ ){
	    //if ( ligne == colonne ){
		    if ( !j ){
			if ( plateau[ligne][ligne] == 'X' ){
			    cpt++;
			}
			if ( cpt == 3 ){
			    return true;
			}
			
		    }
		    else if ( j ){
			if ( plateau[ligne][ligne] == '0' ){
			    cpt2++;
			}
			if ( cpt2 == 3 ){
			    return true;
			}
			//		 }
		    	//}
	    }
	}

	cpt = 0;
	cpt2 = 0;
	//vérifie l'autre diagonale
	for ( int ligne = plateau.length-1; ligne >= 0; ligne-- ){
	    //for ( int colonne = plateau[0].length-1; colonne >=0; colonne-- ){
	    //if ( ligne == colonne ){
		    if ( !j ){
			if ( plateau[ligne][ligne] == 'X' ){
			    cpt++;
			}
			if ( cpt == 3 ){
			    return true;
			}
			
		    }
		   else if ( j ){
			if ( plateau[ligne][ligne] == '0' ){
			    cpt2++;
			}
			if ( cpt2 == 3 ){
			    return true;
			}
			//   }
			//	}
	    }
	}
	return false;
	*/
	char val = plateau[0][0];

	if ( !j ) {
	    val = 'X';
	    
	}
	else {
	    val = '0';
	}

	int i = 0;
	while ( i < plateau.length && plateau[i][i] == val ){
	    i++;
	}

	if ( i == plateau.length ){
	    return true;
	}

	i = 0;
	while ( i < plateau.length && plateau[plateau.length-i-1][i] == val ){
	    i++;
	}

	return i == plateau.length;

	

	


	
    }


	
	



	
    void placerPion(char[][] plateau, int idxl, int idxc, boolean j){
	/*
	char[][] rep = new char[plateau.length][plateau[0].length];
	for ( int ligne = 0; ligne < plateau.length; ligne++ ){
	    for ( int colonne = 0; colonne < plateau[0].length; colonne++ ){
		rep[ligne][colonne] = plateau[ligne][colonne];
	    }
	}
	*/
	
	    
	if ( j ){
	    plateau[idxl][idxc] = 'X';
	}
	else {
	    plateau[idxl][idxc] = '0';
	}
	//return plateau;
    }
	


    
    void algorithm(){
	char[][] plateau = new char[3][3];
	//char[][] Nplateau = new char[3][3];
	int indicel, indicec;
	boolean joueur1 = true;
	boolean partieFinie = false;

	
	initialiser(plateau);

	while ( !partieFinie ){
	
	    clearScreen();
	    afficher(plateau);
	    println("saisie une coordonnée x: ");
	    indicel = saisie();
	    println("saisir une coordonnée y jujujul: ");
	    indicec = saisie();

	    placerPion(plateau,indicel,indicec,joueur1);
	    joueur1 = !joueur1;
	    
	    /*
	    if ( joueur1 ){
		plateau[indicel][indicec] = 'X';
		joueur1 = false;
	    }
	    else {
		plateau[indicel][indicec] = '0';
		joueur1 = true;
	    }
	    */

	    clearScreen();
	    afficher(plateau);
	    partieFinie = finPartie(plateau, joueur1);
	    
	}
	
    }
}
    



