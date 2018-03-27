#include <stdio.h>

int incr(int t[8]) {

  int cpt;
  for (cpt = 0; cpt < 8; cpt = cpt + 1){
    if (t[cpt] == 0){
      t[cpt] = 1;
      return -1;
    }
    else {
      t[cpt] = 0;
    }
  }
  if (t[7] == 0){
    return 0;
  }
  else {
    return -1;
  }
  return 0;
  
}

