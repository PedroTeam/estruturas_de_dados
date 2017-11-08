public class No {

	No direita;
	
	No esquerda;
	
	int altura = 0;

	Comparable elemento;

	public No(Comparable elem) {
		this.elemento = elem;
	}

	public No(Comparable elem, No cel) {
		this.elemento = elem;
		this.direita = cel;
	}
	
	public boolean isBalanceado() {
		boolean balanceado=true;
		//verifica se a direita esta balanceada
		if (direita!=null) {
			balanceado = direita.isBalanceado();
		}
		//verifica se a esquerda esta balaceada somente se a direita estiver balanceada
		if (esquerda!=null&&balanceado) {
			balanceado = esquerda.isBalanceado();
		}
		return balanceado&&Math.abs(ArvoreAVL.diff(direita, esquerda))<=1;
	}
	
	@Override
	public String toString() {
		return "[" 
				+ (esquerda != null? esquerda : "#")
				+ " <- "+ altura+"-" + elemento + " -> "
				+ (direita != null? direita : "#")
						+ "]";
	}
}