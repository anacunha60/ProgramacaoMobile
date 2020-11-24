package Threads;

//Sincronizando o acesso a um buffer limitado de quatro elementos compartilhados.
public class CircularBuffer implements Buffer {
	private final int[] buffer = {-1, -1, -1}; // buffer compartilhado
	
	private int occupiedCells = 0; // conta n�mero de buffers utilizados
	private int writeIndex = 0; // �ndice do pr�ximo elemento em que gravar
	private int readIndex = 0; // �ndice do pr�ximo elemento a ler
	
	// coloca o valor no buffer
	public synchronized void blockingPut(int value) throws InterruptedException{
		// espera at� que haja espa�o dispon�vel no buffer, ent�o grava o valor;
		// enquanto n�o houver posi��es vazias, p�e o thread no estado bloqueado
		while (occupiedCells == buffer.length) {
			System.out.printf("Buffer is full. Producer waits.%n");
			wait(); // espera at� uma c�lula do buffer ser liberada
		}// fim do while
		
		buffer[writeIndex] = value; // configura novo valor de buffer
		
		// atualiza �ndice de grava��o circular
		writeIndex = (writeIndex + 1) % buffer.length;
		
		++occupiedCells; // mais uma c�lula do buffer est� cheia
		displayState("Producer writes " + value);
		notifyAll(); // notifica threads que est�o esperando para ler a partir do buffer
	}
	
	// retorna valor do buffer
	public synchronized int blockingGet() throws InterruptedException{
		// espera at� que o buffer tenha dados, ent�o l� o valor;
		// enquanto os dados n�o s�o lidos, coloca thread em estado de espera
		while (occupiedCells == 0) {
			System.out.printf("Buffer is empty. Consumer waits.%n");
			wait(); // espera at� que uma c�lula do buffer seja preenchida
		} // fim do while
		
		int readValue = buffer[readIndex]; // l� valor do buffer
		
		// atualiza �ndice de leitura circular
		readIndex = (readIndex + 1) % buffer.length;
		
		--occupiedCells; // um n�mero menor de c�lulas do buffer � ocupado
		displayState("Consumer reads " + readValue);
		notifyAll(); // notifica threads que est�o esperando para gravar no buffer
		
		return readValue;
	}
	
	// exibe a opera��o atual e o estado de buffer
	public synchronized void displayState(String operation) {
		// gera sa�da de opera��o e n�mero de c�lulas de buffers ocupadas
		System.out.printf("%s%s%d)%n%s", operation,
				" (buffer cells occupied: ", occupiedCells, "buffer cells: ");
		
		for (int value : buffer) 
			System.out.printf(" %2d  ", value); // gera a sa�da dos valores no buffer
		
		System.out.printf("%n            ");
		
		for (int i = 0; i < buffer.length; i++)
			System.out.print("---- ");
		
		System.out.printf("%n            ");
		
		for (int i = 0; i < buffer.length; i++) {
			if (i == writeIndex && i == readIndex)
				System.out.print(" WR"); // �ndice de grava��o e leitura
			else if (i == writeIndex)
				System.out.print(" W "); // s� grava �ndice
			else if (i == readIndex)
				System.out.print(" R "); // s� l� �ndice
			else
				System.out.print(" "); // nenhum dos �ndices
		}
		
		System.out.printf("%n%n");
	}	
}// fim da classe CircularBuffer
