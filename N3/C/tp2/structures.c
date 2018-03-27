#include <stdio.h>

struct rat {
  int den;
  int num;
};

struct rat rat_produit(struct rat n1, struct rat n2) {
  struct rat reponse;
  reponse.den = n1.den * n2.den;
  reponse.num = n1.num * n2.num;
  return reponse;
}

struct rat rat_somme(struct rat n1, struct rat n2) {
  struct rat reponse;
  reponse.den = n1.den * n2.num + n1.num * n2.den;
  reponse.num = n1.num * n2.num;
  return reponse;
}

struct rat rat_plus_petit(struct rat liste[]) {
  struct rat reponse = liste[0];
  int i = 0;
  float res = 100;
  while (liste[i].den != 0) {
    float rat = liste[i].num/liste[i].den;
    if ( rat < res) {
      res = rat;
      reponse = liste[i];
    }
    i++;
  }
  return reponse;
}

void afficher_rat(struct rat n1) {
  printf("%d / %d\n", n1.den, n1.num);
}

int main(void) {
  struct rat rat1;
  rat1.den = 2;
  rat1.num = 3;
  struct rat rat2;
  rat2.den = 2;
  rat2.num = 4;
  struct rat rat3;
  rat3.den = 0;
  rat3.num = 0;
  struct rat liste[3] = { rat1, rat2, rat3 };
  printf("produit \n");
  afficher_rat(rat_produit(rat1,rat2));
  printf("somme \n");
  afficher_rat(rat_somme(rat1,rat2));
  printf("plus petit \n");
  afficher_rat(rat_plus_petit(liste));

  
}
