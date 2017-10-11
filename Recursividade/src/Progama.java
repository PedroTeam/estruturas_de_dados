import java.util.Scanner;

public class Progama {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de termos da Sequencia Fibonacci:\n");
		int quant = scan.nextInt();
		String texto = "";
		Fibonacci fibonacci = new Fibonacci(quant);
		while (quant > 0) {
			fibonacci.reset(quant);
			texto = fibonacci.calcularSequencia();
			System.out.println(texto);
			
			System.out.printf("Escreva a quantidade de termos da Sequencia Fibonacci:\n");
			quant = scan.nextInt();


		}

	}

}
