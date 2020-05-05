public class HanoiTower {

	// Utilizando 3 pilhas estaticas de numeros inteiros
	private Pilha pinoA;
	private Pilha pinoB;
	private Pilha pinoC;

	// Construtor
	public HanoiTower() {

		// Inicializando todas os Pinos
		pinoA = new Pilha(3); // declara uma pilha com tamanho 3
		pinoA.push(3); // insere disco de tamanho 3
		pinoA.push(2); // insere disco de tamanho 2
		pinoA.push(1); // insere disco de tamanho 1

		pinoB = new Pilha(3); // declara uma pilha com tamanho 3
		pinoB.push(0); // insere disco de tamanho 0
		pinoB.push(0); // insere disco de tamanho 0
		pinoB.push(0); // insere disco de tamanho 0

		pinoC = new Pilha(3); // declara uma pilha com tamanho 3
		pinoC.push(0); // insere disco de tamanho 0
		pinoC.push(0); // insere disco de tamanho 0
		pinoC.push(0); // insere disco de tamanho 0

	}

	// Move disco de um pino para outro
	public boolean Move(char origem, char destino) {

		if (origem == 'A') {

			if (destino == 'B') {
				return !Movimento(origem, destino, pinoA, pinoB);
			} else if (destino == 'C') {
				return !Movimento(origem, destino, pinoA, pinoC);
			}

		} else if (origem == 'B') {

			if (destino == 'A') {
				return !Movimento(origem, destino, pinoB, pinoA);
			} else if (destino == 'C') {
				return !Movimento(origem, destino, pinoB, pinoC);
			}

		} else if (origem == 'C') {

			if (destino == 'A') {
				return !Movimento(origem, destino, pinoC, pinoA);
			} else if (destino == 'B') {
				return !Movimento(origem, destino, pinoC, pinoB);
			}
		}
		return false;

	}

	// Faz a movimentação dos Discos
	public boolean Movimento(char origem, char destino, Pilha pinoOrigem, Pilha pinoDestino) {

		// Armazena qual disco será movido
		int DiscoMovido = 0;

		// Registra quantas posicoes iguais a zero foram excluidas, para reposição
		int posicoesExcluidas = 0;

		// Será true caso o movimento precisar ser interrompido/dê erro
		boolean stop = false;

		// RETIRA DO PINO ORIGEM
		for (int i = 2; i > -1;) {

			// Verifica se a posicão está vazia
			if (pinoOrigem.peekPosition(i) == 0) {
				// Se estiver vazia, será excluida até que algum disco seja encontrado
				pinoOrigem.pop();
				posicoesExcluidas++;
				i--;
			} else {

				// Se não estiver vazia
				// Pega o valor do Disco que será movido
				DiscoMovido = pinoOrigem.peekPosition(i);

				// Verifica o tamanho do disco que estiver no topo
				for (int k = 2; k >= 0; k--) {

					if (pinoDestino.peekPosition(k) > 0) {

						if (DiscoMovido > pinoDestino.peekPosition(k)) {
							stop = true;
							pinoOrigem.pop();
							posicoesExcluidas++;
							i = -1;
						}
					}
				}

				// Se o Disco sendo movido NÃO for maior que o Disco que ja estiver no Pino de
				// Destino
				if (!stop) {
					// Exclui o disco
					pinoOrigem.pop();
					posicoesExcluidas++;
					i = -1;
				}
			}
		}

		// REAJUSTA O PINO ORIGEM
		for (int i = 0; i < posicoesExcluidas; i++) {
			// Repõe as posições vazias que foram excluidas
			pinoOrigem.push(0);
		}

		// Registra quantas posicoes iguais a zero foram excluidas, para reposição
		posicoesExcluidas = 0;

		// ADICIONA NO PINO DESTINO
		for (int i = 2; i > -1;) {

			// Verifica se a posicão está vazia
			if (pinoDestino.peekPosition(i) == 0) {

				// Verifica se já chegou na ultima posição
				if (i == 0) {
					// Se a ultima posição estiver vazia, o disco será inserido nela
					pinoDestino.pop();
					pinoDestino.push(DiscoMovido);
					i = -1;
				} else {
					// Exclui a posição vazia
					pinoDestino.pop();
					posicoesExcluidas++;
				}

				i--;

			} else {
				// Se a posição não estiver vazia, adiciona o disco na posição excluida
				// anteriormente
				pinoDestino.push(DiscoMovido);
				i = -1;
			}
		}

		// REAJUSTA O PINO DESTINO
		for (int i = 0; i < posicoesExcluidas; i++) {
			// Repõe as posições vazias que foram excluidas
			pinoDestino.push(0);
		}

		return stop;
	}

	// Imprime a configuracao atual dos 3 Pinos
	public String print() {
		return pinoA.print() + pinoB.print() + pinoC.print();
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
