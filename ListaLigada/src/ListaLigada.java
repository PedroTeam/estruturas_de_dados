
public class ListaLigada {

	private Celula primeira;

	private Celula ultima;

	private int totalElementos = 0;

	/**
	 * Insere o elemento na ultima posicao
	 * 
	 * @param elemento
	 */
	public void add(Object elemento) {
		// Guarda o ultimo registro em uma variavel temporaria
		Celula celula = ultima;
		// Cria a nova celula e inseri na ultima posicao
		ultima = new Celula(elemento);
		// Vwerifica se nao e o primeiro elemento da lista
		if (celula != null) {
			celula.proxima = ultima;
		} else {// Inserindo o primeiro elemento da lista
			primeira = ultima;
		}
		this.totalElementos++;
	}

	/**
	 * Se a posicao existir adiciona na posicao indicada. Se não adiciona na
	 * ultima posicao
	 * 
	 * @param elemento
	 */
	public void add(int posicao, Object elemento) {
		// Se posicao nao for valida insere na ultima
		if (!posicaoValida(posicao)) {
			add(elemento);
			return;
		}
		// Guarda o ultimo registro em uma variavel temporaria
		Celula celula = primeira;
		// Se a posicao nao existir adiciona na ultima
		for (int i = 0; i < (posicao - 1) && celula != null; i++) {
			if (celula.proxima != null)
				celula = celula.proxima;
		}

		// Cria a nova celula e inseri na posicao desejada
		Celula nova = new Celula(elemento);
		// Vwerifica se nao e o primeiro elemento da lista
		if (celula != null) {
			if (celula.proxima != null) {
				// Guardando a referencia da proxima celula
				Celula proxima = celula.proxima;
				celula.proxima = nova;
				nova.proxima = proxima;
			} else {
				celula.proxima = nova;
				ultima = nova;
			}
		} else {// Inserindo o primeiro elemento da lista
			ultima = nova;
			primeira = ultima;
		}
		this.totalElementos++;
	}

	/**
	 * Remove o elemento do final da lista
	 */
	public void remove() {
		Celula celula = primeira;
		Celula anterior = primeira;
		// Se lista possui mais de um elemento
		if (primeira != null && primeira.proxima != null) {
			// Recuperar a ultima e a penultima celula
			while (celula.proxima != null) {
				anterior = celula;
				celula = celula.proxima;
			}
			// Atribui o apontamento de ultima para a anterior
			ultima = anterior;
			// Atribui nulo para a proxima
			ultima.proxima = null;
			totalElementos--;
		} else {// Existe no maximo um elemento
			primeira = null;
			ultima = null;
			totalElementos = 0;
		}
	}

	/**
	 * Remove o elemento da posicao indicada
	 */
	public void remove(Integer index) {
		if (posicaoValida(index)) {
			// Guarda o primeiro registro em uma variavel temporaria
			Celula celula = primeira;
			// Varro a lista ate chegar na posicao anterior a indicada ou no
			// final
			for (int i = 0; i < (index - 1) && celula != null; i++) {
				if (celula.proxima != null) {
					celula = celula.proxima;
				}
			}
			//Se for a primeira
			if (index == 0) {
				// Remove a referencia da primeira
				primeira = primeira.proxima;
				// Se lista ficou vazia remove referencia para a ultima
				if (primeira == null) {
					ultima = null;
				}
			} else {
				// Pega a celula que deseja deletar
				Celula atual = celula.proxima;
				// Se a posicao informada for da ultima celula
				if (atual.proxima == null) {
					celula.proxima = null;
					ultima = celula;
				} else {// Se nao for a ultima
					// Aponta a proxima da anterior para proxima da atual que
					// sera removida
					celula.proxima = atual.proxima;
					atual = null;
				}
			}
			totalElementos--;
		} else {// Se posicao nao e valida remove a ultima
			remove();
		}
	}

	/**
	 * Recupera o Veiculo da posicao solicitada. Se nao houver retorna null.
	 * 
	 * @param index
	 * @return
	 */
	public Celula recupera(Integer index) {
		if (posicaoValida(index)) {
			// Guarda o primeiro registro em uma variavel temporaria
			Celula celula = primeira;
			for (int i = 0; i < index && celula != null; i++) {
				if (celula.proxima != null)
					celula = celula.proxima;
			}
			return celula;
		} else {
			return null;
		}
	}

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
		String str = "Lista [";
		Celula celula = primeira;
		int i = 0;
		if (celula != null) {
			str = str.concat(" " + i + "=" + celula.toString());
			// Enquanto existir proximo
			while (celula.proxima != null) {
				celula = celula.proxima;
				if (celula != null) {
					str = str.concat(" -> " + (++i) + "=" + celula.toString());
				} else {
					break;
				}
			}
		}
		str = str.concat("]");
		return str;
	}
}
