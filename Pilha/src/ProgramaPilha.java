import java.util.Scanner;

public class ProgramaPilha {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Veiculos:\n");
		int quant = scan.nextInt();
		Pilha veiculos = new Pilha();
		Peca peca = null;
		for (int i = 0; i < quant; i++) {
			System.out.printf("Escreva o nome da peca %d:\n", i + 1);
			String str = scan.next();
			peca = new Peca(str);
			veiculos.inserir(peca);
		}
		System.out.println(veiculos);

		Object object = veiculos.remover();
		System.out.println(object);
		System.out.println(veiculos);
		while (!veiculos.ehVazia()) {
			System.out.println(veiculos.remover());
		}
		
		

	}

}
