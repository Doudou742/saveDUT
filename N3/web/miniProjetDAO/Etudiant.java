package miniProjetDAO;

public class Etudiant{
	private int etuno;
	private String nom;
	private String prenom;
	private String tel;
	private int semestre;
	
	public Etudiant(int nb,String no,String pre,String te,int sem){
		etuno=nb;
		nom=no;
		prenom=pre;
		tel=te;
		semestre=sem;
	}

	public int getEtuno() {
		return etuno;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTel() {
		return tel;
	}

	public int getSemestre() {
		return semestre;
	}

	@Override
	public String toString() {
		return "Etudiant [eno=" + etuno + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", semestre="
				+ semestre + "]";
	}

	
}