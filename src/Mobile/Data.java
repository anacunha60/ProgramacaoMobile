package Mobile;

public class Data {

	private byte dia;
	private byte mes;
	private short ano;
	
	private int calcularUltimoDia() {
		int valores[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(ehFevereiro() && ehBissexto()) {
			return 29;
		}
		
		return valores[mes - 1];
	}

	private boolean ehFevereiro() {
		return mes == 2;
	}

	private boolean ehBissexto() {
		return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
	}

	public Data() {
		this.dia = 1;
		this.mes = 1;
		this.ano = 1;
	}

	public Data(int dia, int mes, int ano) {
		this();
		setAno((short) ano);
		setMes((byte) mes);
		setDia((byte) dia);
	}

	public byte getDia() {
		return dia;
	}

	public void setDia(int dia) {

		int ultimoDia = calcularUltimoDia();

		if (dia >= 1 && dia <= ultimoDia) {
			this.dia = (byte)dia;
		}
	}

	public byte getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes >= 1 && mes <= 12) {
			this.mes = (byte)mes;
		}
	}

	public short getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano >= 1 && ano <= 9999) {
			this.ano = (short)ano;
		}
	}

	@Override
	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}

	
	public void incrementaDia() {
		
		int d = dia + 1;
		
		if(d == calcularUltimoDia() + 1) {
			dia = 1;
			incrementaMes();
		}else {
			dia = (byte)d;
		}		
	}

	private void incrementaMes() {
		int m = mes + 1;
		
		if(m == 13) {
			mes = 1;
			incrementaAno();
		}else {
			mes = (byte)m;
		}		
	}

	private void incrementaAno() {
		int a = ano + 1;
		
		if(a == 10000) {
			ano = 1;
		}else {
			ano = (short)a;
		}
		
	}
	
}
