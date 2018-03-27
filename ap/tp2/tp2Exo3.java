class tp2Exo3 extends Program{

    void testSuffixe(){
	assertEquals("jour", suffixe("Bonjour",4));
	assertEquals("ERREUR", suffixe("Bonjour",10));
    }

    String suffixe(String mot, int nbLettres){

	String suffixe = " ";

	if ( nbLettres > mot.length() )
	    return "ERREUR";
	else {
	    suffixe = substring(mot, mot.length()-nbLettres, mot.length() );
	    return suffixe;
	}
    }
	
    
}
