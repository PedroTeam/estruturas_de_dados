import java.util.Scanner;

public class ProgramaAVL {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Veiculos:\n");
		int quant = scan.nextInt();
		ArvoreAVL veiculos = new ArvoreAVL();
		Veiculo veiculo = null;
		int placa = 0;
		for (int i = 0; i < quant; i++) {
			System.out.printf("Escreva a placa do veiculo %d:\n", i + 1);
			placa = scan.nextInt();
			veiculo = new Veiculo(placa);
			veiculos.add(veiculo);
			System.out.println("Balanceada="+veiculos.isBalanceada());
		}
		System.out.println(veiculos);

		clearConsole();
		while (placa!=0) {
			System.out.printf("Escreva a placa do veiculo para remover:\n");
			placa = scan.nextInt();

			veiculos.remover(new Veiculo(placa));
			System.out.println(veiculos);
			System.out.println("Balanceada="+veiculos.isBalanceada());
		}
		

	}

	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}

}
