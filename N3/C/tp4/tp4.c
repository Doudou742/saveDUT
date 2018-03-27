#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char * miroir (const char *s) {
	int longueur = strlen(s);
	//printf("%d\n", longueur);
	char * nouvelleChaine;
	nouvelleChaine = malloc(strlen(s) * sizeof(char));
	int i;
	for (i = longueur; i > 0; i--) {
		nouvelleChaine[longueur - i ] = s[i-1];
	}
	//printf("%s\n", nouvelleChaine);
	return nouvelleChaine;
}

char * saisie() {
	char c;
	char * chaine;
	chaine = malloc(sizeof(1));
	int cpt = 0;
	
	/*while () {
		cpt++;
		printf("%c", c);
		chaine = realloc(chaine, sizeof(char)*(cpt+1));
		chaine[cpt] = c;
		c = getchar();
	}*/
	do {
		c = getchar();
		chaine[cpt] = c;
		printf("%c", c);
		cpt++;
		chaine = realloc(chaine, sizeof(char)*(cpt+1));
	}while (c != EOF && c != 10 && c != ' ');
	//chaine = malloc(sizeof(cpt));
	return chaine;
}

int main(int argc, char*argv[]) {
	
	/*
	char chaine[] = {'S','t','r','i','n','g','\0'};
	//int l = strlen(chaine);
	char * nc;
	nc = malloc(strlen(chaine) * sizeof(strlen(chaine)));
	nc = miroir(chaine);
	printf("%s\n", nc);
	//free(chaine);
	free(nc);
	*/
	/*
	char * sais;
	sais = malloc(sizeof(char));
	sais = saisie();
	printf("%s\n", sais);
	*/
	//chaine option string
	//il faudrait utiliser une boucle sur les arguments
	if (strcmp(argv[1],"-m")==0 && argc <= 2){
		printf("%s\n", "pas assez d'arguments");
		return 0;
	}
	if (argc > 2) {
    	if ( (strcmp(argv[1],"-m") == 0 && strcmp(argv[2],"-s") == 0) || (strcmp(argv[1],"-s") == 0 && strcmp(argv[2],"-m") == 0)  ) {
    		char * flag = saisie() ;
			printf("%s\n", miroir(flag));
		}
	}
	
	if ( strcmp(argv[1],"-ms") == 0 || strcmp(argv[1], "-sm") == 0) {
		char * flag = saisie();
		printf("%s\n", miroir(flag));
	}

	else if (strcmp(argv[1],"-m") == 0 && argc >= 2) {
		
		printf("%s\n", miroir(argv[2]));
	}

	else if (strcmp(argv[1],"-s") == 0) {
		saisie();
		
		//printf("argument %d %s \n", i+1, argv[i]);
	}

	return 0;
}