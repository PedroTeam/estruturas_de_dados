public class Celula {

	Celula proxima;
	

	Object elemento;

	public Celula(Object elem) {
		this.elemento = elem;
	}

	public Celula(Object elem, Celula cel) {
		this.elemento = elem;
		this.proxima = cel;
	}
	
	@Override
	public String toString() {
		return "[" + elemento + "]";
	}
}