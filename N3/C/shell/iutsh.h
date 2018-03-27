#include <stdio.h>
#include "ligne_commande.h"
#include <unistd.h>
#include <stdlib.h>

void execute_ligne_commande();
void affiche_prompt();
int lance_commande(int in, int out, char *com, char ** argv);
