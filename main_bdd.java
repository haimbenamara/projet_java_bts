package bdd;



		
import java.sql.Connection;
import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;

		import java.sql.ResultSetMetaData;

		public class main_bdd {

			public static void main(String[] args) {
				
				Connection cnx;
				//
				Statement stmt;
				
				// Recuperation des resultats de la requete SELECT
				ResultSet rs;
				
				// 1ere etape: Recherche et chargement du driver en memoire
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//la methode forname de la class class qui est une class qui est integree
					//a toutes les classes java et cette methode va instancier la 
					//classe driver et va faire new driver , le repertopire de class com qui
					//contient le repertoire mysql qui contient le repertoire jdbc
					//qui contient la classe driver
					//donc il y a 3 class cnx,statement,driver
					System.out.println("Driver trouve !!");
					
					// 2eme etape: Connexion a la BDD
					cnx = DriverManager.getConnection("jdbc:mysql://localhost/ecole?useSSL=false", "root", "");
					//cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "");
					System.out.println("Connexion BDD Ecole OK!!");
					
					// 3eme etape: Creation du conteneur de requete
					stmt = cnx.createStatement();
					
					// 4eme etape: Envoi de la requete INSERT
					stmt.executeUpdate("INSERT INTO profeleve values('calvo','Herve','Terminale',50,'Martin','Philo','H')");
					
					// 4eme etape: Envoi d'une requete UPDATE
					//stmt.executeUpdate("UPDATE profeleve set age=11 where nomEleve='Dupont' and prenomEleve='Eric'");
					
					// 4eme etape: Envoi d'une requete DELETE
					//stmt.executeUpdate("DELETE from profeleve where matiere='Math'");
					
				} catch (ClassNotFoundException e) {
					System.out.println("Driver non trouve");
				} catch (SQLException e) {
					System.out.println("Probleme connexion a la BDD ecole !!");
					e.printStackTrace();
				}
			}
		

	}


