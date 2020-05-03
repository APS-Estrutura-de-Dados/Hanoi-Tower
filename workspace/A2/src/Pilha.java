public class Pilha {

	// atributos
	private int[] vetor;
	private int topo;

	// construtor
	public Pilha(int maxSize) {
		vetor = new int[maxSize];
		topo = -1;
	}

	// verifica se a pilha esta cheia
	public boolean isFull() {
		return (topo == vetor.length - 1);
	}

	// empilha
	public void push(int elemento) {
		if (isFull() == false) {
			topo++;
			vetor[topo] = elemento;
		}
	}

	// verifica se a pilha esta vazia
	public boolean isEmpty() {
		return (topo == -1);
	}

	// desempilha
	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int elemento = vetor[topo];
			topo--;
			return elemento;
		}
	}

	// mostra o elemento do topo
	public int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			return vetor[topo];
		}
	}

	// mostra o elemento na posicao especificada
	public int peekPosition(int position) {
		if (isEmpty() || position > topo) {
			return -1;
		} else {
			return vetor[position];
		}
	}

	// mostra quantos elemetos tem na pilha
	public int size() {
		return topo + 1;
	}

	// imprime os elementos do topo ate o inicio
	public String print() {
		String elementos = "";
		if (isEmpty()) {
			elementos = null;
		} else {
			for (int i = topo; i >= 0; i--) {
				elementos+=vetor[i];
			}
		}
		return elementos;
	}

}
