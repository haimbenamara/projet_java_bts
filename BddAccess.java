package accesBDD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import projet_E_5.IhmMembre;


public class BddAccess {

	private Connection cnx;
	private Statement stmt;
	
	// Recuperation des resultats de la requete SELECT
	private ResultSet rs;
	
	// Donne les informations sur les tables, colonnes,..
	private ResultSetMetaData resMeta;
	private IhmMembre refihmMembre;
	
	// 1ere etape: Recherche et chargement du driver en memoire
	public void rechercherDriver(String driver) {
		try {
			Class.forName(driver);
			System.out.println("Driver trouve !!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non trouve !!");
			e.printStackTrace();
		}
	}
	
	// 2eme etape : se connecter a la base de donnees
	public void connecterBdd(String bddName, String login, String mdp) {
		try {
			cnx = DriverManager.getConnection(bddName, login, mdp);
			//cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole?useSSL=false", "root", "");
			System.out.println("Connexion BDD OK!!");
		} catch (SQLException e) {
			System.out.println("Probleme connexion BDD!!");
			e.printStackTrace();
		}
	}
	
	// 3eme etape: Creation du conteneur de requete
	public void creerStatement() {
		try {
			stmt = cnx.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 4eme etape: Envoi d'une requete SELECT 
	public ResultSet envoiRequeteSelect(String req) {
		try {
			rs = stmt.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	// 4eme etape: Envoi d'une requete de type (UPDATE, INSERT, CREATE, DELETE,..)
	public void envoiRequeteUpdate(String req) {
		try {
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Recuperation de la reponse associee a une requete select
	public void recupereReponseSelect() {
		//Recuper de rs les meta data c.a.d  par ex combien de ligne y a t il dans la reponse
		//la metadata va chercher le type de structuration de la BDD
		try {
			resMeta=(ResultSetMetaData) rs.getMetaData();
				
			//recuperer le nombre de colonne de la reponse
			int nbCols = resMeta.getColumnCount();
				
			//affichage des noms des colonnes
			for(int i = 1; i<= nbCols; i++) {
				System.out.print(resMeta.getColumnName(i) + " |"+" " );
				refihmMembre.afficherConseils(resMeta.getColumnName(i) + " |"+" ");
			}
			refihmMembre.afficherConseils("\n");	
			//System.out.println();
			//System.out.println("----------------------------");
			refihmMembre.afficherConseils("------------------------");
				
			//traitement de la requete
			while(rs.next()){
					
				for(int i = 1; i <= nbCols; i++) {
					//System.out.print(rs.getObject(i).toString() + " ");
					refihmMembre.afficherConseils(rs.getObject(i).toString() + " ");
				}
				//System.out.println();
				refihmMembre.afficherConseils("\n");
				//System.out.println("_____________________________");
				refihmMembre.afficherConseils("------------------------");
			}
				
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public void setIhmMembre(IhmMembre ihmM) {
		refihmMembre = ihmM;
	}
	
	
}
	