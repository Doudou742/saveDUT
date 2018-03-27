class tp1_exo3 extends Program {
    void testPremierDernier() {
        assertEquals("tate", premierDernier("etat"));
        assertEquals("lue", premierDernier("elu"));
    }
    String premierDernier(String mot) {
        char premiereLettre = charAt(mot, 0);
        String resteDuMot   = substring(mot, 1, length(mot));
	// String resultat     = resteDuMot + premiereLettre;
	return resteDuMot + premiereLettre;

    }
}
