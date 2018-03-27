class RenduMonnaie extends Program {
    void testRendreMonnaie() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 1}, rendreMonnaie(1));
        assertArrayEquals(new int[]{0, 0, 0, 2, 0}, rendreMonnaie(4));
        assertArrayEquals(new int[]{0, 0, 1, 0, 0}, rendreMonnaie(5));
        assertArrayEquals(new int[]{0, 1, 0, 1, 1}, rendreMonnaie(13));
        assertArrayEquals(new int[]{1, 0, 1, 1, 1}, rendreMonnaie(28));
    }
    int[] rendreMonnaie(int somme) {
        int nb20, nb10, nb5, nb2, nb1, reste;
        // à vous de compléter ici
        // ...
        // Ne pas modifier la ligne ci-dessous
	nb20 = somme / 20;
	reste = somme % 20;
	nb10 = reste / 10;
	reste
        return new int[]{nb20, nb10, nb5, nb2, nb1};
    }
