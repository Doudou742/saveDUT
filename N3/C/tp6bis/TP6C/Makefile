.SUFFIXES:

#CONST
CC = gcc
FLAGS = -g -Wall -W -Werror
FILENAME = main
SRC = $(wildcard *.c)
OBJS = $(SRC:.c=.o)

#EXECUTABLE GENERATION
$(FILENAME):$(OBJS)
	$(CC) $(FLAGS) -o $@ $^
#GENERIC COMPILATION
%.o:%.c
	$(CC) $(FLAGS) -c $< -o $@
#CLEANING
clean:
	rm -f *.o

real-clean:
	make clean
	rm -f $(FILENAME)
#GRANT ACCESS
install:
	chmod 755 $(FILENAME)
