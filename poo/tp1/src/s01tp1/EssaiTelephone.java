package s01tp1;
import tps.Telephone;
import java.util.*;
public class EssaiTelephone{
    public static void main(String[] arg){
	for (int i = 0; i < 5; i++){
	    Telephone num = new Telephone(i*11,i*11,i*11,i*11,i*11);
	    System.out.println(num);
	}
	System.out.println();
	System.out.println();

	int x = Integer.valueOf(arg[0]);
	for ( int i = 0; i < x ; i++ ){
	    int a = new Random().nextInt(10);
	    int b = new Random().nextInt(100);
	    int c = new Random().nextInt(100);
     	    int d = new Random().nextInt(100);				    	            int e = new Random().nextInt(100);
	    System.out.println(new Telephone(a,b,c,d,e));
					     
	}
    }
}
