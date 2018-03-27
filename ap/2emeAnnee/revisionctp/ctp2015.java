/**
 * Controle TP - mercredi 16 décembre 2015 (duree 1h30) Tous documents autorises
 *
 * NE PAS OUBLIER DE RENOMMER VOTRE FICHIER EN RESPECTANT LA CONVENTION
 * SUIVANTE:
 *
 * GROUPE_NOM_Prenom.java (exemple: A_SECQ_Yann.java)
 *
 * NE PAS OUBLIER DE DEPOSER VOTRE FICHIER SUR MOODLE DANS LES 5 DERNIERES
 * MINUTES DE L'EPREUVE.
 *
 * @author yann.secq@univ-lille1.fr
 */
class ctp2015 extends Program {

    /**
     * EXERCICE 1: Jeu de bingo (10 points)
     *
     * Ce jeu est destine aux enfants lorsqu'ils apprennent la notion de
     * division. Les enfants enumerent les nombres de 1 a n, mais lorqu'un
     * nombre est divisible par trois, ils le remplacent par le mot "bin", et
     * si il est divisible par 5, ils le remplacent par le mot "go".
     * Si le nombre est divisible a la fois par 3 et 5 alors les enfants 
     * doivent le remplacer par "bingo".
     *
     * Voici un exemple de sequence: 1, 2, bin, 4, bin, bin, 7, 8, bin,
     * go, 11, bin, 13, 14, bingo
     *
     * Le but de ce premier exercice est d'ecrire ce jeu de Bingo. Pour cela,
     * une premiere fonction ne traitant qu'un seul nombre est a ecrire.
     * Ensuite, vous pourrez reutiliser cette fonction afin de produire une
     * sequence similaire a celle donnee en exemple ci-dessus.
     */
    /**
     * La fonction 'bingo' prend en parametre un nombre positif et retourne:
     * - "bin"   si n est divisible par 3, 
     * - "go"    si n est divisible par 5, 
     * - "bingo" si n est divisible par 3 et par 5, 
     * - n (sous forme de chaine) sinon.
     */
    void testBingo() {
        assertEquals("2", bingo(2));
        assertEquals("bin", bingo(3));
        assertEquals("go", bingo(5));
        assertEquals("bingo", bingo(15));
    }

    String bingo(int n) {
	String res ="";

	if ( (n%3)==0 && (n%5)==0 ){
	    res += "bingo";
	    return res;
	}
	
	if ( (n%3)==0 ){
	    return "bin";
	}

	else if ( (n%5)==0 ){
	    return "go";
	}

	return ""+n;
       
    }

    /**
     * La fonction 'listeBingo' prend en paramètre un nombre positif et
     * retourne un tableau contenant la valeur de retour de la fonction
     * 'bingo' pour les nombres compris dans l'intervalle [1, n].
     */
    void testListeBingo() {
        final String[] answer1 = new String[]{
            "1", "2", "bin", "4", "go"
        };
        assertArrayEquals(answer1, listeBingo(5));
        final String[] answer2 = new String[]{
            "1", "2", "bin", "4", "go", "bin", "7", "8",
            "bin", "go", "11", "bin", "13", "14", "bingo"
        };
        assertArrayEquals(answer2, listeBingo(15));
    }

    String[] listeBingo(int n) {
	String[] res = new String[n];
	for ( int i = 0; i < n; i++ ){
	    res[i] = bingo(i+1);
	}
	return res;
    }
    /**
     * La fonction 'bingoPlus' ajoute une fonctionnalite supplementaire:
     * si le nombre contient le chiffre 3 ou le chiffre 5, on ajoute 
     * autant de '!' que d'occurences de 3 ou de 5 dans l'ecriture du 
     * nombre.
     * 
     * Exemple: 35 donnera 'go' car il est divisible par 5, mais comme 
     * 3 et 5 apparaissent dans l'ecriture de 35, on ajouter deux '!'.
     */
    void testBingoPlus() {
        assertEquals("bin!", bingoPlus(3));
        assertEquals("go!", bingoPlus(5));
        assertEquals("go!!", bingoPlus(35));
    }
    
    String bingoPlus(int n) {
	String r = "";
	String tmp = ""+n;
	r = bingo(n);
	for ( int idx = 0; idx < tmp.length(); idx++ ){
	    if ( charAt(tmp,idx) == '3' || charAt(tmp,idx) == '5' ){
		r += '!';
	    }
	}
	return r;
    }
    
    /**
     * EXERCICE 2: Décomposons Pierre/Papier/Ciseaux (10 points)
     *
     * On s'interesse dans cet exercice a la decomposition du jeu pierre /
     * papier / ciseaux. Ce jeu implique deux joueurs qui choisissent
     * chacun une des trois options: pierre, papier ou ciseaux. Une fois
     * ce choix realise, soit l'un des deux joueurs l'emporte sur l'autre et
     * gagne un point, soit il y a egalite et le score des joueurs reste
     * inchange. Le jeu s'arrete des que l'un des joueurs atteint 5 points.
     *
     * Il est conseille d'ecrire en premier la fonction 'void algorithm()' 
     * en introduisant des appels a d'autres fonctions si necessaire. 
     * Ensuite, définissez les signatures de ces fonctions avec une valeur 
     * de retour quelconque afin que votre programme compile. Finalement, 
     * ajoutez le code dans les fonctions que vous avez définies afin 
     * d'avoir un programme fonctionnel.
     *
     * Voici un exemple d'execution vous indiquant les affichages que 
     * vous devez produire:
     * ---------------------------------------------------------------
     * Que jouez-vous joueur 1 ? pierre
     * Que jouez-vous joueur 2 ? papier
     * Joueur 1 = 0 et Joueur 2 = 1
     * Que jouez-vous joueur 1 ? papier
     * Que jouez-vous joueur 2 ? ciseau
     * Joueur 1 = 0 et Joueur 2 = 2
     * Que jouez-vous joueur 1 ? papier
     * Que jouez-vous joueur 2 ? papier
     * Joueur 1 = 0 et Joueur 2 = 2
     * Que jouez-vous joueur 1 ? ciseau
     * Que jouez-vous joueur 2 ? papier
     * Joueur 1 = 1 et Joueur 2 = 2
     * Que jouez-vous joueur 1 ? pierre
     * Que jouez-vous joueur 2 ? papier
     * Joueur 1 = 1 et Joueur 2 = 3
     * Que jouez-vous joueur 1 ? ciseau
     * Que jouez-vous joueur 2 ? pierre
     * Joueur 1 = 1 et Joueur 2 = 4
     * Que jouez-vous joueur 1 ? ciseau
     * Que jouez-vous joueur 2 ? papier
     * Joueur 1 = 2 et Joueur 2 = 4
     * Que jouez-vous joueur 1 ? papier
     * Que jouez-vous joueur 2 ? ciseau
     * Joueur 1 = 2 et Joueur 2 = 5
     * Le joueur 2 a gagne !
     * ---------------------------------------------------------------
     */



    String saisie(){
	String tmp = "";
	do {
	    tmp = readString();
	}
	while ( !(tmp.equals("papier")) && !(tmp.equals("pierre")) && !(tmp.equals("ciseau")) );
	
	return tmp;
    }

    int marquePoint(String r1, String r2){
	if ( r1.equals(r2) ){
	    return 0;
	}

	if ( r1.equals("pierre") ){

	    if ( r2.equals("ciseau")) {
		return 1;		    
	    }

	    if ( r2.equals("papier") ){
		return 2;
	    }
	    
	}


	if ( r1.equals("papier") ){

	    if ( r2.equals("pierre") ){
		return 1;
	    }
	    if ( r2.equals("ciseau") ){
		return 2;
	    }
	}

	if ( r1.equals("ciseau") ){

	    if ( r2.equals("pierre") ){
		return 2;
	    }
	    if ( r2.equals("papier") ){
		return 1;
	    }
	}

	return -1;
	
    }


    boolean gagner(int nb1, int nb2){
	if ( nb1 == 5 ){
	    println("joueur 1 a gagne");
	    return true;
	}
	if ( nb2 == 5 ){
	    println("joueur 2 a gagne");
	    return true;
	}
	return false;
    }

    
    void algorithm() {
	boolean fini = false;
	String repJ1, repJ2;
	int pointJ1 = 0;
	int pointJ2 = 0;
	int marqueLePoint;
	
	while ( !fini ){
	  
	    println("joueur 1 saisir: ");
	    repJ1 = saisie();
	    //joueur1 = false;
	    
	    
	    println("joueur 2 saisir: ");
	    repJ2 = saisie();
	    //joueur1 = true;

	    marqueLePoint = marquePoint(repJ1,repJ2);

	    if ( marqueLePoint == 0 ){
		println("point null");
	    }
	    else if ( marqueLePoint == 1 ){
		pointJ1 += 1;
	    }
	    else if ( marqueLePoint == 2 ){
		pointJ2 +=1;
	    }
	    
	    println("point joueur1: " + pointJ1 + ", point joueur2: " + pointJ2);

	    fini = gagner(pointJ1,pointJ2);
	    
	}

    }

    
}
