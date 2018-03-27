#include "tp6.h"


int lire_deux_octets(int fd, uint16 *val) {	
	return read(fd,val,2);
}

int lire_quatre_octets(int fd, uint32 *val) {
	return read(fd,val,4);
}


int ecrire_deux_octets(int fd, uint16 val) {
	return write(fd,&val,2);
}

int ecrire_quatre_octets(int fd, uint32 val) {
	return write(fd,&val,4);
}

int ecrire_bmp(int dest, entete_bmp *entete, unsigned char *pixels){
  if(ecrire_entete(dest, entete) == -1){
    printf("Erreur dans l'ecriture de l'entete");
    return -1;
  }
  if(ecrire_pixels(dest, entete, pixels) == -1){
    printf("Erreur dans l'ecriture des pixels");
    return -1;
  }
  return 0;
}



int lire_entete(int de, entete_bmp *entete) {
	int octetsLus = 0;
	//traitement pour entete fichier

	//traitement de la signature
	octetsLus += (int) lire_deux_octets(de,&entete->fichier.signature);
	printf("%x\n", entete->fichier.signature);
	//traitement de la taille fichier
	octetsLus += (int) lire_quatre_octets(de,&entete->fichier.taille_fichier);
	printf("taille du fichier = %d\n", entete->fichier.taille_fichier);
	//traitement de la reserve
	octetsLus += (int) lire_quatre_octets(de,&entete->fichier.reserve);
	printf("taille de la reserve = %x\n", entete->fichier.reserve);
	//traitement offset donnee
	octetsLus += (int) lire_quatre_octets(de,&entete->fichier.offset_donnees);
	printf("taille offset_donnees = %x\n", entete->fichier.offset_donnees);

	//traitement bitmap

	//traitement pour entete bitmap
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.taille_entete);
	printf("taille entete_bitmap = %d\n", entete->bitmap.taille_entete);
	//traitement pour largeur
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.largeur);
	printf("taille largeur = %d\n", entete->bitmap.largeur);
	//traitement pour hauteur
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.hauteur);
	printf("taille hauteur = %d\n", entete->bitmap.hauteur);
	//traitement pour nombre plan
	octetsLus += (int) lire_deux_octets(de,&entete->bitmap.nombre_plans);
	printf("taille nombre_plans = %d\n", entete->bitmap.nombre_plans);
	//traitement pour profondeur
	octetsLus += (int) lire_deux_octets(de,&entete->bitmap.profondeur);
	printf("taille profondeur = %d\n", entete->bitmap.profondeur);
	//traitement pour compression
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.compression);
	printf("taille compression = %d\n", entete->bitmap.compression);
	//traitement pour taille donnees image
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.taille_donnees_image);
	printf("taille taille_donnees_image = %d\n", entete->bitmap.taille_donnees_image);
	//traitement pour resolution horizontale
	octetsLus+= (int) lire_quatre_octets(de,&entete->bitmap.resolution_horizontale);
	printf("taille resolution horizontale = %d\n", entete->bitmap.resolution_horizontale);
	//traitement pour resolution verticale
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.resolution_verticale);
	printf("taille resolution_verticale = %d\n", entete->bitmap.resolution_verticale);
	//traitement pour taille palette
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.taille_palette);
	printf("taille taille_palette = %d\n", entete->bitmap.taille_palette);
	//traitement pour nombre de couleurs importantes
	octetsLus += (int) lire_quatre_octets(de,&entete->bitmap.nombre_de_couleurs_importantes);
	printf("taille nombre_de_couleurs_importantes = %d\n", entete->bitmap.nombre_de_couleurs_importantes);
	if (octetsLus != 54 ) {
		printf("erreur \n");
		return -1;
	}
	printf("octetsLus %d \n", octetsLus );
	return 0;
}

int ecrire_entete(int vers, entete_bmp *entete) {
	int cpt = 0;
	//traitement entete fichier

	//traitement signature
	cpt += ecrire_deux_octets(vers,entete->fichier.signature);
	printf("ecriture dans fichier %x\n", entete->fichier.signature);
	//traitement taille fichier
	cpt += 	ecrire_quatre_octets(vers,entete->fichier.taille_fichier);
	printf("ecriture taille fichier %d\n", entete->fichier.taille_fichier);
	//traitement reserve
	cpt += ecrire_quatre_octets(vers,entete->fichier.reserve);
	printf("ecriture reserve %x\n",entete->fichier.reserve);
	//traitement offsett
	cpt += ecrire_quatre_octets(vers,entete->fichier.offset_donnees);
	printf("ecriture offset_donnees %x\n", entete->fichier.offset_donnees);


	//traitement entete bitmap

	//traitement taille entete
	cpt += ecrire_quatre_octets(vers,entete->bitmap.taille_entete);
	printf("ecriture taille entete %x\n", entete->bitmap.taille_entete);
	//traitement largeur
	cpt += ecrire_quatre_octets(vers,entete->bitmap.largeur);
	printf("ecriture taille largeur %d\n", entete->bitmap.largeur);
	//traitement hauteur
	cpt += ecrire_quatre_octets(vers,entete->bitmap.hauteur);
	printf("ecriture taille hauteur %d\n", entete->bitmap.hauteur);
	//traitement nombre de plan 
	cpt += ecrire_deux_octets(vers,entete->bitmap.nombre_plans);
	printf("ecriture nombre de plans %d\n", entete->bitmap.nombre_plans);
	//traitement profondeur
	cpt += ecrire_deux_octets(vers,entete->bitmap.profondeur);
	printf("ecriture profondeur %d\n", entete->bitmap.profondeur);
	//traitement compression
	cpt += ecrire_quatre_octets(vers,entete->bitmap.compression);
	printf("ecriture compression %d\n", entete->bitmap.compression);
	//traitement taille donnees images
	cpt += ecrire_quatre_octets(vers,entete->bitmap.taille_donnees_image);
	printf("ecriture taille_donnees_image %d\n", entete->bitmap.taille_donnees_image);
	//traitement resolution horizontale
	cpt += ecrire_quatre_octets(vers,entete->bitmap.resolution_horizontale);
	printf("ecriture resolution_horizontale %d\n", entete->bitmap.resolution_horizontale);
	//traitement resolution verticale
	cpt += ecrire_quatre_octets(vers,entete->bitmap.resolution_verticale);
	printf("ecriture verticale  %d\n", entete->bitmap.resolution_verticale);
	//traitement taille palette
	cpt += ecrire_quatre_octets(vers,entete->bitmap.taille_palette);
	printf("ecriture  taille_palette %d\n", entete->bitmap.taille_palette);
	//traitement nb couleurs importantes
	cpt += ecrire_quatre_octets(vers,entete->bitmap.nombre_de_couleurs_importantes);
	printf("ecriture nombre_de_couleurs_importantes %d\n", entete->bitmap.nombre_de_couleurs_importantes);

	if (cpt != 54) {
		printf("erreur\n");
		return -1;
	}

	return 0;
}


int verifier_entete(entete_bmp *entete) {
	if (entete->bitmap.profondeur != 24)  {
		return -1;
	}
	return 0;
}


unsigned char* allouer_pixels(entete_bmp *entete) {
	return malloc(entete->bitmap.taille_donnees_image);
}

int lire_pixels(int de, entete_bmp *entete, unsigned char *pixels){

	unsigned int tmp = 0;

	while (tmp != entete->bitmap.taille_donnees_image ) {
		int nlu = read(de, pixels + tmp , entete->bitmap.taille_donnees_image - tmp ) ;
		if (nlu <= 0) {
			return 1;
		}
		tmp += nlu;
	}

	return 0;
}

int ecrire_pixels(int vers, entete_bmp *entete, unsigned char *pixels){
	
	unsigned int tmp = 0;

	while (tmp != entete->bitmap.taille_donnees_image) {
		int necrit = write(vers, pixels + tmp , entete->bitmap.taille_donnees_image - tmp ) ;
		if (necrit <= 0 ) {
			return 1;
		}
		tmp += necrit;
		if (tmp > 1000) {
			return 1;
		}
	}
	return 0;
}

int copier_bmp(int de, int vers) {
	entete_bmp entete;
	unsigned char *pixels;
	/* lecture du fichier source */
	lire_entete(de, &entete);
	pixels = allouer_pixels(&entete);
	lire_pixels(de, &entete, pixels);
	/* écriture du fichier destination */
	ecrire_entete(vers, &entete);
	ecrire_pixels(vers, &entete, pixels);
	/* on libère les pixels */
	free(pixels);
	return 1; /* on a réussi */
}


void rouge(entete_bmp *entete, unsigned char * pixels){
	int taille = 3*entete->bitmap.largeur;
	int cpt = 0;
	int unsigned i;
	int unsigned j;
	for(i=0; i< entete->bitmap.hauteur; i++){
		for(j=0; j< entete->bitmap.largeur; j++){
			pixels[cpt]=0;
			pixels[cpt+1]=0;      
			cpt += 3;
		}
		cpt += taille%4;
	}
}

void negatif(entete_bmp *entete, unsigned char *pixels) {
	int taille = 3*entete->bitmap.largeur;
	int cpt = 0;
	int unsigned i;
	int unsigned j;
	for(i=0; i< entete->bitmap.hauteur; i++){
		for(j=0; j< entete->bitmap.largeur; j++){
			pixels[cpt]=~pixels[cpt];
			pixels[cpt+1]=~pixels[cpt+1]; 
			pixels[cpt+2]=~pixels[cpt+2];
			cpt += 3;
		}
		cpt += taille%4;
	}
}

void noirEtBlanc(entete_bmp *entete, unsigned char *pixels){
	int taille = 3*entete->bitmap.largeur;
	int cpt = 0;
	int unsigned i;
	int unsigned j;
	int val=0;
	for(i=0; i<entete->bitmap.hauteur; i++){
		for(j=0; j<entete->bitmap.largeur; j++){
			val=(pixels[cpt]+pixels[cpt+1]+pixels[cpt+2])/3;
			pixels[cpt]=val;
			pixels[cpt+1]=val;
			pixels[cpt+2]=val;
			cpt += 3;
		}
		cpt += taille%4;
	}
}

void moitie(entete_bmp *entete, unsigned char *pixels, int sup){
	unsigned int i;
 	unsigned int new_taille =  entete->bitmap.taille_donnees_image/2;
 	if(sup==1){
      	unsigned int j = new_taille;
      	for(i=0;i < new_taille; i++){
	 	 	pixels[i] = pixels[j];
	  		j++;
		}
    }
  	entete->bitmap.taille_donnees_image = new_taille;
  	entete->fichier.taille_fichier -= new_taille;
 	entete->bitmap.hauteur = entete->bitmap.hauteur/2;
}


int length(const char* arg){
  return (arg[0]=='\0')?0:1+length(&arg[1]);
}

int main(int argc, char **argv){
  if(argc < 2){
    printf("Erreur : Pas de fichier en parametre.\n");
    return -1;
  }

  int file = -1, dest = -1, nbArg;
  entete_bmp ebmp;
  unsigned char * pixels;
  for(nbArg = 1; nbArg < argc; nbArg++){
    if(argv[nbArg][0] != '-'){
      if (file == -1){
	file = open(argv[nbArg], O_RDONLY);
	printf("File opened : %d\n", file);
	if(lire_entete(file, &ebmp) == -1 || !verifier_entete(&ebmp)){
	  printf("Erreur lors de la lecture de l'entete du fichier.\n");
	  return -1;
	}
	printf("Entete lue\n");
       	pixels = allouer_pixels(&ebmp);
	if(lire_pixels(file, &ebmp, pixels) == 0){
	  printf("Erreur lors de la lecture des pixels.\n");
	  return -1;
	}
	printf("Pixels alloues et lus\n");
      }else if (dest == -1){
	dest = open(argv[nbArg], O_CREAT|O_TRUNC|O_WRONLY, 0644);
	printf("Fichier dest cree a partir d'argument\n");
      }else {
	printf("Erreur : trop d'arguments.\n");
	return -1;
      }
    }
  }
  if(file == -1){
    printf("Erreur : pas de fichier en entree.\n");
    return -1;
  }else if(dest == -1){
    dest = open("bmpModified.bmp", O_CREAT|O_TRUNC|O_WRONLY, 0644);
    printf("Fichier cree par defaut\n");
  }
  for(nbArg = 1; nbArg < argc; nbArg++){
    if(argv[nbArg][0] == '-'){
      int idx;
      for(idx = 1; idx < length(argv[nbArg]); idx++){
	if(argv[nbArg][idx] == 'r'){
	  rouge(&ebmp, pixels);
       	}else if(argv[nbArg][idx] == 'n'){
	  negatif(&ebmp, pixels);
       	}else if(argv[nbArg][idx] == 'b'){
	  noirEtBlanc(&ebmp, pixels);
       	}else if(argv[nbArg][idx] == 's'){
	  moitie(&ebmp, pixels, 1);
       	}else if(argv[nbArg][idx] == 'i'){
	  moitie(&ebmp, pixels, 0);
       	}
      }
    }
  }
  
  if(ecrire_bmp(dest, &ebmp, pixels)==-1) return -1;
  
  close(file);
  close(dest);
  free(pixels);
  return 0;
}
