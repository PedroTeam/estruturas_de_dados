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
	
	@Override
	public String toString() {
		return "[" 
				+ (esquerda != null? esquerda : "#")
				+ " <- "+ altura+"-" + elemento + " -> "
				+ (direita != null? direita : "#")
						+ "]";
	}
}