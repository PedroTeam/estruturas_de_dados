import java.util.Scanner;

public class Velocidade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Veiculos:\n");
		int quant = scan.nextInt();
		Lista veiculos = new Lista(quant);
		Veiculo veiculo = null;
		for (int i = 0; i < veiculos.maxSize(); i++) {
			System.out.printf("Escreva a placa do veiculo %d:\n", i+1);
			String placa = scan.next();
			System.out.printf("Escreva a velocidade do veiculo %d:\n", i+1);
			int velocidade = scan.nextInt();
			veiculo = new Veiculo(placa, velocidade);
			veiculos.add(veiculo);
		}
		System.out.println(veiculos);
		
		System.out.printf("Escreva a Velocidade Maxima:\n");
		int velocidade = scan.nextInt();
		
		for (int i = 0; i < veiculos.maxSize(); i++) { 
			Veiculo veic = (Veiculo)veiculos.recupera(i);
			if (veic.velocidade > velocidade*1.1) {
				System.out.println("Veiculo de placa="+veic.placa + " excedeu a velicidade da via!");
			} else {
				System.out.println("Veiculo de placa="+veic.placa + " trafega na velicidade permitida!");
				
			}
		}
	}

}
