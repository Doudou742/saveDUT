#include <stdio.h>
int main(void)
{
  double x = 0.1;
  double s;
  double t;
  int signe = -1;
  t = x;
  s = x;
  int i;
  for (i = 3; i < 12; i = i + 2) {
    t = t * x * x / (i * (i-1));
    s = s + signe * t;
    signe = -signe;
    printf("i = %d; s = %10.9lf \n",i,s);
  }
}
