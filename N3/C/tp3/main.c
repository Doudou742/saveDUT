#include <stdio.h>

/*int mon_strlen(char s[]){
  int length = 0;
  while(s[length] != '\0'){
    length++;
  }
  return length;
  }*/

int mon_strlen(const char *s){
  if(*s != '\0'){
    return 1+mon_strlen(s+1);
  }
  return 0;
}

int mon_strcmp(const char* s1, const char * s2){
  int idx = 0;
  for(;idx < mon_strlen(s1); idx++){
    if(s1[idx] < s2[idx]){
      return -1;
    }else if (s1[idx] > s2[idx]){
      return 1;
    }
  }
  return 0;
}
	
int mon_strncmp(const char * s1, const char * s2, int n){
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

int main(void){
  char s[] = {'0', 'a', '5', '\0'};
  const char* s1 = "test";
  const char* s2 = "test";
  const char* s3 = "Test";
  const char* s4 = "tesa";
  printf("length : %d\n", mon_strlen(s));
  printf("s1 compare s2 : %d\n", mon_strcmp(s1, s2));
  printf("s1 compare s3 : %d\n", mon_strcmp(s1, s3));
  printf("s1 compare s4 : %d\n", mon_strcmp(s1, s4));
  printf("s1 compare s4 on 3 char : %d\n", mon_strncmp(s1, s4, 3));
  return 0;
}
