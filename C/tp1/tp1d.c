#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void)
{
  int i;
  int j;
  int x;
  int y;
  int t[8];
  int cpt =0;
  int puissance = 0;
  
  int dec;
  
  for (x=0; x < 8; x++) {
    t[x]=0;
  }
  
  for (i=1; i < 256; i=i+1) {
    incr(t);
    printf("initiale : %d ",i);
    
    for (j = 7; j >= 0; j--) {
      printf(" %d ", t[j]);
    }
    
    for (y = 0; y < 8; y++) {
      if (t[y] == 1) {
	dec = dec + t[y]* (int)pow(2,y);
      }
    }
    
    printf("decimale : %d",dec);
    
    dec =0;
    
    printf("\n");
  }
  return 0;
}  
