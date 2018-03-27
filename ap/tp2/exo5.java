class exo5 extends Program {
    void testTri() {
	int[] nombresTries = new int[]{1, 2, 3};
	assertArrayEquals(nombresTries, tri(1, 2, 3));
	assertArrayEquals(nombresTries, tri(1, 3, 2));
	assertArrayEquals(nombresTries, tri(2, 1, 3));
	assertArrayEquals(nombresTries, tri(2, 3, 1));
	assertArrayEquals(nombresTries, tri(3, 1, 2));
	assertArrayEquals(nombresTries, tri(3, 2, 1));
    }


    int[] tri(int a, int b, int c) {

	int tmp;
	
	if ( a > b ){
	    tmp = a;
	    a = b;
	    b = tmp;
	}

	if ( a > c ){
	    tmp = a;
	    a = c;
	    c = tmp;
	}
	
	if ( b > c ){
	    tmp = b;
	    b = c;
	    c = tmp;
	}
	    
	return new int[]{a, b, c}; // Interdit de modifier cette ligne !
    }

    
}
