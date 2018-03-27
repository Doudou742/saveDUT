class exercice1 extends Program{

    void algorithm(){
	int t = 8;
	//	dessinerBarreVerticale(t);
	dessinerCroixCarre(t);
    }

    void dessinerBarreVerticale(int taille){

	for ( int i = 0; i < taille; i++ ){
	    for ( int j = 0; j < taille; j++ ){
		if ( j%2 == 0 ){
		    print('.');
		}
		else print('*');
	    }
	    println();
	}
	
    }

    void dessinerCroixCarre(int taille){

	for ( int i = 0; i < taille; i++ ){
	    for ( int j = 0; j < taille; j++ ){
		if ( i == 0 || i == taille-1 || j == 0 || j == taille-1 || i == j ||  ){
		    print('*');
		}
		else print('.');
	    }      
		    
	    println();
	}
    }
	
    

}
