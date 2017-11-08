
public class ArvoreAVL extends Arvore {

	/**
	 * Insere o elemento
	 * 
	 * @param elemento
	 */
	public void add(No noh, Comparable elemento) {
		super.add(noh, elemento);
		atualizarAltura(getRaiz());
	}

	private No atualizarAltura(No no) {
		if (no==null) {
			return null;
		}
		no.altura = max(atualizarAltura(no.direita),atualizarAltura(no.esquerda))+1;
		return no;
	}

	private int max(No direita, No esquerda) {
		if (direita==null&&esquerda==null) {
			return -1;
		} else if (direita!=null&&esquerda!=null) {
			if (direita.altura>esquerda.altura) {
				return direita.altura;
			} else {
				return esquerda.altura;
			}
		} else if (direita!=null) {
			return direita.altura;
		} else {
			return esquerda.altura;
		}
	}

	public No remover(No aux, Comparable elemento) {
		aux = super.remover(aux, elemento);
		atualizarAltura(getRaiz());
		return aux;
	}

}
