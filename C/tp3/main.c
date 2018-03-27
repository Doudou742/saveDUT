#include "vecteur.h"
#include <stdio.h>

int main(){
  // TODO
	
  vecteur v;
  v.x = 10;
  v.y = 10;

  vecteur a;
  a.x = 12;
  a.y = 12;

  vecteur c;
  c.x = 11;
  c.y = 11;

  vecteur tableau[LONGUEUR];
  tableau[0] = a;
  tableau[1] = v; 
  tableau[2] = c;

  int tab[] = {0,1,2};

  printf("%d \n",maximum(tableau));
  trier2_p(tableau, tab);
  afficher(tableau);
  //afficher2(tableau,tab);
  
  //afficher(tableau);

  //int cpt;
  //for (cpt = 0; cpt < LONGUEUR; cpt++) {
  //	printf("%d\n",tab[cpt] );
  //}
  
  //printf("%d/%d",v.x,v.y);
	/*
	int a = 12;
	int b = 10;
	printf("%d,%d\n",a,b );
	permute(&a,&b);
	printf("%d,%d\n",a,b );
	*/
  return 0;
}
