//deschamps geoffrey frene26
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>

int envoyer_donnees(int in, int out) {
	char buffer[100];

	if (in == -1) {
		printf("ouverture fichier impossible\n");
		return -1;
	}

	int octets = -1;
	
	while ( (octets = read(in,buffer,100) ) > 0) {
		if (write(out,&buffer,octets) == -1) {
			return -1;
		}	
	}

	return 0;
}


int lance_commande(int in, const char *commande) {
	int pid	= fork();
	int t [] = {in};
	close(0);
	dup(t[0]);
	//on est dans le fils
	if (pid == 0) {
		execlp(commande,commande,NULL);
		perror(commande);
		return pid;
	}
	return 0;
}

int lance_traitement(int in, const char *commande) {
	//creation d un premier processus
	pid_t pid = fork();
	int *pointeurPid = &pid;

	//creation d'un tube
	int tab[2] = {in,commande[0]};
	int tube = pipe(tab);
	if (tube == -1) {
		perror("pipe");
		return -1;
	}

	//si il y a une erreur
	if (pid == -1) {
		perror("fork");
		return -1;
	}
	//dans le fils
	else if (pid == 0) {
		//envoyer_donnees(in,commande);


	}
	close(tab[0]);
	close(tab[1]);
	free(pointeurPid);
	return 0;
}

int main() {
	return 0;
}