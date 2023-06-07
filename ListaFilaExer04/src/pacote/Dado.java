package pacote;

import java.util.Comparator;

public class Dado implements Comparator {
	private int idadeAluno;
    private String NomeAluno;

	public Dado(int idadeAluno, String nomeAluno) {
		super();
		this.idadeAluno = idadeAluno;
		NomeAluno = nomeAluno;
	}
    
    public int compare(Dado o1, Dado o2) {
        return o1.idadeAluno > o2.idadeAluno ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Idade do Aluno: " + this.idadeAluno + " Nome do aluno: " + this.NomeAluno;
    }
   

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getIdadeAluno() {
		return idadeAluno;
	}


}

