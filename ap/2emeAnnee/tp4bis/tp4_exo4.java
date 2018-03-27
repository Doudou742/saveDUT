class tp4_exo4 extends Program{


    void testCompterMots() {
	//assertEquals(1, compterMots("test"));
	//assertEquals(1, compterMots("    test"));
	//assertEquals(1, compterMots("test    "));
	//assertEquals(2, compterMots("test   test"));
	assertEquals(4, compterMots("Les   jours    heureux !"));

    }


    int compterMots(String chaine){

	int cpt = 0;
	

	if ( chaine.length() == 0 )
	    return -1;

	for ( int indice = 0; indice < chaine.length()-1; indice++ ){
	    //  println("valeur de indice: "+indice);
	    
	    if (  (charAt(chaine,indice) >= 'a' && charAt(chaine,indice) <= 'z')    && charAt(chaine,indice+1) == ' ' ){
		cpt += 1;
		//println("a");
	    }

	    println("valeur indice : " + indice);
	    println("test1 : ");
	    println( charAt(chaine,indice) != ' ');
	    println("test2 : ");
	    println( (indice+1) == chaine.length()-1);
	    
	    if (  charAt(chaine,indice) != ' ' && indice+1 == chaine.length()-1 ){
		cpt +=1;
		println("b");
	    }

	 

	}
	
	println("valeur de cpt: " + cpt);
	
	return cpt;
	
	
    }
}



