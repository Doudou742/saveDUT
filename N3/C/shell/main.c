#include "iutsh.h"
#include <stdio.h>
#include "ligne_commande.h"
#include <unistd.h>
#include <stdlib.h>

int main(void){
  
  while(1){
    affiche_prompt();
    execute_ligne_commande();
  }
  
  return 0;
}
