package Mobile;

public class Principal {

public static void main(String[] args) {
		
		Relogio r = new Relogio(28, 2, 2001);
		System.out.println(r);
		
		for(int i = 0; i < 86400 * 2; i++) {
			r.tictac();
			System.out.println(r);
		}
	}
}
