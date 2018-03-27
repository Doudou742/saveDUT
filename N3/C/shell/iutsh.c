#include <stdio.h>
#include "ligne_commande.h"
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include "iutsh.h"


void execute_ligne_commande(){
  int  nb;
  int flag;
  char *** ligne = ligne_commande(&flag,&nb);
  
  if((ligne == NULL || flag == -1) || nb == 0){
    return;
  }

  int i=0;
  int old=0;
  int pid=0;
  while(ligne[i] != NULL){
    if(ligne[i+1] != NULL){
      int t[2];
      pipe(t);
      //printf("|| %d-%d-%s\n",old,t[1],ligne[i][0]);
      pid = lance_commande(old,t[1],ligne[i][0],ligne[i]);
      close(t[1]);
      if(pid == -1){
	printf("Erreur\n");
	return;
      }
      old=t[0];
    }
    else {
      //printf("%d-%d-%s\n",old,1,ligne[i][0]);
      pid = lance_commande(old,1,ligne[i][0],ligne[i]);
      if(pid == -1){
	printf("Erreur\n");
	return;
      }
    }
    
    i++;
  }
  
  if(flag == 0){
    int status;
    waitpid(pid,&status,0);
    if (WIFEXITED(status))
      {
	//printf("Fin de commande: ");
	/*if (WEXITSTATUS(status) == 0)
	  //printf("sans erreur\n");
	else
	  //printf("avec erreur\n");
      }
      */
      }
    else /* !WIFEXITED */
      {
	printf("Processus terminé par signal %d\n", WTERMSIG(status));
      }
  }
  
    
}

void affiche_prompt(){
  char * env = getenv("USER");
  char name [128];
  gethostname(name, sizeof name);
  char name2 [128];
  getcwd(name2, sizeof name2);
  printf("\n%s@%s:%s$ ", env, name, name2);
  fflush(stdout);
}

int lance_commande(int in, int out, char *com, char ** argv){

  int pid = fork();
  
  if (pid == 0)
    {
      if(in != 0){
	close(0);
	dup(in);
      }
      if(out != 1){
	close(1);
	dup(out);
      }
      execvp(com, argv);
      perror(com);
      exit(0);
    }
  
  return pid;
  
}
