#Constantes
CC = gcc
CFLAGS = -Werror -W -Wall


#Regle 1
tp3: chaines.o
	$(CC) -o $@ $^
# $ a permet de fait reference a tp1, $^ fait reference au .o

#Regle 2
%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<
# pour les .o fait reference .c



#Regle 3
