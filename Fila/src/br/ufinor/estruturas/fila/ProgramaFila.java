package br.ufinor.estruturas.fila;
import java.util.Scanner;

public class ProgramaFila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Escreva a quantidade de Pessoas:\n");
		int quant = scan.nextInt();
		Fila fila = new Fila();
		Pessoa peca = null;
		for (int i = 0; i < quant; i++) {
			System.out.printf("Escreva o nome da pessoa %d:\n", i + 1);
			String nome = scan.next();
			System.out.printf("Escreva a idade da pessoa %d:\n", i + 1);
			Integer idade = scan.nextInt();
			peca = new Pessoa(nome,idade);
			fila.inserir(peca);
		}
		Integer somaIdade = 0;
		System.out.println(fila);

		while (!fila.ehVazia()) {
			Object object = fila.remover();
			somaIdade += ((Pessoa)object).idade;
			System.out.println(object);
			System.out.println(fila);
		}
		System.out.println("Media de idade dos Motoristas="+(somaIdade/quant));

	}

}
