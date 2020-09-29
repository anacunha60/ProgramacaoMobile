package Mobile;

public class HorarioNG implements IHorario{
	
	private int segundos;

	@Override
	public boolean ehUltimoSegundo() {
		return segundos == 86399;
	}
	
	public HorarioNG() {
		segundos = 0;
	}
	
	public HorarioNG(int hora, int minuto, int segundo) {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	@Override
	public byte getHora() {
		return (byte)(segundos / 3600);
	}

	@Override
	public void setHora(int hora) {
		if(hora >= 0 && hora <= 23) {
			this.segundos = hora * 3600;
		}		
	}

	@Override
	public byte getMinuto() {
		return (byte)(this.segundos / 60);
	}

	@Override
	public void setMinuto(int minutos) {
		if(minutos >= 0 && minutos <= 59) {
			this.segundos = minutos * 60;
		}	
	}

	@Override
	public byte getSegundo() {
		return (byte)(this.segundos % 60);
	}

	@Override
	public void setSegundo(int segundo) {
		if(segundo >= 0 && segundo <= 59) {
			this.segundos = segundo;
		}	
		
	}
	
	public String toString() {
		return this.getHora() + ":" + this.getMinuto() + ":" + this.getSegundo();
	}

	@Override
	public void incrementaSegundo() {
		
	int s = this.getSegundo() + 1;
		
		if(s == 60) {
			this.setSegundo(0);
			incrementaMinuto();
		}else {
			this.setSegundo(s);
		}		
	}

	@Override
	public void incrementaMinuto() {
		int m = this.getMinuto() + 1;
		
		if(m == 60) {
			this.setMinuto(0);
			incrementaHora();
		}else {
			this.setMinuto(m);;
		}	
		
	}

	@Override
	public void incrementaHora() {
		int h = this.getHora() + 1;
		
		if(h == 24) {
			this.setHora(0);
			//incrementaDia();
		}else {
			this.setHora(h);
		}
		
	}

}
