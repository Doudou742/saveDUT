class exercice5 extends Program{
    
     void testOccurrence() {
	String phrase = "Hello World !";
	assertEquals(2, occurrenceFor(phrase, 'o'));
	assertEquals(3, occurrenceFor(phrase, 'l'));
	assertEquals(0, occurrenceFor(phrase, 'y'));

	print("fini");
    }

    public int occurrenceFor(String phrase, char c){
	
	int cpt = 0;	
	for ( int i = 0; i < phrase.length(); i++ ){
	    if ( charAt(phrase, i) == c ){
		cpt += 1;
	    }
	}
	return cpt;
    }
    
      void testOccurrenceWhile() {
	String phrase = "Hello World !";
	assertEquals(2, occurrenceWhile(phrase, 'o'));
	assertEquals(3, occurrenceWhile(phrase, 'l'));
	assertEquals(0, occurrenceWhile(phrase, 'y'));
    }
	


    public int occurrenceWhile(String phrase, char c){

	int i = 0;
	int cpt = 0;
	while ( i < phrase.length() ){
	    if ( charAt(phrase, i) == c ){
		cpt += 1;
		
	    }
	    i += 1;
	    // println(i);
	}
	return cpt;
	
    }
	
}
