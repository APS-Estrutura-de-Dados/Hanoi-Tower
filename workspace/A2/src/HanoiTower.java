public class HanoiTower {

	// Utilizando 3 pilhas estaticas de numeros inteiros
	private Pilha pinoA;
	private Pilha pinoB;
	private Pilha pinoC;

	// Construtor
	public HanoiTower() {

		// Inicializando todas os Pinos
		pinoA = new Pilha(3); // declara uma pilha com tamanho 3
		pinoA.push(3); // insere disco de tamanho 0
		pinoA.push(2); // insere disco de tamanho 0
		pinoA.push(1); // insere disco de tamanho 0

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
	public void Move(char origem, char destino) {

		if (origem == 'A') {

			if (destino == 'B') {
				Movimento(origem, destino, pinoA, pinoB);
			} else if (destino == 'C') {
				Movimento(origem, destino, pinoA, pinoC);
			}

		} else if (origem == 'B') {

			if (destino == 'A') {
				Movimento(origem, destino, pinoB, pinoA);
			} else if (destino == 'C') {
				Movimento(origem, destino, pinoB, pinoC);
			}

		} else if (origem == 'C') {

			if (destino == 'A') {
				Movimento(origem, destino, pinoC, pinoA);
			} else if (destino == 'B') {
				Movimento(origem, destino, pinoC, pinoB);
			}

		}

	}

	public void Movimento(char origem, char destino, Pilha pinoOrigem, Pilha pinoDestino) {

		// Armazena qual disco ser� movido
		int DiscoMovido = 0;

		// Registra quantas posicoes iguais a zero foram excluidas, para reposi��o
		int posicoesExcluidas = 0;

		// RETIRA DO PINO ORIGEM
		for (int i = 2; i > -1;) {

			// Verifica se a posic�o est� vazia
			if (pinoOrigem.peekPosition(i) == 0) {
				// Se estiver vazia, ser� excluida at� que algum disco seja encontrado
				pinoOrigem.pop();
				posicoesExcluidas++;
				i--;
			} else {
				// Se n�o estiver vazia, ser� excluida e movida para outro pino
				DiscoMovido = pinoOrigem.peekPosition(i);
				pinoOrigem.pop();
				posicoesExcluidas++;
				i = -1;
			}
		}

		// REAJUSTA O PINO ORIGEM
		for (int i = 0; i < posicoesExcluidas; i++) {
			// Rep�e as posi��es vazias que foram excluidas
			pinoOrigem.push(0);
		}

		// Registra quantas posicoes iguais a zero foram excluidas, para reposi��o
		posicoesExcluidas = 0;

		// ADICIONA NO PINO DESTINO
		for (int i = 2; i > -1;) {

			// Verifica se a posic�o est� vazia
			if (pinoDestino.peekPosition(i) == 0) {

				// Verifica se j� chegou na ultima posi��o
				if (i == 0) {
					// Se a ultima posi��o estiver vazia, o disco ser� inserido nela
					pinoDestino.pop();
					pinoDestino.push(DiscoMovido);
					i = -1;
				} else {
					// Exclui a posi��o vazia
					pinoDestino.pop();
					posicoesExcluidas++;
				}

				i--;

			} else {
				// Se a posi��o n�o estiver vazia, adiciona o disco na posi��o excluida
				// anteriormente
				pinoDestino.push(DiscoMovido);
				i = -1;
			}

		}

		// REAJUSTA O PINO DESTINO
		for (int i = 0; i < posicoesExcluidas; i++) {
			// Rep�e as posi��es vazias que foram excluidas
			pinoDestino.push(0);
		}

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
