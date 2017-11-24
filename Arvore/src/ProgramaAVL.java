import java.io.IOException;
import java.util.Scanner;

public class ProgramaAVL {

	public static void main(String[] args) throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Veiculos:\n");
		int quant = scan.nextInt();
		ArvoreAVL veiculos = new ArvoreAVL();
		Veiculo veiculo = null;
		int placa = 0;
		for (int i = 0; i < quant; i++) {
			clearConsole();
			System.out.printf("Escreva a placa do veiculo %d:\n", i + 1);
			clearConsole();
			placa = scan.nextInt();
			veiculo = new Veiculo(placa);
			veiculos.add(veiculo);
			imprimirTeste(veiculos);
		}
		System.out.println(veiculos);

		while (placa != 0) {
			clearConsole();
			System.out.printf("Escreva a placa do veiculo para remover:\n");
			placa = scan.nextInt();
			clearConsole();
			veiculos.remover(new Veiculo(placa));
			imprimirTeste(veiculos);
		}

	}

	private static void imprimirTeste(ArvoreAVL veiculos) {
		System.out.println("Balanceada=" + veiculos.isBalanceada());
		System.out.println(veiculos);
	}

	public final static void clearConsole() {
		try {
//			final String os = System.getProperty("os.name");
//
//			if (os.contains("Windows")) {
//				Runtime.getRuntime().exec("cls");
//			} else {
//				Runtime.getRuntime().exec("clear");
//			}
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
