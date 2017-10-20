import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Veiculos:\n");
		int quant = scan.nextInt();
		Arvore veiculos = new Arvore();
		Veiculo veiculo = null;
		for (int i = 0; i < quant; i++) {
			System.out.printf("Escreva a placa do veiculo %d:\n", i + 1);
			String placa = scan.next();
			System.out.printf("Escreva a velocidade do veiculo %d:\n", i + 1);
			int velocidade = scan.nextInt();
			veiculo = new Veiculo(placa, velocidade);
			veiculos.add(null, veiculo);
		}
		System.out.println(veiculos);

//		System.out.printf("\nEscreva a placa do veiculo da posicao %d:\n", 1);
//		String placa = scan.next();
//		System.out.printf("Escreva a velocidade do veiculo da posicao %d:\n", 1);
//		int velocidade = scan.nextInt();
//		veiculo = new Veiculo(placa, velocidade);
//		veiculos.add(1, veiculo);
//
//		System.out.println(veiculos);
//
//		System.out.printf("\nEscreva a posicao desejada para exclusao:\n");
//		int posicao = scan.nextInt();
//		System.out.println(veiculos.recupera(posicao));
//
//		veiculos.remove(1);
//		System.out.println(veiculos);
//		for (int i = 0; i < 5; i++) {
//			veiculos.remove();
//			System.out.println(veiculos);
//		}
		
		

	}

}
