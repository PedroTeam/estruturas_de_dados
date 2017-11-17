
public class ArvoreAVL extends Arvore {

	public void add(Comparable elemento, boolean naoBalancear) {
		add(getRaiz(), elemento, naoBalancear);
	}
	
	/**
	 * Insere o elemento
	 * 
	 * @param elemento
	 */
	public void add(No noh, Comparable elemento) {
		add(noh, elemento, false);
	}

	public void add(No noh, Comparable elemento, boolean naoBalancear) {
		super.add(noh, elemento);
		atualizarAltura(getRaiz());
		if (!naoBalancear&&!isBalanceada()) {
			balancear(getRaiz());
		}
	}
	
	private void balancear(No no) {
		int diff = diff(no.direita, no.esquerda);
		if (diff > 0) {// verifica se esta desbalanceada direita
			if (diff >= 2) {// Verifica se eh o no que esta desbalanceado
				Comparable aux = no.elemento;
				this.remover(no.elemento, true);
				this.add(aux, true);
			} else {// Chama o balandear da direita
				balancear(no.direita);
			}
		} else if (diff < 0) {// verifica se esta desbalanceada esquerda
			if (diff <= -2) {// Verifica se eh o no que esta desbalanceado
				Comparable aux = no.elemento;
				this.remover(no.elemento, true);
				this.add(aux, true);
			} else {// Chama o balandear da esquerda
				balancear(no.esquerda);
			}
		} else {
			if (no.direita!=null)
				balancear(no.direita);
			if (no.esquerda!=null)
				balancear(no.esquerda);
		}

	}

	private No atualizarAltura(No no) {
		if (no == null) {
			return null;
		}
		no.altura = max(atualizarAltura(no.direita), atualizarAltura(no.esquerda)) + 1;
		return no;
	}

	public static int max(No direita, No esquerda) {
		if (direita == null && esquerda == null) {
			return -1;
		} else if (direita != null && esquerda != null) {
			if (direita.altura > esquerda.altura) {
				return direita.altura;
			} else {
				return esquerda.altura;
			}
		} else if (direita != null) {
			return direita.altura;
		} else {
			return esquerda.altura;
		}
	}

	public boolean isBalanceada() {
		return isBalanceado(getRaiz());
	}

	public static boolean isBalanceado(No no) {
		return no == null ? true : no.isBalanceado();
	}

	public static int diff(No direita, No esquerda) {
		if (direita == null && esquerda == null) {
			return 0;
		} else if (direita != null && esquerda != null) {
			return direita.altura - esquerda.altura;
		} else if (direita != null) {
			return direita.altura - (-1);
		} else {
			return (-1) - esquerda.altura ;
		}
	}

	public No remover(Comparable elemento, boolean naoBalancear) {
		return remover(getRaiz(), elemento, naoBalancear);
	}

	public No remover(No aux, Comparable elemento) {
		return remover(aux, elemento, false);
	}
	
	public No remover(No aux, Comparable elemento, boolean naoBalancear) {
		No temp = super.remover(aux, elemento);
		aux = copiarNo(aux, temp);
		atualizarAltura(getRaiz());
		if (!naoBalancear&&!isBalanceada()) {
			balancear(getRaiz());
		}
		return aux;
	}

	private No copiarNo(No aux, No temp) {
		if (temp!=null) {
			aux.elemento = temp.elemento;
			aux.esquerda = temp.esquerda;
			aux.direita = temp.direita;
		} else {
			aux = null;
		}
		return aux;
	}

}
