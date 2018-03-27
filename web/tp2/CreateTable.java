import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable
{  

  public static void main(String args[]) 
  {      
		
      // enregistrement du driver
	  try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  }
	  catch (ClassNotFoundException e3) {
		  System.err.println("driver non trouvé");
		  return ;
	  }
	  
      Connection con = null;
      int nbPersonneVoulue = 1000;
	  // connexion à la base
	  try {
		  
		String url = "jdbc:odbc:tp2Base";	  
		String nom = "deschamg";
		String mdp = "moi";
		con = DriverManager.getConnection(url,nom,mdp);

		// execution de la requete	
		Statement stmt = con.createStatement();
		//drop table de clients
		
		/*String delete = "drop table CLIENTS";
		System.out.println(delete);
		stmt.executeUpdate(delete);
		*/
		//create table de clients
		String query = "create table CLIENTS (NOM varchar(10), PRENOM varchar(10), AGE int)";
		System.out.println(query);
		stmt.executeUpdate(query);
		
		/*//drop vendeur
		String deleteV = "drop table VENDEURS";
		System.out.println(deleteV);
		stmt.executeUpdate(deleteV);
		*/
		//creation table vendeur
		String vendeur = "create table VENDEURS (NOM varchar(10), PRENOM varchar(10), AGE int)";
		System.out.println(vendeur);
		stmt.executeUpdate(vendeur);
		
		//remplissage de clients
		/*
		String insert = "insert into CLIENTS values ('deschamps', 'geoffrey', 20)";
		System.out.println(insert);
		stmt.executeUpdate(insert);
		*/
		
		//creation d'un vendeur
		stmt.executeUpdate("insert into VENDEURS values ('deschamps', 'geoffrey', 20)");
		stmt.executeUpdate("insert into VENDEURS values ('ablain', 'lucas', 19)");
		
		//creation 1000 personne
		for (int i = 0; i < nbPersonneVoulue; i++) {
			System.out.println("creation 1000 personnes");
			stmt.executeUpdate("insert into CLIENTS values ('nom_"+i+"', 'prenom_"+i+"',10)");
		}
		
		//selection de table
		
		
		
	  }
	  
	  catch (Exception e) {
		  System.err.println(e.toString() + " failed quelque part good luck have fun");
	  }
	  
	  finally {
		  try  { 
			con.close(); 
		  } 
		  catch (Exception e2)  {
			  
		  }
	  }
		// fermeture des espaces
		
		
  }
}
