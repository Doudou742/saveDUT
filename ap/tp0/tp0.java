public class tp0 extends Program{
    void testF(){
	assertEquals(f(7), 42);
    }

    int f(int x){
	int f_x;
	f_x = 7 * x + 7;
	return f_x;
    }
}
