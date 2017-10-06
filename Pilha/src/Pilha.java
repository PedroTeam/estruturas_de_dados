
public class Pilha {
	private ListaDuplaLigada pilha = new ListaDuplaLigada();

	/**
	 * Insere a peca na ultima posicao
	 * @param peca
	 */
	public void inserir(Object peca) {
		pilha.add(peca);
	}

	/**
	 * Remove a peca da ultima posicao
	 */
	public Object remover() {
		Celula celula = (Celula) pilha.remove();
		if (celula != null) {
			return celula.elemento;
		} 
		return null;
	}

	/**
	 * Verifica se a pilha esta vazia
	 * @return true para vazia e false para nao vazia
	 */
	public boolean ehVazia() {
		return pilha.getTotalElementos() == 0;
	}
}
