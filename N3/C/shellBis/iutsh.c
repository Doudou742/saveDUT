#include "ligne_commande.h"
#include "iutsh.h"

void affiche_prompt() {
	//char * environment = getenv("PWD");
	char * user = getenv("USER");
	char buff[16];
	gethostname(buff,16);
	char buffCwd[256];
	buffCwd[255] = '\0';
	if (getcwd(buffCwd,255) == NULL )  {
		perror("cwd");
	}
	printf("%s@%s:%s/iutsh$ ",user,buff,buffCwd);
	fflush(stdout);
}

void execute_ligne_commande() {
	int flag;
	int nb;
	char ***  lcmd = ligne_commande(&flag,&nb);
	pid_t pid = fork();
	if (pid == -1) {
		perror("pid");
	}
	else if (pid == 0) {
		//affiche_prompt();
		execvp(lcmd[0][0], lcmd[0]);
	}
	else {
		if (flag == 0) {
			int stat;
			waitpid(pid,&stat,WUNTRACED);	
			printf("%d", stat);

			if (WIFEXITED(stat)) {
      			printf("Fin de execute_ligne_commande: ");
      			if (WEXITSTATUS(stat) == 0)
         			printf("sans erreur\n");
      			else
         			printf("avec erreur\n");
   			}
   			else {
   				printf("Pocessus terminé par signal %d\n", WTERMSIG(stat));
   			}
		}	
	}
	libere(lcmd);
}

int lance_commande(int in, int out, char * com, char ** argv) {
	//création d'un processus
	pid_t pid = fork();
	int * pointeurPid = &pid;
	//creation d'un tube avec tableau de 2 descripteurs
	int tab[2] = {in,out};
	int tube = pipe(tab);
	if (tube == -1) {
		perror("pipe");
		return -1;
	}
	else {

	}

	//si il y a une erreur
	if (pid == -1) {
		perror("fork");
		return -1;
	}
	//dans ffle fils
	else if (pid == 0) {
	

	}
	close(tab[0]);
	close(tab[1]);
	free(pointeurPid);
	return pid;
}


int main() {
	while (1) {
		affiche_prompt();
		execute_ligne_commande();
	}
	return 0;
}