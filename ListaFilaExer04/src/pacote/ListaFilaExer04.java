package pacote;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ListaFilaExer04 {

	public static <E> void main(String[] args) {
		//04 - Crie um programa em java para gerenciar a fila de uma sala de aula, onde deverá está ordenada por idade
		//Inserir alunos
		//onsultar alunos
		//Sair. 
		Scanner idadeContato = new Scanner(System.in);
		Scanner nomeContato = new Scanner(System.in);
		Scanner opcaoUsuario = new Scanner(System.in);
		Queue<String> objetoAlunoConsulta =  new LinkedList<String>(); 
		//objetoAluno que vai lidar com os dados da classe Dado
		Queue<Dado> objetoAluno = new PriorityQueue<>(new CustomerOrderComparator());
		if(objetoAluno.isEmpty()) {
			System.out.println("Sua fila está vazia!");
		}else {
			System.out.println("Fila cheia!");
		}
		int qtd=0;
		do {
			System.out.print("Usuário escolha a opção"
					+ "\n(1) Inserir alunos"
					+ "\n(2) Consultar alunos"
					+ "\n(3) Sair");


			int operacao = opcaoUsuario.nextInt();
			switch(operacao) {
			//adicionar
			case 1:
				//recebe Dados do aluno e os adiciona a fila
				String nomeAluno = recebeNome(nomeContato);
				int idadeAluno =recebeIdade(idadeContato);
			adicionaAluno(idadeAluno, nomeAluno, objetoAluno);	   
			adicionaAlunoConsulta(nomeAluno, objetoAlunoConsulta);
			break;
			case 2:					
				String nomeAlunoConsulta = recebeNome(nomeContato);
				ConsultaAluno(nomeAlunoConsulta, objetoAlunoConsulta);
				break;
		case 3:
			//				//sair
			qtd = 10;	
			break;
		default:
			System.out.println("Operação inválida!!!!");
		}

	}while(qtd<5);
	opcaoUsuario.close();
	System.out.println("Saiu do menu!");
}
public static void adicionaAluno(int idadeAluno, String nomeAluno, Queue<Dado> objetoAluno) {
	Dado dadosAlunos = new Dado(idadeAluno, nomeAluno);
	objetoAluno.add(dadosAlunos);
	System.out.println("Dados do aluno foram adicionados!");
	System.out.println("Sua fila é:");
	Iterator<Dado>objetoInterator1 = objetoAluno.iterator();
	while(objetoInterator1.hasNext()) {
		System.out.println(objetoInterator1.next());
	}
}

public static void adicionaAlunoConsulta(String nomeAluno, Queue<String> objetoAlunoConsulta) {
	objetoAlunoConsulta.add(nomeAluno);
	}
public static void ConsultaAluno(String nomeAluno, Queue<String> objetoAlunoConsulta) {
		if(objetoAlunoConsulta.contains(nomeAluno)) {
			System.out.println("O aluno está na fila!");
			}else {
			System.out.println("o aluno não está na fila!");
		}
	
	}

	public static int recebeIdade(Scanner idadeContato){
		System.out.println("Usuário qual a idade do aluno?");
		return idadeContato.nextInt();
	}
	public static String recebeNome(Scanner nomeContato){
		System.out.println("Usuário qual o nome do aluno?");
		return nomeContato.nextLine();
	}
	static class CustomerOrderComparator implements Comparator<Dado> {

		@Override
		public int compare(Dado o1, Dado o2)
		{
			return o1.getIdadeAluno() < o2.getIdadeAluno() ? 1 : -1;



		}
	}
}

