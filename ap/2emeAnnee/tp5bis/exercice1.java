class exercice1 extends Program{

    void testPrintln(){
	println(new int[]{1, 4, 5, 2, 3});
    }

    void println(int[] tab){
	for ( int i = 0; i < tab.length; i++ ){
	    if ( i == tab.length-1 ){
		println(i);
	    }
	    else {
		println(i + ',');
	    }
	}
    }


    void testCreerTableau() {
	assertArrayEquals(new int[]{1,1,1,1,1,2,2,2,2,2}, creerTableau(10));
    }

    int[] creerTableau(int taille){
	int[] tab = new int[taille];
	for ( int i = 0; i < taille; i++ ){
	    if ( i < taille/2 ){
		tab[i] = 1;
	    }
	    else {
		tab[i] = 2;
	    }
	}
	return tab;
	
    }

    /*
    void algorithm(){
	int[] tableau = creerTableauAleatoire(10);
	for ( int i = 0; i < tableau.length; i++ ){
	    println(tableau[i] + ',');
	}
	}*/

    
    int[] creerTableauAleatoire(int taille){

	int[] tab = new int[taille];
	for ( int i = 0; i < taille; i++ ){
	    tab[i] = (int) (random()*100);
	}
	return tab;
	
    }


    
}
