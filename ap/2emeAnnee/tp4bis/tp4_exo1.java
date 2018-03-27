class tp4_exo1 extends Program{

    void algorithm(){
	println(diviseurs(9));
    }

    String diviseurs ( int nbDepart ){

	int saveNbDepart = nbDepart;
	String reponse = "";
	for ( int i = nbDepart; i > 0; i-- ){
	    if ( ( saveNbDepart % i ) == 0 ){
		reponse += "" + i + ", ";
	    }
	}
	return reponse;
    }

}
