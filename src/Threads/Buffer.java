package Threads;

//Interface buffer especifica métodos chamados por produtor e consumidor
public interface Buffer {

	//coloca o valor int no buffer
	public void blockingPut(int value) throws InterruptedException;
	
	//retorna o valor int a partir do buffer
	public int blockingGet() throws InterruptedException;
}//fim da interface buffer
