package Mobile;

public class Principal {

public static void main(String[] args) {
		
		IHorario h = new HorarioNG();
		
		//a posi��o ainda altera o resultado, n�o consegui modificar isso.
		
		h.setMinuto(45);
		
		h.setSegundo(32);	

		h.setHora(22);
		
		System.out.println(h.getHora());
	}
}