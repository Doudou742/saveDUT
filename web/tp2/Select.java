	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.*;

	public class Select
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
			
			String select = "SELECT * from VENDEURS where nom = 'deschamps'";
			ResultSet res = stmt.executeQuery(select);
			while (res.next()) {
				String nom2 = res.getString("NOM");
				String prenom2 = res.getString("PRENOM");
				int age2 = res.getInt("AGE");
				System.out.println(nom2 + " " + prenom2 + " " + age2);
			}
			
			int nbLigne = 0;
			String selectAll = "SELECT * from VENDEURS";
			ResultSet nbligne = stmt.executeQuery(selectAll);
			while(nbligne.next()) {
				nbLigne++;
			}
			System.out.println("il y a " + nbLigne + "  liggnes dans la table VENDEURS");
			
		  
		  
		  //metadata
		  ResultSet md = stmt.executeQuery(selectAll);
		  ResultSetMetaData rsmd = md.getMetaData();
		  int nbcolonne = rsmd.getColumnCount();
		  System.out.println("il y a " + nbcolonne + " colonnes");
		  for (int i = 1; i <= nbcolonne; i++) {
			  System.out.println("Colonne" + i );
			  System.out.println("Nom : " + rsmd.getColumnName(i));
			  System.out.println("Type : " + rsmd.getColumnTypeName(i));
			 
			  System.out.println("");
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
	}
