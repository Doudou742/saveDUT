class exo6 extends Program {
    void testBissextile() {
	int[] anneesBissextiles = new int[]{2012, 2008, 2004, 2000,
					    1996, 1992, 1988, 1984, 1980, 1976, 1972};
	int annee;
	for (int i=0; i<length(anneesBissextiles); i=i+1) {
	    annee = anneesBissextiles[i];
	    assertTrue(bissextile1(annee));
	    //   assertEquals(bissextile1(annee), bissextile2(annee));
	    //   assertEquals(bissextile2(annee), bissextile3(annee));
	    //    assertEquals(bissextile3(annee), bissextile4(annee));
	}
	// d’autres dates non bissextile
	assertFalse(bissextile1(2013));
	//	assertFalse(bissextile2(2006));
	//	assertFalse(bissextile3(2005));
	//	assertFalse(bissextile4(1999));
    }


    boolean bissextile1(int annee) {
	boolean estBissextile = false;
	if ( annee%4 == 0 )
	    estBissextile = true;
	return estBissextile;
    }
    // Utiliser le même schéma pour bissextile2/3/4
}
