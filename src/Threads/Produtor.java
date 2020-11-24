package Threads;

import java.security.SecureRandom;

//Produtor com um método run que insere os valores de 1 a 10 em buffer.
public class Produtor implements Runnable{
	
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation; //referência a objeto compartilhado
	
	//construtor
	public Produtor(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	//armazena valores de 1 a 10 em sharedLocation
	@Override
	public void run() {
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			try {//dorme de 0 a 3 segundos, então coloca valor em buffer
				
				Thread.sleep(generator.nextInt(3000));//sono aleatório
				sharedLocation.blockingPut(i);//configura valor no buffer
				
				sum += i;//incrementa soma de valores
				System.out.printf("\t\t%2d%n", sum);
				
			}
			catch(InterruptedException exception) {
				
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.printf(
				"Producer done producing%nTerminating Producer%n");
		
	}

}//fim da classe produtor
