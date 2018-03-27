
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <stdlib.h>

/* ls | grep fichier | wc -l */

int main(void)
{
   printf("Debut\n");
   int t[2];
   int t2[2];
   pipe(t);
   pipe(t2);
   
   /* Fils 1 : ls */
   if (fork() == 0)
   {
      close(1);
      dup(t[1]);
      execlp("ls", "ls", NULL);
      exit(0);
   }
   /* Fils 2 : grep */
   if (fork() == 0)
   {
      close(t[1]); /* on evite les bloquages */
      /* redirection de l'entrée */
      close(0);
      dup(t[0]);
      /* redirection de la sortie */
      close(1);
      dup(t2[1]);
      execlp("grep", "grep", "fichier", NULL);
      exit(0);
   }
   /* Fils 3 : wc */
   if (fork() == 0)
   {
      close(t[1]); /* pas besoin de l'entrée du tube */
      close(t2[1]); /* pas besoin de l'entrée du tube */
      /* redirection de l'entrée */
      close(0);
      dup(t2[0]);
      execlp("wc", "wc", "-l", NULL);
      exit(0);
   }
   close(t[1]);
   close(t[0]);
   close(t2[1]);
   close(t2[0]);
   int pid1 = wait(NULL);
   printf("Fin de %d\n", pid1);
   int pid2 = wait(NULL);
   printf("Fin de %d\n", pid2);
   int pid3 = wait(NULL);
   printf("Fin de %d\n", pid3);
   return 0;
}
