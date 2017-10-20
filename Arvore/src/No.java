public class No {

	No direita;
	
	No esquerda;

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
				+ " <- " + elemento + " -> "
				+ (direita != null? direita : "#")
						+ "]";
	}
}