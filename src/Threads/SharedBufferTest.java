package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Aplicativo com duas threads que manipulamm um buffer não sincronizado
public class SharedBufferTest {
	
	public static void main(String[] args) throws InterruptedException{
		
		//cria novo loop de threads com duas threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//cria UnsynchronizedBuffer para armazenar ints
		Buffer sharedLocation = new UnsynchronizedBuffer();
		
		System.out.println(
				"Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.printf(
				"------\t\t-----\t---------------\t----------------%n%n");
		
		//execurtar Producer e Consumer, dando a cada um
		//acesso a sharedLocation
		executorService.execute(new Produtor(sharedLocation));
		executorService.execute(new Consumidor(sharedLocation));
					
		executorService.shutdown();//termina o aplicativo quando as tarefas concluem
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	
	}

}//fim da classe SharedBufferTest
