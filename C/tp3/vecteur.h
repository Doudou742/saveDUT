#define LONGUEUR 3

/*******************************/
/* Définir ici le type vecteur */
/*******************************/

typedef struct{
	int x;
	int y;
}vecteur;

int norme(vecteur);

void afficher(vecteur[]);

int maximum(vecteur[]);

void trier(vecteur[]);

void trier2(vecteur[], int[]);

void afficher2(vecteur[], int[]);

void trier3(vecteur* []);

void afficher3(vecteur* []);

void permute(int *a, int *b);
