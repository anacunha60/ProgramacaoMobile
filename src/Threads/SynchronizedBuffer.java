package Threads;

public class SynchronizedBuffer implements Buffer {
	
	private int buffer = -1; // compartilhado pelos threads producer and consumer
	private boolean occupied = false;
	
	// coloca o valor no buffer
	public synchronized void blockingPut(int value)throws InterruptedException{
		// enquanto n�o houver posi��es vazias, coloca a thread em estado de espera
		while (occupied) {
			// envia informa��es da thread e do buffer para a sa�da, ent�o espera
			System.out.println("Producer tries to write."); // apenas para demonstra��o
			displayState("Buffer full. Producer waits."); // apenas para demonstra��o
			wait();
		}
		
		buffer = value; // configura novo valor de buffer
		
		// indica que a produtora n�o pode armazenar outro valor
		// at� a consumidora recuperar valor atual de buffer
		occupied = true;
		
		displayState("Producer writes " + buffer); // apenas para demonstra��o
		
		notifyAll(); // instrui thread(s) em espera a entrar no estado execut�vel
	    }// fim do m�todo blockingPut; libera bloqueio em SynchronizedBuffer
	
	// retorna valor do buffer
	public synchronized int blockingGet() throws InterruptedException{
		// enquanto os dados n�o s�o lidos, coloca thread em estado de espera
		while (!occupied) {
			// envia informa��es da thread e do buffer para a sa�da, ent�o espera
			System.out.println("Consumer tries to read."); // apenas para demonstra��o
			displayState("Buffer empty. Consumer waits."); // apenas para demonstra��o
			wait();
		}
		
		// indica que a produtora pode armazenar outro valor
		// porque a consumidora acabou de recuperar o valor do buffer�
		occupied = false;
		
		displayState("Consumer reads " + buffer); // apenas para demonstra��o
		
		notifyAll(); // instrui thread(s) em espera a entrar no estado execut�vel
		
		return buffer;
		
		}// fim do m�todo blockingGet; libera bloqueio em SynchronizedBuffer
	
	// exibe a opera��o atual e o estado de buffer; apenas para demonstra��o
	private synchronized void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}
	
	
}// fim da classe SynchronizedBuffer
