package br.ufinor.estruturas.fila;

public class Fila {
	private ListaDuplaLigada lista = new ListaDuplaLigada();

	/**
	 * Insere a peca na ultima posicao
	 * @param peca
	 */
	public void inserir(Object peca) {
		lista.add(peca);
	}

	/**
	 * Remove a peca da ultima posicao
	 */
	public Object remover() {
		Celula celula = (Celula) lista.remove(0);
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
		return lista.getTotalElementos() == 0;
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
}
