public class HanoiTower {
	
	// Utilizando 3 pilhas estaticas de numeros inteiros
	private Pilha pinoA;
	private Pilha pinoB;
	private Pilha pinoC;

	// Construtor
	public HanoiTower() {
		
		// Inicializando todas os Pinos
		pinoA = new Pilha(3); // declara uma pilha com tamanho 3
		pinoA.push(1); // insere disco de tamanho 0
		pinoA.push(0); // insere disco de tamanho 0
		pinoA.push(0); // insere disco de tamanho 0
		
		pinoB = new Pilha(3); // declara uma pilha com tamanho 3
		pinoB.push(2); // insere disco de tamanho 0
		pinoB.push(0); // insere disco de tamanho 0
		pinoB.push(0); // insere disco de tamanho 0
		
		pinoC = new Pilha(3); // declara uma pilha com tamanho 3
		pinoC.push(3); // insere disco de tamanho 0
		pinoC.push(0); // insere disco de tamanho 0
		pinoC.push(0); // insere disco de tamanho 0

	}

	// Move disco de um pino para outro
	public void move(char origem, char destino) {
		// codigo
	}

	// Imprime a configuracao atual dos 3 Pinos
	public String print() {
		String configuracaoAtual = "";
		configuracaoAtual += pinoA.print();
		configuracaoAtual += "," + pinoB.print();
		configuracaoAtual += "," + pinoC.print();
		return configuracaoAtual;
	}
	
	// Imprime a configuracao atual do Pino A
	public String printPinA() {
		return pinoA.print();
	}
	
	// Imprime a configuracao atual do Pino B
	public String printPinB() {
		return pinoB.print();
	}
	
	// Imprime a configuracao atual do Pino C
	public String printPinC() {
		return pinoC.print();
	}
	
}
