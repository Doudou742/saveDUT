#include "deftypes.h"
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>

int lire_deux_octets(int fd, uint16 *val){
  return read(fd, val, 2);
}

int lire_quatre_octets(int fd, uint32 *val){
  return read(fd, val, 4);
}

int ecrire_deux_octets(int fd, uint16 val){
  return write(fd, &val, 2);
}

int ecrire_quatre_octets(int fd, uint32 val){
  return write(fd, &val, 4);
}

int bourrage(entete_bmp *entete){
  int tailleMod = (entete -> bitmap.largeur * (entete -> bitmap.profondeur) / 8) % 4;
  if(tailleMod == 0) return 0;
  return 4 - tailleMod;
}

int verifier_entete(entete_bmp *entete){
  printf("bourrage : %d",bourrage(entete));
  
  return entete -> bitmap.profondeur == 24 && (entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete)) * entete -> bitmap.hauteur == entete -> bitmap.taille_donnees_image;
}

int lire_entete(int de, entete_bmp *entete){
  lseek(de, 0, SEEK_SET);
  int nbBytes = 0;
  nbBytes += lire_deux_octets(de, &(entete -> fichier.signature));
  nbBytes += lire_quatre_octets(de, &(entete -> fichier.taille_fichier));
  nbBytes += lire_quatre_octets(de, &(entete -> fichier.reserve));
  nbBytes += lire_quatre_octets(de, &(entete -> fichier.offset_donnees));
      
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.taille_entete));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.largeur));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.hauteur));
  nbBytes += lire_deux_octets(de, &(entete -> bitmap.nombre_plans));
  nbBytes += lire_deux_octets(de, &(entete -> bitmap.profondeur));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.compression));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.taille_donnees_image));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.resolution_horizontale));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.resolution_verticale));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.taille_palette));
  nbBytes += lire_quatre_octets(de, &(entete -> bitmap.nombre_de_couleurs_importantes));
  if(nbBytes != 54) return -1;
  return 0;
}

int ecrire_entete(int de, entete_bmp *entete){
  lseek(de, 0, SEEK_SET);
  int nbBytes = 0;
  nbBytes += ecrire_deux_octets(de, entete -> fichier.signature);
  nbBytes += ecrire_quatre_octets(de, entete -> fichier.taille_fichier);
  nbBytes += ecrire_quatre_octets(de, entete -> fichier.reserve);
  nbBytes += ecrire_quatre_octets(de, entete -> fichier.offset_donnees);
      
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.taille_entete);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.largeur);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.hauteur);
  nbBytes += ecrire_deux_octets(de, entete -> bitmap.nombre_plans);
  nbBytes += ecrire_deux_octets(de, entete -> bitmap.profondeur);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.compression);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.taille_donnees_image);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.resolution_horizontale);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.resolution_verticale);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.taille_palette);
  nbBytes += ecrire_quatre_octets(de, entete -> bitmap.nombre_de_couleurs_importantes);
  printf("Nb Bytes : %d", nbBytes);
  if(nbBytes != 54) return -1;
  return 0;
}

unsigned char* allouer_pixels(entete_bmp *entete){
  int taille = (entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete)) * entete -> bitmap.hauteur;
  unsigned char* tab = (unsigned char*) malloc(taille * sizeof(unsigned char));
  return tab;
}

int lire_pixels(int de, entete_bmp *entete, unsigned char *pixels){
  lseek(de, entete -> fichier.offset_donnees, SEEK_SET);
  //int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int nbALire = entete -> bitmap.taille_donnees_image;
  int nbLus = (int) read(de, pixels, nbALire);
  printf("Offset : %d File : %d %d %d",entete -> fichier.offset_donnees, de, nbLus, nbALire);
  return nbLus == nbALire;
}

int ecrire_pixels(int vers, entete_bmp *entete, unsigned char *pixels){
  lseek(vers, entete -> fichier.offset_donnees, SEEK_SET);
  // int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int nbAEcrire = entete -> bitmap.taille_donnees_image;
  int nbEcrits = write(vers, pixels, nbAEcrire);
  printf("Offset : %d File : %d %d %d",entete -> fichier.offset_donnees, vers, nbEcrits, nbAEcrire);
  return nbEcrits == nbAEcrire;
}

void rouge(entete_bmp *entete, unsigned char *pixels){
  //int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int i, j;
  size_t curseur = 0;
  for(i = 0; i < (int) entete -> bitmap.hauteur; i++){
    for(j = 0; j < (int) entete -> bitmap.largeur; j++){
      pixels[curseur] = 0;
      pixels[curseur+1] = 0;
      curseur += 3;
    }
    curseur += bourrage(entete);
  }
}

void negatif(entete_bmp *entete, unsigned char *pixels){
  int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int i, j;
  for(i = 0; i < (int) entete -> bitmap.hauteur; i++){
    for(j = 0; j < largeur; j++){
      pixels[i*largeur+j] = ~pixels[i*largeur+j]; 
    }
  }
}

void noir_et_blanc(entete_bmp *entete, unsigned char *pixels){
  int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int i, j;
  unsigned char moy;
  for(i = 0; i < (int) entete -> bitmap.hauteur; i++){
    for(j = 0; j < largeur; j++){
      if(j%3 == 0 && j>0){
	moy =  (pixels[i*largeur+j-2] + pixels[i*largeur+j*1] + pixels[i*largeur+j]) / 3;
	pixels[i*largeur+j-2] = moy;
	pixels[i*largeur+j-1] = moy;
	pixels[i*largeur+j] = moy;
      }
    }
  }
}

void moitie(entete_bmp *entete, unsigned char *pixels, int sup){
  int largeur =  entete -> bitmap.largeur * (entete -> bitmap.profondeur / 8) + bourrage(entete);
  int i, j;
  if(entete -> bitmap.hauteur%2 == 0){
    entete -> bitmap.hauteur/=2;
  }else {
    entete -> bitmap.hauteur=(entete -> bitmap.hauteur-1)/2;
  }
  entete -> bitmap.taille_donnees_image = largeur*entete -> bitmap.hauteur;
  entete -> fichier.taille_fichier = entete -> bitmap.taille_donnees_image + entete -> fichier.offset_donnees;
  
  if(sup == 1){
    for(i = 0; i < (int) entete -> bitmap.hauteur; i++){
      for(j = 0; j < largeur; j++){
	pixels[i*largeur+j] = pixels[(i+entete -> bitmap.hauteur)*largeur+j];
      }
    }
  }
 
}

int copier_bmp(int de, int vers)
{
  entete_bmp entete;
  unsigned char *pixels;
  /* lecture du fichier source */
  lire_entete(de, &entete);
  pixels = allouer_pixels(&entete);
  if(lire_pixels(de, &entete, pixels) == 0) return -1;
  /* écriture du fichier destination */
  ecrire_entete(vers, &entete);
  ecrire_pixels(vers, &entete, pixels);
  /* on libère les pixels */
  free(pixels);
  return 1; /* on a réussi */
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
	  noir_et_blanc(&ebmp, pixels);
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
