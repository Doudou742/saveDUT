package miniProjetDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO{
	
	public EtudiantDAO(){
		try{
			Class.forName("org.postgresql.Driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	private Connection getConnection(){
		Connection con=null;
		try{
			String url = "jdbc:postgresql://psqlserv/n3p1";
			String nom = "ablainl";
			String mdp = "moi";
			con = DriverManager.getConnection(url,nom,mdp);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return con;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Etudiant> findAll(){
		List<Etudiant> liste = new ArrayList<Etudiant>();
		Connection con = null;
		try{
			con = this.getConnection();
			// execution de la requete
			Statement stmt = con.createStatement();		
			//select table
			String query = "SELECT * from Etudiant;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				Etudiant p = new Etudiant(rs.getInt("etuno"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),rs.getShort("semestre"));
				liste.add(p);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{con.close();}catch(Exception e2){}
			return liste;
		}
	}
	
	public Etudiant findById(int etuno){
		List<Etudiant> list = this.findAll();
		for(Etudiant p : list){
			if(p.getEtuno()==etuno){
				return p;
			}
		}
		return null;
	}
}
