package miniProjetDAO;

import java.util.List;

public class EtudiantView {
	public static String getHTML(List<Etudiant> list){
		String res ="<table><tr><th>choix</th><th>etuno</th><th>Nom</th><th>Prenom</th><th>Telephone</th><th>Semestre</th>";
		for(Etudiant p : list){
			res=res+"<tr><td><input type=\"radio\" id=\"radioButton\"></td>"+"<td>"+p.getEtuno()+"</td>"+"<td>"+p.getNom()+"</td>"+"<td>"+p.getPrenom()+"</td>"+"<td>"+p.getTel()+"</td>"+"<td>"+p.getSemestre()+"</td></tr>";
		}
		return res+"</table>";
	}
	public static String getDetail(Etudiant p){
		String res ="<table>";
		res=res+"<tr><td>"+p.getEtuno()+"</td></tr>"+"<tr><td>"+p.getNom()+"</td></tr>"+"<tr><td>"+p.getPrenom()+"</td></tr>"+"<tr><td>"+p.getTel()+"</td></tr>"+"<tr><td>"+p.getSemestre()+"</td></tr>";
		return res+"</table>";	}
}
