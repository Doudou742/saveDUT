class exercice3 extends Program{

    void algorithm(){

	final int DEPART = 1;
	int nbLignes;
	int prixHT = DEPART;
	println("combien de ligne(s) ? : ");
	nbLignes = readInt();
	for ( int cpt = 0; cpt < nbLignes; cpt ++ ){
	    println("" + prixHT + " euros HT = " + (prixHT * 1.196) + " euros TTC");
	    prixHT += 1;
	}
	
    }

}
