
public class Fibonacci {

	private int quantidadeTermos;
	private String texto;
	private int cont;
	private Integer termo1;
	private Integer termo2;

	public Fibonacci(int quant) {
		reset(quant);
	}

	public void reset(int quant) {
		quantidadeTermos = quant;
		texto = "";
		termo1 = 0;
		termo2 = 1;
		cont=0;
	}

	public String calcularSequencia() {
		if (cont == 0) {
			texto = texto.concat(termo1.toString());
			cont++;
			return calcularSequencia();
		} else if (cont == 1 && cont < quantidadeTermos) {
			texto = texto.concat(", " + termo2);
			cont++;
			return calcularSequencia();
		} else if (cont < quantidadeTermos) {
			Integer proximo = termo1 + termo2;
			termo1 = termo2;
			termo2 = proximo;
			texto = texto.concat(", " + termo2);
			cont++;
			return calcularSequencia();
		}
		return texto;
	}
}
