package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircularBufferTest {
	public static void main(String[] args) throws InterruptedException{
		// cria novo pool de threads com duas threads
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		// cria CircularBuffer para armazenar ints
		CircularBuffer sharedLocation = new CircularBuffer();
		
		// exibe o estado inicial do CircularBuffer
		sharedLocation.displayState("Initial State");
		
		// executa as tarefas do produtor e consumidor
		executorService.execute(new Produtor(sharedLocation));
		executorService.execute(new Consumidor(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);		
	}
} // fim da classe CircularBufferTest
