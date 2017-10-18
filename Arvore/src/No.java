public class No {

	No direita;
	
	No esquerda;

	Object elemento;

	public No(Object elem) {
		this.elemento = elem;
	}

	public No(Object elem, No cel) {
		this.elemento = elem;
		this.direita = cel;
	}
	
	@Override
	public String toString() {
		return "[" + elemento + "]";
	}
}