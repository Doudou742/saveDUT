class tp4_exo2 extends Program{

    void algorithm(){

	println(carrePlein());
	println(carreVide());
	println(triangle());
	println(triangleVide());
    }


    String carrePlein(){

	String rep = "";
	for ( int i = 0; i < 5; i ++ ){
	    for ( int j = 0; j <5; j++ ){
		rep += "*";
	    }
	    rep += "\n";
	}
	return rep;
    }

    String carreVide(){

	String rep = "";
	for ( int i = 0; i < 5; i++ ){
	    for ( int j = 0; j < 5; j++){
		if ( i == 0 || i == 4 ){
		    rep += "*";
		}
		else if ( (i == 1 && j == 4) || ( i == 2 && j == 4 ) || ( i == 3 && j == 4 ) || (i == 1 && j == 0) || ( i == 2 && j == 0 ) || ( i == 3 && j == 0 ) ){
		    rep += "*";
		}
		else rep += " ";
		
	    }
	    rep += "\n";
	}
	return rep;
    }


    String triangle(){

	String rep ="";
	for ( int i = 1; i <= 5; i++){
	    for ( int j = 1; j <= i; j++ ){
		if ( i >= c ){
		rep += "*";
		}
		else {
			res += " ";
		    }
	    }
	    rep += "\n";
	}
	return rep;
    }

    String triangleVide(){
	String rep = "";
	for ( int i = 0; i < 5; i++ ){
	    for ( int j = 0; j < i; j++ ){
		if ( i >= 2 || i <= 5 ){
		    for ( int cpt = 0; cpt < i-1; cpt ++ ){
			rep += " ";
		    }
		}
	    }
	    rep +="\n";
	}
	return rep;
	
    }

}
