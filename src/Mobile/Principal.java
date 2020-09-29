package Mobile;

public class Principal {

public static void main(String[] args) {
		
		IHorario h = new HorarioNG();
		
		//a posição ainda altera o resultado, não consegui modificar isso.
		
		h.setMinuto(45);
		
		h.setSegundo(32);	

		h.setHora(22);
		
		System.out.println(h.getHora());
	}
}