package br.ufinor.estruturas.fila;

public class Pessoa {

	public Integer idade;
	public String nome;
	
	public Pessoa(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [idade=" + idade + ", nome=" + nome + "]";
	}
	
}
