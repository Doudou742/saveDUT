
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>          /* See NOTES */
#include <sys/socket.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <errno.h>
#include <ctype.h>

#define BUFFER_SIZE 1024

#define MESSAGE_ERREUR "<ServeurHD> HTTP/1.1 400 Bad Request \r\nConnection : close \r\nContent-Length : 17 \r\n"
#define MESSAGE_OK "<ServeurHD> HTTP/1.1 200 OK\r\n"

int check_and_open ( const char * target , const char * document_root ) {
	
}

int main () {
  char * const* chaine = "/home/infoetu/deschamg";
  execvp("stat", chaine);
  
  return 0;
}
