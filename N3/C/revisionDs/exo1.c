#include <stdio.h>
#include <unistd.h>

int main ( void )
{
	printf ("Un\n");
	fork (); fork (); fork ();
	printf ("Deux\n");
	if ( fork () == 0) printf ("Trois\n");
	printf ("Quatre\n");
	return 0;
}
