import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert
{  
    
	public void inserer(Connection con, ) {
		
	}
      // enregistrement du driver
	  try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  }
	  catch (ClassNotFoundException e3) {
		  System.err.println("driver non trouvé");
		  return ;
	  }
	  
      Connection con = null;
      
	  // connexion à la base
	  try {
		  
		String url = "jdbc:odbc:tp2";	  
		String nom = "admin";
		String mdp = "xxx";
		 con = DriverManager.getConnection(url,nom,mdp);

		// execution de la requete	
		Statement stmt = con.createStatement();
	
		// insert 1000 clients
		for (int i = 0; i < 1000; i++) {
			String nom2 = "nom_" + i;
			String prenom2 = "prenom_" + i;
			String tmp = "insert into CLIENTS values (nom2, prenom2, i)";
			System.out.println(tmp);
			stmt.executeUpdate(tmp);
		}
		
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