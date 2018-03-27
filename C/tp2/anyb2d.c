#include <stdio.h>
#include <math.h>

int anyb2d(int base) {
  char saisie;
  int res = 0;
  while (saisie != '\n') {
    saisie = getchar();
    /*
    if (base == 2) {
      b2d();
    }
    */
    
    if (base == 8) {
      if (saisie < '0' && saisie > '7' && saisie != '\n'){
	       return -1;
      }
      
      if (saisie >= '0' && saisie <= '7') {
	       res = base * res + saisie - '0';
      }
      
    }
    

    if (base == 10) {
      if (saisie < '0' && saisie > '9' && saisie != '\n') {
        return -1;
      }
      if (saisie >= '0' && saisie <= '9' ) {
        res = res * base + saisie - '0';
      }
    }

    if (base == 16) {
      if (saisie >= '0' && saisie <= '9') {
        res = res * base + saisie - '0';
      }
      else if (saisie >= 'a' && saisie <= 'f') {
        res = res * base + saisie - 87;
      }
    }
  }
  
  return res;
}

int d2any(int entier, int base) { 
  int res = 0;
  while (entier != 0) {
   if (base == 2) {
      if (entier % base == 0) {
        printf("0");
      }
      else if (entier % base == 1) {
        printf("1");
      }
      entier = entier / 2;
    }
  }
  printf("\n");
  return 0;
}

int main(void) {
  // printf("voici le nb choisi: %d \n",anyb2d(16));  
  d2any(20,2);
  return 0;
}
