class Exo1 extends Program{
    void testEstLettre() {
	assertFalse( estLettre('Z') );
	assertTrue ( estLettre('a') );
	assertTrue ( estLettre('v') );
	assertFalse( estLettre('!') );
    } 

    boolean estLettre(char c){
	if ( c >= 'a' && c <= 'z' ){
	    return true;
	}
	return false;
    }

    void testPositionLettre() {
	assertEquals( -1, positionLettre('c', "azerty") );
	assertEquals(  3, positionLettre('r', "azerty") );
    }

    int positionLettre(char c, String chaine){
	for ( int i = 0; i < chaine.length(); i ++ ){
	    if ( charAt(chaine,i) == c )
		return i;
	}
	return -1;
    }

    void testSupprimeLettre() {
	assertEquals( "onjour", supprimeLettre(0, "bonjour") );
    }

    String supprimeLettre(int indice, String chaine){
	String reponse = "";
	for ( int i = 0; i < chaine.length(); i++ ){
	    if ( i == indice ){
		reponse += "";
	    }
	    else
		reponse += charAt(chaine,i);
	}
	return reponse;
    }

    void testGenereAlphabet() {
	assertEquals("abcdefghijklmnopqrstuvwxyz", genereAlphabet());
    }

    String genereAlphabet(){
	String rep = "";
	for ( int i = 'a'; i <= 'z'; i++ ){
	    rep += (char) i;
	}
	return rep;
    }

    /*
    void testEstPangramme() {
	assertTrue( estPangramme("portez ce vieux whisky au juge blond qui fume"));
	assertTrue( estPangramme("monsieur jack vous dactylographiez bien mieux que votre ami wolf"));
	assertTrue( estPangramme("buvez de ce whisky que le patron juge fameux"));
    }

    boolean estPangramme(String chaine){
	return false;
	
    }*/

    void testEquals(){
	assertTrue ( equals(new char[] {'a','b','c'}, new char[]{'a','b','c'} ));
	assertFalse ( equals(new char[] {'a','b','c'},new  char[] {'a','c','b'} ));
	assertFalse ( equals(new char[] {'a','a','c'},new  char[] {'a','a','c','v'}));
    }

    boolean equals(char[] mot1, char[] mot2){
	if ( mot1.length != mot2.length )
	    return false;
	for ( int i = 0; i < mot1.length; i++ ){
	    if ( mot1[i] != mot2[i] )
		return false;
	}
	return true;
    }
    

}
