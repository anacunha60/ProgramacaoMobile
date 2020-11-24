package Threads;

import java.security.SecureRandom;

//Consumidor com um método run que faz um loop, lendo 10 valores do buffer.

public class Consumidor implements Runnable{
	
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation;//referência a objeto compartilhado
	
	//construtor
	public Consumidor(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	//lê os valores do sharedLocation 10 vezes e soma os valores
	@Override
	public void run() {
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			//dorme de 0 a 3 segundos, lê o valor do buffer e adiciona a soma
			try {
				
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.blockingGet();
				
				System.out.printf("\t\t\t%2d%n", sum);
			}
			catch(InterruptedException exception) {
				
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf("%n%s %d%n%s%n",
				"Consumer read values totaling", sum, "Terminating Consumer");
	}

}//fim da classe Consumidor
