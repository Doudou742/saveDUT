
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>

/* ls > fichier */

int main(void)
{
   int fd = open("fichier", O_CREAT| O_TRUNC | O_WRONLY, 0666);
   char * c = "Bonjour\n";

   printf("Avant LS\n");
   fflush(stdout);
   if (fork() == 0)
   {
      close(1);
      int fd2 = dup(fd);
      execlp("ls", "ls", "-l", NULL);
      return 0;
   }
   wait(NULL);
   printf("Apres LS\n");
   close(fd);
   
   return 0;
}
