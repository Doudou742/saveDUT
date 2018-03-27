
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <stdlib.h>

/* ls | wc -l */

int main(void)
{
   printf("Debut\n");
   int t[2];
   pipe(t);
   
   /* Fils 1 : ls */
   if (fork() == 0)
   {
      close(1);
      dup(t[1]);
      execlp("ls", "ls", NULL);
      exit(0);
   }
   /* Fils 2 : wc */
   if (fork() == 0)
   {
      close(t[1]); /* pas besoin de l'entrée du tube */
      close(0);
      dup(t[0]);
      execlp("wc", "wc", "-l", NULL);
      exit(0);
   }
   close(t[1]);
   close(t[0]);
   int pid1 = wait(NULL);
   printf("Fin de %d\n", pid1);
   int pid2 = wait(NULL);
   printf("Fin de %d\n", pid2);
   return 0;
}
