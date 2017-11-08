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
	
	public boolean isBalancedo() {
		return Math.abs(ArvoreAVL.diff(direita, esquerda))<=1;
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