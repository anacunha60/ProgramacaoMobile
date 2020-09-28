package Mobile;

public class Horario {

	private byte hora; 
	private byte minuto;
	private byte segundo;
	
	public boolean ehUltimoSegundo() {
		return hora == 23 && minuto == 59 && segundo == 59;
	}

	public Horario() {
		hora = 0;
		minuto = 0;
		segundo = 0;
	}

	public Horario(int hora, int minuto, int segundo) {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	public byte getHora() {
		return hora;
	}

	public void setHora(int hora){
		if(hora >= 0 && hora <= 23) {
			this.hora = (byte)hora;
		}
	}

	public byte getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		if(minuto >= 0 && minuto <= 59) {
			this.minuto = (byte)minuto;
		}		
	}

	public byte getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		if(segundo >= 0 && segundo <= 59) {
			this.segundo = (byte)segundo;
		}		
	}
	
	@Override
	public String toString() {
		return this.getHora() + ":" + this.getMinuto() + ":" + this.getSegundo();
	}
	
	public void incrementaSegundo() {
		
		byte s = (byte)(segundo + 1);
		
		if(s == 60) {
			segundo = 0;
			incrementaMinuto();
		}else {
			segundo = s;
		}
	}

	public void incrementaMinuto() {
		int m = minuto + 1;
		
		if(m == 60) {
			minuto = 0;
			incrementaHora();
		}else {
			minuto = (byte)m;
		}		
	}

	public void incrementaHora() {
		int h = hora + 1;
		
		if(h == 24) {
			hora = 0;
			//incrementaDia();
		}else {
			hora = (byte)h;
		}
		
	}
}
