/**
 * Controle TP 1 - Promotion 2016-2017
 * 
 * Vous avez le droit de consulter vos TD/TP et les supports Moodle.
 * Il est interdit d'acceder et faire des recherches sur Internet (votre
 * activite reseau est surveillee)
 * 
 * Conseils:
 * 1. Renommer votre fichier pour refleter vos propres informations
 * 2. Renommer votre programme pour qu'il corresponde à votre nom de fichier
 * 3. Lisez bien l'ensemble de l'enonce avant de vous lancer !
 * 4. Decommentez au fur et à mesure les differents test ...
 * 5. Deposez dans les temps votre code source (le fichier .java !) sur Moodle
 */
class A_DESCHAMPS_Geoffrey extends Program {

    /** QUESTION 1: affichage d'une partie de la table ASCII
     * 
     * On souhaite definir une fonction permettant de creer une chaine 
     * contenant une partie de la table ASCII.
     * 
     */
    
    void testGenererTable() {
        assertEquals("97:a 98:b 99:c 100:d 101:e ", genererTable('a','e'));
        assertEquals("90:Z 91:[ 92:\\ 93:] 94:^ 95:_ 96:` 97:a ", genererTable('Z','a'));
    }
    

    String genererTable(char debut, char fin) {
	String rep = "";
	for ( int i = debut; i <= fin; i++ ){
	    char c = (char) i;
	    rep += i + ":" + c + " "; 
	}
	
        return rep;
    }
    
    /** QUESTION 2: dessinons un quadrillage
     * 
     * On souhaite dessiner un quadrillage en exploitant l'algorithme vu
     * en TD/TP reposant sur deux boucles imbriquees et une alternative.
     * On suppose que la taille sera toujours un nombre impair.
     */
    
    void testQuadrillage() {
        assertEquals("%\n", quadrillage(1, '%'));
        
        assertEquals("%%%\n"+
                     "% %\n"+
                     "%%%\n", quadrillage(3, '%'));
        /*
        assertEquals("*****\n"+
                     "* * *\n"+
                     "*****\n"+
                     "* * *\n"+
                     "*****\n", quadrillage(5, '*'));
	*/
    }
    
    String quadrillage(int taille, char symbole) {
	String rep = "";

	for ( int i = 0; i < taille; i ++ ){
	    for ( int j = 0; j < taille; j++ ){
		if ( (i==0) || ( j== 0 ) || ( i==taille-1 ) || (j==taille-1) ){
			rep += symbole;
		}
		else if ( i+1 == taille%2 && j+1 == taille%2 ){
		    rep += symbole;
		}
		else
		    rep += " ";
		
	    }
	    rep += "\n";
	}
	
        return rep;
    }
    
    /** QUESTION 4: calcul des termes de la suite de Fibonacci
     * 
     * La suite de Fibonacci est ainsi definie:
     * - U(0) = 0
     * - U(1) = 1
     * - U(n) = U(n-1) + U(n-2)
     * 
     * Ainsi, U(2) = U(1) + U(0) = 1 + 0 = 1
     *        U(3) = U(2) + U(1) = 1 + 1 = 2
     * 
     * Definissez la fonction fibonacci(int n) qui calcule le nieme terme
     * de la suite, en supposant que n est positif ou nul.
     */
    
    void testFibonacci() {
        assertEquals( 0, fibonacci(0));
        assertEquals( 1, fibonacci(1));
        assertEquals( 1, fibonacci(2));
        assertEquals( 2, fibonacci(3));
	  assertEquals( 3, fibonacci(4));
	assertEquals( 5, fibonacci(5));
	//  assertEquals( 8, fibonacci(6));
    }
    
    int fibonacci(int n) {

	final int U0 = 0;
	final int U1 = 1;
	int rep = 0;
	int save = rep;
	
	for ( int i = 0; i <=n ; i++ ){
	    if ( i == 0 ){
		rep = 0;
	    }
	    else if ( i == 1 ) {
		rep = 1;
	    }

	    else {
		rep = ( i - (i-1) + (i-2) + ( n-i ));
	    }
	    
		
	}

	    
	    
    
	
	
	return rep;
    }
    
    /** QUESTION 5: dessinons un F
     * 
     * On souhaite dessiner la lettre F avec une taille impaire donnee (>=5).
     * ATTENTION: interdit d'utiliser le meme type d'algorithme que pour 
     * la question 3 car le but est ici de generer une chaine ne contenant
     * que les caracteres necessaires (ie. elle ne doit contenir aucun 
     * caractere espace !)
     * 
     * Exemple avec taille = 5 => *****
     *                            *
     *                            ***
     *                            *
     *                            *
     */
    
    void testDessinF() {        
        final String TAILLE_5 = "*****\n"+
                                "*\n"+
                                "***\n"+
                                "*\n"+
                                "*\n";
        assertEquals(TAILLE_5, dessinF(5));
        
        final String TAILLE_7 = "*******\n"+
                                "*\n"+
                                "*\n"+
                                "****\n"+
                                "*\n"+
                                "*\n"+
                                "*\n";
        assertEquals(TAILLE_7, dessinF(7));        
    }
    
    String dessinF(int taille) {

	String rep = "";
	println("valeur de taille/2= " + 5/2 );
	for ( int i = 0; i < taille; i ++ ){
	    for ( int j = 0; j < taille; j++ ){
		//si premiere ligne ou premiere colonne
		if ( i == 0 || j == 0 ){
		    rep += "*";
		}
		
		//si ligne du milieu && colonne jusque milieu
		else if ( i == taille/2 && j <= taille/2 ){
		    rep += "*";
		}
		
	    }
	    rep += "\n";
	    
	}
	
        return rep;
    }
    
}
