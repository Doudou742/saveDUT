class exercice4 extends Program{
    public void algorithm(){

	String reponse = "";
	String mot = "";
	println("saisir mot: ");
	mot = readString();
	for ( int i = 0; i < mot.length(); i++ ){
	    // println(charAt(mot,i));
	    println(substring(mot, i, i+1));
	}
        
    }
}
