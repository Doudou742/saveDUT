class exo4 extends Program{
    void testNature(){
	assertEquals("ALPHABETIQUE", nature('t'));
	assertEquals("NUMERIQUE", nature('0'));
	assertEquals("AUTRE", nature('$'));
    }

    String nature(char c){
	if ( c >= 'a' && c <= 'z' ){
	    return "ALPHABETIQUE";
	}
	
	else if ( c >= '0' && c <= '9' ){
	    return "NUMERIQUE";
	}
	
	else 
	    return "AUTRE";
	
    }
}