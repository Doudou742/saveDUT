#include <stdio.h>
/*
int mon_strlen(char s[]) {
  int i = 0;
  while (s[i] != '\0') {
    i++;
  }
  return i;
}
*/
int mon_strlen(const char *s) {
  if (*s != '\0'){
    return 1+ mon_strlen(s+1);
  }
  return 0;
}

int mon_strcmp(const char * s1, const char * s2) {
  int idx = 0;
  for(;idx < mon_strlen(s1);idx++){
    if (s1[idx] < s2[idx]) {
      return -1;
    }
    else if (s1[idx] > s2[idx]) {
      return 1;
    }
  }
  return 0;
}

int mon_strncmp(const char * s1, const char * s2, int n) {
  int idx = 0;
  for(;idx < n; idx++){
    if(s1[idx] < s2[idx]){
      return -1;
    }else if (s1[idx] > s2[idx]){
      return 1;
    }
  }
  return 0;
}

char *mon_strcat(char *s1, const char *s2) {
  int i = mon_strlen(s1);
  int j;
  for (j = 0; j < mon_strlen(s2); j++){
    *(s1+i+j) = *(s2 + j);
  }
  *(s1 + mon_strlen(s1)) = '\0';
  return s1;
}

char *mon_strchr(char *s, int c){
  char rep = (char) c;
  int longueur = mon_strlen(s);
  int cpt;
  for (cpt = 0; cpt < longueur; cpt++) {
    if (s[cpt] == rep) {
      return s + cpt;
    }
  }
  return NULL;
}

char *mon_strstr(char *haystack, char *needle){
  if (mon_strcmp(needle, haystack) == 0){
    return haystack;
  }
  
  else {
    if (mon_strlen(haystack) < mon_strlen(needle)){
      return NULL;
    }
    return mon_strstr(haystack+1, needle);
    
  }
}

int main(void) {
  char liste[8] = {'a', 'b','\0'};
  char liste2[5] = {'g', 'h', 'i', 'j', '\0'};
  mon_strlen(&liste[0]);
  printf("\n taille tableau : %d \n", mon_strlen(liste));
  printf("\n taille liste2: %d \n", mon_strlen(liste2));
  printf("\n strcmp liste a liste2: %d \n", mon_strcmp(liste, liste2));
  printf("\n strcmp liste a liste2 sur n char: %d \n", mon_strncmp(liste,liste2,1));
  printf("%s \n", mon_strcat(liste,liste2));
  printf("%s \n", mon_strchr(liste2, (int) 'i'));
  printf("%s \n", mon_strstr(liste2, "hij1")); 
  return 0;
}
