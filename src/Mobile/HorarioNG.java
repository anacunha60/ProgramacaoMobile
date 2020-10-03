package Mobile;

public class HorarioNG implements IHorario{
	
	private int segundos;

	@Override
	public boolean ehUltimoSegundo() {
		return segundos == 86399;
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
			this.segundos -= getHora();
			this.segundos += hora * 3600;
		}		
	}

	@Override
	public byte getMinuto() {
		return (byte)(this.segundos / 60 % 60);
	}

	@Override
	public void setMinuto(int minutos) {
		if(minutos >= 0 && minutos <= 59) {
			this.segundos -= getMinuto();
			this.segundos += minutos * 60;
		}	
	}

	@Override
	public byte getSegundo() {
		return (byte)(this.segundos % 60);
	}

	@Override
	public void setSegundo(int segundo) {
		if(segundo >= 0 && segundo <= 59) {
			this.segundos -= getSegundo();
			this.segundos += segundo;
		}	
		
	}

	@Override
	public void incrementaSegundo() {
		
	int s = this.segundos + 1;
		
		if(s == 86400) {
			this.segundos = 0;
		}else {
			this.segundos = s;
		}		
	}

	@Override
	public void incrementaMinuto() {
		for(int i = 0; i < 60; i++) {
			incrementaSegundo();
		}
		
	}

	@Override
	public void incrementaHora() {
		for(int i = 0; i < 3600; i++) {
			incrementaSegundo();
		}
		
	}
	
	public String toString() {
		return this.getHora() + ":" + this.getMinuto() + ":" + this.getSegundo();
	}

}
