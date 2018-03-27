#include <stdio.h>
#include "vecteur.h"

int norme(vecteur v){
  // TODO
  return v.x+v.y;
}

void afficher(vecteur m[]){
  // TODO
  int i;
  for (i = 0; i < LONGUEUR; i++) {
    printf("%d/%d \n",m[i].x, m[i].y);   
  }
}

int maximum(vecteur m[]){
  // TODO
  int res = 0;
  int i;
  for (i = 0; i < LONGUEUR; i++) {
    if (norme(m[i]) > norme(m[res])) {
      res = i;
    
    }

  }
  return res;
}

// tri à bulles
void trier(vecteur m[]){
  // TODO
  
  int taille = LONGUEUR;
  vecteur tmp;
 
  int i;
  int j;
  int p = 0;
  int bol = 1;
  do {
    bol = 0;
    for (j = 0; j < taille-1-p; j++) {
      if (norme(m[j+1]) < norme(m[j])) {
        tmp = m[j];
        m[j] = m[j+1];
        m[j+1] = tmp;
        bol = 1;
      }
    }
    p += 1;
  } while (bol == 1);
  
}

void trier2(vecteur m[], int ordre[]){
  // TODO
  int i;
  int tmp;
  int p = 0;
  int bol = 1;
  do {
    bol = 0;
    for (i = 0; i < LONGUEUR-1-p; i++){
      if (norme(m[ordre[i+1]]) < norme(m[ordre[i]])) {
        tmp = ordre[i];
        ordre[i] = ordre[i+1];
        ordre[i+1] = tmp;
        bol = 1;
      }
    }
    p += 1;
  } while (bol == 1);

}

void trier2_p(vecteur m[], int ordre[]) {
  int i;
  int tmp;
  int tmp2;
  int p = 0;
  int bol = 1;
  do {
    bol = 0;
    for (i = 0; i < LONGUEUR-1-p; i++){
      if (norme(m[ordre[i+1]]) < norme(m[ordre[i]])) {
        permute(&(ordre[i]),&(ordre[i+1]));
        bol = 1;
      }
    }
    p += 1;
  } while (bol == 1);

}

void afficher2(vecteur m[], int ordre[]){
  // TODO
  int i;
  for (i = 0; i < LONGUEUR; i++) {
    printf("%d/%d a pour indice %d\n",m[ordre[i]].x,m[ordre[i]].y,i );
  }
}

void permute(int *a, int *b) {
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

void swap(vecteur* a, vecteur* b){
  // TODO
  vecteur* tmp = a;
  a = b;
  b = tmp;
}

void trier3(vecteur* a[]){
  // TODO
}

void afficher3(vecteur* a[]){
  // TODO
}
