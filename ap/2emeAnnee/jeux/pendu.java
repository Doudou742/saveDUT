class pendu extends Program{

   
    
    //saisie une chaine de caractère composée uniquement de lettres et la retourne sous forme de tableau de char
    public char[] saisir(){
	String rep = "";
	char[] res;
	println("saisir un mot qu'il faudra deviner: ");
	rep = readString();
	while ( !queLettre(rep) ){
	    rep = readString();
	}
	
	res = new char[rep.length()];
	for ( int idx = 0; idx < rep.length(); idx++ ){
	    res[idx] = charAt(rep,idx);
	    //print(motADeviner[idx]);
	}
	return res;
    }


    //vérifie que dans un String il n'y a que des lettres, si oui return vrai, sinon false
    public boolean queLettre(String s){
	for ( int i = 0; i < s.length(); i++ ){
	    if ( (charAt(s,i) < 'a' || charAt(s,i) > 'z') && charAt(s,i) != 'é' &&  charAt(s,i) != 'è' && charAt(s,i) != 'ç' && charAt(s,i) != 'à' && charAt(s,i) != 'ù'  ){
		return false;
	    }
	}
	return true;
    }

   
    public char[] transformeMotEnEtoile(char[] tab){
	char[] rep = new char[tab.length];
	for ( int idx = 0; idx < tab.length; idx++ ){
	    rep[idx] = '*';
	}
	return rep;
    }

    public void remplacement(char[] tab, char[] tabEtoile, char c){
	for ( int idx = 0; idx < tab.length; idx++ ){
	    if ( tab[idx] == c ){
		tabEtoile[idx] = c;
	    }
	}
    }


    public boolean estPresent(char[] tab, char c){
	for ( int idx = 0; idx < tab.length; idx++ ){
	    if (tab[idx] == c ){
		return true;
	    }
	}
	return false;
    }


    public boolean finie(char[]tab){
	for ( int idx = 0; idx < tab.length; idx++ ){
	    if ( tab[idx] == '*' ){
		//println("passe dans pas finie");
		return false;
	    }
	}
	//println("passe dans finie");
	return true;
    }
    

    public void afficheTab(char[] tab){
	for ( int idx = 0; idx < tab.length; idx++ ){
	    print(tab[idx]);
	}
    }




    void algorithm(){

	char saisie = ' ';
	int nbVies = 5;
	boolean finPartie = false;
	
	//saisir un mot à deviner
	char[] motADeviner = saisir();

	//transformer le mot en mot étoilé
	char[] motEnEtoile = transformeMotEnEtoile(motADeviner);

	clearScreen();
	afficheTab(motEnEtoile);

	while ( nbVies > 0 && !finPartie ){
	
	//while ( true ){
	
	    println("choisir un char: ");
	    saisie = readChar();

	    if ( estPresent(motADeviner,saisie) ){
		remplacement(motADeviner,motEnEtoile,saisie);
	    }
	    else {
		nbVies-- ;
	    }
	    if ( nbVies > 1 ){
		println("il reste: " + nbVies + ", méfie te");
	    }
	    else {
		println("PLUS QU'1 VIE");
	    }
	    afficheTab(motEnEtoile);
	    finPartie = finie(motEnEtoile);

	
	}//while de boucle de jeu


    }

}
