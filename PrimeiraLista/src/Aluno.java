
public class Aluno {

	String nome = null;
	Aluno[] listaAluno = null;

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		//Lista de 5 alunos
		aluno.listaAluno = new Aluno[5];

		for (int i = 0; i < aluno.listaAluno.length; i++) {
			aluno.listaAluno[i] = new Aluno();
			aluno.listaAluno[i].nome = "Aluno "+i;
			
		}
	}

}
