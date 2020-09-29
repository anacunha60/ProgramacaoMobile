package Mobile;

public class Principal {

public static void main(String[] args) {
		
		IHorario h = new HorarioNG();
		
		//a posição ainda altera o resultado, não consegui modificar isso.
		
		h.setSegundo(59);	
		
		System.out.println(h.getHora());
		
		h.incrementaSegundo();
		
		System.out.println(h);
		
	}
}