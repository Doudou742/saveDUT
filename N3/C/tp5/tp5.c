#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

int traiter (int f, int * car, int * mot, int * lig) {
	char buffer[100];
	if (f == -1) {
		printf("ouverture du fichier impossible");
		return -1;
	}
	//count nb char
	*car = 
	

	//count nb ligne
	int cptLigne = 0;
	int nbMot = 0;
	int i;
	if (buffer[0] >= 'a' && buffer[0] <= 'z') {
		nbMot++;
	}
	for (i = 0; i < *car; i++) {
			if (buffer[i] == '\n') {
				cptLigne++;
			}
			if ((buffer[i] == ' ' && (buffer[i+1] >= 'a' && buffer[i+1] <= 'z')) || ( buffer[i] == '\n' && (buffer[i+1] >= 'a' && buffer[i+1] <= 'z'))) {
				nbMot++;
			}
	}
	*lig = cptLigne;
	*mot = nbMot;		

	return 1;
}

int main(int argc, char * argv[]) {
	int car,mot,lig;

	//ouverture du fichier en readOnly
	int fd;
	int optionL = 0;
	int optionM = 0;
	int optionC = 0;
	const char* file[256];
	int cptFile = 0;
	
	int cptArgument;
	for (cptArgument = 1; cptArgument < argc; cptArgument++) {

		if (argv[cptArgument][0] != '-') {
			file[cptFile] = argv[cptArgument];
			cptFile++;
		}

		if (argv[cptArgument][0] == '-') {
			int tmp;
			for (tmp = 1; tmp <= argc; tmp++) {
				if (argv[cptArgument][tmp] == 'c') {
					optionC = 1;
				}
				if (argv[cptArgument][tmp] == 'l') {
					optionL = 1;
				}
				if (argv[cptArgument][tmp] == 'm') {
					optionM = 1;
				}
			}
		}
	
	}

	int i;
	for (i = 0; i < cptFile; i++) {
		fd = open(file[i], O_RDONLY);
		printf("fichier ouvert \n" );
		if (fd == -1) {
			printf("ouverture fichier impossible");
			return -1;
		}
		traiter(fd,&car,&mot,&lig);
		if (optionC == 1) {
			printf("nb car : %d\n", car);
		}
		if (optionL == 1) {
			printf("nb ligne : %d\n", lig);
		}
		if (optionM == 1) {
			printf("nb mot : %d\n", mot);
		}
		if (optionM == 0 && optionL == 0 && optionC == 0) {
			printf("nb car : %d\n", car);
			printf("nb ligne : %d\n", lig);
			printf("nb mot : %d\n", mot);
		}
		
	}
	

	
	return 0;
}