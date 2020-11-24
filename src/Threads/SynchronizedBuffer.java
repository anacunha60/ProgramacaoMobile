package Threads;

public class SynchronizedBuffer implements Buffer {
	
	private int buffer = -1; // compartilhado pelos threads producer and consumer
	private boolean occupied = false;
	
	// coloca o valor no buffer
	public synchronized void blockingPut(int value)throws InterruptedException{
		// enquanto não houver posições vazias, coloca a thread em estado de espera
		while (occupied) {
			// envia informações da thread e do buffer para a saída, então espera
			System.out.println("Producer tries to write."); // apenas para demonstração
			displayState("Buffer full. Producer waits."); // apenas para demonstração
			wait();
		}
		
		buffer = value; // configura novo valor de buffer
		
		// indica que a produtora não pode armazenar outro valor
		// até a consumidora recuperar valor atual de buffer
		occupied = true;
		
		displayState("Producer writes " + buffer); // apenas para demonstração
		
		notifyAll(); // instrui thread(s) em espera a entrar no estado executável
	    }// fim do método blockingPut; libera bloqueio em SynchronizedBuffer
	
	// retorna valor do buffer
	public synchronized int blockingGet() throws InterruptedException{
		// enquanto os dados não são lidos, coloca thread em estado de espera
		while (!occupied) {
			// envia informações da thread e do buffer para a saída, então espera
			System.out.println("Consumer tries to read."); // apenas para demonstração
			displayState("Buffer empty. Consumer waits."); // apenas para demonstração
			wait();
		}
		
		// indica que a produtora pode armazenar outro valor
		// porque a consumidora acabou de recuperar o valor do bufferÿ
		occupied = false;
		
		displayState("Consumer reads " + buffer); // apenas para demonstração
		
		notifyAll(); // instrui thread(s) em espera a entrar no estado executável
		
		return buffer;
		
		}// fim do método blockingGet; libera bloqueio em SynchronizedBuffer
	
	// exibe a operação atual e o estado de buffer; apenas para demonstração
	private synchronized void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}
	
	
}// fim da classe SynchronizedBuffer
