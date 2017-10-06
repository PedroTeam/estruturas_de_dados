
public class ListaDuplaLigada {

	private Celula primeira;

	private Celula ultima;

	private int totalElementos = 0;

	public int getTotalElementos() {
		return totalElementos;
	}

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
		// Verifica se nao e o primeiro elemento da lista
		if (celula != null) {
			// Nova celula ocupa a ultima posicao
			celula.proxima = ultima;
			// Anterior da nova ultima celula
			ultima.anterior = celula;
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
		if (!posicaoValida(posicao) || (posicao == (totalElementos - 1))) {
			add(elemento);
			return;
		}
		Celula celula = primeira;
		// Se for a primeira posicao
		if (posicao == 0) {
			// Cria a nova celula e inseri na posicao desejada
			Celula nova = new Celula(elemento);
			nova.proxima = celula;
			celula.anterior = nova;
			primeira = nova;
			this.totalElementos++;
			return;
			// Busca de tras para frente
		} else {
			celula = recupera(posicao);
		}
		// Cria a nova celula e inseri na posicao desejada
		Celula nova = new Celula(elemento);

		// Guardando a referencia da anterior celula
		Celula anterior = celula.anterior;

		anterior.proxima = nova;
		nova.proxima = celula;
		nova.anterior = anterior;
		celula.anterior = nova;
		this.totalElementos++;

	}

	/**
	 * Remove o elemento do final da lista
	 * @return 
	 */
	public Object remove() {
		Celula removida = ultima;
		
		//Se existir somente um elemento
		if (totalElementos==1) {
			ultima = null;
			primeira = null;
			totalElementos=0;
			// Se lista possui mais de um elemento
		} else if (totalElementos>1) {
			Celula anterior = ultima.anterior;
			// Atribui o apontamento de ultima para a anterior
			ultima = anterior;
			// Atribui nulo para a proxima
			ultima.proxima = null;
			totalElementos--;
		}
		return removida;
	}

	/**
	 * Remove o elemento da posicao indicada
	 */
	public void remove(Integer index) {
		if (posicaoValida(index)) {
			if (index == 0) {
				// Remove a referencia da primeira
				primeira = primeira.proxima;
				// Se lista ficou vazia remove referencia para a ultima
				if (primeira == null) {
					ultima = null;
				} else {//Atribui nulo para anterior da primeira
					primeira.anterior = null;
				}
				totalElementos--;
			} else if (index==(totalElementos-1)) {//Se for a ultima posicao
				remove();
			} else {
				//Referencia da celula a ser removida
				Celula removida = recupera(index);
				
				//Guarda a referecia da proxima celula
				Celula proxima = removida.proxima;
				//Guarda a referecia da celula anterior
				Celula anterior = removida.anterior;
				//Liga a proxima com a anterior
				proxima.anterior = anterior;
				//Liga a anterior com a proxima
				anterior.proxima = proxima;
				//Anula a referencia da celula removida
				removida = null;

				totalElementos--;
			}
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
			if (index >= totalElementos / 2) {
				// Guarda o ultimo registro em uma variavel temporaria
				celula = ultima;
				//Procura do fim para o inicio
				for (int i = (totalElementos - 1); i > (index) && celula != null; i--) {
					if (celula.anterior != null)
						celula = celula.anterior;
				}
			} else {
				//Procura do inicio para o fim
				for (int i = 0; i < index && celula != null; i++) {
					if (celula.proxima != null)
						celula = celula.proxima;
				}
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
