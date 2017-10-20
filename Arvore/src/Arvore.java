
public class Arvore {

	private No raiz;

	private int totalElementos = 0;

	/**
	 * Insere o elemento na ultima posicao
	 * 
	 * @param elemento
	 */
	public void add(No noh, Comparable elemento) {
		No no = new No(elemento);
		if (raiz == null) {
			raiz = no;
			this.totalElementos++;
			return;
		}
		if (noh==null) {
			if (elemento.compareTo(raiz.elemento) < 0) {
				if (raiz.esquerda == null) {
					raiz.esquerda = no;
				} else {
					add(raiz.esquerda, elemento);	
				}
				this.totalElementos++;
			} else if (elemento.compareTo(raiz.elemento) > 0) {	
				if (raiz.direita == null) {
					raiz.direita = no;
				} else {
					add(raiz.direita, elemento);	
				}	
				this.totalElementos++;
			}
			return;
		}
		if (elemento.compareTo(noh.elemento) < 0) {
			if (noh.esquerda == null) {
				noh.esquerda = no;
			} else {
				add(noh.esquerda, elemento);	
			}
			this.totalElementos++;
		} else if (elemento.compareTo(noh.elemento) > 0) {
			if (noh.direita == null) {
				noh.direita = no;
			} else {
				add(noh.direita, elemento);	
			}
			this.totalElementos++;
		}

	}

	/**
	 * Se a posicao existir adiciona na posicao indicada. Se não adiciona na
	 * ultima posicao
	 * 
	 * @param elemento
	 */
	// public void add(int posicao, Object elemento) {
	// // Se posicao nao for valida insere na ultima
	// if (!posicaoValida(posicao) || (posicao == (totalElementos - 1))) {
	// add(elemento);
	// return;
	// }
	// No celula = raiz;
	// // Se for a primeira posicao
	// if (posicao == 0) {
	// // Cria a nova celula e inseri na posicao desejada
	// No nova = new No(elemento);
	// nova.direita = celula;
	// celula.esquerda = nova;
	// raiz = nova;
	// this.totalElementos++;
	// return;
	// // Busca de tras para frente
	// } else {
	// celula = recupera(posicao);
	// }
	// // Cria a nova celula e inseri na posicao desejada
	// No nova = new No(elemento);
	//
	// // Guardando a referencia da anterior celula
	// No anterior = celula.esquerda;
	//
	// anterior.direita = nova;
	// nova.direita = celula;
	// nova.esquerda = anterior;
	// celula.esquerda = nova;
	// this.totalElementos++;
	//
	// }

	/**
	 * Remove o elemento do final da lista
	 */
//	public void remove() {
//		// Se existir somente um elemento
//		if (totalElementos == 1) {
//			ultima = null;
//			raiz = null;
//			totalElementos = 0;
//			// Se lista possui mais de um elemento
//		} else if (totalElementos > 1) {
//			No anterior = ultima.esquerda;
//			// Atribui o apontamento de ultima para a anterior
//			ultima = anterior;
//			// Atribui nulo para a proxima
//			ultima.direita = null;
//			totalElementos--;
//		}
//	}

	/**
	 * Remove o elemento da posicao indicada
	 */
//	public void remove(Integer index) {
//		if (posicaoValida(index)) {
//			if (index == 0) {
//				// Remove a referencia da primeira
//				raiz = raiz.direita;
//				// Se lista ficou vazia remove referencia para a ultima
//				if (raiz == null) {
//					ultima = null;
//				} else {// Atribui nulo para anterior da primeira
//					raiz.esquerda = null;
//				}
//				totalElementos--;
//			} else if (index == (totalElementos - 1)) {// Se for a ultima
//														// posicao
//				remove();
//			} else {
//				// Referencia da celula a ser removida
//				No removida = recupera(index);
//
//				// Guarda a referecia da proxima celula
//				No proxima = removida.direita;
//				// Guarda a referecia da celula anterior
//				No anterior = removida.esquerda;
//				// Liga a proxima com a anterior
//				proxima.esquerda = anterior;
//				// Liga a anterior com a proxima
//				anterior.direita = proxima;
//				// Anula a referencia da celula removida
//				removida = null;
//
//				totalElementos--;
//			}
//		} else {// Se posicao nao e valida remove a ultima
//			remove();
//		}
//	}

	/**
	 * Recupera o Veiculo da posicao solicitada. Se nao houver retorna null.
	 * 
	 * @param index
	 * @return
	 */
//	public No recupera(Integer index) {
//		if (posicaoValida(index)) {
//			// Guarda o primeiro registro em uma variavel temporaria
//			No celula = raiz;
//			if (index >= totalElementos / 2) {
//				// Guarda o ultimo registro em uma variavel temporaria
//				celula = ultima;
//				// Procura do fim para o inicio
//				for (int i = (totalElementos - 1); i > (index) && celula != null; i--) {
//					if (celula.esquerda != null)
//						celula = celula.esquerda;
//				}
//			} else {
//				// Procura do inicio para o fim
//				for (int i = 0; i < index && celula != null; i++) {
//					if (celula.direita != null)
//						celula = celula.direita;
//				}
//			}
//			return celula;
//		} else {
//			return null;
//		}
//	}

	/**
	 * Verifica se existe Veiculo na posicao indicada.
	 * 
	 * @param index
	 * @return
	 */
	public boolean posicaoValida(Integer index) {
		return index >= 0 && index < this.totalElementos;
	}

	@Override
	public String toString() {
		String str = "Arvore ["+raiz+"]";
		return str;
	}
}
