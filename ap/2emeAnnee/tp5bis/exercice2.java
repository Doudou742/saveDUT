class exercice2 extends Program{



    void testCreerTableauOrdonne() {
	assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10},  creerTableauOrdonne());
    }

    int[] creerTableauOrdonne(){
	int[] tab = new int[10];
	for ( int i = 0; i < tab.length; i++ ){
	    tab[i] = i + 1;
	}
	return tab;
    }


    void testShift() {
	int[] tab = creerTableauOrdonne();
	shift(tab);
	assertArrayEquals(new int[]{10,1,2,3,4,5,6,7,8,9}, tab);
	tab = new int[]{2, 5, 3, 1, 7};
	shift(tab);
	assertArrayEquals(new int[]{7, 2, 5, 3, 1}, tab);
    }
    
    void shift(int[] tableau){
	int save = tableau[tableau.length-1];
	println("valeur de save : " + save);
	int[] rep = new int[tableau.length];
	
	rep[0] = tableau[tableau.length-1];
	//println("valeur de rep indice 0 : " + rep[0]);
        for ( int i = 1; i <= tableau.length-1; i++ ){
	    // println("valeur de tab indice i-1 : " + tab[i-1] + " avec comme indice : " + i); 
	    rep[i] = tableau[i-1];
	    //println("valeur de rep indice i : " + rep[i] + " avec comme indice : " + i);
	}
	for ( int i = 0; i < rep.length; i++ ){
	    tableau[i] = rep[i];
	}
	
    }
}
