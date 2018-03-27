class minToMaj extends Program{

    void algorithm(){
	char a = 'y';
	println(mintomaj(a));
    }
    
    char mintomaj(char c){
	char rep = c;
	if ( c >= 'a' && c <= 'z' ){
	    rep = (char) (c - 32);
	    
	}
	else 
	    rep = c;
	return rep;
	
    }

}
