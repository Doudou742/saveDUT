#include <stdio.h>
#include <math.h>

int b2d() {
  int t = 0;
  char c;
  int res = 0;
  while (c != '\n') {
    t = getchar();
    c = t;
    if (c != '0' && c != '1' && c != '\n') {
      return -1;
    }
    res = res * 2;
    if (c == '1') {
      res++;
    }
  }
  res = res / 2;
  printf("%d\n", res);
  return res;
  
}

int main(void) {
  b2d();
  return 0;
}
