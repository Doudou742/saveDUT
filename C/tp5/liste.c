#include <stdio.h>
#include <stdlib.h>

struct cell
{
	int val;
	struct cell *nxt;	
};
//pointeur sur la première cellule de la liste
typedef struct cell* list;

int head(list lst) {
	return lst->val;
}

//renvoie la queue de la liste passe en parametre 
list tail(list l) {
	return l->nxt;
}

int nbElement(list l) {
	if (l == NULL) {
		return 0;
	}
	return nbElement(l->nxt)+1;
}	

print_list(list l) {
	int i;
	struct cell *tmp = l;
	for (i = 0; i < nbElement(l) && l != NULL; i++) {
		printf("%d \n",  *tmp);
		tmp = tmp->nxt;
	}
}

//important à savoir faire avec les malloc qui allouent un espace mémoire
list cons(int v, list l) {
	struct cell* m = (struct cell*) malloc(sizeof(struct cell));
	m->val = v;
	m->nxt = l;
	return m;	
}

list append(list l1, list l2) {
	if (!l1) {
		return l2;
	}
	list tmp = l1;
	while(tmp->nxt) {
		tmp = tmp->nxt;
	}
	tmp->nxt=l2;
	return l1;
}

list reverse(list l) {
	list tmp = l;
	list r = NULL;
	list p;
	while(tmp != NULL) {
		p = tmp;
		tmp = tmp->nxt;
		p->nxt = r;
		r = p;
	}
	return r;
}

int main(void) {
	list maliste = NULL;
	struct cell m2 = {2,NULL};
	struct cell m3 = {1,&m2};
	maliste = &m3;
	/*
	list maliste2 = NULL;
	struct cell m4 =  {4,NULL};
	struct cell m5 = {3,&m4};
	maliste2 = &m5;
	print_list(append(maliste,maliste2));
	*/
	print_list(reverse(maliste));
	//printf("%d \n", nbElement(maliste) );
	//printf("%d \n",head(maliste));
	//printf("%d \n",tail(maliste));
	return 0;
}