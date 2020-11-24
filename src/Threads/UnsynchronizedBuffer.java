package Threads;

public class UnsynchronizedBuffer implements Buffer {
	
	private int buffer = -1;//compartilhado pelas threads produtor e consumidor
	
	//coloca o valor ao buffer
	@Override
	public void blockingPut(int value) throws InterruptedException {
		
		System.out.printf("Producer writes\t%2d", value);
		buffer = value;
	}
	
	//retorna valor do buffer
	@Override
	public int blockingGet() throws InterruptedException {
		
		System.out.printf("Consumer reads\t%2d", buffer);
		return buffer;
	}
}//fim da classe UnsynchronizedBuffer
