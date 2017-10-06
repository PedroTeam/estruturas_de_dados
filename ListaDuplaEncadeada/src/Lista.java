
public class Lista {

	// Declarando e Inicializando um array de Aluno com capacidade 100.
	public static final Integer TAMANHO_MAXIMO = 100;
	private Object[] lista = new Object[TAMANHO_MAXIMO];
	private int maxSize = 100;
	private int lastIndex = 0;

	public Lista() {
	}

	public Lista(int size) {
		this.maxSize = size;
	}

	public int maxSize() {
		return this.maxSize;
	}

	public int size() {
		return this.lastIndex;
	}

	/**
	 * Adiciona um novo item.
	 * @param item
	 */
	public void add(Object item) {
		resizeList();
		this.lista[lastIndex] = item;
		this.lastIndex++;
	}
	
	/**
	 * Adiciona um novo item passando a posicao.
	 *
	 * @param index
	 * @param item
	 */
	public void add(Integer index, Object item) {
		resizeList();
		if (posicaoValida(index)) {
			for (int i = lastIndex; i > index; i--) {
				lista[i] = lista[i-1];				
			}
			lista[index] = item;
			this.lastIndex++;
		} else {
			add(item);
		}		
	}

	public void remove() {
		this.lastIndex--;
		this.lista[lastIndex] = null;
	}

	/**
	 * Removendo da posicao indicada.
	 * Se nao existir remove o ultimo.
	 * @param index posicao indicada.
	 */
	public void remove(Integer index) {
		if (posicaoValida(index)) {
			lista[index] = null;
			for (int i = index; i < lastIndex; i++) {
				if ((i+1)!=TAMANHO_MAXIMO) {
					lista[i] = lista[i+1];	
				} else {
					lista[i] = null;
				}								
			}
			this.lastIndex--;
		} else {
			remove();
		}
	}

	public boolean contem(Object item) {
		for (int i = 0; i < lastIndex; i++) {
			Object Object = lista[i];
			if (item.equals(Object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Recupera o Object da posicao solicitada. Se nao houver retorna null.
	 * 
	 * @param index
	 * @return
	 */
	public Object recupera(Integer index) {
		if (posicaoValida(index)) {
			return this.lista[index];
		} else {
			return null;
		}
	}

	/**
	 * Verifica se existe Object na posicao indicada.
	 * @param index
	 * @return
	 */
	public boolean posicaoValida(Integer index) {
		return index >= 0 && index < lastIndex;
	}

	/**
	 * Aumenta dinamicamente o tamanho da lista.
	 */
	private void resizeList() {
		if (lastIndex == lista.length) {
			int novoTamanho = lista.length*3/2;
			Object[] novaLista = new Object[novoTamanho];
			for (int i = 0; i < lista.length; i++) {
				novaLista[i] = lista[i];				
			}
			lista = novaLista;
		}
	}

	@Override
	public String toString() {
		String str = "Lista [";
		for (int i = 0; i < lista.length; i++) {
			Object obj = lista[i];
			if (obj != null) {
				str = str.concat(" "+i+"="+obj.toString());
			} else {
				break;
			}
		}
		str = str.concat("]");
		return str;
	}
}
