#include <stdio.h>
#include <stdlib.h>
#include <math.h> 
int main(void){
	int tab[8];
	int j;
	int i;

	for(j=0;j<8;j++){
		tab[j]=0;
	}

		for(i=1;i<256;i++){
			incr(tab);
			int k;
			printf("%d en binaire ; ",i );
			for(k=7;k>=0;k--){
				printf("%d   ",tab[k]);
			}
			int l;
			int res=0;
			for(l=7;l>=0;l--){
				res+=(int)pow(2,l)*tab[l];
			}

			if(res==i){
				printf("Bonne réponse %d",res);
			}else {
				printf("Mauvaise réponse %d",res);
			}
			printf("\n");
		}



	return 0;
}