
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int main(void)
{
   int fd = open("fichier", O_CREAT| O_TRUNC | O_WRONLY, 0666);
   char * c = "Bonjour\n";
   close(1);
   int fd2 = dup(fd);
   printf("Chaine: %s", c);
   close(fd);
   
   return 0;
}
