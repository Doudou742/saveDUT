class tp2Menu extends Program{
    void algorithm(){

	int x;
	boolean valide = false;
	println("Bienvenu dans la matrice");
	println("1. ourvrir doc");
	println("2. cree doc");
	println("3. enregistrer doc");
	println("4. quitter");
	println("que voulez vous faire? ");
	x = readInt();
	while ( !valide ){
	    if ( x == 1 ){
		println("vous voulez ouvrir"); valide = true;
	    }
	    else  if ( x == 2 ){
		    println("vous voulez creer doc"); valide = true;
	    }
	    
	    else  if ( x == 3 ) {
		println("vous voulez enregistrer"); valide = true;
	    }
	    
	    else  if ( x == 4 ) {
		println("vous voulez quitter"); valide = true;
	    }
	    
	    else {
		
		println("je veux un entier");
		x = readInt();
		
	    }
	}
    }
}
