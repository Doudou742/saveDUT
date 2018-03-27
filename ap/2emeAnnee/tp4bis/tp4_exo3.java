class tp4_exo3 extends Program{

    
    String ssChaineT(String s, int taille){

	String tmp = "";
	for ( int i = 0; i < (length(s)-taille)+1; i++){
	    tmp += "\n" + substring(s, i,i+taille);
	}
	return tmp;
	
    }
    
    
    String ssChaine(String s){

	String tmp = "";

	for ( int i = 0; i < s.length(); i++ ){
	    tmp += ssChaineT(s,i);
	}
	return tmp;
    }


    
    void algorithm(){


	println("saisir mot: ");
	String saisie = readString();
	String tmp;
	int taille = 0;
	println("saisir taille: ");
	taille = readInt();
	//println(ssChaine(saisie));

	for ( int i = length(saisie); i > 0; i--){
	    tmp = substring(saisie,0,i);
	    for ( int j = 0; j < tmp.length();j++){
		println(substring(tmp,j,length(tmp)));

	    }
	    
	    
	}

	
	
    }

}
