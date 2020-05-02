public class HanoiTower {
	// utilizando 3 pilhas estaticas de numeros inteiros
	private Pilha pinoA;
	private Pilha pinoB;
	private Pilha pinoC;

	// construtor
	public HanoiTower() {
		pinoA = new Pilha(3); // declara uma pilha com tamanho 3
		pinoA.push(3); // insere disco de tamanho 3
		pinoA.push(2); // insere disco de tamanho 2
		pinoA.push(1); // insere disco de tamanho 1
		pinoB = new Pilha(3); // declara uma pilha com tamanho 3
		pinoC = new Pilha(3); // declara uma pilha com tamanho 3
	}

	// move disco de um pino para outro
	public void move(char origem, char destino) {
		// codigo
	}

	// imprime a configuracao atual dos 3 pinos
	public void print() {
		// codigo
	}
}
