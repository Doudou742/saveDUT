class jdlv extends Program{



    void initialisation(boolean[][] tab){
	for ( int l = 0; l < length(tab,1); l++ ){
	    for ( int c = 0; c < length(tab,2); c++ ){
		
		if ( random() < 0.3 ){
		    tab[l][c] = true;
		}
		else
		    tab[l][c] = false;
	    }
	}
	
    }


    void affichage(boolean[][] tab){
	for ( int l = 0; l < length(tab,1); l++ ){
	    for ( int c = 0; c < length(tab,2); c++ ){
		if ( tab[l][c] == true ){
		    print("1");
		}
		else
		    print("0");
	    }
	    println();
	}
    }

    void calculNouvelleG(boolean[][] tab, boolean[][] newTab){
	int nbVoisin = 0;
	for ( int l = 1; l < length(tab,1)-1; l ++ ){
	    for ( int c = 1; c < length(tab,2)-1; c++ ){

		nbVoisin = 0;
		
		if ( tab[l][c-1]   == true ){ nbVoisin+=1;}
		if ( tab[l][c+1]   == true ){ nbVoisin+=1;}
		if ( tab[l-1][c ]  == true ){ nbVoisin+=1;}
		if ( tab[l+1][c ]  == true ){ nbVoisin+=1;}
		if ( tab[l-1][c-1] == true ){ nbVoisin+=1;}
		if ( tab[l+1][c+1] == true ){ nbVoisin+=1;}
		if ( tab[l+1][c-1] == true ){ nbVoisin+=1;}
		if ( tab[l-1][c+1] == true ){ nbVoisin+=1;}
		

		if ( tab[l][c] == false && nbVoisin == 3 ){
		    newTab[l][c] = true;
		}
		else {
		    if ( (tab[l][c] == true && (nbVoisin == 2 || nbVoisin == 3)) ){
			newTab[l][c] = true;
		    }
		    else {
			newTab[l][c] = false;
		    }
		}
	    
       
		//println("nbvoisin de la cellule" + l + " , " + c + " = " + nbVoisin);
		
	    }
	}
	
    }



    void algorithm(){

	boolean[][] plateau = new boolean[10][11];
	boolean[][] plateauNewge = new boolean[10][11];
	
	initialisation(plateau);

	while ( true ){
	
	    affichage(plateau);
	    
	    calculNouvelleG(plateau,plateauNewge);
	    for ( int l = 0; l < length(plateau,1); l++ ){
		for ( int c = 0; c < length(plateau,2); c++ ){
		    plateau[l][c] = plateauNewge[l][c];
		}
	    }
	    
	    delay(1000);
	    println();
	    println();
	    println();
	    println();
	    
	    
	    affichage(plateauNewge);
	    
	    println();
	    println();
	    println();
	    println();
	    
	    
	}
	
	
    }



}
