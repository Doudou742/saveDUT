#include <stdio.h>

int main(void) {
  int nbParenth = 0;
  unsigned int a;
  char c = 'a';

  printf("\n saisir un mot \n ");
  while (c != '\n'){

    c = getchar();
    a = c;
    if (a == 40) {
      nbParenth = nbParenth + 1;
    }
    if (a == 41) {
      nbParenth = nbParenth -1;
    }
  }
  
  if (nbParenth == 0) {
    return 0;
  }
  else {
    return 1;
  }
}
