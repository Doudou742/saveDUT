#include <stdio.h>

void afficher(int liste[], int taille) {
  int i;
  for(i = 0; i < taille; i++) {
    printf("%d\n", liste[i]);
  }
}

int somme(int liste[], int taille) {
  int somme = 0;
  int idx;
  for(idx = 0; idx < taille; idx++) {
    somme += liste[idx];
  }
  return somme;
}

void copie_dans(int dest[], int src[], int taille) {
  int idx;
  for(idx = 0; idx < taille; idx++) {
    dest[idx] = src[idx];
  }
}

void ajoute_apres(int dest[], int taille_dest, int src[], int taille_src) {
  int idx;
  for (idx = taille_src; idx < taille_dest; idx++) {
    dest[idx] = src[idx-taille_src];
  }
}

int main(void) {
  int tab[100] = {1,2,3};
  int tab2[3] = {4,5,6};
  afficher(tab,3);
  copie_dans(tab2, tab, 3);
  printf("somme = %d\n", somme(tab,3));
  printf("nouveau tab\n");
  afficher(tab2, 3);
  ajoute_apres(tab, 100, tab2, 3);
  afficher(tab,6);
  return 0;
}